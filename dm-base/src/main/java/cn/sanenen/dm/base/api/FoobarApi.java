package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * Foobar
 *
 * @author sun
 **/
public interface FoobarApi {
    /**
     * 根据指定的位图创建一个自定义形状的窗口
     *
     * @param hwnd        整形数: 指定的窗口句柄,如果此值为0,那么就在桌面创建此窗口
     * @param x           整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y           整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param pic_name    字符串: 位图名字. 如果第一个字符是@,则采用指针方式. @后面是指针地址和大小. 必须是十进制. 具体看下面的例子
     * @param trans_color 字符串: 透明色(RRGGBB)
     * @param sim         双精度浮点数: 透明色的相似值 0.1-1.0
     * @return 整形数 : 创建成功的窗口句柄
     */
    @ComMethod
    long CreateFoobarCustom(long hwnd, int x, int y, String pic_name, String trans_color, double sim);

    /**
     * 创建一个椭圆窗口
     *
     * @param hwnd 整形数: 指定的窗口句柄,如果此值为0,那么就在桌面创建此窗口
     * @param x    整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y    整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param w    整形数: 矩形区域的宽度
     * @param h    整形数: 矩形区域的高度
     * @return 整形数 : 创建成功的窗口句柄
     */
    @ComMethod
    long CreateFoobarEllipse(long hwnd, int x, int y, int w, int h);

    /**
     * 创建一个矩形窗口
     *
     * @param hwnd 整形数: 指定的窗口句柄,如果此值为0,那么就在桌面创建此窗口
     * @param x    整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y    整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param w    整形数: 矩形区域的宽度
     * @param h    整形数: 矩形区域的高度
     * @return 整形数 : 创建成功的窗口句柄
     */
    @ComMethod
    long CreateFoobarRect(long hwnd, int x, int y, int w, int h);

    /**
     * 创建一个圆角矩形窗口
     *
     * @param hwnd 整形数: 指定的窗口句柄,如果此值为0,那么就在桌面创建此窗口
     * @param x    整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y    整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param w    整形数: 矩形区域的宽度
     * @param h    整形数: 矩形区域的高度
     * @param rw   整形数: 圆角的宽度
     * @param rh   整形数: 圆角的高度
     * @return 整形数 : 创建成功的窗口句柄
     */
    @ComMethod
    long CreateFoobarRoundRect(long hwnd, int x, int y, int w, int h, int rw, int rh);

    /**
     * 清除指定的Foobar滚动文本区
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarClearText(long hwnd);

    /**
     * 关闭一个Foobar,注意,必须调用此函数来关闭窗口,用SetWindowState也可以关闭,但会造成内存泄漏.
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄
     * @return 整形数 : 0: 失败 1: 成功
     */
    @ComMethod
    long FoobarClose(long hwnd);

