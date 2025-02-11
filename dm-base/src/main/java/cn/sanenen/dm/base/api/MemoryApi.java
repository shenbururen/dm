package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 内存
 *
 * @author sun
 **/
public interface MemoryApi {

    /**
     * 把双精度浮点数转换成二进制形式.
     *
     * @param value 双精度浮点数: 需要转化的双精度浮点数
     * @return 字符串: 字符串形式表达的二进制数据
     */
    @ComMethod
    String DoubleToData(double value);

    /**
     * 搜索指定的二进制数据,默认步长是1.如果要定制步长，请用FindDataEx
     *
     * @param hwnd       窗口句柄或者进程ID
     * @param addr_range 指定搜索的地址集合
     * @param data       要搜索的二进制数据
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindData(long hwnd, String addr_range, String data);

    /**
     * 搜索指定的二进制数据.
     *
     * @param hwnd         窗口句柄或者进程ID
     * @param addr_range   指定搜索的地址集合
     * @param data         要搜索的二进制数据
     * @param step         搜索步长
     * @param multi_thread 是否开启多线程查找
     * @param mode         是否开启快速扫描
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindDataEx(long hwnd, String addr_range, String data, int step, int multi_thread, int mode);

    /**
     * 搜索指定的双精度浮点数,默认步长是1.如果要定制步长，请用FindDoubleEx
     *
     * @param hwnd             窗口句柄或者进程ID
     * @param addr_range       指定搜索的地址集合
     * @param double_value_min 搜索的双精度数值最小值
     * @param double_value_max 搜索的双精度数值最大值
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindDouble(long hwnd, String addr_range, double double_value_min, double double_value_max);

    /**
     * 搜索指定的双精度浮点数.
     *
     * @param hwnd             窗口句柄或者进程ID
     * @param addr_range       指定搜索的地址集合
     * @param double_value_min 搜索的双精度数值最小值
     * @param double_value_max 搜索的双精度数值最大值
     * @param step             搜索步长
     * @param multi_thread     是否开启多线程查找
     * @param mode             是否开启快速扫描
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindDoubleEx(long hwnd, String addr_range, double double_value_min, double double_value_max, int step, int multi_thread, int mode);

    /**
     * 搜索指定的单精度浮点数,默认步长是1.如果要定制步长，请用FindFloatEx
     *
     * @param hwnd            窗口句柄或者进程ID
     * @param addr_range      指定搜索的地址集合
     * @param float_value_min 搜索的单精度数值最小值
     * @param float_value_max 搜索的单精度数值最大值
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindFloat(long hwnd, String addr_range, float float_value_min, float float_value_max);

    /**
     * 搜索指定的单精度浮点数.
     *
     * @param hwnd            窗口句柄或者进程ID
     * @param addr_range      指定搜索的地址集合
     * @param float_value_min 搜索的单精度数值最小值
     * @param float_value_max 搜索的单精度数值最大值
     * @param step            搜索步长
     * @param multi_thread    是否开启多线程查找
     * @param mode            是否开启快速扫描
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindFloatEx(long hwnd, String addr_range, float float_value_min, float float_value_max, int step, int multi_thread, int mode);

    /**
     * 搜索指定的整数,默认步长是1.如果要定制步长，请用FindIntEx
     *
     * @param hwnd          窗口句柄或者进程ID
     * @param addr_range    指定搜索的地址集合
     * @param int_value_min 搜索的整数数值最小值
     * @param int_value_max 搜索的整数数值最大值
     * @param type          搜索的整数类型
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindInt(long hwnd, String addr_range, long int_value_min, long int_value_max, int type);

    /**
     * 搜索指定的整数.
     *
     * @param hwnd          窗口句柄或者进程ID
     * @param addr_range    指定搜索的地址集合
     * @param int_value_min 搜索的整数数值最小值
     * @param int_value_max 搜索的整数数值最大值
     * @param type          搜索的整数类型
     * @param step          搜索步长
     * @param multi_thread  是否开启多线程查找
     * @param mode          是否开启快速扫描
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindIntEx(long hwnd, String addr_range, long int_value_min, long int_value_max, int type, int step, int multi_thread, int mode);

    /**
     * 搜索指定的字符串,默认步长是1.如果要定制步长，请用FindStringEx
     *
     * @param hwnd         窗口句柄或者进程ID
     * @param addr_range   指定搜索的地址集合
     * @param string_value 搜索的字符串
     * @param type         搜索的字符串类型
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindString(long hwnd, String addr_range, String string_value, int type);

    /**
     * 搜索指定的字符串.
     *
     * @param hwnd         窗口句柄或者进程ID
     * @param addr_range   指定搜索的地址集合
     * @param string_value 搜索的字符串
     * @param type         搜索的字符串类型
     * @param step         搜索步长
     * @param multi_thread 是否开启多线程查找
     * @param mode         是否开启快速扫描
     * @return 字符串: 返回搜索到的地址集合
     */
    @ComMethod
    String FindStringEx(long hwnd, String addr_range, String string_value, int type, int step, int multi_thread, int mode);

