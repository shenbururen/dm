package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;
import com.sun.jna.platform.win32.Variant;

/**
 * 文字识别
 *
 * @author sun
 **/
public interface OcrApi {

    /**
     * 给指定的字库中添加一条字库信息.
     *
     * @param index     字库的序号,取值为0-99,目前最多支持100个字库
     * @param dict_info 字库描述串，具体参考大漠综合工具中的字符定义
     * @return 0:失败 1:成功
     */
    @ComMethod
    long AddDict(int index, String dict_info);

    /**
     * 清空指定的字库.
     *
     * @param index 字库的序号,取值为0-99,目前最多支持100个字库
     * @return 0:失败 1:成功
     */
    @ComMethod
    long ClearDict(int index);

    /**
     * 允许当前调用的对象使用全局字库.
     *
     * @param enable 0 关闭 1 打开
     * @return 0 : 失败 1 : 成功
     */
    @ComMethod
    long EnableShareDict(int enable);

    /**
     * 根据指定的范围,以及指定的颜色描述，提取点阵信息.
     *
     * @param x1    左上角X坐标
     * @param y1    左上角Y坐标
     * @param x2    右下角X坐标
     * @param y2    右下角Y坐标
     * @param color 颜色格式串
     * @param word  待定义的文字
     * @return 识别到的点阵信息，可用于AddDict
     */
    @ComMethod
    String FetchWord(int x1, int y1, int x2, int y2, String color, String word);

