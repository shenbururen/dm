package cn.sanenen.dm.grpc.common;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;

/**
 * @author sun
 **/
public class MessageUtil {
    private static final Log log = Log.get();

    public static String printJson(MessageOrBuilder request) {
        try {
            String print = JsonFormat.printer().print(request);
            return StrUtil.removeAll(print, CharUtil.CR, CharUtil.LF, CharUtil.SPACE);
        } catch (Exception e) {
            log.error(e);
        }
        return "";
    }
}
