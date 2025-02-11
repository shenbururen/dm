package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.Variant;

/**
 * 窗口
 * @author sun
 **/
public interface WindowsApi {

	/**
	 * 把窗口坐标转换为屏幕坐标
	 *
	 * @param hwnd 整形数: 指定的窗口句柄
	 * @param x    变参指针: 窗口X坐标
	 * @param y    变参指针: 窗口Y坐标
	 * @return 0: 失败 1: 成功
	 */
	@ComMethod
	long ClientToScreen(long hwnd, Variant.VARIANT x, Variant.VARIANT y);

	/**
	 * 根据指定进程名,枚举系统中符合条件的进程PID,并且按照进程打开顺序排序.
	 *
	 * @param name 字符串:进程名,比如qq.exe
	 * @return 返回所有匹配的进程PID, 并按打开顺序排序, 格式"pid1,pid2,pid3"
	 */
	@ComMethod
	String EnumProcess(String name);

	/**
	 * 根据指定条件,枚举系统中符合条件的窗口,可以枚举到按键自带的无法枚举到的窗口
	 *
	 * @param parent     整形数: 获得的窗口句柄是该窗口的子窗口的窗口句柄,取0时为获得桌面句柄
	 * @param title      字符串: 窗口标题. 此参数是模糊匹配.
	 * @param class_name 字符串: 窗口类名. 此参数是模糊匹配.
	 * @param filter     整形数: 取值定义如下
	 *                   1 : 匹配窗口标题,参数title有效
	 *                   2 : 匹配窗口类名,参数class_name有效.
	 *                   4 : 只匹配指定父窗口的第一层孩子窗口
	 *                   8 : 匹配父窗口为0的窗口,即顶级窗口
	 *                   16 : 匹配可见的窗口
	 *                   32 : 匹配出的窗口按照窗口打开顺序依次排列
	 *                   这些值可以相加,比如4+8+16就是类似于任务管理器中的窗口列表
	 * @return 字符串 : 返回所有匹配的窗口句柄字符串,格式"hwnd1,hwnd2,hwnd3"
	 */
	@ComMethod
	String EnumWindow(long parent, String title, String class_name, int filter);

	/**
	 * 根据指定进程以及其它条件,枚举系统中符合条件的窗口,可以枚举到按键自带的无法枚举到的窗口
	 *
	 * @param process_name 字符串: 进程映像名.比如(svchost.exe). 此参数是精确匹配,但不区分大小写.
	 * @param title        字符串: 窗口标题. 此参数是模糊匹配.
	 * @param class_name   字符串: 窗口类名. 此参数是模糊匹配.
	 * @param filter       整形数: 取值定义如下
	 *                     1 : 匹配窗口标题,参数title有效
	 *                     2 : 匹配窗口类名,参数class_name有效
	 *                     4 : 只匹配指定映像的所对应的第一个进程. 可能有很多同映像名的进程，只匹配第一个进程的.
	 *                     8 : 匹配父窗口为0的窗口,即顶级窗口
	 *                     16 : 匹配可见的窗口
	 *                     32 : 匹配出的窗口按照窗口打开顺序依次排列
	 *                     这些值可以相加,比如4+8+16
	 * @return 字符串: 返回所有匹配的窗口句柄字符串,格式"hwnd1,hwnd2,hwnd3"
	 */
	@ComMethod
	String EnumWindowByProcess(String process_name, String title, String class_name, int filter);

	/**
	 * 根据指定进程pid以及其它条件,枚举系统中符合条件的窗口,可以枚举到按键自带的无法枚举到的窗口
	 *
	 * @param pid        整形数: 进程pid.
	 * @param title      字符串: 窗口标题. 此参数是模糊匹配.
	 * @param class_name 字符串: 窗口类名. 此参数是模糊匹配.
	 * @param filter     整形数: 取值定义如下
	 *                   1 : 匹配窗口标题,参数title有效
	 *                   2 : 匹配窗口类名,参数class_name有效
	 *                   8 : 匹配父窗口为0的窗口,即顶级窗口
	 *                   16 : 匹配可见的窗口
	 *                   这些值可以相加,比如2+8+16
	 * @return 字符串: 返回所有匹配的窗口句柄字符串,格式"hwnd1,hwnd2,hwnd3"
	 */
	@ComMethod
	String EnumWindowByProcessId(int pid, String title, String class_name, int filter);

