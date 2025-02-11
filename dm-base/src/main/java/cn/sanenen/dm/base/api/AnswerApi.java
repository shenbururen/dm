package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 答题接口
 * @author sun
 **/
public interface AnswerApi {

    /**
     * 取消上次FaqPost的发送
     *
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long FaqCancel();

    /**
     * 截取指定范围内的动画或者图像,并返回此句柄.
     *
     * @param x1      左上角X坐标
     * @param y1      左上角Y坐标
     * @param x2      右下角X坐标
     * @param y2      右下角Y坐标
     * @param quality 图像或动画品质,或者叫压缩率,此值越大图像质量越好 取值范围（1-100或者250）
     * @param delay   截取动画时用,表示相隔两帧间的时间间隔,单位毫秒 （如果只是截取静态图像,这个参数必须是0）
     * @param time    表示总共截取多久的动画,单位毫秒 （如果只是截取静态图像,这个参数必须是0）
     * @return 图像或者动画句柄
     */
    @ComMethod
    long FaqCapture(int x1, int y1, int x2, int y2, int quality, int delay, int time);

    /**
     * 截取指定图片中的图像,并返回此句柄.
     *
     * @param x1      左上角X坐标
     * @param y1      左上角Y坐标
     * @param x2      右下角X坐标
     * @param y2      右下角Y坐标
     * @param file    图片文件名,图像格式基本都支持.
     * @param quality 图像或动画品质,或者叫压缩率,此值越大图像质量越好 取值范围（1-100或者250）
     * @return 图像或者动画句柄
     */
    @ComMethod
    long FaqCaptureFromFile(int x1, int y1, int x2, int y2, String file, int quality);

    /**
     * 从给定的字符串(也可以算是文字类型的问题),获取此句柄.
     *
     * @param str 文字类型的问题. 比如(桃园三结义指的是哪些人?)
     * @return 文字句柄
     */
    @ComMethod
    long FaqCaptureString(String str);

    /**
     * 获取由FaqPost发送后，由服务器返回的答案.
     *
     * @return 如果此函数调用失败,那么返回值如下 "Error:错误描述"
     *         如果函数调用成功,那么返回值如下 "OK:答案"
     *         根据FaqPost中 request_type取值的不同,返回值不同
     *         当request_type 为0时,答案的格式为"x,y" (不包含引号)
     *         当request_type 为1时,答案的格式为"1" "2" "3" "4" "5" "6" (不包含引号)
     *         当request_type 为2时,答案就是要求的答案比如 "李白" (不包含引号)
     *         当request_type 为3时,答案的格式为"x1,y1|..|xn,yn" 比如 "20,30|78,68|33,33" (不包含引号)
     *         如果返回为空字符串，表示FaqPost还未处理完毕,或者没有调用过FaqPost.
     */
    @ComMethod
    String FaqFetch();

    /**
     * 获取句柄所对应的数据包的大小,单位是字节
     *
     * @param handle 由FaqCapture返回的句柄
     * @return 数据包大小,一般用于判断数据大小,选择合适的压缩比率.
     */
    @ComMethod
    long FaqGetSize(long handle);

    /**
     * 用于判断当前对象是否有发送过答题(FaqPost)
     *
     * @return 0 : 没有 1 : 有发送过
     */
    @ComMethod
    long FaqIsPosted();

    /**
     * 发送指定的图像句柄到指定的服务器,并立即返回(异步操作).
     *
     * @param server       服务器地址以及端口,格式为(ip:port),例如 "192.168.1.100:12345"
     * @param handle       由FaqCapture获取到的句柄
     * @param request_type 取值定义如下   0 : 要求获取坐标 1 : 要求获取选项,比如(ABCDE) 2 : 要求获取文字答案 3 : 要求获取N个坐标.此功能要求答题器必须是v15之后的版本.
     * @param time_out     表示等待多久,单位是毫秒
     * @return 0 : 失败，一般情况下是由于上个FaqPost还没有处理完毕(服务器还没返回) 1 : 成功
     */
    @ComMethod
    long FaqPost(String server, long handle, int request_type, int time_out);

    /**
     * 发送指定的图像句柄到指定的服务器,并等待返回结果(同步等待).
     *
     * @param server       服务器地址以及端口,格式为(ip:port),例如 "192.168.1.100:12345"
     *                     多个地址可以用"|"符号连接。比如"192.168.1.100:12345|192.168.1.101:12345"。
     * @param handle       由FaqCapture获取到的句柄
     * @param request_type 取值定义如下 0 : 要求获取坐标 1 : 要求获取选项,比如(ABCDE) 2 : 要求获取文字答案 3 : 要求获取N个坐标.此功能要求答题器必须是v15之后的版本.
     * @param time_out     表示等待多久,单位是毫秒
     * @return 如果此函数调用失败,那么返回值如下 "Error:错误描述"
     *         如果函数调用成功,那么返回值如下 "OK:答案"
     *         根据request_type取值的不同,返回值不同
     *         当request_type 为0时,答案的格式为"x,y" (不包含引号)
     *         当request_type 为1时,答案的格式为"1" "2" "3" "4" "5" "6" (不包含引号)
     *         当request_type 为2时,答案就是要求的答案 比如 "李白" (不包含引号)
     *         当request_type 为3时,答案的格式为"x1,y1|...|xn,yn|" 比如 "20,30|78,68|33,33" (不包含引号)
     *         
     */
    @ComMethod
    String FaqSend(String server, long handle, int request_type, int time_out);

}
