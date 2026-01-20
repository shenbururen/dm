package cn.sanenen.dm.client.common;

import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;

@FunctionalInterface
public interface CmdHandler {
    ControlServerPg.ClientMessage.Builder handle(ControlServerPg.ServerMessage msg);
}