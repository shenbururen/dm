package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 基本设置
 * @author sun
 **/
public interface BaseApi {

    /**
     * 设置是否开启或者关闭插件内部的图片缓存机制. (默认是打开).
     *
     * @param enable 整形数:
     *               0 : 关闭
     *               1 : 打开
     * @return 整形数:
     *         0: 失败
     *         1: 成功
     */
    @ComMethod
    long EnablePicCache(int enable);

    /**
     * 获取注册在系统中的dm.dll的路径.
     *
     * @return 字符串:
     *         返回dm.dll所在路径
     */
    @ComMethod
    String GetBasePath();

    /**
     * 返回当前进程已经创建的dm对象个数.
     *
     * @return 整形数:
     *         个数.
     */
    @ComMethod
    long GetDmCount();

    /**
     * 返回当前大漠对象的ID值，这个值对于每个对象是唯一存在的。可以用来判定两个
     * 大漠对象是否一致.
     *
     * @return 整形数:
     *         当前对象的ID值.
     */
    @ComMethod
    long GetID();

    /**
     * 获取插件命令的最后错误
     *
     * @return 整形数:
     *         返回值表示错误值。 0表示无错误.-1 : 表示你使用了绑定里的收费功能，但是没注册，无法使用.-2 : 使用模式0 2 时出现，因为目标窗口有保护. 常见于win7以上系统.或者有安
     *         全软件拦截插件.解决办法: 关闭所有安全软件，然后再重新尝试. 如果还不行就
     *         可以肯定是目标窗口有特殊保护. -3 : 使用模式0 2 时出现，可能目标窗口有保护，也可能是异常错误. 可以尝试
     *         换绑定模式或许可以解决.-4 : 使用模式101 103时出现，这是异常错误.-5 : 使用模式101 103时出现, 这个错误的解决办法就是关闭目标窗口，重新打开
     *         再绑定即可. 也可能是运行脚本的进程没有管理员权限. -6 : 被安全软件拦截。典型的是金山.360等. 如果是360关闭即可。 如果是金
     *         山，必须卸载，关闭是没用的.-7 -9 : 使用模式101 103时出现,异常错误. 还有可能是安全软件的问题，比如
     *         360等。尝试卸载360.-8 -10 : 使用模式101 103时出现, 目标进程可能有保护,也可能是插件版本过
     *         老，试试新的或许可以解决. -8可以尝试使用DmGuard中的np2盾配合.-11 : 使用模式101 103时出现, 目标进程有保护. 告诉我解决。-12 : 使用模式101 103时出现, 目标进程有保护. 告诉我解决。-13 : 使用模式101 103时出现, 目标进程有保护. 或者是因为上次的绑定没有解
     *         绑导致。 尝试在绑定前调用ForceUnBindWindow. -37 : 使用模式101 103时出现, 目标进程有保护. 告诉我解决。-14 : 可能系统缺少部分DLL,尝试安装d3d. 或者是鼠标或者键盘使用了
     *         dx.mouse.api或者dx.keypad.api，但实际系统没有插鼠标和键盘. 也有可能是图
     *         色中有dx.graphic.3d之类的,但相应的图色被占用,比如全屏D3D程序.-16 : 可能使用了绑定模式 0 和 101，然后可能指定了一个子窗口.导致不支持.
     *         可换模式2或者103来尝试. 另外也可以考虑使用父窗口或者顶级窗口.来避免这
     *         个错误。还有可能是目标窗口没有正常解绑然后再次绑定的时候.-17 : 模式101 103时出现. 这个是异常错误. 告诉我解决.-18 : 句柄无效.-19 : 使用模式0 11 101时出现,这是异常错误,告诉我解决.-20 : 使用模式101 103 时出现,说明目标进程里没有解绑，并且子绑定达到了最
     *         大. 尝试在返回这个错误时，调用ForceUnBindWindow来强制解除绑定.-21 : 使用模式任何模式时出现,说明目标进程已经存在了绑定(没有正确解绑就退
     *         出?被其它软件绑定?,或者多个线程同时进行了绑定?). 尝试在返回这个错误
     *         时，调用ForceUnBindWindow来强制解除绑定.或者检查自己的代码.-22 : 使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件释放的EXE文
     *         件导致.-23 : 使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件释放的DLL文
     *         件导致.-24 : 使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件运行释放的
     *         EXE.-25 : 使用模式0 2,绑定64位进程窗口时出现,因为安全软件拦截插件运行释放的
     *         EXE.-26 : 使用模式0 2,绑定64位进程窗口时出现, 因为目标窗口有保护. 常见于win7
     *         以上系统.或者有安全软件拦截插件.解决办法: 关闭所有安全软件，然后再重新尝
     *         试. 如果还不行就可以肯定是目标窗口有特殊保护.-27 : 绑定64位进程窗口时出现，因为使用了不支持的模式，目前暂时只支持模式
     *         0 2 11 13 101 103-28 : 绑定32位进程窗口时出现，因为使用了不支持的模式，目前暂时只支持模式
     *         0 2 11 13 101 103-38 : 是用了大于2的绑定模式,并且使用了dx.public.inject.c时，分配内存失
     *         败. 可以考虑开启memory系列盾来尝试.-39 : 是用了大于2的绑定模式,并且使用了dx.public.inject.c时的异常错误. 可
     *         联系我解决.-40 : 是用了大于2的绑定模式,并且使用了dx.public.inject.c时, 写入内存失
     *         败. 可以考虑开启memory系列盾来尝试.-41 : 是用了大于2的绑定模式,并且使用了dx.public.inject.c时的异常错误. 可
     *         联系我解决.-42 : 绑定时,创建映射内存失败. 这是个异常错误. 一般不会出现. 如果出现
     *         了，检查下代码是不是有同个对象同时绑定的情况.还有可能是你的进程有句柄泄
     *         露导致无法创建句柄会出这个错误.-43 : 绑定时,映射内存失败. 这是个异常错误. 一般不会出现. 如果出现了，一
     *         般是你的进程内存不足,检查下你的进程是不是内存泄漏了. -44 : 无效的参数,通常是传递了不支持的参数.-45 : 绑定时,创建互斥信号失败. 这个是一场错误. 一般不会出现. 如果出现了
     *         检查进程是否有句柄泄漏的情况.-100 : 调用读写内存函数后，发现无效的窗口句柄-101 : 读写内存函数失败-200 : AsmCall失败
     * @return 整形数:
     *         返回值表示错误值。
     */
    @ComMethod
    long GetLastError();

