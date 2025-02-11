package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 键鼠
 * key_str     虚拟键码
 * "1",          49
 * "2",          50
 * "3",          51
 * "4",          52
 * "5",          53
 * "6",          54
 * "7",          55
 * "8",          56
 * "9",          57
 * "0",          48
 * "-",          189
 * "=",          187
 * "back",       8
 * "a",          65
 * "b",          66
 * "c",          67
 * "d",          68
 * "e",          69
 * "f",          70
 * "g",          71
 * "h",          72
 * "i",          73
 * "j",          74
 * "k",          75
 * "l",          76
 * "m",          77
 * "n",          78
 * "o",          79
 * "p",          80
 * "q",          81
 * "r",          82
 * "s",          83
 * "t",          84
 * "u",          85
 * "v",          86
 * "w",          87
 * "x",          88
 * "y",          89
 * "z",          90
 * "ctrl",       17
 * "alt",        18
 * "shift",      16
 * "win",        91
 * "space",      32
 * "cap",        20
 * "tab",        9
 * "~",          192
 * "esc",        27
 * "enter",      13
 * "up",         38
 * "down",       40
 * "left",       37
 * "right",      39
 * "option",     93
 * "print",      44
 * "delete",     46
 * "home",       36
 * "end",        35
 * "pgup",       33
 * "pgdn",       34
 * "f1",         112
 * "f2",         113
 * "f3",         114
 * "f4",         115
 * "f5",         116
 * "f6",         117
 * "f7",         118
 * "f8",         119
 * "f9",         120
 * "f10",        121
 * "f11",        122
 * "f12",        123
 * "[",          219
 * "]",          221
 * "\\",         220
 * ";",          186
 * "'",          222
 * ",",          188
 * ".",          190
 * "/",          191
 *
 * @author sun
 **/
public interface KeyMouseApi {

    /**
     * 设置当前系统鼠标的精确度开关. 如果所示。 此接口仅仅对前台MoveR接口起作用.
     *
     * @param enable 整形数: 0 关闭指针精确度开关. 1打开指针精确度开关. 一般推荐关闭.
     * @return 整形数:
     * 设置之前的精确度开关.
     */
    @ComMethod
    long EnableMouseAccuracy(int enable);

    /**
     * 获取鼠标位置.
     *
     * @param x 变参指针: 返回X坐标
     * @param y 变参指针: 返回Y坐标
     * @return 整形数:
     * 0 : 失败
     * 1 : 成功
     */
    @ComMethod
    long GetCursorPos(int[] x, int[] y);

    /**
     * 获取鼠标特征码. 当BindWindow或者BindWindowEx中的mouse参数含有dx.mouse.cursor时，
     * 获取到的是后台鼠标特征，否则是前台鼠标特征.
     *
     * @return 字符串:
     * 成功时，返回鼠标特征码.
     * 失败时，返回空的串.
     */
    @ComMethod
    String GetCursorShape();

    /**
     * 获取鼠标特征码. 当BindWindow或者BindWindowEx中的mouse参数含有dx.mouse.cursor时，
     * 获取到的是后台鼠标特征，否则是前台鼠标特征.
     *
     * @param type 整形数:获取鼠标特征码的方式. 和工具中的方式1 方式2对应. 方式1此参数值为0. 方式2此参数值为1.
     * @return 字符串:
     * 成功时，返回鼠标特征码.
     * 失败时，返回空的串.
     */
    @ComMethod
    String GetCursorShapeEx(int type);

    /**
     * 获取鼠标热点位置.(参考工具中抓取鼠标后，那个闪动的点就是热点坐标,不是鼠标坐标)
     * 当BindWindow或者BindWindowEx中的mouse参数含有dx.mouse.cursor时，
     * 获取到的是后台鼠标热点位置，否则是前台鼠标热点位置.
     *
     * @return 字符串:
     * 成功时，返回形如"x,y"的字符串
     * 失败时，返回空的串.
     */
    @ComMethod
    String GetCursorSpot();

    /**
     * 获取指定的按键状态.(前台信息,不是后台)
     *
     * @param vk_code 整形数:虚拟按键码
     * @return 整形数:
     * 0:弹起
     * 1:按下
     */
    @ComMethod
    long GetKeyState(int vk_code);

    /**
     * 获取系统鼠标的移动速度. 如图所示红色区域. 一共分为11个级别. 从1开始,11结束. 这仅是前台鼠标的速度. 后台不用理会这个.
     *
     * @return 整形数:
     * 0:失败
     * 其他值,当前系统鼠标的移动速度
     */
    @ComMethod
    long GetMouseSpeed();

