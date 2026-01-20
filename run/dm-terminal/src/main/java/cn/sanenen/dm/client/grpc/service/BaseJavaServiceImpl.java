package cn.sanenen.dm.client.grpc.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.log.Log;
import cn.hutool.system.SystemUtil;
import cn.sanenen.dm.client.Main;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;

import java.io.File;
import java.util.List;

/**
 * @author sun
 **/
public class BaseJavaServiceImpl {
    private static final Log log = Log.get();

    public ControlServerPg.GetCurrentPIDResponse getCurrentPID() {
        return ControlServerPg.GetCurrentPIDResponse.newBuilder()
                .setPid(SystemUtil.getCurrentPID())
                .build();
    }

    public ControlServerPg.GetHasFilesResponse getHasFiles() {
        ControlServerPg.GetHasFilesResponse.Builder builder = ControlServerPg.GetHasFilesResponse.newBuilder();
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        log.info("文件列表：{}", dmFilesDir.getPath());
        List<File> files = FileUtil.loopFiles(dmFilesDir);
        if (CollUtil.isNotEmpty(files)) {
            for (File file : files) {
                ControlServerPg.GetHasFilesResponse.HasFile.Builder hasFileBuilder =
                        ControlServerPg.GetHasFilesResponse.HasFile.newBuilder();
                hasFileBuilder.setFileSize(FileUtil.size(file));
                hasFileBuilder.setFileName(FileUtil.getName(file));
                hasFileBuilder.setFilePath(FileUtil.subPath(dmFilesDir.getPath(), file));
                builder.addHasFiles(hasFileBuilder.build());
            }
        }
        return builder.build();
    }

    public ControlServerPg.UploadFileResponse uploadFile(ControlServerPg.UploadFileRequest request) {
        log.info("接受到文件：{} {}", request.getFilePath(), request.getFileName());
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        File file = FileUtil.file(dmFilesDir, request.getFilePath());
        FileUtil.writeBytes(request.getFileBytes().toByteArray(), file);
        return ControlServerPg.UploadFileResponse.newBuilder().build();
    }

    public ControlServerPg.DelAllFilesResponse delAllFiles(ControlServerPg.DelAllFilesRequest request) {
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        for (File file : FileUtil.loopFiles(dmFilesDir)) {
            try {
                FileUtil.del(file);
            } catch (Exception e) {
                log.error("删除文件失败：{},e:{}", file.getPath(), e.getMessage());
            }
        }
        return ControlServerPg.DelAllFilesResponse.newBuilder().build();
    }

    public ControlServerPg.RestartResponse restart(ControlServerPg.RestartRequest request) {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(100);
            Main.restart();
        });
        return ControlServerPg.RestartResponse.newBuilder().build();
    }
}