    /**
     * 获取全局路径.(可用于调试)
     *
     * @return 字符串:
     *         以字符串的形式返回当前设置的全局路径
     */
    @ComMethod
    String GetPath();

    /**
     * 调用此函数来注册，从而使用插件的高级功能.推荐使用此函数.
     *
     * @param reg_code 字符串: 注册码. (从大漠插件后台获取)
     * @param ver_info 字符串: 版本附加信息. 可以在后台详细信息查看. 可以任意填写. 可
     *                 留空. 长度不能超过20. 并且只能包含数字和字母以及小数点. 这个版本信息不是
     *                 插件版本.
     * @return 整形数:-1 : 无法连接网络,(可能防火墙拦截,如果可以正常访问大漠插件网站，那就可以
     *         肯定是被防火墙拦截)-2 : 进程没有以管理员方式运行. (出现在win7 win8 vista 2008.建议关闭uac)
     *         0 : 失败 (未知错误)
     *         1 : 成功
     *         2 : 余额不足
     *         3 : 绑定了本机器，但是账户余额不足50元.
     *         4 : 注册码错误
     *         5 : 你的机器或者IP在黑名单列表中或者不在白名单列表中.
     *         6 : 非法使用插件. 一般出现在定制插件时，使用了和绑定的用户名不同的注册
     *         码. 也有可能是系统的语言设置不是中文简体,也可能有这个错误.
     *         7 : 你的帐号因为非法使用被封禁. （如果是在虚拟机中使用插件，必须使用Reg
     *         或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机
     *         器）
     *         8 : ver_info不在你设置的附加白名单中.
     *         77： 机器码或者IP因为非法使用，而被封禁. （如果是在虚拟机中使用插件，必
     *         须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，
     *         或者封禁机器）
     *         封禁是全局的，如果使用了别人的软件导致77，也一样会导致所有注册码均
     *         无法注册。解决办法是更换IP，更换MAC.
     *         777： 同一个机器码注册次数超过了服务器限制,被暂时封禁. 请登录后台，插件
     *         今日详细消费记录里，相应的机器码是否有次数异常，并立刻优化解决.如果还有
     *         问题，可以联系我来解决.-8 : 版本附加信息长度超过了20-9 : 版本附加信息里包含了非法字母.
     *         空 : 这是不可能返回空的，如果出现空，那肯定是当前使用的版本不对,老的插件
     *         里没这个函数导致返回为空.最好参考文档中的标准写法,判断插件版本号.
     */
    @ComMethod
    long Reg(String reg_code, String ver_info);

