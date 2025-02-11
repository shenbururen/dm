package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.Variant;

/**
 * ai
 * @author sun
 **/
public interface AiApi {

    /**
     * 在指定范围内检测对象.
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param prob 置信度,也可以认为是相似度. 超过这个prob的对象才会被检测
     * @param iou 用于对多个检测框进行合并. 越大越不容易合并(很多框重叠). 越小越容易合并(可能会把正常的框也给合并). 所以这个值一般建议0.4 0.6之间.
     * @return 返回的是所有检测到的对象.格式是"类名,置信度,x,y,w,h|....". 如果没检测到任何对象,返回空字符串.
     */
    @ComMethod
    String AiYoloDetectObjects(int x1, int y1, int x2, int y2, double prob, double iou);

    /**
     * 在指定范围内检测对象,把结果输出到BMP图像数据.用于二次开发.
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param prob 置信度,也可以认为是相似度. 超过这个prob的对象才会被检测
     * @param iou 用于对多个检测框进行合并. 越大越不容易合并(很多框重叠). 越小越容易合并(可能会把正常的框也给合并). 所以这个值一般建议0.4 0.6之间.
     * @param data 返回图片的数据指针
     * @param size 返回图片的数据长度
     * @param mode 0表示绘制的文字信息里包含置信度. 1表示不包含.
     * @return 0 : 失败 1 : 成功
     */
    @ComMethod
    long AiYoloDetectObjectsToDataBmp(int x1, int y1, int x2, int y2, double prob, double iou, Variant.VARIANT data, Variant.VARIANT size, int mode);

    /**
     * 在指定范围内检测对象,把结果输出到指定的BMP文件.
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param prob 置信度,也可以认为是相似度. 超过这个prob的对象才会被检测
     * @param iou 用于对多个检测框进行合并. 越大越不容易合并(很多框重叠). 越小越容易合并(可能会把正常的框也给合并). 所以这个值一般建议0.4 0.6之间.
     * @param file 图片名,比如"test.bmp"
     * @param mode 0表示绘制的文字信息里包含置信度. 1表示不包含.
     * @return 0 : 失败 1 : 成功
     */
    @ComMethod
    long AiYoloDetectObjectsToFile(int x1, int y1, int x2, int y2, double prob, double iou, String file, int mode);

    /**
     * 卸载指定的模型
     * @param index 模型的序号. 最多支持20个. 从0开始
     * @return 1 表示成功 0 失败
     */
    @ComMethod
    long AiYoloFreeModel(int index);

    /**
     * 把通过AiYoloDetectObjects或者是AiYoloSortsObjects的结果,按照顺序把class信息连接输出.
     * @param objects AiYoloDetectObjects或者AiYoloSortsObjects的返回值.
     * @return 返回的是class信息连接后的信息.
     */
    @ComMethod
    String AiYoloObjectsToString(String objects);

    /**
     * 从文件加载指定的模型.
     * @param index 模型的序号. 最多支持20个. 从0开始
     * @param file 模型文件名. 比如"xxxx.onnx"或者"xxxx.dmx"
     * @param pwd 模型的密码. 仅对dmx格式有效.
     * @return 1 表示成功 0 失败
     */
    @ComMethod
    long AiYoloSetModel(int index, String file, String pwd);

    /**
     * 从内存加载指定的模型. 仅支持dmx格式的内存
     * @param index 模型的序号. 最多支持20个. 从0开始
     * @param data dmx模型的内存地址
     * @param size dmx模型的大小
     * @param pwd dmx模型的密码
     * @return 1 表示成功 0 失败
     */
    @ComMethod
    long AiYoloSetModelMemory(int index, int data, int size, String pwd);

    /**
     * 设置Yolo的版本
     * @param ver Yolo的版本信息. 需要在加载Ai模块后,第一时间调用. 目前可选的值只有"v5-7.0"
     * @return 1 表示成功 0 失败
     */
    @ComMethod
    long AiYoloSetVersion(String ver);

    /**
     * 把通过AiYoloDetectObjects的结果进行排序. 排序按照从上到下,从左到右.
     * @param objects AiYoloDetectObjects的返回值
     * @param height 行高信息. 排序时需要使用此行高. 用于确定两个检测框是否处于同一行. 如果两个框的Y坐标相差绝对值小于此行高,认为是同一行.
     * @return 返回的是所有检测到的对象.格式是"类名,置信度,x,y,w,h|....". 如果没检测到任何对象,返回空字符串.
     */
    @ComMethod
    String AiYoloSortsObjects(String objects, int height);

    /**
     * 切换当前使用的模型序号.用于AiYoloDetectXX等系列接口.
     * @param index 模型的序号. 最多支持20个. 从0开始
     * @return 1 表示成功 0 失败
     */
    @ComMethod
    long AiYoloUseModel(int index);

