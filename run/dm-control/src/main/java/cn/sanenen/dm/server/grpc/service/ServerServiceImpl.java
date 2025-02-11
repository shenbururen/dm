package cn.sanenen.dm.server.grpc.service;


import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.grpc.common.MessageUtil;
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
    private static final Log log = Log.get();

    @Override
    public void registerDmTerminal(ServerPg.RegisterDmTerminalRequest request, StreamObserver<ServerPg.RegisterDmTerminalResponse> responseObserver) {
        log.info("registerDmTerminal {}", MessageUtil.printJson(request));
        MainService mainService = Singleton.get(MainService.class);
        Context.Key<String> clientIpKey = ServerStart.clientIpKey;
        String ip = clientIpKey.get();
        try {
            mainService.registerDmTerminal(ip, request.getPort());
            responseObserver.onNext(ServerPg.RegisterDmTerminalResponse.newBuilder().setIp(ip).build());
            responseObserver.onCompleted();
        } catch (InterruptedException e) {
            log.error(e);
            responseObserver.onError(e);
        }
    }
}
