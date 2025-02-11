package cn.sanenen.dm.grpc;

import cn.sanenen.dm.common.CallFunction;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GrpcClient {
    private final String host;
    private final int port;
    private final ManagedChannel channel;
    
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private static final long INITIAL_DELAY = 1; // 初始延迟1秒
    private CallFunction successCallFunction;
    private CallFunction failCallFunction;
    

    public GrpcClient(String host, int port) {
        this.host = host;
        this.port = port;
        this.channel = createNewChannel();
        watchChannelState(channel);
    }

    public void setConnectSuccessHandler(CallFunction callFunction) {
        this.successCallFunction = callFunction;
    }
    public void setConnectFailHandler(CallFunction callFunction) {
        this.failCallFunction = callFunction;
    }

    private ManagedChannel createNewChannel() {
        return ManagedChannelBuilder.forAddress(host, port)
                .keepAliveTime(30, TimeUnit.SECONDS)
                .keepAliveTimeout(5, TimeUnit.SECONDS)
                .usePlaintext()
                .enableRetry()
                .build();
    }

    private void watchChannelState(ManagedChannel channel) {
        ConnectivityState currentState = channel.getState(true);
        handleStateChange(currentState, channel);
        channel.notifyWhenStateChanged(currentState, () -> {
            ConnectivityState newState = channel.getState(false);
            handleStateChange(newState, channel);
            watchChannelState(channel); // 继续监听状态变化
        });
    }

    private void handleStateChange(ConnectivityState state, ManagedChannel channel) {
        if (state == ConnectivityState.TRANSIENT_FAILURE || state == ConnectivityState.SHUTDOWN) {
            System.out.println("检测到连接断开，启动重连...");
            if (failCallFunction != null) {
                failCallFunction.call();
            }
            startReconnectProcess();
        }
    }

    private void startReconnectProcess() {
        AtomicInteger retryCount = new AtomicInteger(0);
        Runnable reconnectTask = new Runnable() {
            @Override
            public void run() {
                try {
                    if (checkConnection(channel)) {
                        System.out.println("重连成功");
                        if (successCallFunction != null) {
                            successCallFunction.call();
                        }
                    } else {
                        throw new Exception("连接检查失败");
                    }
                } catch (Exception e) {
                    long delay = (long) (INITIAL_DELAY * Math.pow(2, retryCount.incrementAndGet()));
                    System.out.printf("重试次数 %d，%d秒后重试...%n", retryCount.get(), Math.min(delay, 10));
                    scheduler.schedule(this, delay, TimeUnit.SECONDS);
                }
            }
        };
        scheduler.schedule(reconnectTask, INITIAL_DELAY, TimeUnit.SECONDS);
    }

    private boolean checkConnection(ManagedChannel channel) {
        try {
            // 执行简单的RPC调用验证连接
            channel.getState(true);
            return channel.getState(false) == ConnectivityState.READY;
        } catch (Exception e) {
            return false;
        }
    }

    public void shutdown() throws InterruptedException {
        if (channel != null) {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        scheduler.shutdown();
    }

    public ManagedChannel getChannel() {
        return channel;
    }

}