package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 系统
 *
 * @author sun
 **/
public interface SystemApi {

    /**
     * 蜂鸣器.
     *
     * @param f        频率
     * @param duration 时长(ms)
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long Beep(int f, int duration);

    /**
     * 检测当前系统是否有开启屏幕字体平滑.
     *
     * @return 0: 系统没开启平滑字体 1: 系统有开启平滑字体
     */
    @ComMethod
    long CheckFontSmooth();

    /**
     * 检测当前系统是否有开启UAC(用户账户控制).
     *
     * @return 0: 没开启UAC 1: 开启了UAC
     */
    @ComMethod
    long CheckUAC();

    /**
     * 延时指定的毫秒,过程中不阻塞UI操作.
     *
     * @param mis 毫秒数. 必须大于0
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long Delay(int mis);

    /**
     * 延时指定范围内随机毫秒,过程中不阻塞UI操作.
     *
     * @param mis_min 最小毫秒数. 必须大于0
     * @param mis_max 最大毫秒数. 必须大于0
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long Delays(int mis_min, int mis_max);

    /**
     * 设置当前的电源设置，禁止关闭显示器，禁止关闭硬盘，禁止睡眠，禁止待机.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long DisableCloseDisplayAndSleep();

    /**
     * 关闭当前系统屏幕字体平滑.同时关闭系统的ClearType功能.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long DisableFontSmooth();

    /**
     * 关闭电源管理，不会进入睡眠.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long DisablePowerSave();

    /**
     * 关闭屏幕保护.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long DisableScreenSave();

    /**
     * 开启当前系统屏幕字体平滑.同时开启系统的ClearType功能.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long EnableFontSmooth();

    /**
     * 退出系统(注销 重启 关机)
     *
     * @param type 0: 注销系统 1: 关机 2: 重新启动
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long ExitOs(int type);

    /**
     * 获取剪贴板的内容
     *
     * @return 剪贴板内容
     */
    @ComMethod
    String GetClipboard();

    /**
     * 获取当前CPU类型(intel或者amd).
     *
     * @return 0: 未知 1: Intel cpu 2: AMD cpu
     */
    @ComMethod
    long GetCpuType();

    /**
     * 获取当前CPU的使用率. 用百分比返回.
     *
     * @return 0-100表示的百分比
     */
    @ComMethod
    long GetCpuUsage();

    /**
     * 得到系统的路径
     *
     * @param type 0: 获取当前路径 1: 获取系统路径(system32路径) 2: 获取windows路径(windows所在路径) 3: 获取临时目录路径(temp) 4: 获取当前进程(exe)所在的路径
     * @return 返回路径
     */
    @ComMethod
    String GetDir(int type);

    /**
     * 获取本机的指定硬盘的厂商信息.
     *
     * @param index 硬盘序号. 表示是第几块硬盘. 从0开始编号,最小为0,最大为5
     * @return 字符串表达的硬盘厂商信息
     */
    @ComMethod
    String GetDiskModel(int index);

    /**
     * 获取本机的指定硬盘的修正版本信息.
     *
     * @param index 硬盘序号. 表示是第几块硬盘. 从0开始编号,最小为0,最大为5
     * @return 字符串表达的修正版本信息
     */
    @ComMethod
    String GetDiskReversion(int index);

    /**
     * 获取本机的指定硬盘的序列号.
     *
     * @param index 硬盘序号. 表示是第几块硬盘. 从0开始编号,最小为0,最大为5
     * @return 字符串表达的硬盘序列号
     */
    @ComMethod
    String GetDiskSerial(int index);

    /**
     * 获取本机的显卡信息.
     *
     * @return 字符串表达的显卡描述信息. 如果有多个显卡,用"|"连接
     */
    @ComMethod
    String GetDisplayInfo();

    /**
     * 判断当前系统的DPI(文字缩放)是不是100%缩放.
     *
     * @return 0: 不是 1: 是
     */
    @ComMethod
    long GetDPI();

    /**
     * 判断当前系统使用的非UNICODE字符集是否是GB2312(简体中文).
     *
     * @return 0: 不是GB2312(简体中文) 1: 是GB2312(简体中文)
     */
    @ComMethod
    long GetLocale();

    /**
     * 获取本机的机器码.(带网卡).
     *
     * @return 字符串表达的机器机器码
     */
    @ComMethod
    String GetMachineCode();

    /**
     * 获取本机的机器码.(不带网卡).
     *
     * @return 字符串表达的机器机器码
     */
    @ComMethod
    String GetMachineCodeNoMac();

    /**
     * 获取当前内存的使用率. 用百分比返回.
     *
     * @return 0-100表示的百分比
     */
    @ComMethod
    long GetMemoryUsage();

    /**
     * 从网络获取当前北京时间.
     *
     * @return 时间格式. 和now返回一致. 比如"2001-11-01 23:14:08"
     */
    @ComMethod
    String GetNetTime();

    /**
     * 根据指定时间服务器IP,从网络获取当前北京时间.
     *
     * @param ip IP或者域名,并且支持多个IP或者域名连接
     * @return 时间格式. 和now返回一致. 比如"2001-11-01 23:14:08"
     */
    @ComMethod
    String GetNetTimeByIp(String ip);

    /**
     * 得到操作系统的build版本号.
     *
     * @return build 版本号
     */
    @ComMethod
    long GetOsBuildNumber();

