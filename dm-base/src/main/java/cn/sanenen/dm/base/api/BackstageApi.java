package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 后台设置
 *
 * @author sun
 **/
public interface BackstageApi {

    /**
     * 函数简介: 绑定指定的窗口,并指定这个窗口的屏幕颜色获取方式,鼠标仿真模式,键盘仿真模式,以及模式设定,高级用户可以参考BindWindowEx
     * 更加
     * 灵活强大.
     *
     * @param hwnd    整形数: 指定的窗口句柄
     * @param display 字符串: 屏幕颜色获取方式
     * @param mouse   字符串: 鼠标仿真模式
     * @param keypad  字符串: 键盘仿真模式
     * @param mode    整形数: 模式
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long BindWindow(long hwnd, String display, String mouse, String keypad, int mode);

    /**
     * 函数简介: 绑定指定的窗口,并指定这个窗口的屏幕颜色获取方式,鼠标仿真模式,键盘仿真模式,高级用户使用.
     *
     * @param hwnd      整形数: 指定的窗口句柄
     * @param display   字符串: 屏幕颜色获取方式
     * @param mouse     字符串: 鼠标仿真模式
     * @param keypad    字符串: 键盘仿真模式
     * @param publicParam    字符串: 公共属性
     * @param mode      整形数: 模式
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long BindWindowEx(long hwnd, String display, String mouse, String keypad, String publicParam, int mode);

    /**
     * 函数简介: 设置是否暂时关闭或者开启后台功能. 默认是开启. 一般用在前台切换，或者脚本暂停和恢复时，可以让用户操作窗口.
     *
     * @param enable 整形数: 0 全部关闭(图色键鼠都关闭,也就是说图色,键鼠都是前台,但是如果有指定dx.public.active.message时，在窗口前后
     *               台切换时，这个属性会失效.)-1 只关闭图色.(也就是说图色是normal前台. 键鼠不变)
     *               1 开启(恢复原始状态)
     *               5 同0，也是全部关闭，但是这个模式下，就算窗口在前后台切换时，属性dx.public.active.message的效果也一样不会
     *               失效.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableBind(int enable);

    /**
     * 函数简介: 设置是否开启后台假激活功能. 默认是关闭. 一般用不到. 除非有人有特殊需求. 注意看注释.
     *
     * @param enable 整形数: 0 关闭
     *               1 开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableFakeActive(int enable);

    /**
     * 函数简介: 设置是否关闭绑定窗口所在进程的输入法.
     *
     * @param enable 整形数: 1 开启
     *               0 关闭
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableIme(int enable);

    /**
     * 函数简介: 是否在使用dx键盘时开启windows消息.默认开启.
     *
     * @param enable 整形数: 0 禁止
     *               1开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableKeypadMsg(int enable);

    /**
     * 函数简介: 键盘消息发送补丁. 默认是关闭.
     *
     * @param enable 整形数: 0 禁止
     *               1开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableKeypadPatch(int enable);

    /**
     * 函数简介: 键盘消息采用同步发送模式.默认异步.
     *
     * @param enable 整形数: 0 禁止同步
     *               1开启同步
     * @param time_out 整形数: 单位是毫秒,表示同步等待的最大时间.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableKeypadSync(int enable, int time_out);

    /**
     * 函数简介: 是否在使用dx鼠标时开启windows消息.默认开启.
     *
     * @param enable 整形数: 0 禁止
     *               1开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableMouseMsg(int enable);

    /**
     * 函数简介: 鼠标消息采用同步发送模式.默认异步.
     *
     * @param enable 整形数: 0 禁止同步
     *               1开启同步
     * @param time_out 整形数: 单位是毫秒,表示同步等待的最大时间.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableMouseSync(int enable, int time_out);

    /**
     * 函数简介: 键盘动作模拟真实操作,点击延时随机.
     *
     * @param enable 整形数: 0 关闭模拟
     *               1 开启模拟
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableRealKeypad(int enable);

    /**
     * 函数简介: 鼠标动作模拟真实操作,带移动轨迹,以及点击延时随机.
     *
     * @param enable 整形数: 0 关闭模拟
     *               1 开启模拟(直线模拟)
     *               2 开启模拟(随机曲线,更接近真实)
     *               3 开启模拟(小弧度曲线,弧度随机)
     *               4 开启模拟(大弧度曲线,弧度随机)
     * @param mousedelay 整形数: 单位是毫秒. 表示在模拟鼠标移动轨迹时,每移动一次的时间间隔.这个值越大,鼠标移动越慢. 必须大于0,否则会失
     *                   败.
     * @param mousestep 整形数: 表示在模拟鼠标移动轨迹时,每移动一次的距离. 这个值越大，鼠标移动越快速.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableRealMouse(int enable, int mousedelay, int mousestep);

    /**
     * 函数简介: 设置是否开启高速dx键鼠模式。 默认是关闭.
     *
     * @param enable 整形数: 0 关闭
     *               1 开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long EnableSpeedDx(int enable);

    /**
     * 函数简介: 强制解除绑定窗口,并释放系统资源.
     *
     * @param hwnd 整形数: 需要强制解除绑定的窗口句柄.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long ForceUnBindWindow(long hwnd);

    /**
     * 函数简介: 获取当前对象已经绑定的窗口句柄. 无绑定返回0
     *
     * @return 整形数: 窗口句柄
     */
    @ComMethod
    long GetBindWindow();

