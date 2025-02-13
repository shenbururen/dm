package cn.sanenen.dm.base;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.Constant;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.util.Factory;
import com.sun.jna.platform.win32.Ole32;

/**
 * @author sun
 **/
public class DMRegHandler {
    private static final Log log = Log.get();
    private static volatile DMRegHandler DM_REG_HANDLER;
    
    private final Factory FACTORY;
    private final DmReg dmReg;
    
    static {
        Ole32.INSTANCE.CoInitializeEx(Pointer.NULL, Ole32.COINIT_SPEED_OVER_MEMORY + Ole32.COINIT_MULTITHREADED);
    }

    private DMRegHandler() {
        dmReg = Native.load(Constant.DM_FILES + "/DmReg.dll", DmReg.class);
        int handler = handler();
        if (handler != 1) {
            log.error("免注册失败，终止运行。");
            System.exit(-1);
        }
        FACTORY = new Factory();
    }

    private void shutdown(){
        FACTORY.disposeAll();
        FACTORY.getComThread().terminate(10000);
        Native.unregister(DmReg.class);
        DM_REG_HANDLER = null;
    }
    
    /**
     * jna 调用标准免注册dll
     */
    private interface DmReg extends Library {
        /**
         * SetDllPathA  字符串(Ascii码表示插件所在的路径),整数(0表示STA，1表示MTA)
         */
        int SetDllPathA(String format, int args);

        /**
         * SetDllPathW  字符串(Unicode码表示插件所在的路径),整数(0表示STA，1表示MTA)
         */
        void SetDllPathW(String format, int args);
    }

    public int handler() {
        //获取dm.dll的绝对路径。
        String absolutePath = FileUtil.getAbsolutePath(Constant.DM_FILES + "/dm.dll");
        log.info("大漠插件路径:{}", absolutePath);
        int result = dmReg.SetDllPathA(absolutePath, 1);
        log.info("免注册调用结果：{}", result == 1 ? "成功" : "失败");
        return result;
    }

    public static <T> T newDmObject(Class<T> clazz) {
        if (DM_REG_HANDLER == null) {
            synchronized (DMRegHandler.class) {
                if (DM_REG_HANDLER == null){
                    DM_REG_HANDLER = new DMRegHandler();
                }
            }
        }
        //log.info("创建 大漠对象 version:{}", dmObject.Ver());
        return DM_REG_HANDLER.FACTORY.createObject(clazz);
    }
    public static void shutdownDmObject(){
        if (DM_REG_HANDLER != null){
            DM_REG_HANDLER.shutdown();
        }
    }
}