    /**
     * 把单精度浮点数转换成二进制形式.
     *
     * @param value 单精度浮点数: 需要转化的单精度浮点数
     * @return 字符串: 字符串形式表达的二进制数据
     */
    @ComMethod
    String FloatToData(float value);

    /**
     * 释放指定进程的不常用内存.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long FreeProcessMemory(long hwnd);

    /**
     * 获取指定窗口所在进程的启动命令行
     *
     * @param hwnd 窗口句柄或者进程ID
     * @return 字符串: 读取到的启动命令行
     */
    @ComMethod
    String GetCommandLine(long hwnd);

    /**
     * 根据指定的窗口句柄，来获取对应窗口句柄进程下的指定模块的基址
     *
     * @param hwnd   窗口句柄或者进程ID
     * @param module 模块名
     * @return 长整形数: 模块的基址
     */
    @ComMethod
    long GetModuleBaseAddr(long hwnd, String module);

    /**
     * 根据指定的窗口句柄，来获取对应窗口句柄进程下的指定模块的大小
     *
     * @param hwnd   窗口句柄或者进程ID
     * @param module 模块名
     * @return 整形数: 模块的大小
     */
    @ComMethod
    long GetModuleSize(long hwnd, String module);

    /**
     * 根据指定的目标模块地址,获取目标窗口(进程)内的导出函数地址.
     *
     * @param hwnd      窗口句柄或者进程ID
     * @param base_addr 目标模块地址
     * @param fun_name  需要获取的导出函数名
     * @return 长整形数: 获取的地址
     */
    @ComMethod
    long GetRemoteApiAddress(long hwnd, long base_addr, String fun_name);

    /**
     * 强制转换64位整数为32位.
     *
     * @param value 长整形数: 需要转换的64位整数
     * @return 整形数: 返回的32位整数
     */
    @ComMethod
    long Int64ToInt32(long value);

    /**
     * 把整数转换成二进制形式.
     *
     * @param value 长整形数: 需要转化的整型数
     * @param type  取值如下: 0: 4字节整形数 1: 2字节整形数 2: 1字节整形数 3: 8字节整形数
     * @return 字符串: 字符串形式表达的二进制数据
     */
    @ComMethod
    String IntToData(long value, int type);

    /**
     * 根据指定pid打开进程，并返回进程句柄.
     *
     * @param pid 整形数: 进程pid
     * @return 整形数: 进程句柄
     */
    @ComMethod
    long OpenProcess(int pid);

    /**
     * 读取指定地址的二进制数据
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param len  二进制数据的长度
     * @return 字符串: 读取到的数值,以16进制表示的字符串
     */
    @ComMethod
    String ReadData(long hwnd, String addr, int len);

    /**
     * 读取指定地址的二进制数据
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param len  二进制数据的长度
     * @return 字符串: 读取到的数值,以16进制表示的字符串
     */
    @ComMethod
    String ReadDataAddr(long hwnd, long addr, int len);

    /**
     * 读取指定地址的二进制数据,只不过返回的是内存地址,而不是字符串.适合高级用户.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param len  二进制数据的长度
     * @return 整形数: 读取到的数据指针
     */
    @ComMethod
    long ReadDataAddrToBin(long hwnd, long addr, int len);

    /**
     * 读取指定地址的二进制数据,只不过返回的是内存地址,而不是字符串.适合高级用户.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param len  二进制数据的长度
     * @return 整形数: 读取到的数据指针
     */
    @ComMethod
    long ReadDataToBin(long hwnd, String addr, int len);

    /**
     * 读取指定地址的双精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @return 双精度浮点数: 读取到的数值
     */
    @ComMethod
    double ReadDouble(long hwnd, String addr);

    /**
     * 读取指定地址的双精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @return 双精度浮点数: 读取到的数值
     */
    @ComMethod
    double ReadDoubleAddr(long hwnd, long addr);

    /**
     * 读取指定地址的单精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @return 单精度浮点数: 读取到的数值
     */
    @ComMethod
    float ReadFloat(long hwnd, String addr);

    /**
     * 读取指定地址的单精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @return 单精度浮点数: 读取到的数值
     */
    @ComMethod
    float ReadFloatAddr(long hwnd, long addr);

    /**
     * 读取指定地址的整数数值，类型可以是8位，16位 32位 或者64位
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param type 整数类型
     * @return 长整形数: 读取到的数值
     */
    @ComMethod
    long ReadInt(long hwnd, String addr, int type);

    /**
     * 读取指定地址的整数数值，类型可以是8位，16位 32位 或者64位
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param type 整数类型
     * @return 长整形数: 读取到的数值
     */
    @ComMethod
    long ReadIntAddr(long hwnd, long addr, int type);

    /**
     * 读取指定地址的字符串，可以是GBK字符串或者是Unicode字符串.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param type 字符串类型
     * @param len  需要读取的字节数目
     * @return 字符串: 读取到的字符串
     */
    @ComMethod
    String ReadString(long hwnd, String addr, int type, int len);

