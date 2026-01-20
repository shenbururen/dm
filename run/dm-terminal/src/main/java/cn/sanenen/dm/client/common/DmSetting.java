package cn.sanenen.dm.client.common;

import cn.hutool.setting.Setting;

/**
 * @author sun
 **/
public class DmSetting {
    private static final Setting setting;

    static {
        setting = new Setting("dm.setting");
    }
    
    public static String getControlHost() {
        return setting.get("controlHost");
    }
    public static int getControlPort() {
        return setting.getInt("controlPort");
    }
    
    public static String getId() {
        return setting.get("id");
    }
    public static String getName() {
        return setting.get("name");
    }
    
}
