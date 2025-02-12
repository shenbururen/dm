package cn.sanenen.dm.client.grpc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.system.SystemUtil;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaPg;
import cn.sanenen.dm.grpc.pkg.client.base.BaseJavaServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.util.List;

/**
 * @author sun
 **/
public class BaseJavaServiceImpl extends BaseJavaServiceGrpc.BaseJavaServiceImplBase {
    private static final Log log = Log.get();

    @Override
    public void getCurrentPID(Empty request, StreamObserver<BaseJavaPg.getCurrentPIDResponse> responseObserver) {
        responseObserver.onNext(BaseJavaPg.getCurrentPIDResponse.newBuilder()
                .setPid(SystemUtil.getCurrentPID())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getHasFiles(Empty request, StreamObserver<BaseJavaPg.getHasFilesResponse> responseObserver) {
        BaseJavaPg.getHasFilesResponse.Builder builder = BaseJavaPg.getHasFilesResponse.newBuilder();
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        log.info("获取文件列表：{}", dmFilesDir.getPath());
        List<File> files = FileUtil.loopFiles(dmFilesDir);
        if (CollUtil.isNotEmpty(files)) {
            for (File file : files) {
                BaseJavaPg.getHasFilesResponse.HasFile.Builder hasFileBuilder =
                        BaseJavaPg.getHasFilesResponse.HasFile.newBuilder();
                hasFileBuilder.setFileSize(FileUtil.size(file));
                hasFileBuilder.setFileName(FileUtil.getName(file));
                hasFileBuilder.setFilePath(FileUtil.subPath(dmFilesDir.getPath(), file));
                builder.addHasFiles(hasFileBuilder.build());
            }
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void uploadFile(BaseJavaPg.uploadFileRequest request, StreamObserver<Empty> responseObserver) {
        log.info("接受到文件：{} {}", request.getFilePath(), request.getFileName());
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        File file = FileUtil.file(dmFilesDir, request.getFilePath());
        FileUtil.writeBytes(request.getFileBytes().toByteArray(), file);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void delAllFiles(Empty request, StreamObserver<Empty> responseObserver) {
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        FileUtil.del(dmFilesDir);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
