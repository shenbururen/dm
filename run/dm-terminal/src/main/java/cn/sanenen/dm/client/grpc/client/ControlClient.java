package cn.sanenen.dm.client.grpc.client;

import cn.sanenen.dm.grpc.pkg.control.ControlPg;
import cn.sanenen.dm.grpc.pkg.control.ControlServiceGrpc;
import io.grpc.Channel;

/**
 * @author sun
 **/
public class ControlClient {
    final ControlServiceGrpc.ControlServiceBlockingStub serverStub;

    public ControlClient(Channel channel) {
        serverStub = ControlServiceGrpc.newBlockingStub(channel);
    }

    public String registerDmClient(int port) {
        ControlPg.RegisterDmTerminalResponse clientResponse = serverStub.registerDmTerminal(ControlPg.RegisterDmTerminalRequest.newBuilder()
                .setPort(port).build());
        return clientResponse.getIp();
    }
}
