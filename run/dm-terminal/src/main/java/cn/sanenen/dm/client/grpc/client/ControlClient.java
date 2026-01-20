package cn.sanenen.dm.client.grpc.client;

import cn.hutool.core.lang.Singleton;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.client.common.CmdHandler;
import cn.sanenen.dm.client.common.DmSetting;
import cn.sanenen.dm.client.grpc.service.BaseJavaServiceImpl;
import cn.sanenen.dm.client.grpc.service.DmCallServiceImpl;
import cn.sanenen.dm.grpc.common.MessageUtil;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;
import cn.sanenen.dm.grpc.pkg.control.ControlServerServiceGrpc;
import io.grpc.Channel;
import io.grpc.stub.StreamObserver;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ControlClient {

    private static final Log log = Log.get();

    private final AtomicBoolean running = new AtomicBoolean(true);
    private final AtomicInteger retryTimes = new AtomicInteger(0);
    private static final ScheduledExecutorService RECONNECT_POOL =
            Executors.newScheduledThreadPool(1,
                    Thread.ofVirtual().name("control-reconnect-", 0).factory());


    private final Channel channel;
    private volatile StreamObserver<ControlServerPg.ClientMessage> writer;

    private final Map<String, CmdHandler> cmdMap = Map.of(
            ControlServerPg.ServerMessage.MessageCase.DMCALLREQUEST.name(), this::handleDmCall,
            ControlServerPg.ServerMessage.MessageCase.DELALLFILESREQUEST.name(), this::handleDelAllFiles,
            ControlServerPg.ServerMessage.MessageCase.RESTARTREQUEST.name(), this::handleRestart,
            ControlServerPg.ServerMessage.MessageCase.UPLOADFILEREQUEST.name(), this::handleUploadFile,
            ControlServerPg.ServerMessage.MessageCase.GETCURRENTPIDREQUEST.name(), this::handleGetPid,
            ControlServerPg.ServerMessage.MessageCase.GETHASFILESREQUEST.name(), this::handleGetHasFiles
    );

    private final DmCallServiceImpl dmCallService = Singleton.get(DmCallServiceImpl.class);
    private final BaseJavaServiceImpl javaService = Singleton.get(BaseJavaServiceImpl.class);

    private static final ExecutorService VT_POOL = Executors.newVirtualThreadPerTaskExecutor();

    public void shutdown() {
        running.set(false);
        RECONNECT_POOL.shutdownNow();
        VT_POOL.shutdown();
        StreamObserver<ControlServerPg.ClientMessage> w = writer;
        if (w != null) {
            w.onCompleted();
        }
    }

    public ControlClient(Channel channel) {
        this.channel = channel;
        restart();          // 首次启动
    }

    public void registerSelf() {
        String id = DmSetting.getId();
        String name = DmSetting.getName();
        ControlServerPg.RegisterDmTerminalRequest req = ControlServerPg.RegisterDmTerminalRequest.newBuilder()
                .setTerminalId(id)
                .setTerminalName(name)
                .setTerminalIp(NetUtil.getLocalhostStr())
                .build();
        ControlServerPg.ClientMessage msg = ControlServerPg.ClientMessage.newBuilder()
                .setRegisterDmTerminalRequest(req)
                .build();
        StreamObserver<ControlServerPg.ClientMessage> w = writer;
        if (w != null) {
            w.onNext(msg);
        }
    }

    /* =====================  核心：重启双向流  ===================== */
    private void restart() {
        if (!running.get()) {
            log.info("client already shutdown, skip restart");
            return;
        }
        try {
            /* 1. 优雅关闭旧流 */
            StreamObserver<ControlServerPg.ClientMessage> old = writer;
            if (old != null) {
                old.onCompleted();
            }

            /* 2. 新建流 */
            StreamObserver<ControlServerPg.ClientMessage> outbound =
                    ControlServerServiceGrpc.newStub(channel)
                            .registerDmTerminal(new InboundObserver());
            writer = outbound;

            /* 3. 立即重注册 */
            registerSelf();
            retryTimes.set(0);          // 成功归零
        } catch (Exception e) {
            log.error("restart stream error", e);
            scheduleReconnect();
        }
    }

    private void scheduleReconnect() {
        if (!running.get()) return;
        int times = retryTimes.incrementAndGet();
        long base = Math.min(1L << Math.min(times, 6), 30); // 最大 30 s
        long jitter = RandomUtil.randomInt(0, 1000);        // 0~1 s 抖动
        long delay = base * 1000 + jitter;
        log.info("schedule reconnect after {} ms", delay);
        RECONNECT_POOL.schedule(this::restart, delay, TimeUnit.MILLISECONDS);
    }

    /* =============================================================== */
    private final class InboundObserver implements StreamObserver<ControlServerPg.ServerMessage> {
        @Override
        public void onNext(ControlServerPg.ServerMessage msg) {
            if (msg.hasRegisterDmTerminalResponse()) {
                boolean ok = msg.getRegisterDmTerminalResponse().getSuccess();
                if (ok) {
                    log.info("注册成功。终端id：{}", msg.getRegisterDmTerminalResponse().getResult());
                } else {
                    log.error("注册失败。终端id：{}", msg.getRegisterDmTerminalResponse().getResult());
                    writer.onCompleted();
                }
                return;
            }

            String mid = msg.getMessageId();
            if (StrUtil.isNotBlank(mid)) {
                String cmd = msg.getMessageCase().name();
                CmdHandler h = cmdMap.get(cmd);
                if (h == null) {
                    log.warn("unknown cmd: {}", cmd);
                    return;
                }
                VT_POOL.execute(() -> {
                    try {
                        log.info("cmd: {}, msg: {}", cmd, MessageUtil.printJson(msg));
                        writer.onNext(h.handle(msg).setMessageId(mid).build());
                    } catch (Throwable e) {
                        log.error("cmd {} error", cmd, e);
                        writer.onError(e);
                    }
                });
            }
        }

        @Override
        public void onError(Throwable t) {
            log.error("stream onError -> schedule reconnect", t);
            writer = null;
            scheduleReconnect();
        }

        @Override
        public void onCompleted() {
            log.warn("stream onCompleted -> schedule reconnect");
            writer = null;
            scheduleReconnect();
        }
    }

    /* ====================  以下 handler 不变  ==================== */
    private ControlServerPg.ClientMessage.Builder handleDmCall(ControlServerPg.ServerMessage msg) {
        ControlServerPg.DmCallResponse resp = dmCallService.call(msg.getDmCallRequest());
        return ControlServerPg.ClientMessage.newBuilder().setDmCallResponse(resp);
    }

    private ControlServerPg.ClientMessage.Builder handleDelAllFiles(ControlServerPg.ServerMessage msg) {
        ControlServerPg.DelAllFilesResponse resp = javaService.delAllFiles(msg.getDelAllFilesRequest());
        return ControlServerPg.ClientMessage.newBuilder().setDelAllFilesResponse(resp);
    }

    private ControlServerPg.ClientMessage.Builder handleRestart(ControlServerPg.ServerMessage msg) {
        ControlServerPg.RestartResponse resp = javaService.restart(msg.getRestartRequest());
        return ControlServerPg.ClientMessage.newBuilder().setRestartResponse(resp);
    }

    private ControlServerPg.ClientMessage.Builder handleUploadFile(ControlServerPg.ServerMessage msg) {
        ControlServerPg.UploadFileResponse resp = javaService.uploadFile(msg.getUploadFileRequest());
        return ControlServerPg.ClientMessage.newBuilder().setUploadFileResponse(resp);
    }

    private ControlServerPg.ClientMessage.Builder handleGetPid(ControlServerPg.ServerMessage msg) {
        ControlServerPg.GetCurrentPIDResponse resp = javaService.getCurrentPID();
        return ControlServerPg.ClientMessage.newBuilder().setGetCurrentPIDResponse(resp);
    }

    private ControlServerPg.ClientMessage.Builder handleGetHasFiles(ControlServerPg.ServerMessage msg) {
        ControlServerPg.GetHasFilesResponse resp = javaService.getHasFiles();
        return ControlServerPg.ClientMessage.newBuilder().setGetHasFilesResponse(resp);
    }
}