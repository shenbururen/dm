package cn.sanenen.dm.server.grpc.client;

import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaPg;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.Channel;

/**
 * @author sun
 **/
public class BaseClient {
    final BaseJavaServiceGrpc.BaseJavaServiceBlockingStub baseStub;

    public BaseClient(Channel channel) {
        baseStub = BaseJavaServiceGrpc.newBlockingStub(channel);
    }

    public long registerDmClient() {
        BaseJavaPg.getCurrentPIDResponse response = baseStub.getCurrentPID(Empty.newBuilder().build());
        return response.getPid();
    }
}
