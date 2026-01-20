package cn.sanenen.dm.grpc;

import cn.sanenen.dm.grpc.pkg.control.ControlServerServiceGrpc;

/**
 *
 * @author sun
 * @date 2026-01-16
 **/
public class Main {
    public static void main(String[] args) {
        GrpcChannel channel = new GrpcChannel("127.0.0.1", 50051);
        ControlServerServiceGrpc.ControlServerServiceFutureStub stub = ControlServerServiceGrpc.newFutureStub(null);
        
    }
}
