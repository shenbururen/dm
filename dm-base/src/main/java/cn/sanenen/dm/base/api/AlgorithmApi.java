package cn.sanenen.dm.base.api;


import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 算法
 *
 * @author sun
 **/
public interface AlgorithmApi {


    /**
     * 根据部分Ex接口的返回值，排除指定范围区域内的坐标.
     *
     * @param all_pos 字符串: 坐标描述串。 一般是
     *                FindStrEx,FindStrFastEx,FindStrWithFontEx, FindColorEx, FindMultiColorEx,
     *                和FindPicEx的返回值.
     * @param type 整形数: 取值为0或者1
     *             如果all_pos的内容是由
     *             FindPicEx,FindStrEx,FindStrFastEx,FindStrWithFontEx返回，那么取值为0
     *             如果all_pos的内容是由FindColorEx,
     *             FindMultiColorEx,FindColorBlockEx,FindShapeEx返回，那么取值为1
     *             如果all_pos的内容是由OcrEx返回，那么取值为2
     *             如果all_pos的内容是由FindPicExS,FindStrExS,FindStrFastExS返回，那么取值为3
     * @param x1 整形数: 左上角横坐标
     * @param y1 整形数: 左上角纵坐标
     * @param x2 整形数: 右下角横坐标
     * @param y2 整形数: 右下角纵坐标
     * @return 字符串: 经过筛选以后的返回值，格式和type指定的一致.
     */
    @ComMethod
    String ExcludePos(String all_pos, int type, int x1, int y1, int x2, int y2);

    /**
     * 根据部分Ex接口的返回值，然后在所有坐标里找出距离指定坐标最近的那个坐标.
     *
     * @param all_pos 字符串: 坐标描述串。 一般是
     *                FindStrEx,FindStrFastEx,FindStrWithFontEx, FindColorEx, FindMultiColorEx,
     *                和FindPicEx的返回值.
     * @param type 整形数: 取值为0或者1
     *             如果all_pos的内容是由
     *             FindPicEx,FindStrEx,FindStrFastEx,FindStrWithFontEx返回，那么取值为0
     *             如果all_pos的内容是由FindColorEx, FindMultiColorEx,FindColorBlockEx
     *             返回，那么取值为1
     *             如果all_pos的内容是由OcrEx返回，那么取值为2
     *             如果all_pos的内容是由FindPicExS,FindStrExS,FindStrFastExS返回，那么取值为3
     * @param x 整形数: 横坐标
     * @param y 整形数: 纵坐标
     * @return 字符串: 返回的格式和type有关，如果type为0，那么返回的格式是"id,x,y"
     *             如果type为1,那么返回的格式是"x,y".
     */
    @ComMethod
    String FindNearestPos(String all_pos, int type, int x, int y);

    /**
     * 根据部分Ex接口的返回值，然后对所有坐标根据对指定坐标的距离(或者指定X或者
     * Y)进行从小到大的排序.
     *
     * @param all_pos 字符串: 坐标描述串。 一般是
     *                FindStrEx,FindStrFastEx,FindStrWithFontEx, FindColorEx, FindMultiColorEx,
     *                和FindPicEx的返回值.
     * @param type 整形数: 取值为0或者1
     *             如果all_pos的内容是由
     *             FindPicEx,FindStrEx,FindStrFastEx,FindStrWithFontEx返回，那么取值为0
     *             如果all_pos的内容是由FindColorEx, FindMultiColorEx,FindColorBlockEx
     *             返回，那么取值为1
     *             如果all_pos的内容是由OcrEx返回，那么取值为2
     *             如果all_pos的内容是由FindPicExS,FindStrExS,FindStrFastExS返回，那么取值为3
     * @param x 整形数: 横坐标
     * @param y 整形数: 纵坐标
     *          注意:如果x为65535并且y为0时，那么排序的结果是仅仅对x坐标进行排序,如果y为65535并且x为0时，那么排序的结果是仅仅对y坐标进行排序.
     * @return 字符串: 返回的格式和type指定的格式一致.
     */
    @ComMethod
    String SortPosDistance(String all_pos, int type, int x, int y);

}
