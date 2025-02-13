package cn.sanenen.dm.client.common;

import cn.sanenen.dm.base.DMRegHandler;
import cn.sanenen.dm.base.DmApi;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sun
 **/
public class DmApiMap {
    private static final Map<String, DmApi> dmApiMap = new ConcurrentHashMap<>();

    public static DmApi getDmApi(String dmInstanceId) {
        return dmApiMap.computeIfAbsent(dmInstanceId, key -> DMRegHandler.newDmObject(DmApi.class));
    }
    
    public static void releaseAllDmApi() {
        Iterator<Map.Entry<String, DmApi>> iterator = dmApiMap.entrySet().iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        DMRegHandler.shutdownDmObject();
    }
}
