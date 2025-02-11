package cn.sanenen.dm.common;

import cn.hutool.setting.Setting;

/**
 * @author sun
 **/
public class DmSetting {
    private static final Setting setting;

    static {
        setting = new Setting("dm.setting");
    }
    
}
