package cn.sanenen.dm.server.fx.service;

import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.common.TerminalStatus;
import cn.sanenen.dm.server.common.StageCache;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.fx.controller.MainController;
import cn.sanenen.dm.server.fx.controller.TerminalOperateController;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import cn.sanenen.dm.server.grpc.GrpcTerminal;
import javafx.application.Platform;

/**
 * @author sun
 **/
public class MainService {

    public void registerDmTerminal(GrpcTerminal grpcTerminal) throws InterruptedException {
        MainController mainController = Singleton.get(MainController.class);

        boolean isNew = TerminalCache.cacheTerminal(grpcTerminal);

        if (isNew) {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.uploadFiles(grpcTerminal.getTerminalId());
            TableData tableData = new TableData();
            tableData.setIp(grpcTerminal.getTerminalId());
            mainController.addDmTerminal(tableData);
        }
    }

    public void setTerminalStatus(String ip, TerminalStatus status) {
        MainController mainController = Singleton.get(MainController.class);
        TableData terminalData = mainController.getDmTerminal(ip);
        terminalData.setStatusEnum(status);
        if (status.code <= TerminalStatus.error.code) {
            Platform.runLater(() -> {
                TerminalOperateController terminalOperateController = Singleton.get(TerminalOperateController.class);
                if (StageCache.terminalStage.isShowing() && ip.equals(terminalOperateController.getTableData().getIp())) {
                    StageCache.terminalStage.close();
                }
            });
        }
    }

    public void setTerminalVersion(String ip, String dmVersion) {
        MainController mainController = Singleton.get(MainController.class);
        TableData terminalData = mainController.getDmTerminal(ip);
        terminalData.setVersion(dmVersion);
    }
}
