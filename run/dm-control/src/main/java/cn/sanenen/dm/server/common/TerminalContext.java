package cn.sanenen.dm.server.common;

import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.grpc.GrpcClient;
import cn.sanenen.dm.grpc.pkg.client.dm.DmCallServiceGrpc;
import cn.sanenen.dm.server.grpc.client.BaseClient;
import cn.sanenen.dm.server.grpc.client.DmApiClientFactory;

/**
 * @author sun
 **/
public class TerminalContext {
    private final GrpcClient grpcClient;
    private final DmCallServiceGrpc.DmCallServiceBlockingStub dmStub;
    
    public final int port;

    public final BaseClient baseClient;
    /**
     * 主线程 大漠对象
     */
    public final DmApi dmMain;
    /**
     * 监控线程 大漠对象
     */
    public final DmApi dmMonitor;
    

    public TerminalContext(String host, int port) {
        this.port = port;
        grpcClient = new GrpcClient(host, port);
        dmStub = DmCallServiceGrpc.newBlockingStub(grpcClient.getChannel());
        dmMain = DmApiClientFactory.newDmApi(dmStub, "dm.main");
        dmMonitor = DmApiClientFactory.newDmApi(dmStub, "dm.monitor");
        
        baseClient = new BaseClient(grpcClient.getChannel());
    }
    
    public String getDmVersion() {
        return dmMain.Ver();
    }
    
    public void shutdown() throws InterruptedException {
        grpcClient.shutdown();
    }
}
