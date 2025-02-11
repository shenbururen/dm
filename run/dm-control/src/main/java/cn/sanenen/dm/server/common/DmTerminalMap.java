package cn.sanenen.dm.server.common;

import cn.sanenen.dm.base.DMRegHandler;
import cn.sanenen.dm.base.DmApi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sun
 * @date 2025-02-10
 **/
public class DmTerminalMap {
    private static final Map<String, DmApi> DmTerminalMap = new ConcurrentHashMap<>();

    public static DmApi getDmApi(String ip) {
        return DmTerminalMap.computeIfAbsent(ip, key -> DMRegHandler.newDmObject(DmApi.class));
    }
}