    /**
     * 读取指定地址的字符串，可以是GBK字符串或者是Unicode字符串.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param type 字符串类型
     * @param len  需要读取的字节数目
     * @return 字符串: 读取到的字符串
     */
    @ComMethod
    String ReadStringAddr(long hwnd, long addr, int type, int len);

    /**
     * 设置是否把所有内存查找接口的结果保存入指定文件.
     *
     * @param file 设置要保存的搜索结果文件名
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long SetMemoryFindResultToFile(String file);

    /**
     * 设置是否把所有内存接口函数中的窗口句柄当作进程ID,以支持直接以进程ID来使用内存接口.
     *
     * @param en 取值如下: 0 : 关闭 1 : 开启
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long SetMemoryHwndAsProcessId(int en);

    /**
     * 把字符串转换成二进制形式.
     *
     * @param value 需要转化的字符串
     * @param type  取值如下: 0: 返回Ascii表达的字符串 1: 返回Unicode表达的字符串
     * @return 字符串: 字符串形式表达的二进制数据
     */
    @ComMethod
    String StringToData(String value, int type);

    /**
     * 根据指定的PID，强制结束进程.
     *
     * @param pid 进程ID
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long TerminateProcess(int pid);

    /**
     * 在指定的窗口所在进程分配一段内存.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 预期的分配地址
     * @param size 需要分配的内存大小
     * @param type 需要分配的内存类型
     * @return 长整形数: 分配的内存地址
     */
    @ComMethod
    long VirtualAllocEx(long hwnd, long addr, int size, int type);

    /**
     * 释放用VirtualAllocEx分配的内存.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr VirtualAllocEx返回的地址
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long VirtualFreeEx(long hwnd, long addr);

    /**
     * 修改指定的窗口所在进程的地址的读写属性,修改为可读可写可执行.
     *
     * @param hwnd        窗口句柄或者进程ID
     * @param addr        需要修改的地址
     * @param size        需要修改的地址大小
     * @param type        修改的地址读写属性类型
     * @param old_protect 指定的读写属性
     * @return 整形数: 0 : 失败 1 : 修改之前的读写属性
     */
    @ComMethod
    long VirtualProtectEx(long hwnd, long addr, int size, int type, int old_protect);

    /**
     * 获取指定窗口，指定地址的内存属性.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 需要查询的地址
     * @param pmbi 这是一个地址,指向的内容是MEMORY_BASIC_INFORMATION32或者MEMORY_BASIC_INFORMATION64
     * @return 字符串: 查询的结果以字符串形式
     */
    @ComMethod
    String VirtualQueryEx(long hwnd, long addr, int pmbi);

    /**
     * 对指定地址写入二进制数据
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param data 二进制数据
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteData(long hwnd, String addr, String data);

    /**
     * 对指定地址写入二进制数据
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param data 二进制数据
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteDataAddr(long hwnd, long addr, String data);

    /**
     * 对指定地址写入二进制数据,只不过直接从数据指针获取数据写入,不通过字符串. 适合高级用户.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param data 数据指针
     * @param len  数据长度
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteDataAddrFromBin(long hwnd, long addr, int data, int len);

    /**
     * 对指定地址写入二进制数据,只不过直接从数据指针获取数据写入,不通过字符串. 适合高级用户.
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param data 数据指针
     * @param len  数据长度
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteDataFromBin(long hwnd, String addr, int data, int len);

    /**
     * 对指定地址写入双精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param v    双精度浮点数
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteDouble(long hwnd, String addr, double v);

    /**
     * 对指定地址写入双精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param v    双精度浮点数
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteDoubleAddr(long hwnd, long addr, double v);

    /**
     * 对指定地址写入单精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param v    单精度浮点数
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteFloat(long hwnd, String addr, float v);

    /**
     * 对指定地址写入单精度浮点数
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param v    单精度浮点数
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteFloatAddr(long hwnd, long addr, float v);

    /**
     * 对指定地址写入整数数值，类型可以是8位，16位 32位 或者64位
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param type 整数类型
     * @param v    整形数值
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteInt(long hwnd, String addr, int type, long v);

    /**
     * 对指定地址写入整数数值，类型可以是8位，16位 32位 或者64位
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param type 整数类型
     * @param v    整形数值
     * @return 整形数: 0 : 失败 1 : 成功
     */
    @ComMethod
    long WriteIntAddr(long hwnd, long addr, int type, long v);

    /**
     * 对指定地址写入字符串，可以是Ascii字符串或者是Unicode字符串
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 用字符串来描述地址
     * @param type 字符串类型
     * @param v    字符串
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long WriteString(long hwnd, String addr, int type, String v);

    /**
     * 对指定地址写入字符串，可以是Ascii字符串或者是Unicode字符串
     *
     * @param hwnd 窗口句柄或者进程ID
     * @param addr 地址
     * @param type 字符串类型
     * @param v    字符串
     * @return 整形数: 0: 失败 1: 成功
     */
    @ComMethod
    long WriteStringAddr(long hwnd, long addr, int type, String v);
}