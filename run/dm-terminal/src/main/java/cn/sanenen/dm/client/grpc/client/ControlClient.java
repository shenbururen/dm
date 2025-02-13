package cn.sanenen.dm.client.grpc.client;

import cn.sanenen.dm.grpc.pkg.server.ServerPg;
import cn.sanenen.dm.grpc.pkg.server.ServerServiceGrpc;
import io.grpc.Channel;

/**
 * @author sun
 **/
public class ControlClient {
    final ServerServiceGrpc.ServerServiceBlockingStub serverStub;

    public ControlClient(Channel channel) {
        serverStub = ServerServiceGrpc.newBlockingStub(channel);
    }

    public String registerDmClient(int port) {
        ServerPg.RegisterDmTerminalResponse clientResponse = serverStub.registerDmTerminal(ServerPg.RegisterDmTerminalRequest.newBuilder()
                .setPort(port).build());
        return clientResponse.getIp();
    }
}
