package cn.sanenen.dm.server.grpc.client;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;
import cn.sanenen.dm.server.grpc.GrpcTerminal;
import com.google.protobuf.ByteString;

import java.io.File;
import java.util.List;

/**
 * @author sun
 **/
@SuppressWarnings("all")
public class BaseClient {
    private static final Log log = Log.get();
    final GrpcTerminal grpcTerminal;

    public BaseClient(GrpcTerminal grpcTerminal) {
        this.grpcTerminal = grpcTerminal;
    }

    public long getCurrentPID() {
        ControlServerPg.ClientMessage clientMessage = grpcTerminal.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setGetCurrentPIDRequest(ControlServerPg.GetCurrentPIDRequest.newBuilder().build()));
        return clientMessage.getGetCurrentPIDResponse().getPid();
    }

    public List<ControlServerPg.GetHasFilesResponse.HasFile> getHasFiles() {
        ControlServerPg.ClientMessage clientMessage = grpcTerminal.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setGetHasFilesRequest(ControlServerPg.GetHasFilesRequest.newBuilder().build()));
        return clientMessage.getGetHasFilesResponse().getHasFilesList();
    }

    public void delAllFiles() {
        grpcTerminal.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setDelAllFilesRequest(ControlServerPg.DelAllFilesRequest.newBuilder().build()));
        log.info("删除所有文件");
    }

    public void uploadFile(File file) {
        File parent = FileUtil.file(Constant.DM_FILES);
        String filePath = FileUtil.subPath(parent.getPath(), file);
        grpcTerminal.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setUploadFileRequest(ControlServerPg.UploadFileRequest.newBuilder()
                        .setFilePath(filePath)
                        .setFileName(FileUtil.getName(file))
                        .setFileBytes(ByteString.copyFrom(FileUtil.readBytes(file)))
                        .build())
        );
        log.info("上传文件：{}", filePath);
    }

    public void restart() {
        grpcTerminal.sendServerMessage(ControlServerPg.ServerMessage.newBuilder()
                .setRestartRequest(ControlServerPg.RestartRequest.newBuilder().build()));
    }
}
