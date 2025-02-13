package cn.sanenen.dm.grpc;

import cn.sanenen.dm.common.CallFunction;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.Getter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GrpcChannel {
    private final String host;
    private final int port;
    @Getter
    private final ManagedChannel channel;

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private CallFunction successCallFunction;
    private CallFunction failCallFunction;


    public GrpcChannel(String host, int port) {
        this.host = host;
        this.port = port;
        this.channel = createNewChannel();
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
                .keepAliveTimeout(30, TimeUnit.SECONDS)
                .usePlaintext()
                .build();
    }


    public void startHeartbeat() {
        scheduler.scheduleAtFixedRate(() -> {
            if (checkConnection(channel)) {
                if (successCallFunction != null) {
                    successCallFunction.call();
                }
            } else {
                if (failCallFunction != null) {
                    failCallFunction.call();
                }
            }
        }, 3, 10, TimeUnit.SECONDS);
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

}