    /**
     * 在屏幕范围(x1,y1,x2,y2)内,查找string(可以是任意个字符串的组合),并返回符合color_format的坐标位置.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param intX         返回X坐标
     * @param intY         返回Y坐标
     * @return 返回字符串的索引 没找到返回-1
     */
    @ComMethod
    long FindStr(int x1, int y1, int x2, int y2, String string, String color_format, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 在屏幕范围(x1,y1,x2,y2)内,查找string(可以是任意个字符串的组合),并返回符合color_format的坐标位置.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回字符串序号以及X和Y坐标
     */
    @ComMethod
    String FindStrE(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 在屏幕范围(x1,y1,x2,y2)内,查找string(可以是任意个字符串的组合),并返回符合color_format的所有坐标位置.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回所有找到的坐标集合
     */
    @ComMethod
    String FindStrEx(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 在屏幕范围(x1,y1,x2,y2)内,查找string(可以是任意个字符串的组合),并返回符合color_format的所有坐标位置.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回所有找到的坐标集合
     */
    @ComMethod
    String FindStrExS(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 同FindStr。
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param intX         返回X坐标
     * @param intY         返回Y坐标
     * @return 返回字符串的索引 没找到返回-1
     */
    @ComMethod
    long FindStrFast(int x1, int y1, int x2, int y2, String string, String color_format, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 同FindStrE
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回字符串序号以及X和Y坐标
     */
    @ComMethod
    String FindStrFastE(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 同FindStrEx
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回所有找到的坐标集合
     */
    @ComMethod
    String FindStrFastEx(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 同FindStrExS.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回所有找到的坐标集合
     */
    @ComMethod
    String FindStrFastExS(int x1, int y1, int x2, int y2, String string, String color_format, double sim);

    /**
     * 同FindStrS.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param intX         返回X坐标
     * @param intY         返回Y坐标
     * @return 返回找到的字符串
     */
    @ComMethod
    String FindStrFastS(int x1, int y1, int x2, int y2, String string, String color_format, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 在屏幕范围(x1,y1,x2,y2)内,查找string(可以是任意个字符串的组合),并返回符合color_format的坐标位置.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param intX         返回X坐标
     * @param intY         返回Y坐标
     * @return 返回找到的字符串
     */
    @ComMethod
    String FindStrS(int x1, int y1, int x2, int y2, String string, String color_format, double sim, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 同FindStr，但是不使用SetDict设置的字库，而利用系统自带的字库.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param font_name    系统字体名
     * @param font_size    系统字体尺寸
     * @param flag         字体类别
     * @param intX         返回X坐标
     * @param intY         返回Y坐标
     * @return 返回字符串的索引 没找到返回-1
     */
    @ComMethod
    long FindStrWithFont(int x1, int y1, int x2, int y2, String string, String color_format, double sim, String font_name, int font_size, int flag, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 同FindStrE，但是不使用SetDict设置的字库，而利用系统自带的字库.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param font_name    系统字体名
     * @param font_size    系统字体尺寸
     * @param flag         字体类别
     * @return 返回字符串序号以及X和Y坐标
     */
    @ComMethod
    String FindStrWithFontE(int x1, int y1, int x2, int y2, String string, String color_format, double sim, String font_name, int font_size, int flag);

    /**
     * 同FindStrEx，但是不使用SetDict设置的字库，而利用系统自带的字库.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param string       待查找的字符串
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @param font_name    系统字体名
     * @param font_size    系统字体尺寸
     * @param flag         字体类别
     * @return 返回所有找到的坐标集合
     */
    @ComMethod
    String FindStrWithFontEx(int x1, int y1, int x2, int y2, String string, String color_format, double sim, String font_name, int font_size, int flag);

    /**
     * 获取指定字库中指定条目的字库信息.
     *
     * @param index      字库序号(0-99)
     * @param font_index 字库条目序号
     * @return 返回字库条目信息
     */
    @ComMethod
    String GetDict(int index, int font_index);

    /**
     * 获取指定的字库中的字符数量.
     *
     * @param index 字库序号(0-99)
     * @return 字库数量
     */
    @ComMethod
    long GetDictCount(int index);

    /**
     * 根据指定的文字，以及指定的系统字库信息，获取字库描述信息.
     *
     * @param str       需要获取的字符串
     * @param font_name 系统字体名
     * @param font_size 系统字体尺寸
     * @param flag      字体类别
     * @return 返回字库信息
     */
    @ComMethod
    String GetDictInfo(String str, String font_name, int font_size, int flag);

    /**
     * 获取当前使用的字库序号(0-99)
     *
     * @return 字库序号(0 - 99)
     */
    @ComMethod
    long GetNowDict();

    /**
     * 对插件部分接口的返回值进行解析,并返回ret中的坐标个数
     *
     * @param ret 部分接口的返回串
     * @return 返回ret中的坐标个数
     */
    @ComMethod
    long GetResultCount(String ret);

    /**
     * 对插件部分接口的返回值进行解析,并根据指定的第index个坐标,返回具体的值
     *
     * @param ret   部分接口的返回串
     * @param index 第几个坐标
     * @param intX  返回X坐标
     * @param intY  返回Y坐标
     * @return 0:失败 1:成功
     */
    @ComMethod
    long GetResultPos(String ret, int index, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 在使用GetWords进行词组识别以后,可以用此接口进行识别词组数量的计算.
     *
     * @param str GetWords接口调用以后的返回值
     * @return 返回词组数量
     */
    @ComMethod
    long GetWordResultCount(String str);

    /**
     * 在使用GetWords进行词组识别以后,可以用此接口进行识别各个词组的坐标
     *
     * @param str   GetWords的返回值
     * @param index 表示第几个词组
     * @param intX  返回的X坐标
     * @param intY  返回的Y坐标
     * @return 0: 失败 1: 成功
     */
    @ComMethod
    long GetWordResultPos(String str, int index, Variant.VARIANT intX, Variant.VARIANT intY);

    /**
     * 在使用GetWords进行词组识别以后,可以用此接口进行识别各个词组的内容
     *
     * @param str   GetWords的返回值
     * @param index 表示第几个词组
     * @return 返回的第index个词组内容
     */
    @ComMethod
    String GetWordResultStr(String str, int index);

    /**
     * 根据指定的范围,以及设定好的词组识别参数(一般不用更改,除非你真的理解了)
     * 识别这个范围内所有满足条件的词组. 比较适合用在未知文字的情况下,进行不定识别.
     *
     * @param x1    左上角X坐标
     * @param y1    左上角Y坐标
     * @param x2    右下角X坐标
     * @param y2    右下角Y坐标
     * @param color 颜色格式串
     * @param sim   相似度
     * @return 识别到的格式串
     */
    @ComMethod
    String GetWords(int x1, int y1, int x2, int y2, String color, double sim);

    /**
     * 根据指定的范围,以及设定好的词组识别参数(一般不用更改,除非你真的理解了)
     * 识别这个范围内所有满足条件的词组. 这个识别函数不会用到字库。只是识别大概形状的位置
     *
     * @param x1    左上角X坐标
     * @param y1    左上角Y坐标
     * @param x2    右下角X坐标
     * @param y2    右下角Y坐标
     * @param color 颜色格式串
     * @return 识别到的格式串
     */
    @ComMethod
    String GetWordsNoDict(int x1, int y1, int x2, int y2, String color);

    /**
     * 识别屏幕范围(x1,y1,x2,y2)内符合color_format的字符串,并且相似度为sim,sim
     * 取值范围(0.1-1.0),
     * 这个值越大越精确,越大速度越快,越小速度越慢,请斟酌使用!
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回识别到的字符串
     */
    @ComMethod
    String Ocr(int x1, int y1, int x2, int y2, String color_format, double sim);

    /**
     * 识别屏幕范围(x1,y1,x2,y2)内符合color_format的字符串,并且相似度为sim,sim
     * 取值范围(0.1-1.0),
     * 这个值越大越精确,越大速度越快,越小速度越慢,请斟酌使用!
     * 这个函数可以返回识别到的字符串，以及每个字符的坐标.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回识别到的字符串 格式如 "字符0$x0$y0|…|字符n$xn$yn"
     */
    @ComMethod
    String OcrEx(int x1, int y1, int x2, int y2, String color_format, double sim);

    /**
     * 识别屏幕范围(x1,y1,x2,y2)内符合color_format的字符串,并且相似度为sim,sim
     * 取值范围(0.1-1.0),
     * 这个值越大越精确,越大速度越快,越小速度越慢,请斟酌使用!
     * 这个函数可以返回识别到的字符串，以及每个字符的坐标.这个同OcrEx,另一种返回形式.
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回识别到的字符串 格式如 "识别到的信息|x0,y0|…|xn,yn"
     */
    @ComMethod
    String OcrExOne(int x1, int y1, int x2, int y2, String color_format, double sim);

    /**
     * 识别位图中区域(x1,y1,x2,y2)的文字
     *
     * @param x1           区域的左上X坐标
     * @param y1           区域的左上Y坐标
     * @param x2           区域的右下X坐标
     * @param y2           区域的右下Y坐标
     * @param pic_name     图片文件名
     * @param color_format 颜色格式串
     * @param sim          相似度
     * @return 返回识别到的字符串
     */
    @ComMethod
    String OcrInFile(int x1, int y1, int x2, int y2, String pic_name, String color_format, double sim);

    /**
     * 保存指定的字库到指定的文件中.
     *
     * @param index 字库索引序号 取值为0-99对应100个字库
     * @param file  文件名
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SaveDict(int index, String file);

    /**
     * 高级用户使用,在不使用字库进行词组识别前,可设定文字的列距,默认列距是1
     *
     * @param col_gap 文字列距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetColGapNoDict(int col_gap);

    /**
     * 设置字库文件
     *
     * @param index 字库的序号,取值为0-99,目前最多支持100个字库
     * @param file  字库文件名
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetDict(int index, String file);

    /**
     * 从内存中设置字库.
     *
     * @param index 字库的序号,取值为0-99,目前最多支持100个字库
     * @param addr  数据地址
     * @param size  字库长度
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetDictMem(int index, int addr, int size);

    /**
     * 设置字库的密码,在SetDict前调用,目前的设计是,所有字库通用一个密码.
     *
     * @param pwd 字库密码
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetDictPwd(String pwd);

    /**
     * 高级用户使用,在使用文字识别功能前，设定是否开启精准识别.
     *
     * @param exact_ocr 0 表示关闭精准识别 1 开启精准识别
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetExactOcr(int exact_ocr);

    /**
     * 高级用户使用,在识别前,如果待识别区域有多行文字,可以设定列间距,默认的列间距是0,
     * 如果根据情况设定,可以提高识别精度。一般不用设定。
     *
     * @param min_col_gap 最小列间距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetMinColGap(int min_col_gap);

    /**
     * 高级用户使用,在识别前,如果待识别区域有多行文字,可以设定行间距,默认的行间距是1,
     * 如果根据情况设定,可以提高识别精度。一般不用设定。
     *
     * @param min_row_gap 最小行间距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetMinRowGap(int min_row_gap);

    /**
     * 高级用户使用,在不使用字库进行词组识别前,可设定文字的行距,默认行距是1
     *
     * @param row_gap 文字行距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetRowGapNoDict(int row_gap);

    /**
     * 高级用户使用,在识别词组前,可设定词组间的间隔,默认的词组间隔是5
     *
     * @param word_gap 单词间距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetWordGap(int word_gap);

    /**
     * 高级用户使用,在不使用字库进行词组识别前,可设定词组间的间隔,默认的词组间隔是5
     *
     * @param word_gap 单词间距
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetWordGapNoDict(int word_gap);

    /**
     * 高级用户使用,在识别词组前,可设定文字的平均行高,默认的词组行高是10
     *
     * @param line_height 行高
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetWordLineHeight(int line_height);

    /**
     * 高级用户使用,在不使用字库进行词组识别前,可设定文字的平均行高,默认的词组行高是10
     *
     * @param line_height 行高
     * @return 0:失败 1:成功
     */
    @ComMethod
    long SetWordLineHeightNoDict(int line_height);

    /**
     * 表示使用哪个字库文件进行识别(index范围:0-99)
     * 设置之后，永久生效，除非再次设定
     *
     * @param index 字库编号(0-99)
     * @return 0:失败 1:成功
     */
    @ComMethod
    long UseDict(int index);
}