    /**
     * 函数简介: 获取绑定窗口的fps. (即时fps,不是平均fps).
     *           要想获取fps,那么图色模式必须是dx模式的其中一种. 比如dx.graphic.3d dx.graphic.opengl等.
     *
     * @return 整形数: fps
     */
    @ComMethod
    long GetFps();

    /**
     * 函数简介: 对目标窗口设置加速功能(类似变速齿轮),必须在绑定参数中有dx.public.hack.speed时才会生效.
     *
     * @param rate 双精度浮点数: 取值范围大于0. 默认是1.0 表示不加速，也不减速. 小于1.0表示减速,大于1.0表示加速. 精度为小数点后1位.
     *             也就是1.5 和 1.56其实是一样的.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long HackSpeed(double rate);

    /**
     * 函数简介: 判定指定窗口是否已经被后台绑定. (前台无法判定)
     *
     * @param hwnd 整形数: 窗口句柄
     * @return 整形数: 0: 没绑定,或者窗口不存在.
     *               1: 已经绑定.
     */
    @ComMethod
    long IsBind(long hwnd);

    /**
     * 函数简介: 锁定指定窗口的图色数据(不刷新).
     *
     * @param lock 整形数: 0关闭锁定
     *             1 开启锁定
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long LockDisplay(int lock);

    /**
     * 函数简介: 禁止外部输入到指定窗口
     *
     * @param lock 整形数: 0关闭锁定
     *             1 开启锁定(键盘鼠标都锁定)
     *             2 只锁定鼠标
     *             3 只锁定键盘
     *             4 同1,但当您发现某些特殊按键无法锁定时,比如(回车，ESC等)，那就用这个模式吧. 但此模式会让SendString函数后台失效，
     *               或者采用和SendString类似原理发送字符串的其他3方函数失效.
     *             5同3,但当您发现某些特殊按键无法锁定时,比如(回车，ESC等)，那就用这个模式吧. 但此模式会让SendString函数后台失效，或
     *               者采用和SendString类似原理发送字符串的其他3方函数失效.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long LockInput(int lock);

    /**
     * 函数简介: 设置前台鼠标在屏幕上的活动范围.
     *
     * @param x1 整形数:区域的左上X坐标. 屏幕坐标.
     * @param y1 整形数:区域的左上Y坐标. 屏幕坐标.
     * @param x2 整形数:区域的右下X坐标. 屏幕坐标.
     * @param y2 整形数:区域的右下Y坐标. 屏幕坐标.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long LockMouseRect(int x1, int y1, int x2, int y2);

    /**
     * 函数简介: 设置开启或者关闭系统的Aero效果. (仅对WIN7及以上系统有效)
     *
     * @param enable 整形数: 0 关闭
     *               1 开启
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long SetAero(int enable);

    /**
     * 函数简介: 设置dx截图最长等待时间。内部默认是3000毫秒. 一般用不到调整这个.
     *
     * @param time 整形数: 等待时间，单位是毫秒。 注意这里不能设置的过小，否则可能会导致截图失败,从而导致图色函数和文字识别失败.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long SetDisplayDelay(int time);

    /**
     * 函数简介: 设置opengl图色模式的强制刷新窗口等待时间. 内置为400毫秒.
     *
     * @param time 整形数: 等待时间，单位是毫秒。 这个值越小,强制刷新的越频繁，相应的窗口可能会导致闪烁.
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long SetDisplayRefreshDelay(int time);

    /**
     * 函数简介: 设置当前对象用于输入的对象. 结合图色对象和键鼠对象,用一个对象完成操作.
     *
     * @param dm_id 整形数: 接口GetId的返回值
     * @param rx 整形数: 两个对象绑定的窗口的左上角坐标的x偏移. 是用dm_id对应的窗口的左上角x坐标减去当前窗口左上角坐标的x坐标. 一般是0
     * @param ry 整形数: 两个对象绑定的窗口的左上角坐标的y偏移. 是用dm_id对应的窗口的左上角y坐标减去当前窗口左上角坐标的y坐标. 一般是0
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long SetInputDm(long dm_id, int rx, int ry);

    /**
     * 函数简介: 在不解绑的情况下,切换绑定窗口.(必须是同进程窗口)
     *
     * @param hwnd 整形数: 需要切换过去的窗口句柄
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long SwitchBindWindow(long hwnd);

    /**
     * 函数简介: 解除绑定窗口,并释放系统资源.一般在OnScriptExit调用
     *
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long UnBindWindow();
}