    /**
     * 在指定的Foobar窗口内部画线条.
     *
     * @param hwnd  整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x1    整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y1    整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param x2    整形数: 右下角X坐标(相对于hwnd客户区坐标)
     * @param y2    整形数: 右下角Y坐标(相对于hwnd客户区坐标)
     * @param color 字符串: 填充的颜色值
     * @param style 整形数: 画笔类型. 0为实线. 1为虚线
     * @param width 整形数: 线条宽度.
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarDrawLine(long hwnd, int x1, int y1, int x2, int y2, String color, int style, int width);

    /**
     * 在指定的Foobar窗口绘制图像
     *
     * @param hwnd        整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x           整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y           整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param pic_name    字符串: 图像文件名 如果第一个字符是@,则采用指针方式. @后面是指针地址和大小. 必须是十进制. 具体看下面的例子
     * @param trans_color 字符串: 图像透明色
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarDrawPic(long hwnd, int x, int y, String pic_name, String trans_color);

    /**
     * 在指定的Foobar窗口绘制文字
     *
     * @param hwnd  整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x     整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y     整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param w     整形数: 矩形区域的宽度
     * @param h     整形数: 矩形区域的高度
     * @param text  字符串: 字符串
     * @param color 字符串: 文字颜色值
     * @param align 整形数: 取值定义如下 1 : 左对齐 2 : 中间对齐 4 : 右对齐
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarDrawText(long hwnd, int x, int y, int w, int h, String text, String color, int align);

    /**
     * 在指定的Foobar窗口内部填充矩形
     *
     * @param hwnd  整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x1    整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y1    整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param x2    整形数: 右下角X坐标(相对于hwnd客户区坐标)
     * @param y2    整形数: 右下角Y坐标(相对于hwnd客户区坐标)
     * @param color 字符串: 填充的颜色值
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarFillRect(long hwnd, int x1, int y1, int x2, int y2, String color);

    /**
     * 锁定指定的Foobar窗口,不能通过鼠标来移动
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarLock(long hwnd);

    /**
     * 向指定的Foobar窗口区域内输出滚动文字
     *
     * @param hwnd  整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param text  字符串: 文本内容
     * @param color 字符串: 文本颜色
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarPrintText(long hwnd, String text, String color);

    /**
     * 设置指定Foobar窗口的字体
     *
     * @param hwnd      整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param font_name 字符串: 系统字体名,注意,必须保证系统中有此字体
     * @param size      整形数: 字体大小
     * @param flag      整形数: 取值定义如下 0 : 正常字体 1 : 粗体 2 : 斜体 4 : 下划线 文字可以是以上的组合 比如粗斜体就是1+2,斜体带下划线就是:2+4等.
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarSetFont(long hwnd, String font_name, int size, int flag);

    /**
     * 设置保存指定的Foobar滚动文本区信息到文件.
     *
     * @param hwnd   整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param file   字符串: 保存的文件名
     * @param enable 整形数: 取值如下 0 : 关闭向文件输出 (默认是0) 1 : 开启向文件输出
     * @param header 字符串: 输出的附加头信息. (比如行数 日期 时间信息) 格式是如下格式串的顺序组合.如果为空串，表示无附加头.
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarSetSave(long hwnd, String file, int enable, String header);

    /**
     * 设置指定Foobar窗口的是否透明
     *
     * @param hwnd     整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param is_trans 整形数: 是否透明. 0为不透明(此时,color和sim无效)，1为透明.
     * @param color    字符串: 透明色(RRGGBB)
     * @param sim      双精度浮点数: 透明色的相似值 0.1-1.0
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarSetTrans(long hwnd, int is_trans, String color, double sim);

    /**
     * 在指定的Foobar窗口绘制gif动画.
     *
     * @param hwnd         整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x            整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y            整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param pic_name     字符串: 图像文件名 如果第一个字符是@,则采用指针方式. @后面是指针地址和大小. 必须是十进制. 具体看下面的例子
     * @param repeat_limit 整形数: 表示重复GIF动画的次数，如果是0表示一直循环显示.大于0，则表示循环指定的次数以后就停止显示.
     * @param delay        整形数: 表示每帧GIF动画之间的时间间隔.如果是0，表示使用GIF内置的时间，如果大于0，表示使用自定义的时间间隔.
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarStartGif(long hwnd, int x, int y, String pic_name, int repeat_limit, int delay);

    /**
     * 停止在指定foobar里显示的gif动画.
     *
     * @param hwnd     整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @param x        整形数: 左上角X坐标(相对于hwnd客户区坐标)
     * @param y        整形数: 左上角Y坐标(相对于hwnd客户区坐标)
     * @param pic_name 字符串: 图像文件名
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarStopGif(long hwnd, int x, int y, String pic_name);

    /**
     * 设置滚动文本区的文字行间距,默认是3
     *
     * @param hwnd     整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param line_gap 整形数: 文本行间距
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarTextLineGap(long hwnd, int line_gap);

    /**
     * 设置滚动文本区的文字输出方向,默认是0
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param dir  整形数: 0 表示向下输出 1 表示向上输出
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarTextPrintDir(long hwnd, int dir);

    /**
     * 设置指定Foobar窗口的滚动文本框范围,默认的文本框范围是窗口区域
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @param x    整形数: x坐标
     * @param y    整形数: y坐标
     * @param w    整形数: 宽度
     * @param h    整形数: 高度
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarTextRect(long hwnd, int x, int y, int w, int h);

    /**
     * 解锁指定的Foobar窗口,可以通过鼠标来移动
     *
     * @param hwnd 整形数: 指定的Foobar窗口句柄,此句柄必须是通过CreateFoobarxxx创建而来
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarUnlock(long hwnd);

    /**
     * 刷新指定的Foobar窗口
     *
     * @param hwnd 整形数: 指定的Foobar窗口,注意,此句柄必须是通过CreateFoobarxxxx系列函数创建出来的
     * @return 整形数 : 0 : 失败 1 : 成功
     */
    @ComMethod
    long FoobarUpdate(long hwnd);
}