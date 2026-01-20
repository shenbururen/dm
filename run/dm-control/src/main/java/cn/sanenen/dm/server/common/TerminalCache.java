package cn.sanenen.dm.server.common;

import cn.hutool.log.Log;
import cn.sanenen.dm.server.grpc.GrpcTerminal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sun
 **/
public class TerminalCache {
    private static final Log log = Log.get();
    public static Map<String, TerminalContext> terminalMap = new ConcurrentHashMap<>();

    public static boolean cacheTerminal(GrpcTerminal grpcTerminal) {
        if (terminalMap.containsKey(grpcTerminal.getTerminalId())) {
            log.trace("{} 终端服务已存在", grpcTerminal.getTerminalId());
            return false;
        }
        terminalMap.computeIfAbsent(grpcTerminal.getTerminalId()
                , k -> new TerminalContext(grpcTerminal));
        log.info("{} 添加终端", grpcTerminal.getTerminalId());
        return true;
    }
    
    public static TerminalContext getTerminalContext(String terminalId) {
        return terminalMap.get(terminalId);
    }
    
    public static void removeTerminal(String terminalId) {
        if (terminalMap.containsKey(terminalId)) {
            TerminalContext old = terminalMap.remove(terminalId);
            log.trace("{} 终端断开，终端关闭。", terminalId);
            old.shutdown();
        }
    }
    
    public static void shoutdownAllTerminal() {
        for (String terminalId : terminalMap.keySet()) {
            removeTerminal(terminalId);
        }
    }

}
