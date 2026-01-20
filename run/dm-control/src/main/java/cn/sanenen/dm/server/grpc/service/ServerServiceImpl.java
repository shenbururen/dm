package cn.sanenen.dm.server.grpc.service;


import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.grpc.common.MessageUtil;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;
import cn.sanenen.dm.grpc.pkg.control.ControlServerServiceGrpc;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.WaitPool;
import cn.sanenen.dm.server.fx.service.MainService;
import cn.sanenen.dm.server.grpc.GrpcTerminal;
import cn.sanenen.dm.server.grpc.ServerStart;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sun
 **/
public class ServerServiceImpl extends ControlServerServiceGrpc.ControlServerServiceImplBase {
    private static final Log log = Log.get();
    private final static ExecutorService VT_POOL = Executors.newVirtualThreadPerTaskExecutor();
    @Override
    public StreamObserver<ControlServerPg.ClientMessage> registerDmTerminal(StreamObserver<ControlServerPg.ServerMessage> responseObserver) {
        /* 用 final 局部变量，每个终端独享 */
        final GrpcTerminal grpcTerminal = GrpcTerminal.builder()
                .responseObserver(responseObserver)
                .build();
        return new StreamObserver<>() {
            @Override
            public void onNext(ControlServerPg.ClientMessage clientMessage) {
                log.trace("registerDmTerminal {}", MessageUtil.printJson(clientMessage));
                Context.Key<String> clientIpKey = ServerStart.clientIpKey;
                String ip = clientIpKey.get();
                grpcTerminal.setTerminalIp(ip);
                VT_POOL.execute(() -> {
                    if (clientMessage.hasRegisterDmTerminalRequest()) {
                        ControlServerPg.RegisterDmTerminalRequest registerDmTerminalRequest = clientMessage.getRegisterDmTerminalRequest();
                        MainService mainService = Singleton.get(MainService.class);
                        log.trace("新终端注册：", registerDmTerminalRequest);
                        grpcTerminal.setTerminalId(registerDmTerminalRequest.getTerminalId());
                        grpcTerminal.setTerminalName(registerDmTerminalRequest.getTerminalName());
                        try {
                            mainService.registerDmTerminal(grpcTerminal);
                        } catch (InterruptedException e) {
                            log.error(e, "终端注册 {} 异常", grpcTerminal.getTerminalId());
                            responseObserver.onError(e);
                        }
                        return;
                    }
                    String messageId = clientMessage.getMessageId();
                    if (StrUtil.isBlank(messageId)) {
                        log.error("registerDmTerminal messageId为空 {}", clientMessage);
                    } else {
                        CompletableFuture<ControlServerPg.ClientMessage> f = WaitPool.remove(messageId);
                        if (f != null) {
                            f.complete(clientMessage);
                        } else {
                            log.error("registerDmTerminal messageId不存在 {}", clientMessage);
                        }
                    }
                });
            }

            @Override
            public void onError(Throwable t) {
                String id = grpcTerminal.getTerminalId();
                log.error(t, "终端 {} 异常", id);
                if (id != null) TerminalCache.removeTerminal(id);
            }

            @Override
            public void onCompleted() {
                String id = grpcTerminal.getTerminalId();
                log.info("终端 {} 完成", id);
                if (id != null) TerminalCache.removeTerminal(id);
                VT_POOL.shutdown();
            }
        };
    }
}
