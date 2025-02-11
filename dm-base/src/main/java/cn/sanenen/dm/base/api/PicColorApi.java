package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.Variant;

/**
 * 图色
 * @author sun
 **/
public interface PicColorApi {
    
    /**
     * 追加图片地址
     * @param pic_info 图片信息
     * @param addr 地址
     * @param size 大小
     * @return 追加后的图片地址
     */
    @ComMethod
    String AppendPicAddr(String pic_info, int addr, int size);

    /**
     * 将BGR颜色转换为RGB颜色
     * @param bgr_color BGR颜色字符串
     * @return RGB颜色字符串
     */
    @ComMethod
    String BGR2RGB(String bgr_color);

    /**
     * 捕获屏幕指定区域为图片文件
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param file 保存的文件路径
     * @return 捕获结果
     */
    @ComMethod
    long Capture(int x1, int y1, int x2, int y2, String file);

    /**
     * 捕获屏幕指定区域为GIF文件
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param file 保存的文件路径
     * @param delay 延迟时间
     * @param time 持续时间
     * @return 捕获结果
     */
    @ComMethod
    long CaptureGif(int x1, int y1, int x2, int y2, String file, int delay, int time);

    /**
     * 捕获屏幕指定区域为JPG文件
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param file 保存的文件路径
     * @param quality 图片质量
     * @return 捕获结果
     */
    @ComMethod
    long CaptureJpg(int x1, int y1, int x2, int y2, String file, int quality);

    /**
     * 捕获屏幕指定区域为PNG文件
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param file 保存的文件路径
     * @return 捕获结果
     */
    @ComMethod
    long CapturePng(int x1, int y1, int x2, int y2, String file);

    /**
     * 捕获屏幕预览
     * @param file 保存的文件路径
     * @return 捕获结果
     */
    @ComMethod
    long CapturePre(String file);

    /**
     * 比较颜色
     * @param x x坐标
     * @param y y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @return 比较结果
     */
    @ComMethod
    long CmpColor(int x, int y, String color, double sim);

    /**
     * 启用或禁用显示调试
     * @param enable_debug 启用或禁用调试标志
     * @return 设置结果
     */
    @ComMethod
    long EnableDisplayDebug(int enable_debug);

    /**
     * 启用或禁用多线程查找图片
     * @param enable 启用或禁用多线程标志
     * @return 设置结果
     */
    @ComMethod
    long EnableFindPicMultithread(int enable);

    /**
     * 启用或禁用通过捕获获取颜色
     * @param enable 启用或禁用标志
     * @return 设置结果
     */
    @ComMethod
    long EnableGetColorByCapture(int enable);

    /**
     * 查找颜色
     * @param x 起始x坐标
     * @param y 起始y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindColor(int x, int y, String color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找颜色块
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @param count 颜色块数量
     * @param width 宽度
     * @param height 高度
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindColorBlock(int x1, int y1, int x2, int y2, String color, double sim, int count, int width, int height, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找颜色块（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @param count 颜色块数量
     * @param width 宽度
     * @param height 高度
     * @return 查找结果
     */
    @ComMethod
    String FindColorBlockEx(int x1, int y1, int x2, int y2, String color, double sim, int count, int width, int height);

    /**
     * 查找颜色（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindColorE(int x1, int y1, int x2, int y2, String color, double sim, int dir);

    /**
     * 查找颜色（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindColorEx(int x1, int y1, int x2, int y2, String color, double sim, int dir);

    /**
     * 查找多颜色
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @return 查找结果
     */
    @ComMethod
    long FindMulColor(int x1, int y1, int x2, int y2, String color, double sim);