    /**
     * 按住指定的虚拟键码
     *
     * @param vk_code 整形数:虚拟按键码
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyDown(int vk_code);

    /**
     * 按住指定的虚拟键码
     *
     * @param key_str 字符串: 字符串描述的键码. 大小写无所谓.
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyDownChar(String key_str);

    /**
     * 按下指定的虚拟键码
     *
     * @param vk_code 整形数:虚拟按键码
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyPress(int vk_code);

    /**
     * 按下指定的虚拟键码
     *
     * @param key_str 字符串: 字符串描述的键码. 大小写无所谓.
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyPressChar(String key_str);

    /**
     * 根据指定的字符串序列，依次按顺序按下其中的字符.
     *
     * @param key_str 字符串: 需要按下的字符串序列. 比如"1234","abcd","7389,1462"等.
     * @param delay   整形数: 每按下一个按键，需要延时多久. 单位毫秒.这个值越大，按的速
     *                度越慢。
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyPressStr(String key_str, int delay);

    /**
     * 弹起来虚拟键vk_code
     *
     * @param vk_code 整形数:虚拟按键码
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyUp(int vk_code);

    /**
     * 弹起来虚拟键key_str
     *
     * @param key_str 字符串: 字符串描述的键码. 大小写无所谓.
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long KeyUpChar(String key_str);

    /**
     * 按下鼠标左键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long LeftClick();

    /**
     * 双击鼠标左键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long LeftDoubleClick();

    /**
     * 按住鼠标左键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long LeftDown();

    /**
     * 弹起鼠标左键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long LeftUp();

    /**
     * 按下鼠标中键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long MiddleClick();

    /**
     * 按住鼠标中键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long MiddleDown();

    /**
     * 弹起鼠标中键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long MiddleUp();

    /**
     * 鼠标相对于上次的位置移动rx,ry. 如果您要使前台鼠标移动的距离和指定的rx,ry一致,最好配合EnableMouseAccuracy
     * 函数来使用.
     *
     * @param rx 整形数:相对于上次的X偏移
     * @param ry 整形数:相对于上次的Y偏移
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long MoveR(int rx, int ry);

    /**
     * 把鼠标移动到目的点(x,y)
     *
     * @param x 整形数:X坐标
     * @param y 整形数:Y坐标
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long MoveTo(int x, int y);

    /**
     * 把鼠标移动到目的范围内的任意一点
     *
     * @param x 整形数:X坐标
     * @param y 整形数:Y坐标
     * @param w 整形数:宽度(从x计算起)
     * @param h 整形数:高度(从y计算起)
     * @return 字符串:
     * 返回要移动到的目标点. 格式为x,y. 比如MoveToEx 100,100,10,10,返回值可能
     * 是101,102
     */
    @ComMethod
    String MoveToEx(int x, int y, int w, int h);

    /**
     * 按下鼠标右键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long RightClick();

    /**
     * 按住鼠标右键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long RightDown();

    /**
     * 弹起鼠标右键
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long RightUp();

    /**
     * 设置按键时,键盘按下和弹起的时间间隔。高级用户使用。某些窗口可能需要调整
     * 这个参数才可以正常按键。
     *
     * @param type  字符串: 键盘类型,取值有以下
     *              "normal" : 对应normal键盘 默认内部延时为30ms
     *              "windows": 对应windows 键盘 默认内部延时为10ms
     *              "dx" : 对应dx 键盘 默认内部延时为50ms
     * @param delay 整形数: 延时,单位是毫秒
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long SetKeypadDelay(String type, int delay);

    /**
     * 设置鼠标单击或者双击时,鼠标按下和弹起的时间间隔。高级用户使用。某些窗口
     * 可能需要调整这个参数才可以正常点击。
     *
     * @param type  字符串: 鼠标类型,取值有以下
     *              "normal" : 对应normal鼠标 默认内部延时为 30ms
     *              "windows": 对应windows 鼠标 默认内部延时为 10ms
     *              "dx" : 对应dx鼠标 默认内部延时为40ms
     * @param delay 整形数: 延时,单位是毫秒
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long SetMouseDelay(String type, int delay);

    /**
     * 设置系统鼠标的移动速度. 如图所示红色区域. 一共分为11个级别. 从1开始,11
     * 结束。此接口仅仅对前台鼠标有效.
     *
     * @param speed 整形数:鼠标移动速度, 最小1，最大11. 居中为6. 推荐设置为6
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long SetMouseSpeed(int speed);

    /**
     * 设置前台键鼠的模拟方式.
     * 驱动功能支持的系统版本号为(win7/win8/win8.1/win10(10240)/win10
     * (10586)/win10(15063)/win10(16299)/win10(17134)/win10(17763)/win10(18362)/win10(18363)/win10(19041)/win10(19042) /win10
     * (19043)/ win10(19045)/win11(22000)/win11(22621)
     * 不支持所有的预览版本,仅仅支持正式版本. 除了模式3,其他模式同时支持32位系
     * 统和64位系统.
     *
     * @param mode 整形数: 0 正常模式(默认模式)
     *             1 硬件模拟
     *             2 硬件模拟2(ps2)（仅仅支持标准的3键鼠标，即左键，右键，中
     *             键，带滚轮的鼠标,2键和5键等扩展鼠标不支持）
     *             3 硬件模拟3
     * @return 整形数:
     * 0 : 插件没注册-1 : 32位系统不支持-2 : 驱动释放失败.-3 : 驱动加载失败.可能是权限不够. 参考UAC权限设置. 或者是被安全软件拦截.
     * -10: 设置失败
     * -7 : 系统版本不支持. 可以用winver命令查看系统内部版本号. 驱动只支持正式
     * 发布的版本，所有预览版本都不支持.
     * 1 : 成功
     */
    @ComMethod
    long SetSimMode(int mode);

    /**
     * 等待指定的按键按下 (前台,不是后台)
     *
     * @param vk_code  整形数:虚拟按键码,当此值为0，表示等待任意按键。 鼠标左键是1,鼠标
     *                 右键时2,鼠标中键是4.
     * @param time_out 整形数:等待多久,单位毫秒. 如果是0，表示一直等待
     * @return 整形数:
     * 0:超时
     * 1:指定的按键按下 (当vk_code不为0时)
     * 按下的按键码:(当vk_code为0时)
     */
    @ComMethod
    long WaitKey(int vk_code, int time_out);

    /**
     * 滚轮向下滚
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long WheelDown();

    /**
     * 滚轮向上滚
     *
     * @return 整形数:
     * 0:失败
     * 1:成功
     */
    @ComMethod
    long WheelUp();

}
