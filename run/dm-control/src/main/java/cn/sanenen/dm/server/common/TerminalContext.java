package cn.sanenen.dm.server.common;

import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.common.TerminalStatus;
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

    public final String ip;
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


    public TerminalContext(String ip, int port) {
        this.ip = ip;
        this.port = port;
        grpcClient = new GrpcChannel(ip, port);
        grpcClient.setConnectFailHandler(() -> {
            log.info("终端grpc连接失败，释放资源：{}", ip);
            try {
                connectFailProcess(TerminalStatus.grpc_error);
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

    public void connectFailProcess(TerminalStatus status) {
        try {
            MainService mainService = Singleton.get(MainService.class);
            mainService.setTerminalStatus(ip, status);
            try {
                GameStart.stopGame(ip);
            } catch (Exception e) {
                log.error(e);
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
    
    public void shutdown() {
        try {
            grpcClient.shutdown();
            connectFailProcess(TerminalStatus.del_grpc);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
