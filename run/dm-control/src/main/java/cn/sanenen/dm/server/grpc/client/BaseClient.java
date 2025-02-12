package cn.sanenen.dm.server.grpc.client;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaPg;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaServiceGrpc;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;
import io.grpc.Channel;

import java.io.File;
import java.util.List;

/**
 * @author sun
 **/
public class BaseClient {
    private static final Log log = Log.get();
    final BaseJavaServiceGrpc.BaseJavaServiceBlockingStub baseStub;

    public BaseClient(Channel channel) {
        baseStub = BaseJavaServiceGrpc.newBlockingStub(channel);
    }

    public long getCurrentPID() {
        BaseJavaPg.getCurrentPIDResponse response = baseStub.getCurrentPID(Empty.newBuilder().build());
        return response.getPid();
    }
    
    public List<BaseJavaPg.getHasFilesResponse.HasFile> getHasFiles() {
        BaseJavaPg.getHasFilesResponse response = baseStub.getHasFiles(Empty.newBuilder().build());
        return response.getHasFilesList();
    }
    
    public void delAllFiles() {
        baseStub.delAllFiles(Empty.newBuilder().build());
    }
    
    public void uploadFile(File file) {
        File parent = FileUtil.file(Constant.DM_FILES);
        String filePath = FileUtil.subPath(parent.getPath(), file);
        BaseJavaPg.uploadFileRequest request = BaseJavaPg.uploadFileRequest.newBuilder()
                .setFilePath(filePath)
                .setFileName(FileUtil.getName(file))
                .setFileBytes(ByteString.copyFrom(FileUtil.readBytes(file)))
                .build();
        log.info("上传文件：{}", filePath);
        baseStub.uploadFile(request);
    }
}
