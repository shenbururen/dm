package cn.sanenen.dm.server.game.service;

import cn.sanenen.dm.common.GameStatus;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.TerminalContext;

/**
 * @author sun
 **/
public class GameService {

    /**
     * 识别终端当前状态
     */
    public GameStatus identifyTheCurrentStatusOfTheTerminal(String ip) {
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        long l = terminalContext.dmMain.FindWindowByProcess("notepad.exe", "", "");
        if (l > 0) {
            return GameStatus.one;
        } else {
            return GameStatus.no_run;
        }
    }
}
