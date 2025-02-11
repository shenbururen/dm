package cn.sanenen.dm.server.grpc.service;


import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.grpc.pkg.server.ServerPg;
import cn.sanenen.dm.grpc.pkg.server.ServerServiceGrpc;
import cn.sanenen.dm.server.fx.service.MainService;
import cn.sanenen.dm.server.grpc.ServerStart;
import io.grpc.Context;
import io.grpc.stub.StreamObserver;

/**
 * @author sun
 **/
public class ServerServiceImpl extends ServerServiceGrpc.ServerServiceImplBase {
    private MainService mainService = Singleton.get(MainService.class);

    @Override
    public void registerDmTerminal(ServerPg.RegisterDmTerminalRequest request, StreamObserver<ServerPg.RegisterDmTerminalResponse> responseObserver) {
        Context.Key<String> clientIpKey = ServerStart.clientIpKey;
        String ip = clientIpKey.get();
        mainService.registerDmTerminal(ip, request.getPort());
        responseObserver.onNext(ServerPg.RegisterDmTerminalResponse.newBuilder().setIp(ip).build());
        responseObserver.onCompleted();
    }
}
