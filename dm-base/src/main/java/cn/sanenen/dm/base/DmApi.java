package cn.sanenen.dm.base;

import cn.sanenen.dm.base.api.*;
import cn.sanenen.dm.common.Constant;
import com.sun.jna.platform.win32.COM.util.IUnknown;
import com.sun.jna.platform.win32.COM.util.annotation.ComObject;

/**
 * @author sun
 **/
@ComObject(progId = Constant.DM_PROGID)
public interface DmApi extends AiApi, AlgorithmApi, AnswerApi, AssemblyApi, BackstageApi, BaseApi,
        FileApi, FoobarApi, KeyMouseApi, MemoryApi, OcrApi, OtherApi,
        PicColorApi, ProtectApi, SystemApi, WindowsApi, IUnknown {
    
}
