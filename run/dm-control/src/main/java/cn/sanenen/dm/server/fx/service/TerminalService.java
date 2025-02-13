package cn.sanenen.dm.server.fx.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.pkg.terminal.base.BaseJavaPg;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.TerminalContext;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.ptr.IntByReference;

import java.io.File;
import java.util.List;

/**
 * @author sun
 **/
public class TerminalService {
    private static final Log log = Log.get();
    public void delFiles(String ip) {
        log.info("删除文件");
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        terminalContext.baseClient.delAllFiles();
    }

    public void uploadFiles(String ip) {
        log.info("上传文件");
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        File mkdir = FileUtil.mkdir("test");
        File dmFilesDir = FileUtil.mkdir(Constant.DM_FILES);
        log.info("test：{}",mkdir.getPath());
        log.info("资源目录：{}",dmFilesDir.getPath());
        List<File> files = FileUtil.loopFiles(dmFilesDir);
        if (CollUtil.isNotEmpty(files)) {
            List<BaseJavaPg.getHasFilesResponse.HasFile> hasFiles = terminalContext.baseClient.getHasFiles();
            for (File file : files) {
                long size = FileUtil.size(file);
                String path = FileUtil.subPath(dmFilesDir.getPath(), file);
                boolean flag = true;
                for (BaseJavaPg.getHasFilesResponse.HasFile hasFile : hasFiles) {
                    if (path.equals(hasFile.getFilePath()) && size == hasFile.getFileSize()) {
                        log.info("资源已存在：{}",hasFile.getFilePath());
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    terminalContext.baseClient.uploadFile(file);
                }
            }
        }
    }

    public List<String> getHasFiles(String ip) {
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        List<BaseJavaPg.getHasFilesResponse.HasFile> hasFiles = terminalContext.baseClient.getHasFiles();
        return hasFiles.stream().map(BaseJavaPg.getHasFilesResponse.HasFile::getFilePath).toList();
    }

    public String getDmVer(String ip) {
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        return terminalContext.dmMain.Ver();
    }

    public void test(String ip) {
        TerminalContext terminalContext = TerminalCache.getTerminalContext(ip);
        DmApi dmMain = terminalContext.dmMain;
        
        Variant.VARIANT x = new Variant.VARIANT(new IntByReference());
        Variant.VARIANT y = new Variant.VARIANT(new IntByReference());
        long result = dmMain.FindPic(0, 0, 4000, 4000, "img/test1.bmp", "000000", 0.9, 0, x, y);
        log.info("FindPic:{}", result != -1 ? "成功" : "失败");
        if (result != -1) {
            log.info("x:{},y:{}", x.getValue(), y.getValue());
            long moveToResult = dmMain.MoveTo(x.intValue(), y.intValue());
            log.info("MoveTo:{}", moveToResult == 1 ? "成功" : "失败");
        }
        x.clear();
        y.clear();
    }
}