	/**
	 * 根据两组设定条件来枚举指定窗口.
	 *
	 * @param spec1 字符串: 查找串1. (内容取决于flag1的值)
	 * @param flag1 整形数: 取值如下:
	 *              0表示spec1的内容是标题
	 *              1表示spec1的内容是程序名字. (比如notepad)
	 *              2表示spec1的内容是类名
	 *              3表示spec1的内容是程序路径.(不包含盘符,比如\windows\system32)
	 *              4表示spec1的内容是父句柄.(十进制表达的串)
	 *              5表示spec1的内容是父窗口标题
	 *              6表示spec1的内容是父窗口类名
	 *              7表示spec1的内容是顶级窗口句柄.(十进制表达的串)
	 *              8表示spec1的内容是顶级窗口标题
	 *              9表示spec1的内容是顶级窗口类名
	 * @param type1 整形数: 取值如下
	 *              0精确判断
	 *              1模糊判断
	 * @param spec2 字符串: 查找串2. (内容取决于flag2的值)
	 * @param flag2 整形数: 取值如下:
	 *              0表示spec2的内容是标题
	 *              1表示spec2的内容是程序名字. (比如notepad)
	 *              2表示spec2的内容是类名
	 *              3表示spec2的内容是程序路径.(不包含盘符,比如\windows\system32)
	 *              4表示spec2的内容是父句柄.(十进制表达的串)
	 *              5表示spec2的内容是父窗口标题
	 *              6表示spec2的内容是父窗口类名
	 *              7表示spec2的内容是顶级窗口句柄.(十进制表达的串)
	 *              8表示spec2的内容是顶级窗口标题
	 *              9表示spec2的内容是顶级窗口类名
	 * @param type2 整形数: 取值如下
	 *              0精确判断
	 *              1模糊判断
	 * @param sort  整形数: 取值如下
	 *              0不排序.
	 *              1对枚举出的窗口进行排序,按照窗口打开顺序.
	 * @return 字符串: 返回所有匹配的窗口句柄字符串,格式"hwnd1,hwnd2,hwnd3"
	 */
	@ComMethod
	String EnumWindowSuper(String spec1, int flag1, int type1, String spec2, int flag2, int type2, int sort);

	/**
	 * 查找符合类名或者标题名的顶层可见窗口
	 *
	 * @param class_name 字符串: 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配.
	 * @param title 字符串: 窗口标题,如果为空，则匹配所有.这里的匹配是模糊匹配.
	 * @return 整形数: 整形数表示的窗口句柄，没找到返回0
	 */
	@ComMethod
	long FindWindow(String class_name, String title);

	/**
	 * 根据指定的进程名字，来查找可见窗口.
	 *
	 * @param process_name 字符串: 进程名. 比如(notepad.exe).这里是精确匹配,但不区分大小写.
	 * @param class_name   字符串: 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配.
	 * @param title        字符串: 窗口标题,如果为空，则匹配所有.这里的匹配是模糊匹配.
	 * @return 整形数: 整形数表示的窗口句柄，没找到返回0
	 */
	@ComMethod
	long FindWindowByProcess(String process_name, String class_name, String title);

	/**
	 * 根据指定的进程Id，来查找可见窗口.
	 *
	 * @param process_id 整形数: 进程id.
	 * @param class_name 字符串: 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配.
	 * @param title      字符串: 窗口标题,如果为空，则匹配所有.这里的匹配是模糊匹配.
	 * @return 整形数: 整形数表示的窗口句柄，没找到返回0
	 */
	@ComMethod
	long FindWindowByProcessId(int process_id, String class_name, String title);

	/**
	 * 查找符合类名或者标题名的顶层可见窗口,如果指定了parent,则在parent的第一层子窗口中查找.
	 *
	 * @param parent 整形数: 父窗口句柄，如果为空，则匹配所有顶层窗口
	 * @param class_name  字符串: 窗口类名，如果为空，则匹配所有. 这里的匹配是模糊匹配.
	 * @param title  字符串: 窗口标题,如果为空，则匹配所有. 这里的匹配是模糊匹配.
	 * @return 整形数: 整形数表示的窗口句柄，没找到返回0
	 */
	@ComMethod
	long FindWindowEx(long parent, String class_name, String title);