    /**
     * 调用此函数来注册，从而使用插件的高级功能. 可以根据指定的IP列表来注册. 新
     * 手不建议使用!
     *
     * @param reg_code 字符串: 注册码. (从大漠插件后台获取)
     * @param ver_info 字符串: 版本附加信息. 可以在后台详细信息查看.可留空. 长度不能超
     *                 过20. 并且只能包含数字和字母以及小数点. 这个版本信息不是插件版本.
     * @param ip       字符串: 插件注册的ip地址.可以用|来组合,依次对ip中的地址进行注册，直到
     *                 成功. ip地址列表在VIP群中获取.从7.2111开始,这里也可以使用域名的方式。可
     *                 以自己解析域名到我的IP.
     *                 比如"1.xxx.com|2.xxx.com"。1.xxx.com和2.xxx.com是自己的域名,解
     *                 析到我的IP即可.
     * @return 整形数:-1 : 无法连接网络,(可能防火墙拦截,如果可以正常访问大漠插件网站，那就可以
     *         肯定是被防火墙拦截)-2 : 进程没有以管理员方式运行. (出现在win7 win8 vista 2008.建议关闭uac)
     *         0 : 失败 (未知错误)
     *         1 : 成功
     *         2 : 余额不足
     *         3 : 绑定了本机器，但是账户余额不足50元.
     *         4 : 注册码错误
     *         5 : 你的机器或者IP在黑名单列表中或者不在白名单列表中.
     *         6 : 非法使用插件. 一般出现在定制插件时，使用了和绑定的用户名不同的注册
     *         码. 也有可能是系统的语言设置不是中文简体,也可能有这个错误.
     *         7 : 你的帐号因为非法使用被封禁. （如果是在虚拟机中使用插件，必须使用Reg
     *         或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机
     *         器）
     *         8 : ver_info不在你设置的附加白名单中.
     *         77： 机器码或者IP因为非法使用，而被封禁. （如果是在虚拟机中使用插件，必
     *         须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，
     *         或者封禁机器）
     *         封禁是全局的，如果使用了别人的软件导致77，也一样会导致所有注册码均
     *         无法注册。解决办法是更换IP，更换MAC.
     *         777： 同一个机器码注册次数超过了服务器限制,被暂时封禁. 请登录后台，插件
     *         今日详细消费记录里，相应的机器码是否有次数异常，并立刻优化解决.如果还有
     *         问题，可以联系我来解决.-8 : 版本附加信息长度超过了20-9 : 版本附加信息里包含了非法字母.-10 : 非法的参数ip
     *         空 : 这是不可能返回空的，如果出现空，那肯定是当前使用的版本不对,老的插件
     *         里没这个函数导致返回为空.最好参考文档中的标准写法,判断插件版本号.
     */
    @ComMethod
    long RegEx(String reg_code, String ver_info, String ip);

