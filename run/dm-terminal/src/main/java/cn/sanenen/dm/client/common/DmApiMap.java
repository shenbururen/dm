package cn.sanenen.dm.client.common;

import cn.sanenen.dm.base.DMRegHandler;
import cn.sanenen.dm.base.DmApi;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author sun
 **/
public class DmApiMap {
    private static final Map<String, DmApi> dmApiMap = new ConcurrentHashMap<>();

    public static DmApi getDmApi(String dmInstanceId, Consumer<DmApi> dmApiInit) {
        return dmApiMap.computeIfAbsent(dmInstanceId, key -> {
            DmApi dmApi = DMRegHandler.newDmObject(DmApi.class);
            if (dmApiInit != null) {
                dmApiInit.accept(dmApi);
            }
            return dmApi;
        });
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
