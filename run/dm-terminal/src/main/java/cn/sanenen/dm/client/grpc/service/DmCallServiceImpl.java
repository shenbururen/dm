package cn.sanenen.dm.client.grpc.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.client.common.DmApiMap;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.grpc.common.MessageUtil;
import cn.sanenen.dm.grpc.pkg.control.ControlServerPg;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.ptr.IntByReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sun
 **/
public class DmCallServiceImpl {
    private static final Log log = Log.get();

    public ControlServerPg.DmCallResponse call(ControlServerPg.DmCallRequest request) {
        String methodName = request.getMethodName();
        log.info(MessageUtil.printJson(request));
        DmApi dmApi = DmApiMap.getDmApi(request.getDmInstanceId(), this::initDmApi);
        Object[] params = new Object[request.getParamsCount()];
        Map<String, Variant.VARIANT> map = new HashMap<>();
        if (request.getParamsCount() > 0) {
            List<ControlServerPg.KeyValuePair> paramsList = request.getParamsList();
            for (int i = 0; i < paramsList.size(); i++) {
                ControlServerPg.KeyValuePair keyValuePair = paramsList.get(i);
                if (ClassUtil.getClassName(Variant.VARIANT.class, false).equals(keyValuePair.getKey())) {
                    Variant.VARIANT param = new Variant.VARIANT(new IntByReference());
                    params[i] = param;
                    map.put(String.valueOf(i), param);
                } else {
                    params[i] = Convert.convertByClassName(keyValuePair.getKey(), keyValuePair.getValue());
                }
            }
        }

        Object result = ReflectUtil.invoke(dmApi, methodName, params);
        ControlServerPg.DmCallResponse.Builder resultBuilder = ControlServerPg.DmCallResponse.newBuilder()
                .addResults(ControlServerPg.KeyValuePair.newBuilder().setKey("result").setValue(result.toString()).build());
        for (Map.Entry<String, Variant.VARIANT> entry : map.entrySet()) {
            resultBuilder.addResults(ControlServerPg.KeyValuePair.newBuilder()
                    .setKey(entry.getKey()).setValue(String.valueOf(entry.getValue().getValue())).build());
            entry.getValue().clear();
        }
        log.info(MessageUtil.printJson(resultBuilder));
        return resultBuilder.build(); 
    }

    private void initDmApi(DmApi dmApi) {
        //设置资源路径
        dmApi.SetPath(FileUtil.getAbsolutePath(Constant.DM_FILES));
    }
}
