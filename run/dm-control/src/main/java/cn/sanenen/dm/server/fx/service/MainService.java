package cn.sanenen.dm.server.fx.service;

import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.base.DmApi;
import cn.sanenen.dm.grpc.GrpcClient;
import cn.sanenen.dm.server.fx.controller.MainController;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import cn.sanenen.dm.server.grpc.client.DmApiClientFactory;

/**
 * @author sun
 **/
public class MainService {

    public void registerDmTerminal(String ip, int port) {
        MainController mainController = Singleton.get(MainController.class);
        GrpcClient grpcClient = new GrpcClient(ip, port);
        DmApi dmApi = DmApiClientFactory.newDmApi(grpcClient.getChannel());
        String ver = dmApi.Ver();
        TableData sqlTableData = new TableData();
        sqlTableData.setIp(ip);
        sqlTableData.setPort(port);
        sqlTableData.setVersion(ver);
        mainController.addDmTerminal(sqlTableData);
    }
}