	/**
	 * 根据两组设定条件来查找指定窗口.
	 *
	 * @param spec1 字符串: 查找串1. (内容取决于flag1的值)
	 * @param flag1 整形数: 取值如下:
	 *              0表示spec1的内容是标题
	 *              1表示spec1的内容是程序名字. (比如notepad)
	 *              2表示spec1的内容是类名
	 *              3表示spec1的内容是程序路径.(不包含盘符,比如\windows\system32)
	 *              4表示spec1的内容是父句柄.(十进制表达的串)
	 *              5表示spec1的内容是父窗口标题
	 *              6表示spec1的内容是父窗口类名
	 *              7表示spec1的内容是顶级窗口句柄.(十进制表达的串)
	 *              8表示spec1的内容是顶级窗口标题
	 *              9表示spec1的内容是顶级窗口类名
	 * @param type1 整形数: 取值如下
	 *              0精确判断
	 *              1模糊判断
	 * @param spec2 字符串: 查找串2. (内容取决于flag2的值)
	 * @param flag2 整形数: 取值如下:
	 *              0表示spec2的内容是标题
	 *              1表示spec2的内容是程序名字. (比如notepad)
	 *              2表示spec2的内容是类名
	 *              3表示spec2的内容是程序路径.(不包含盘符,比如\windows\system32)
	 *              4表示spec2的内容是父句柄.(十进制表达的串)
	 *              5表示spec2的内容是父窗口标题
	 *              6表示spec2的内容是父窗口类名
	 *              7表示spec2的内容是顶级窗口句柄.(十进制表达的串)
	 *              8表示spec2的内容是顶级窗口标题
	 *              9表示spec2的内容是顶级窗口类名
	 * @param type2 整形数: 取值如下
	 *              0精确判断
	 *              1模糊判断
	 * @return 整形数: 整形数表示的窗口句柄，没找到返回0
	 */
	@ComMethod
	long FindWindowSuper(String spec1, int flag1, int type1, String spec2, int flag2, int type2);

	/**
	 * 获取窗口客户区域在屏幕上的位置
	 *
	 * @param hwnd 整形数: 指定的窗口句柄
	 * @param x1   变参指针: 返回窗口客户区左上角X坐标
	 * @param y1   变参指针: 返回窗口客户区左上角Y坐标
	 * @param x2   变参指针: 返回窗口客户区右下角X坐标
	 * @param y2   变参指针: 返回窗口客户区右下角Y坐标
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long GetClientRect(long hwnd, Variant.VARIANT x1, Variant.VARIANT y1, Variant.VARIANT x2, Variant.VARIANT y2);

	/**
	 * 获取窗口客户区域的宽度和高度
	 *
	 * @param hwnd   整形数: 指定的窗口句柄
	 * @param width  变参指针: 宽度
	 * @param height 变参指针: 高度
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long GetClientSize(long hwnd, Variant.VARIANT width, Variant.VARIANT height);

	/**
	 * 获取顶层活动窗口中具有输入焦点的窗口句柄
	 *
	 * @return 整形数: 返回整型表示的窗口句柄
	 */
	@ComMethod
	long GetForegroundFocus();

	/**
	 * 获取顶层活动窗口,可以获取到按键自带插件无法获取到的句柄
	 *
	 * @return 整形数: 返回整型表示的窗口句柄
	 */
	@ComMethod
	long GetForegroundWindow();

	/**
	 * 获取鼠标指向的可见窗口句柄,可以获取到按键自带的插件无法获取到的句柄
	 *
	 * @return 整形数: 返回整型表示的窗口句柄
	 */
	@ComMethod
	long GetMousePointWindow();

	/**
	 * 获取给定坐标的可见窗口句柄,可以获取到按键自带的插件无法获取到的句柄
	 *
	 * @param x 屏幕X坐标
	 * @param y 屏幕Y坐标
	 * @return 整形数: 返回整型表示的窗口句柄
	 */
	@ComMethod
	long GetPointWindow(int x, int y);