    /**
     * 得到操作系统的类型
     *
     * @return 0: win95/98/me/nt4.0 1: xp/2000 2: 2003/2003 R2/xp-64 3: win7/2008 R2 4: vista/2008 5: win8/2012 6: win8.1/2012 R2 7: win10/2016 TP/win11
     */
    @ComMethod
    long GetOsType();

    /**
     * 获取屏幕的色深.
     *
     * @return 返回系统颜色深度.(16或者32等)
     */
    @ComMethod
    long GetScreenDepth();

    /**
     * 获取屏幕的高度.
     *
     * @return 返回屏幕的高度
     */
    @ComMethod
    long GetScreenHeight();

    /**
     * 获取屏幕的宽度.
     *
     * @return 返回屏幕的宽度
     */
    @ComMethod
    long GetScreenWidth();

    /**
     * 获取指定的系统信息.
     *
     * @param type   取值如下 "cpuid" : 表示获取cpu序列号. method可取0和1 "disk_volume_serial id" : 表示获取分区序列号. id表示分区序号. 0表示C盘.1表示D盘.以此类推. 最高取到5. 也就是6个分区. method可取0 "bios_vendor" : 表示获取bios厂商信息. method可取0和1 "bios_version" : 表示获取bios版本信息. method可取0和1 "bios_release_date" : 表示获取bios发布日期. method可取0和1 "bios_oem" : 表示获取bios里的oem信息. method可取0 "board_vendor" : 表示获取主板制造厂商信息. method可取0和1 "board_product" : 表示获取主板产品信息. method可取0和1 "board_version" : 表示获取主板版本信息. method可取0和1 "board_serial" : 表示获取主板序列号. method可取0 "board_location" : 表示获取主板位置信息. method可取0 "system_manufacturer" : 表示获取系统制造商信息. method可取0 和1 "system_product" : 表示获取系统产品信息. method可取0和1 "system_serial" : 表示获取bios序列号. method可取0 "system_uuid" : 表示获取bios uuid. method可取0 "system_version" : 表示获取系统版本信息. method可取0和1 "system_sku" : 表示获取系统sku序列号. method可取0和1 "system_family" : 表示获取系统家族信息. method可取0和1 "product_id" : 表示获取系统产品id. method可取0 "system_identifier" : 表示获取系统标识. method可取0 "system_bios_version" : 表示获取系统BIOS版本号. method可取 0. 多个结果用"|"连接. "system_bios_date" : 表示获取系统BIOS日期. method可取0 method整形数: 获取方法. 一般从0开始取值.
     * @param method 获取方法. 一般从0开始取值.
     * @return 字符串表达的系统信息.
     */
    @ComMethod
    String GetSystemInfo(String type, int method);

    /**
     * 获取当前系统从开机到现在所经历过的时间，单位是毫秒
     *
     * @return 时间(单位毫秒)
     */
    @ComMethod
    long GetTime();

    /**
     * 判断当前系统是否是64位操作系统
     *
     * @return 0: 不是64位系统 1: 是64位系统
     */
    @ComMethod
    long Is64Bit();

    /**
     * 判断当前CPU是否支持vt,并且是否在bios中开启了vt. 仅支持intel的CPU.
     *
     * @return 0: 当前cpu不是intel的cpu,或者当前cpu不支持vt,或者bios中没打开vt. 1: 支持
     */
    @ComMethod
    long IsSurrpotVt();

    /**
     * 播放指定的MP3或者wav文件.
     *
     * @param media_file 指定的音乐文件，可以采用文件名或者绝对路径的形式.
     * @return 0: 失败 非0表示当前播放的ID。可以用Stop来控制播放结束.
     */
    @ComMethod
    long Play(String media_file);

    /**
     * 运行指定的应用程序.
     *
     * @param app_path 指定的可执行程序全路径.
     * @param mode     0: 普通模式 1: 加强模式
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long RunApp(String app_path, int mode);

    /**
     * 设置剪贴板的内容
     *
     * @param value 以字符串表示的剪贴板内容
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long SetClipboard(String value);

    /**
     * 设置当前系统的硬件加速级别.
     *
     * @param level 取值范围为0-5. 0表示关闭硬件加速。5表示完全打开硬件加速.
     * @return 0: 失败. 1: 成功.
     */
    @ComMethod
    long SetDisplayAcceler(int level);

    /**
     * 设置当前系统的非UNICOD字符集.
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long SetLocale();

    /**
     * 设置系统的分辨率 系统色深
     *
     * @param width  屏幕宽度
     * @param height 屏幕高度
     * @param depth  系统色深
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long SetScreen(int width, int height, int depth);

    /**
     * 设置当前系统的UAC(用户账户控制).
     *
     * @param enable 0: 关闭UAC 1: 开启UAC
     * @return 0: 操作失败 1: 操作成功
     */
    @ComMethod
    long SetUAC(int enable);

    /**
     * 显示或者隐藏指定窗口在任务栏的图标.
     *
     * @param hwnd    指定的窗口句柄
     * @param is_show 0为隐藏,1为显示
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long ShowTaskBarIcon(int hwnd, int is_show);

    /**
     * 停止指定的音乐.
     *
     * @param id Play返回的播放id.
     * @return 0: 失败 1: 成功.
     */
    @ComMethod
    long Stop(int id);

}
