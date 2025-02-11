package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 汇编
 *
 * @author sun
 **/
public interface AssemblyApi {

    /**
     * 添加指定的MASM汇编指令.
     *
     * @param asm_ins 字符串:MASM汇编指令,大小写均可以 比如 "mov eax,1" ,也支持直接加入字节，
     *                比如"emit 90 90 90 90"等. 同时也支持跳转指令，标记.
     *                标记必须以":"开头. 跳转指令后必须接本次AsmCall之前的存在的有效Label. 另外
     *                跳转只支持短跳转,就是跳转的字节码不能超过128个字节.
     * @return 整形数:
     *         0:失败
     *         1:成功
     */
    @ComMethod
    long AsmAdd(String asm_ins);

    /**
     * 执行用AsmAdd加到缓冲中的指令.
     *
     * @param hwnd 窗口句柄
     * @param mode 模式，取值如下
     *             0 : 在本进程中进行执行，这时hwnd无效. 注: 此模式会创建线程.
     *             1 : 对hwnd指定的进程内执行,注入模式为创建远程线程
     *             2 ：必须在对目标窗口进行注入绑定后,才可以用此模式(直接在目标进程
     *             创建线程).此模式下的call的执行是排队的,如果同时有多个call在此窗口执行,那
     *             么必须排队.所以执行效率不如模式1. 同时此模式受目标窗口刷新速度的影响,目
     *             标窗口刷新太慢，也会影响此模式的速度. 注: 此模式会创建线程.
     *             3 ：同模式2,但是此模式不会创建线程,而直接在hwnd所在线程执行.
     *             4 ：同模式0, 但是此模式不会创建线程,直接在当前调用AsmCall的线程内
     *             执行.
     *             5 : 对hwnd指定的进程内执行,注入模式为APC. 此模式必须开启memory
     *             盾。任意一个memory盾都可以.
     *             6 : 直接hwnd所在线程执行.
     * @return 长整形数:
     *         获取执行汇编代码以后的EAX的值(32位进程),或者RAX的值(64位进程).一般是函数
     *         的返回值. 如果要想知道函数是否执行成功，请查看GetLastError-200 : 执行中出现错误.
     *         函数.
     *         201 : 使用模式5时，没有开启memory盾.
     */
    @ComMethod
    long AsmCall(long hwnd, int mode);

    /**
     * 执行用AsmAdd加到缓冲中的指令. 这个接口同AsmCall,但是由于插件内部在每次
     * AsmCall时,都会有对目标进程分配内存的操作,这样会不够效率.
     * 所以增加这个接口，可以让调用者指定分配好的内存,并在此内存上执行call的操
     * 作.
     *
     * @param hwnd      窗口句柄
     * @param mode      模式，取值如下
     *                  0 : 在本进程中进行执行，这时hwnd无效. 注: 此模式会创建线程.
     *                  1 : 对hwnd指定的进程内执行,注入模式为创建远程线程
     *                  2 ：必须在对目标窗口进行注入绑定后,才可以用此模式(直接在目标进程
     *                  创建线程).此模式下的call的执行是排队的,如果同时有多个call在此窗口执行,那
     *                  么必须排队.所以执行效率不如模式1. 同时此模式受目标窗口刷新速度的影响,目
     *                  标窗口刷新太慢，也会影响此模式的速度. 注: 此模式会创建线程.
     *                  3 ：同模式2,但是此模式不会创建线程,而直接在hwnd所在线程执行.
     *                  4 ：同模式0, 但是此模式不会创建线程,直接在当前调用AsmCall的线程内
     *                  执行.
     *                  5 : 对hwnd指定的进程内执行,注入模式为APC. 此模式必须开启memory
     *                  盾。任意一个memory盾都可以.
     *                  6 : 直接hwnd所在线程执行.
     * @param base_addr 字符串: 16进制格式. 比如"45A00000",此参数指定的地址必须要求有可读可写
     *                  可执行属性. 并且内存大小最少要200个字节. 模式6要求至少400个字节. 如果Call的内
     *                  容较多,那么长度相应也要增加. 如果此参数为空,那么效果就和AsmCall一样.
     * @return 长整形数:
     *         获取执行汇编代码以后的EAX的值(32位进程),或者RAX的值(64位进程).一般是函数
     *         的返回值. 如果要想知道函数是否执行成功，请查看GetLastError
     *         函数.-200 : 执行中出现错误.-201 : 使用模式5时，没有开启memory盾.
     */
    @ComMethod
    long AsmCallEx(long hwnd, int mode, String base_addr);

    /**
     * 清除汇编指令缓冲区 用AsmAdd添加到缓冲的指令全部清除
     *
     * @return 整形数:
     *         0:失败
     *         1:成功
     */
    @ComMethod
    long AsmClear();

    /**
     * 此接口对AsmCall和AsmCallEx中的模式5和6中内置的一些延时参数进行设置.
     *
     * @param time_out 具体含义看以下说明.(默认值10000) 单位毫秒
     * @param param    具体含义看以下说明. (默认值100) 单位毫秒
     * @return 整形数:
     *         0:失败
     *         1:成功
     */
    @ComMethod
    long AsmSetTimeout(int time_out, int param);

    /**
     * 把汇编缓冲区的指令转换为机器码 并用16进制字符串的形式输出
     *
     * @param base_addr 用AsmAdd添加到缓冲区的第一条指令所在的地址
     * @param is_64bit  表示缓冲区的指令是32位还是64位. 32位表示为0,64位表示
     *                  为1
     * @return 字符串:
     *         机器码，比如 "aa bb cc"这样的形式
     */
    @ComMethod
    String Assemble(long base_addr, int is_64bit);

    /**
     * 把指定的机器码转换为汇编语言输出
     *
     * @param asm_code  字符串: 机器码，形式如 "aa bb cc"这样的16进制表示的字符串(空格无所谓)
     * @param base_addr 指令所在的地址
     * @param is_64bit  表示asm_code表示的指令是32位还是64位. 32位表示为0,64
     *                  位表示为1
     * @return 字符串:
     *         MASM汇编语言字符串.如果有多条指令，则每条指令以字符"|"连接.
     */
    @ComMethod
    String DisAssemble(String asm_code, long base_addr, int is_64bit);

    /**
     * 设置是否弹出汇编功能中的错误提示,默认是打开.
     *
     * @param show 0表示不打开,1表示打开
     * @return 整形数:
     *         0 : 失败
     *         1 : 成功
     */
    @ComMethod
    long SetShowAsmErrorMsg(int show);


    /**
     * 使用AsmCall时的hwnd参数当作进程pid. 注:仅对AsmCall的模式1起作用,因为其它模式都需要窗口.
     * 
     * @param enable  0关闭,1打开
     * @return 整形数:
     *         0 : 失败
     *         1 : 成功
     */
    @ComMethod
    long SetAsmHwndAsProcessId(int enable);
}