	/**
	 * 根据指定的pid获取进程详细信息,(进程名,进程全路径,CPU占用率(百分比),内存占用量(字节))
	 *
	 * @param pid 进程pid
	 * @return 字符串: 格式"进程名|进程路径|cpu|内存"
	 */
	@ComMethod
	String GetProcessInfo(int pid);

	/**
	 * 获取特殊窗口
	 *
	 * @param flag 取值定义如下
	 *             0 : 获取桌面窗口
	 *             1 : 获取任务栏窗口
	 * @return 整形数: 以整型数表示的窗口句柄
	 */
	@ComMethod
	long GetSpecialWindow(int flag);

	/**
	 * 获取给定窗口相关的窗口句柄
	 *
	 * @param hwnd 窗口句柄
	 * @param flag 取值定义如下
	 *             0 : 获取父窗口
	 *             1 : 获取第一个儿子窗口
	 *             2 : 获取First 窗口
	 *             3 : 获取Last窗口
	 *             4 : 获取下一个窗口
	 *             5 : 获取上一个窗口
	 *             6 : 获取拥有者窗口
	 *             7 : 获取顶层窗口
	 * @return 整形数: 返回整型表示的窗口句柄
	 */
	@ComMethod
	long GetWindow(long hwnd, int flag);

	/**
	 * 获取窗口的类名
	 *
	 * @param hwnd 指定的窗口句柄
	 * @return 字符串: 窗口的类名
	 */
	@ComMethod
	String GetWindowClass(long hwnd);

	/**
	 * 获取指定窗口所在的进程ID.
	 *
	 * @param hwnd 窗口句柄
	 * @return 整形数: 返回整型表示的是进程ID
	 */
	@ComMethod
	long GetWindowProcessId(long hwnd);

	/**
	 * 获取指定窗口所在的进程的exe文件全路径.
	 *
	 * @param hwnd 窗口句柄
	 * @return 字符串: 返回字符串表示的是exe全路径名
	 */
	@ComMethod
	String GetWindowProcessPath(long hwnd);

	/**
	 * 获取窗口在屏幕上的位置
	 *
	 * @param hwnd 指定的窗口句柄
	 * @param x1   变参指针: 返回窗口左上角X坐标
	 * @param y1   变参指针: 返回窗口左上角Y坐标
	 * @param x2   变参指针: 返回窗口右下角X坐标
	 * @param y2   变参指针: 返回窗口右下角Y坐标
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long GetWindowRect(long hwnd, Variant.VARIANT x1, Variant.VARIANT y1, Variant.VARIANT x2, Variant.VARIANT y2);

	/**
	 * 获取指定窗口的一些属性
	 *
	 * @param hwnd 指定的窗口句柄
	 * @param flag 取值定义如下
	 *             0 : 判断窗口是否存在
	 *             1 : 判断窗口是否处于激活
	 *             2 : 判断窗口是否可见
	 *             3 : 判断窗口是否最小化
	 *             4 : 判断窗口是否最大化
	 *             5 : 判断窗口是否置顶
	 *             6 : 判断窗口是否无响应
	 *             7 : 判断窗口是否可用(灰色为不可用)
	 *             8 : 另外的方式判断窗口是否无响应,如果6无效可以尝试这个
	 *             9 : 判断窗口所在进程是不是64位
	 * @return 整形数: 0: 不满足条件 1: 满足条件
	 */
	@ComMethod
	long GetWindowState(long hwnd, int flag);

	/**
	 * 获取指定窗口所在的线程ID.
	 *
	 * @param hwnd 窗口句柄
	 * @return 整形数: 返回整型表示的是线程ID
	 */
	@ComMethod
	long GetWindowThreadId(long hwnd);

	/**
	 * 获取窗口的标题
	 *
	 * @param hwnd 指定的窗口句柄
	 * @return 字符串: 窗口的标题
	 */
	@ComMethod
	String GetWindowTitle(long hwnd);