    /**
     * 调用此函数来注册，从而使用插件的高级功能. 可以根据指定的IP列表来注册.新手不建议使用! 此函数同RegEx函数的不同在于,此函数用于注册的机器码是不带
     * mac地址的.
     *
     * @param reg_code 字符串: 注册码. (从大漠插件后台获取)
     * @param ver_info 字符串: 版本附加信息. 可以在后台详细信息查看.可留空. 长度不能超
     *                 过20. 并且只能包含数字和字母以及小数点. 这个版本信息不是插件版本.
     * @param ip       字符串: 插件注册的ip地址.可以用|来组合,依次对ip中的地址进行注册，直到
     *                 成功. ip地址列表在VIP群中获取. 从7.2111开始,这里也可以使用域名的方式。可
     *                 以自己解析域名到我的IP.
     *                 比如"1.xxx.com|2.xxx.com"。1.xxx.com和2.xxx.com是自己的域名,解
     *                 析到我的IP即可.
     * @return 整形数:-1 : 无法连接网络,(可能防火墙拦截,如果可以正常访问大漠插件网站，那就可以
     *         肯定是被防火墙拦截)-2 : 进程没有以管理员方式运行. (出现在win7 win8 vista 2008.建议关闭uac)
     *         0 : 失败 (未知错误)
     *         1 : 成功
     *         2 : 余额不足
     *         3 : 绑定了本机器，但是账户余额不足50元.
     *         4 : 注册码错误
     *         5 : 你的机器或者IP在黑名单列表中或者不在白名单列表中.
     *         6 : 非法使用插件. 一般出现在定制插件时，使用了和绑定的用户名不同的注册
     *         码. 也有可能是系统的语言设置不是中文简体,也可能有这个错误.
     *         7 : 你的帐号因为非法使用被封禁. （如果是在虚拟机中使用插件，必须使用Reg
     *         或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机
     *         器）
     *         8 : ver_info不在你设置的附加白名单中.
     *         77： 机器码或者IP因为非法使用，而被封禁. （如果是在虚拟机中使用插件，必
     *         须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，
     *         或者封禁机器）
     *         封禁是全局的，如果使用了别人的软件导致77，也一样会导致所有注册码均
     *         无法注册。解决办法是更换IP，更换MAC.
     *         777： 同一个机器码注册次数超过了服务器限制,被暂时封禁. 请登录后台，插件
     *         今日详细消费记录里，相应的机器码是否有次数异常，并立刻优化解决.如果还有
     *         问题，可以联系我来解决.-8 : 版本附加信息长度超过了20-9 : 版本附加信息里包含了非法字母.-10 : 非法的参数ip
     *         空 : 这是不可能返回空的，如果出现空，那肯定是当前使用的版本不对,老的插件
     *         里没这个函数导致返回为空.最好参考文档中的标准写法,判断插件版本号.
     */
    @ComMethod
    long RegExNoMac(String reg_code, String ver_info, String ip);