    /**
     * 查找多个颜色
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param first_color 第一个颜色字符串
     * @param offset_color 偏移颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindMultiColor(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找多个颜色（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param first_color 第一个颜色字符串
     * @param offset_color 偏移颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindMultiColorE(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir);

    /**
     * 查找多个颜色（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param first_color 第一个颜色字符串
     * @param offset_color 偏移颜色字符串
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindMultiColorEx(int x1, int y1, int x2, int y2, String first_color, String offset_color, double sim, int dir);

    /**
     * 查找图片
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindPic(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicE(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    /**
     * 查找图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicEx(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    /**
     * 查找图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicExS(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir);

    /**
     * 查找内存中的图片
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindPicMem(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找内存中的图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicMemE(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    /**
     * 查找内存中的图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicMemEx(int x1, int y1, int x2, int y2, String pic_info, String delta_color, double sim, int dir);

    /**
     * 查找图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    String FindPicS(int x1, int y1, int x2, int y2, String pic_name, String delta_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找相似图片
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindPicSim(int x1, int y1, int x2, int y2, String pic_name, String delta_color, int sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找相似图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicSimE(int x1, int y1, int x2, int y2, String pic_name, String delta_color, int sim, int dir);

    /**
     * 查找相似图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_name 图片名称
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicSimEx(int x1, int y1, int x2, int y2, String pic_name, String delta_color, int sim, int dir);

    /**
     * 查找内存中的相似图片
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindPicSimMem(int x1, int y1, int x2, int y2, String pic_info, String delta_color, int sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找内存中的相似图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicSimMemE(int x1, int y1, int x2, int y2, String pic_info, String delta_color, int sim, int dir);

    /**
     * 查找内存中的相似图片（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param pic_info 图片信息
     * @param delta_color 颜色偏移
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindPicSimMemEx(int x1, int y1, int x2, int y2, String pic_info, String delta_color, int sim, int dir);

    /**
     * 查找形状
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param offset_color 偏移颜色
     * @param sim 相似度
     * @param dir 方向
     * @param intX x坐标结果
     * @param intY y坐标结果
     * @return 查找结果
     */
    @ComMethod
    long FindShape(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 查找形状（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param offset_color 偏移颜色
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindShapeE(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir);

    /**
     * 查找形状（扩展）
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param offset_color 偏移颜色
     * @param sim 相似度
     * @param dir 方向
     * @return 查找结果
     */
    @ComMethod
    String FindShapeEx(int x1, int y1, int x2, int y2, String offset_color, double sim, int dir);

    /**
     * 释放图片
     * @param pic_name 图片名称
     * @return 释放结果
     */
    @ComMethod
    long FreePic(String pic_name);

    /**
     * 获取指定区域的平均HSV值
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @return 平均HSV值
     */
    @ComMethod
    String GetAveHSV(int x1, int y1, int x2, int y2);

    /**
     * 获取指定区域的平均RGB值
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @return 平均RGB值
     */
    @ComMethod
    String GetAveRGB(int x1, int y1, int x2, int y2);

    /**
     * 获取指定点的颜色
     * @param x x坐标
     * @param y y坐标
     * @return 颜色字符串
     */
    @ComMethod
    String GetColor(int x, int y);

    /**
     * 获取指定点的BGR颜色
     * @param x x坐标
     * @param y y坐标
     * @return BGR颜色字符串
     */
    @ComMethod
    String GetColorBGR(int x, int y);

    /**
     * 获取指定点的HSV颜色
     * @param x x坐标
     * @param y y坐标
     * @return HSV颜色字符串
     */
    @ComMethod
    String GetColorHSV(int x, int y);

    /**
     * 获取指定区域的颜色数量
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param color 颜色字符串
     * @param sim 相似度
     * @return 颜色数量
     */
    @ComMethod
    long GetColorNum(int x1, int y1, int x2, int y2, String color, double sim);

    /**
     * 获取图片大小
     * @param pic_name 图片名称
     * @return 图片大小
     */
    @ComMethod
    String GetPicSize(String pic_name);

    /**
     * 获取屏幕数据
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @return 屏幕数据
     */
    @ComMethod
    long GetScreenData(int x1, int y1, int x2, int y2);

    /**
     * 获取屏幕数据为BMP格式
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param data 数据结果
     * @param size 数据大小
     * @return 获取结果
     */
    @ComMethod
    long GetScreenDataBmp(int x1, int y1, int x2, int y2, Variant.VARIANT data, Variant.VARIANT size);

    /**
     * 将图片转换为BMP格式
     * @param pic_name 图片名称
     * @param bmp_name BMP文件路径
     * @return 转换结果
     */
    @ComMethod
    long ImageToBmp(String pic_name, String bmp_name);

    /**
     * 判断显示是否死机
     * @param x1 区域左上角x坐标
     * @param y1 区域左上角y坐标
     * @param x2 区域右下角x坐标
     * @param y2 区域右下角y坐标
     * @param t 时间
     * @return 判断结果
     */
    @ComMethod
    long IsDisplayDead(int x1, int y1, int x2, int y2, int t);

    /**
     * 加载图片
     * @param pic_name 图片名称
     * @return 加载结果
     */
    @ComMethod
    long LoadPic(String pic_name);

    /**
     * 从内存加载图片
     * @param addr 地址
     * @param size 大小
     * @param pic_name 图片名称
     * @return 加载结果
     */
    @ComMethod
    long LoadPicByte(int addr, int size, String pic_name);

    /**
     * 匹配图片名称
     * @param pic_name 图片名称
     * @return 匹配结果
     */
    @ComMethod
    String MatchPicName(String pic_name);

    /**
     * 将RGB颜色转换为BGR颜色
     * @param rgb_color RGB颜色字符串
     * @return BGR颜色字符串
     */
    @ComMethod
    String RGB2BGR(String rgb_color);

    /**
     * 设置排除区域
     * @param mode 模式
     * @param info 信息
     * @return 设置结果
     */
    @ComMethod
    long SetExcludeRegion(int mode, String info);

    /**
     * 设置查找图片的多线程数量
     * @param count 数量
     * @return 设置结果
     */
    @ComMethod
    long SetFindPicMultithreadCount(int count);

    /**
     * 设置查找图片的多线程限制
     * @param limit 限制
     * @return 设置结果
     */
    @ComMethod
    long SetFindPicMultithreadLimit(int limit);

    /**
     * 设置图片密码
     * @param pwd 密码
     * @return 设置结果
     */
    @ComMethod
    long SetPicPwd(String pwd);

}