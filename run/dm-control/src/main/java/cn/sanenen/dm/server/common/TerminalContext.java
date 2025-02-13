package cn.sanenen.dm.server.common;

import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.common.GameStatus;
import cn.sanenen.dm.grpc.GrpcChannel;
import cn.sanenen.dm.grpc.pkg.terminal.dm.DmCallServiceGrpc;
import cn.sanenen.dm.server.fx.service.MainService;
import cn.sanenen.dm.server.game.GameStart;
import cn.sanenen.dm.server.grpc.client.BaseClient;
import cn.sanenen.dm.server.grpc.client.DmApiClientFactory;

/**
 * @author sun
 **/
public class TerminalContext {
    private static final Log log = Log.get();
    
    public final GrpcChannel grpcClient;
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
        grpcClient = new GrpcChannel(host, port);
        grpcClient.setConnectFailHandler(() -> {
            log.info("终端grpc连接失败，释放资源：{}", host);
            MainService mainService = Singleton.get(MainService.class);
            mainService.setTerminalStatus(host, GameStatus.grpc_error);
            try {
                GameStart.stopGame(host);
                TerminalCache.removeTerminal(host);
            } catch (Exception e) {
                log.error(e);
            }
        });
        grpcClient.startHeartbeat();
        dmStub = DmCallServiceGrpc.newBlockingStub(grpcClient.getChannel());
        dmMain = DmApiClientFactory.newDmApi(dmStub, "dm.main");
        dmMonitor = DmApiClientFactory.newDmApi(dmStub, "dm.monitor");
        
        baseClient = new BaseClient(grpcClient.getChannel());
    }
    
    public void shutdown() throws InterruptedException {
        grpcClient.shutdown();
    }
}