	/**
	 * 移动指定窗口到指定位置
	 *
	 * @param hwnd 指定的窗口句柄
	 * @param x    X坐标
	 * @param y    Y坐标
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long MoveWindow(long hwnd, int x, int y);

	/**
	 * 把屏幕坐标转换为窗口坐标
	 *
	 * @param hwnd 整形数: 指定的窗口句柄
	 * @param x    变参指针: 屏幕X坐标
	 * @param y    变参指针: 屏幕Y坐标
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long ScreenToClient(long hwnd, Variant.VARIANT x, Variant.VARIANT y);

	/**
	 * 向指定窗口发送粘贴命令. 把剪贴板的内容发送到目标窗口.
	 *
	 * @param hwnd 指定的窗口句柄. 如果为0,则对当前激活的窗口发送.
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SendPaste(long hwnd);

	/**
	 * 向指定窗口发送文本数据
	 *
	 * @param hwnd 指定的窗口句柄. 如果为0,则对当前激活的窗口发送.
	 * @param str  发送的文本数据
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SendString(long hwnd, String str);

	/**
	 * 向指定窗口发送文本数据
	 *
	 * @param hwnd 指定的窗口句柄. 如果为0,则对当前激活的窗口发送.
	 * @param str  发送的文本数据
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SendString2(long hwnd, String str);

	/**
	 * 向绑定的窗口发送文本数据.必须配合dx.public.input.ime属性.
	 *
	 * @param str 发送的文本数据
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SendStringIme(String str);

	/**
	 * 利用真实的输入法，对指定的窗口输入文字.
	 *
	 * @param hwnd 窗口句柄
	 * @param str  发送的文本数据
	 * @param mode 取值意义如下:
	 *             0 : 向hwnd的窗口输入文字(前提是必须先用模式200安装了输入法)
	 *             1 : 同模式0,如果由于保护无效，可以尝试此模式.(前提是必须先用模式200安装了输入法)
	 *             2 : 同模式0,如果由于保护无效，可以尝试此模式. (前提是必须先用模式200安装了输入法)
	 *             200 : 向系统中安装输入法,多次调用没问题. 全局只用安装一次.
	 *             300 : 卸载系统中的输入法. 全局只用卸载一次. 多次调用没关系.
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SendStringIme2(long hwnd, String str, int mode);

	/**
	 * 设置窗口客户区域的宽度和高度
	 *
	 * @param hwnd   指定的窗口句柄
	 * @param width  宽度
	 * @param height 高度
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetClientSize(long hwnd, int width, int height);

	/**
	 * 设置窗口的大小
	 *
	 * @param hwnd   指定的窗口句柄
	 * @param width  宽度
	 * @param height 高度
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetWindowSize(long hwnd, int width, int height);

	/**
	 * 设置窗口的状态
	 *
	 * @param hwnd 窗口句柄
	 * @param flag 取值定义如下
	 *             0 : 关闭指定窗口
	 *             1 : 激活指定窗口
	 *             2 : 最小化指定窗口,但不激活
	 *             3 : 最小化指定窗口,并释放内存,但同时也会激活窗口.(释放内存可以考虑用FreeProcessMemory函数)
	 *             4 : 最大化指定窗口,同时激活窗口.
	 *             5 : 恢复指定窗口 ,但不激活
	 *             6 : 隐藏指定窗口
	 *             7 : 显示指定窗口
	 *             8 : 置顶指定窗口
	 *             9 : 取消置顶指定窗口
	 *             10 : 禁止指定窗口
	 *             11 : 取消禁止指定窗口
	 *             12 : 恢复并激活指定窗口
	 *             13 : 强制结束窗口所在进程.
	 *             14 : 闪烁指定的窗口
	 *             15 : 使指定的窗口获取输入焦点
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetWindowState(long hwnd, int flag);

	/**
	 * 设置窗口的标题
	 *
	 * @param hwnd  指定的窗口句柄
	 * @param title 标题
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetWindowText(long hwnd, String title);

	/**
	 * 设置窗口的透明度
	 *
	 * @param hwnd  指定的窗口句柄
	 * @param trans 透明度取值(0-255) 越小透明度越大 0为完全透明(不可见) 255为完全显示(不透明)
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetWindowTransparent(long hwnd, int trans);

	/**
	 * 设置SendString和SendString2的每个字符之间的发送间隔.  有些窗口必须设置延迟才可以正常发送. 否则可能会顺序错乱.
	 * 
	 * @param delay 整形数: 大于等于0的延迟数值. 单位是毫秒. 默认是0
	 * @return 整形数: 0: 失败 1: 成功
	 */
	@ComMethod
	long SetSendStringDelay(long delay);
}