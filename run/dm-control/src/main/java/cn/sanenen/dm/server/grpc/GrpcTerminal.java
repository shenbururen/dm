package cn.sanenen.dm.server.grpc;

import cn.hutool.core.util.IdUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;
import cn.sanenen.dm.server.common.WaitPool;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.concurrent.*;

/**
 *
 * @author sun
 * @date 2026-01-16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GrpcTerminal {
    private static final Log log = Log.get();
    private static final Duration TIMEOUT = Duration.ofSeconds(60);

    private String terminalId;
    private String terminalName;
    private String terminalIp;
    private StreamObserver<ControlServerPg.ServerMessage> responseObserver;
    
    public ControlServerPg.ClientMessage sendServerMessage(ControlServerPg.ServerMessage.Builder request) {
        String messageId = IdUtil.fastUUID();
        request.setMessageId(messageId);
        try {
            CompletableFuture<ControlServerPg.ClientMessage> f = new CompletableFuture<>();
            WaitPool.put(messageId, f);
            responseObserver.onNext(request.build());
            //等待客户端异步返回
            return f.get(TIMEOUT.toSeconds(), TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            log.error(e);
            WaitPool.remove(messageId);
        }
        return null;
    }

    public ControlServerPg.DmCallResponse callDm(ControlServerPg.DmCallRequest request) {
        ControlServerPg.ClientMessage response = this.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setDmCallRequest(request));
        return response.getDmCallResponse();
    }

    public void shutdown() {
        responseObserver.onCompleted();
    }

    public void delAllFiles() {
        this.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setDelAllFilesRequest(ControlServerPg.DelAllFilesRequest.newBuilder().build()));
    }
}
