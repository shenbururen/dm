package cn.sanenen.dm.server.fx.service;

import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.TerminalContext;
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
            TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
            TableData sqlTableData = new TableData();
            sqlTableData.setIp(ip);
            sqlTableData.setPort(port);
            sqlTableData.setVersion(terminalContext.getDmVersion());
            mainController.addDmTerminal(sqlTableData);
        }
        
    }
}
