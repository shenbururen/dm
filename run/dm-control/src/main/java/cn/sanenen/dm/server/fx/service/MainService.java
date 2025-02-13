package cn.sanenen.dm.server.fx.service;

import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.common.GameStatus;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.fx.controller.MainController;
import cn.sanenen.dm.server.fx.model.entity.TableData;

/**
 * @author sun
 **/
public class MainService {

    public void registerDmTerminal(String ip, int port) throws InterruptedException {
        MainController mainController = Singleton.get(MainController.class);

        boolean isNew = TerminalCache.cacheTerminalServer(ip, port);
        
        if (isNew) {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.uploadFiles(ip);
            TableData tableData = new TableData();
            tableData.setIp(ip);
            tableData.setPort(port);
            mainController.addDmTerminal(tableData);
        }
        
    }

    public void setTerminalStatus(String ip, GameStatus status) {
        MainController mainController = Singleton.get(MainController.class);
        TableData terminalData = mainController.getDmTerminal(ip);
        terminalData.setStatus(status.desc);
    }

    public void setTerminalVersion(String ip, String dmVersion) {
        MainController mainController = Singleton.get(MainController.class);
        TableData terminalData = mainController.getDmTerminal(ip);
        terminalData.setVersion(dmVersion);
    }
}
