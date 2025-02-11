package cn.sanenen.dm.base.api;

import com.sun.jna.platform.win32.COM.util.annotation.ComMethod;

/**
 * 文件
 * @author sun
 **/
public interface FileApi {

    /**
     * 拷贝文件
     * @param src_file 原始文件名
     * @param dst_file 目标文件名
     * @param over 如果dst_file文件存在则覆盖标志
     * @return 拷贝结果
     */
    @ComMethod
    long CopyFile(String src_file, String dst_file, int over);

    /**
     * 创建指定目录
     * @param folder 目录名
     * @return 创建结果
     */
    @ComMethod
    long CreateFolder(String folder);

    /**
     * 解密指定的文件
     * @param file 文件名
     * @param pwd 密码
     * @return 解密结果
     */
    @ComMethod
    long DecodeFile(String file, String pwd);

    /**
     * 删除文件
     * @param file 文件名
     * @return 删除结果
     */
    @ComMethod
    long DeleteFile(String file);

    /**
     * 删除指定目录
     * @param folder 目录名
     * @return 删除结果
     */
    @ComMethod
    long DeleteFolder(String folder);

    /**
     * 删除指定的ini小节
     * @param section 小节名
     * @param key 变量名
     * @param file ini文件名
     * @return 删除结果
     */
    @ComMethod
    long DeleteIni(String section, String key, String file);

    /**
     * 删除指定的ini小节.支持加密文件
     * @param section 小节名
     * @param key 变量名
     * @param file ini文件名
     * @param pwd 密码
     * @return 删除结果
     */
    @ComMethod
    long DeleteIniPwd(String section, String key, String file, String pwd);

    /**
     * 从internet上下载一个文件
     * @param url 下载的url地址
     * @param save_file 要保存的文件名
     * @param timeout 连接超时时间，单位是毫秒
     * @return 下载结果
     */
    @ComMethod
    long DownloadFile(String url, String save_file, int timeout);

    /**
     * 加密指定的文件
     * @param file 文件名
     * @param pwd 密码
     * @return 加密结果
     */
    @ComMethod
    long EncodeFile(String file, String pwd);

    /**
     * 根据指定的ini文件以及section,枚举此section中所有的key名
     * @param section 小节名
     * @param file ini文件名
     * @return 枚举结果
     */
    @ComMethod
    String EnumIniKey(String section, String file);

    /**
     * 根据指定的ini文件以及section,枚举此section中所有的key名.可支持加密文件
     * @param section 小节名
     * @param file ini文件名
     * @param pwd 密码
     * @return 枚举结果
     */
    @ComMethod
    String EnumIniKeyPwd(String section, String file, String pwd);

    /**
     * 根据指定的ini文件,枚举此ini中所有的Section(小节名)
     * @param file ini文件名
     * @return 枚举结果
     */
    @ComMethod
    String EnumIniSection(String file);

    /**
     * 根据指定的ini文件,枚举此ini中所有的Section(小节名) 可支持加密文件
     * @param file ini文件名
     * @param pwd 密码
     * @return 枚举结果
     */
    @ComMethod
    String EnumIniSectionPwd(String file, String pwd);

    /**
     * 获取指定的文件长度
     * @param file 文件名
     * @return 文件长度(字节数)
     */
    @ComMethod
    long GetFileLength(String file);

    /**
     * 获取指定文件或目录的真实路径
     * @param path 路径名
     * @return 真实路径
     */
    @ComMethod
    String GetRealPath(String path);

    /**
     * 判断指定文件是否存在
     * @param file 文件名
     * @return 判断结果
     */
    @ComMethod
    long IsFileExist(String file);

    /**
     * 判断指定目录是否存在
     * @param folder 目录名
     * @return 判断结果
     */
    @ComMethod
    long IsFolderExist(String folder);

    /**
     * 移动文件
     * @param src_file 原始文件名
     * @param dst_file 目标文件名
     * @return 移动结果
     */
    @ComMethod
    long MoveFile(String src_file, String dst_file);

    /**
     * 从指定的文件读取内容
     * @param file 文件名
     * @return 读取内容
     */
    @ComMethod
    String ReadFile(String file);

    /**
     * 从Ini中读取指定信息
     * @param section 小节名
     * @param key 变量名
     * @param file ini文件名
     * @return 读取结果
     */
    @ComMethod
    String ReadIni(String section, String key, String file);

    /**
     * 从Ini中读取指定信息.可支持加密文件
     * @param section 小节名
     * @param key 变量名
     * @param file ini文件名
     * @param pwd 密码
     * @return 读取结果
     */
    @ComMethod
    String ReadIniPwd(String section, String key, String file, String pwd);

    /**
     * 弹出选择文件夹对话框，并返回选择的文件夹
     * @return 选择的文件夹全路径
     */
    @ComMethod
    String SelectDirectory();

    /**
     * 弹出选择文件对话框，并返回选择的文件
     * @return 选择的文件全路径
     */
    @ComMethod
    String SelectFile();

    /**
     * 向指定文件追加字符串
     * @param file 文件名
     * @param content 写入的字符串
     * @return 写入结果
     */
    @ComMethod
    long WriteFile(String file, String content);

    /**
     * 向指定的Ini写入信息
     * @param section 小节名
     * @param key 变量名
     * @param value 变量内容
     * @param file ini文件名
     * @return 写入结果
     */
    @ComMethod
    long WriteIni(String section, String key, String value, String file);

    /**
     * 向指定的Ini写入信息.支持加密文件
     * @param section 小节名
     * @param key 变量名
     * @param value 变量内容
     * @param file ini文件名
     * @param pwd 密码
     * @return 写入结果
     */
    @ComMethod
    long WriteIniPwd(String section, String key, String value, String file, String pwd);

}
