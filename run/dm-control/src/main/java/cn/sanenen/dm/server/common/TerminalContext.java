package cn.sanenen.dm.server.common;

import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.base.GrpcDmApi;
import cn.sanenen.dm.common.TerminalStatus;
import cn.sanenen.dm.server.fx.service.MainService;
import cn.sanenen.dm.server.game.GameStart;
import cn.sanenen.dm.server.grpc.GrpcTerminal;
import cn.sanenen.dm.server.grpc.client.BaseClient;
import cn.sanenen.dm.server.grpc.client.DmApiClientFactory;

/**
 * @author sun
 **/
public class TerminalContext {
    private static final Log log = Log.get();

    public final GrpcTerminal grpcTerminal;

    public final String id;
    public final String ip;

    /**
     * 主线程 大漠对象
     */
    public final GrpcDmApi dmMain;
    /**
     * 监控线程 大漠对象
     */
    public final GrpcDmApi dmMonitor;
    
    public final BaseClient baseClient;


    public TerminalContext(GrpcTerminal grpcTerminal) {
        this.grpcTerminal = grpcTerminal;
        this.ip = grpcTerminal.getTerminalIp();
        this.id = grpcTerminal.getTerminalId();
        this.dmMain = DmApiClientFactory.newDmApi(this.grpcTerminal, "dm.main");
        this.dmMonitor = DmApiClientFactory.newDmApi(this.grpcTerminal, "dm.monitor");
        this.baseClient = new BaseClient(this.grpcTerminal);
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
            grpcTerminal.shutdown();
            connectFailProcess(TerminalStatus.del_grpc);
        } catch (Exception e) {
            log.error(e);
        }
    }

}
