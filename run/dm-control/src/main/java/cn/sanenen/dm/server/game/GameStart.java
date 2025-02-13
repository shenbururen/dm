package cn.sanenen.dm.server.game;

import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.GameStatus;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.TerminalContext;
import cn.sanenen.dm.server.fx.service.MainService;
import cn.sanenen.dm.server.game.service.GameService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sun
 **/
public class GameStart {
    private static final Log log = Log.get();
    private static final Map<String, GameStart> cache = new ConcurrentHashMap<>();

    public static GameStart getInstance(String ip) {
        return cache.computeIfAbsent(ip, k -> new GameStart(ip));
    }

    private final TerminalContext terminalContext;
    private final GameService gameService;
    private final MainService mainService;
    private volatile boolean isStart = false;
    private final String ip;

    public GameStart(String ip) {
        this.ip = ip;
        terminalContext = TerminalCache.getTerminalContext(ip);
        gameService = Singleton.get(GameService.class);
        mainService = Singleton.get(MainService.class);
    }

    public void start() {
        synchronized (ip.intern()) {
            if (isStart) {
                log.info("已启动");
                return;
            }
            isStart = true;
        }
        
        GameStatus status = gameService.identifyTheCurrentStatusOfTheTerminal(ip);
        String dmVersion = terminalContext.getDmVersion();

        mainService.setTerminalStatus(ip, status);
        mainService.setTerminalVersion(ip, dmVersion);
    }
}