    /**
     * 加载Ai模块. Ai模块从后台下载. 模块加载仅支持所有的正式版本。
     * @param file ai模块的路径. 比如绝对路径c:\ai.module或者相对路径ai.module等.
     * @return 1 表示成功 -1 打开文件失败 -2 内存初始化失败. 如果是正式版本,出现这个错误可以联系我解决. -3 参数错误 -4 加载错误 -5 Ai模块初始化失败 -6 内存分配失败
     */
    @ComMethod
    long LoadAi(String file);

    /**
     * 从内存加载Ai模块. Ai模块从后台下载. 模块加载仅支持所有的正式版本。
     * @param data ai模块在内存中的地址
     * @param size ai模块在内存中的大小
     * @return 1 表示成功 -1 打开文件失败 -2 内存初始化失败. 如果是正式版本,出现这个错误可以联系我解决. -3 参数错误 -4 加载错误 -5 Ai模块初始化失败 -6 内存分配失败
     */
    @ComMethod
    long LoadAiMemory(int data, int size);

    /**
     * 设置是否在调用AiFindPicXX系列接口时,是否弹出找图结果的窗口. 方便调试. 默认是关闭的.
     * @param enable 0 关闭 1 开启
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long AiEnableFindPicWindow(int enable);

    /**
     * 查找指定区域内的图片,位图必须是24位色格式,支持透明色,当图像上下左右4个顶点的颜色一样时,则这个颜色将作为透明色处理.
     * 这个函数可以查找多个图片,只返回第一个找到的X Y坐标.
     * 此接口使用Ai模块来实现,比传统的FindPic的效果更好. 不需要训练
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param pic_name 图片名,可以是多个图片,比如"test.bmp|test2.bmp|test3.bmp"
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
     * @param intX 返回图片左上角的X坐标
     * @param intY 返回图片左上角的Y坐标
     * @return 返回找到的图片的序号,从0开始索引.如果没找到返回-1
     */
    @ComMethod
    long AiFindPic(int x1, int y1, int x2, int y2, String pic_name, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找指定区域内的图片,位图必须是24位色格式,支持透明色,当图像上下左右4个顶点的颜色一样时,则这个颜色将作为透明色处理.
     * 这个函数可以查找多个图片,并且返回所有找到的图像的坐标.
     * 此接口使用Ai模块来实现,比传统的FindPicEx的效果更好.不需要训练
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param pic_name 图片名,可以是多个图片,比如"test.bmp|test2.bmp|test3.bmp"
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
     * @return 返回的是所有找到的坐标格式如下:"id,x,y|id,x,y..|id,x,y" (图片左上角的坐标)
     */
    @ComMethod
    String AiFindPicEx(int x1, int y1, int x2, int y2, String pic_name, double sim, int dir);

    /**
     * 查找指定区域内的图片,位图必须是24位色格式,支持透明色,当图像上下左右4个顶点的颜色一样时,则这个颜色将作为透明色处理.
     * 这个函数可以查找多个图片,只返回第一个找到的X Y坐标. 这个函数要求图片是数据地址.
     * 此接口使用Ai模块来实现,比传统的FindPicMem的效果更好.不需要训练
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param pic_info 图片数据地址集合. 格式为"地址1,长度1|地址2,长度2.....|地址n,长度n". 可以用AppendPicAddr 来组合.
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
     * @param intX 返回图片左上角的X坐标
     * @param intY 返回图片左上角的Y坐标
     * @return 返回找到的图片的序号,从0开始索引.如果没找到返回-1
     */
    @ComMethod
    long AiFindPicMem(int x1, int y1, int x2, int y2, String pic_info, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找指定区域内的图片,位图必须是24位色格式,支持透明色,当图像上下左右4个顶点的颜色一样时,则这个颜色将作为透明色处理.
     * 这个函数可以查找多个图片,并且返回所有找到的图像的坐标. 这个函数要求图片是数据地址.
     * 此接口使用Ai模块来实现,比传统的FindPicMemEx的效果更好.不需要训练
     * @param x1 区域的左上X坐标
     * @param y1 区域的左上Y坐标
     * @param x2 区域的右下X坐标
     * @param y2 区域的右下Y坐标
     * @param pic_info 图片数据地址集合. 格式为"地址1,长度1|地址2,长度2.....|地址n,长度n". 可以用AppendPicAddr 来组合.
     * @param sim 相似度,取值范围0.1-1.0
     * @param dir 查找方向 0: 从左到右,从上到下 1: 从左到右,从下到上 2: 从右到左,从上到下 3: 从右到左, 从下到上
     * @return 返回的是所有找到的坐标格式如下:"id,x,y|id,x,y..|id,x,y" (图片左上角的坐标)
     */
    @ComMethod
    String AiFindPicMemEx(int x1, int y1, int x2, int y2, String pic_info, double sim, int dir);
}