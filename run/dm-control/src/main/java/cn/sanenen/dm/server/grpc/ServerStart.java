package cn.sanenen.dm.server.grpc;

import cn.hutool.log.Log;
import cn.sanenen.dm.server.common.DmSetting;
import cn.sanenen.dm.server.grpc.service.ServerServiceImpl;
import io.grpc.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author sun
 **/
public class ServerStart {
    private static final Log log = Log.get();
    private Server server;
    public static Context.Key<String> clientIpKey = Context.key("clientIp");

    public void start() throws IOException {
        int port = DmSetting.getControlPort();
        server = ServerBuilder.forPort(port)
                .addService(new ServerServiceImpl())
                .intercept(new ServerInterceptor() {
                    @Override
                    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
                        SocketAddress socketAddress = call.getAttributes().get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR);
                        if (socketAddress instanceof InetSocketAddress inetSocketAddress) {
                            String clientIp = inetSocketAddress.getAddress().getHostAddress();
                            log.trace("Client  IP: {}", clientIp);
                            Context context = Context.current().withValue(clientIpKey, clientIp);
                            return Contexts.interceptCall(context, call, headers, next);
                        }
                        return next.startCall(call, headers);
                    }
                })
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    ServerStart.this.stop();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public void shutdown() {
        server.shutdown();
    }
}
