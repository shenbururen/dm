package cn.sanenen.dm.server.common;

import cn.hutool.setting.Setting;

/**
 * @author sun
 **/
public class DmSetting {
    private static final Setting setting;

    static {
        setting = new Setting("dm.setting");
    }
    
    public static int getControlPort() {
        return setting.getInt("controlPort");
    }
    
}
