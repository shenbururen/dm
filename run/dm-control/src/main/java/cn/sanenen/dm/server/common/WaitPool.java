package cn.sanenen.dm.server.common;

import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public final class WaitPool {
    private static final ConcurrentHashMap<String, CompletableFuture<ControlServerPg.ClientMessage>> MSG_MAP =
            new ConcurrentHashMap<>();


    public static void put(String messageId, CompletableFuture<ControlServerPg.ClientMessage> f) {
        MSG_MAP.put(messageId, f);
    }

    public static CompletableFuture<ControlServerPg.ClientMessage> remove(String messageId) {
        return MSG_MAP.remove(messageId);
    }
}