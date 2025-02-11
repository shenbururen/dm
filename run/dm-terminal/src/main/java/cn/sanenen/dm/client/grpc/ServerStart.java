package cn.sanenen.dm.client.grpc;

import cn.hutool.core.net.NetUtil;
import cn.sanenen.dm.client.grpc.service.BaseJavaServiceImpl;
import cn.sanenen.dm.client.grpc.service.DmCallServiceImpl;
import io.grpc.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author sun
 **/
public class ServerStart {
    private Server server;
    public int start() throws IOException {
        int port = NetUtil.getUsableLocalPort(30000);
        server = ServerBuilder.forPort(port)
                .addService(new BaseJavaServiceImpl())
                .addService(new DmCallServiceImpl())
                .build()
                .start();
        return port;
    }

    public void shutdown() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

}
