package cn.sanenen.dm.server.grpc.client;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ClassUtil;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.grpc.pkg.client.dm.DmCallPg;
import cn.sanenen.dm.grpc.pkg.client.dm.DmCallServiceGrpc;
import com.sun.jna.platform.win32.Variant;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成 DM 接口代理，grpc动态调用大漠api方法
 *
 * @author sun
 **/
public interface DmApiClientFactory {

    /**
     * 在后续执行方法时，会在grpc服务端创建一个对应的大漠对象。
     *
     * @return DM 接口代理与服务端大漠对象一一对应。
     */
    static DmApi newDmApi(final DmCallServiceGrpc.DmCallServiceBlockingStub dmStub, final String dmInstanceId) {
        return ProxyUtil.newProxyInstance((proxy, method, args) -> {
            String methodName = method.getName();
            List<DmCallPg.KeyValuePair> params = new ArrayList<>();
            if (args != null) {
                // 收集参数
                for (Object arg : args) {
                    String key = ClassUtil.getClassName(arg.getClass(), false);
                    String value;
                    if (ClassUtil.getClassName(Variant.VARIANT.class, false).equals(key)) {
                        value = "";
                    } else {
                        value = arg.toString();
                    }
                    params.add(DmCallPg.KeyValuePair.newBuilder()
                            .setKey(key)
                            .setValue(value)
                            .build());
                }
            }
            // 构建 gRPC 请求
            DmCallPg.DmCallRequest request = DmCallPg.DmCallRequest.newBuilder()
                    .setDmInstanceId(dmInstanceId)
                    .setMethodName(methodName)
                    .addAllParams(params)
                    .build();

            // 调用 gRPC 通用方法
            DmCallPg.DmCallResponse response = dmStub.call(request);
            List<DmCallPg.KeyValuePair> resultsList = response.getResultsList();
            for (int i = 1; i < resultsList.size(); i++) {
                DmCallPg.KeyValuePair keyValuePair = resultsList.get(i);
                Integer anInt = Convert.toInt(keyValuePair.getKey());
                assert args != null;
                Variant.VARIANT arg = (Variant.VARIANT) args[anInt];
                arg.setValue(Variant.VT_INT, Convert.toInt(keyValuePair.getValue()));
            }
            return Convert.convert(method.getReturnType(), resultsList.getFirst().getValue());
        }, DmApi.class);
    }

}
