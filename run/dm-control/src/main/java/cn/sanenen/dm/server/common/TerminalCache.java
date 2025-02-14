package cn.sanenen.dm.server.common;

import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sun
 **/
public class TerminalCache {
    private static final Log log = Log.get();
    public static Map<String, TerminalContext> terminalMap = new ConcurrentHashMap<>();
    public static Map<String, TerminalContext> terminalIpMap = new ConcurrentHashMap<>();

    public static boolean cacheTerminal(String ip, int port) {
        String key = StrUtil.format("{}:{}", ip, port);
        if (terminalMap.containsKey(key)) {
            log.trace("{} 终端服务已存在", key);
            return false;
        }
        TerminalContext terminalContext = terminalMap.computeIfAbsent(key
                , k -> new TerminalContext(ip, port));
        removeTerminal(ip);
        terminalIpMap.put(ip, terminalContext);
        log.info("{} 添加终端", key);
        return true;
    }
    
    public static TerminalContext getTerminalContext(String ip) {
        return terminalIpMap.get(ip);
    }
    
    public static void removeTerminal(String ip) {
        if (terminalIpMap.containsKey(ip)) {
            TerminalContext old = terminalIpMap.get(ip);
            String oldKey = StrUtil.format("{}:{}", ip, old.port);
            log.trace("{} 终端重连，旧终端关闭。", oldKey);
            terminalMap.remove(oldKey);
            old.shutdown();
            terminalIpMap.remove(ip);
        }
    }

}
