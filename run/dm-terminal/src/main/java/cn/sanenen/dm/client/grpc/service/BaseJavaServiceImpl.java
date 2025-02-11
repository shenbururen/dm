package cn.sanenen.dm.client.grpc.service;

import cn.hutool.system.SystemUtil;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaPg;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

/**
 * @author sun
 **/
public class BaseJavaServiceImpl extends BaseJavaServiceGrpc.BaseJavaServiceImplBase {

    @Override
    public void getCurrentPID(Empty request, StreamObserver<BaseJavaPg.getCurrentPIDResponse> responseObserver) {
        responseObserver.onNext(BaseJavaPg.getCurrentPIDResponse.newBuilder()
                .setPid(SystemUtil.getCurrentPID())
                .build());
        responseObserver.onCompleted();
    }
}