    /**
     * 调用此函数来注册，从而使用插件的高级功能.推荐使用此函数. 新手不建议使用!
     * 此函数同Reg函数的不同在于,此函数用于注册的机器码是不带mac地址的.
     *
     * @param reg_code 字符串: 注册码. (从大漠插件后台获取)
     * @param ver_info 字符串: 版本附加信息. 可以在后台详细信息查看. 可以任意填写. 可
     *                 留空. 长度不能超过20. 并且只能包含数字和字母以及小数点. 这个版本信息不是
     *                 插件版本.
     * @return 整形数:-1 : 无法连接网络,(可能防火墙拦截,如果可以正常访问大漠插件网站，那就可以
     *         肯定是被防火墙拦截)-2 : 进程没有以管理员方式运行. (出现在win7 win8 vista 2008.建议关闭uac)
     *         0 : 失败 (未知错误)
     *         1 : 成功
     *         2 : 余额不足
     *         3 : 绑定了本机器，但是账户余额不足50元.
     *         4 : 注册码错误
     *         5 : 你的机器或者IP在黑名单列表中或者不在白名单列表中.
     *         6 : 非法使用插件. 一般出现在定制插件时，使用了和绑定的用户名不同的注册
     *         码. 也有可能是系统的语言设置不是中文简体,也可能有这个错误.
     *         7 : 你的帐号因为非法使用被封禁. （如果是在虚拟机中使用插件，必须使用Reg
     *         或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，或者封禁机
     *         器）
     *         8 : ver_info不在你设置的附加白名单中.
     *         77： 机器码或者IP因为非法使用，而被封禁. （如果是在虚拟机中使用插件，必
     *         须使用Reg或者RegEx，不能使用RegNoMac或者RegExNoMac,否则可能会造成封号，
     *         或者封禁机器）
     *         封禁是全局的，如果使用了别人的软件导致77，也一样会导致所有注册码均
     *         无法注册。解决办法是更换IP，更换MAC.
     *         777： 同一个机器码注册次数超过了服务器限制,被暂时封禁. 请登录后台，插件
     *         今日详细消费记录里，相应的机器码是否有次数异常，并立刻优化解决.如果还有
     *         问题，可以联系我来解决.-8 : 版本附加信息长度超过了20-9 : 版本附加信息里包含了非法字母.
     *         空 : 这是不可能返回空的，如果出现空，那肯定是当前使用的版本不对,老的插件
     *         里没这个函数导致返回为空.最好参考文档中的标准写法,判断插件版本号.
     */
    @ComMethod
    long RegNoMac(String reg_code, String ver_info);

    /**
     * 设定图色的获取方式，默认是显示器或者后台窗口(具体参考BindWindow)
     *
     * @param mode 字符串: 图色输入模式取值有以下几种
     *             1. "screen" 这个是默认的模式，表示使用显示器或者后台窗口
     *             2. "pic:file" 指定输入模式为指定的图片,如果使用了这个模式，则所
     *             有和图色相关的函数
     *             均视为对此图片进行处理，比如文字识别查找图片 颜色 等等一切图色
     *             函数.
     *             需要注意的是，设定以后，此图片就已经加入了缓冲，如果更改了源图
     *             片内容，那么需要
     *             释放此缓冲，重新设置.
     *             3. "mem:addr,size" 指定输入模式为指定的图片,此图片在内存当中.
     *             addr为图像内存地址,size为图像内存大小.
     *             如果使用了这个模式，则所有和图色相关的函数,均视为对此图片进行
     *             处理.
     *             比如文字识别 查找图片 颜色 等等一切图色函数.
     * @return 整形数:
     *         0: 失败
     *         1: 成功
     */
    @ComMethod
    long SetDisplayInput(String mode);

    /**
     * 设置EnumWindow EnumWindowByProcess EnumWindowSuper FindWindow 以 及
     * FindWindowEx的最长延时. 内部默认超时是10秒.
     *
     * @param delay 整形数: 单位毫秒
     * @return 整形数:
     *         0: 失败
     *         1: 成功
     */
    @ComMethod
    long SetEnumWindowDelay(int delay);

    /**
     * 设置全局路径,设置了此路径后,所有接口调用中,相关的文件都相对于此路径. 比
     * 如图片,字库等.
     *
     * @param path 字符串: 路径,可以是相对路径,也可以是绝对路径
     * @return 整形数:
     *         0: 失败
     *         1: 成功
     */
    @ComMethod
    long SetPath(String path);

    /**
     * 设置是否弹出错误信息,默认是打开.
     *
     * @param show 整形数: 0表示不打开,1表示打开
     * @return 整形数:
     *         0 : 失败
     *         1 : 成功
     */
    @ComMethod
    long SetShowErrorMsg(int show);

    /**
     * 设置是否对前台图色进行加速. (默认是关闭). (对于不绑定，或者绑定图色为
     * normal生效)( 仅对WIN8以上系统有效)
     *
     * @param enable 整形数:
     *               0 : 关闭
     *               1 : 打开
     * @return 整形数:
     *         0: 失败
     *         1: 成功
     */
    @ComMethod
    long SpeedNormalGraphic(int enable);

    /**
     * 返回当前插件版本号
     *
     * @return 字符串:
     *         当前插件的版本描述字符串
     */
    @ComMethod
    String Ver();

}
