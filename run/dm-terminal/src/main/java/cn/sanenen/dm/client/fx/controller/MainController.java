package cn.sanenen.dm.client.fx.controller;

import cn.hutool.log.Log;
import cn.sanenen.dm.client.common.DmSetting;
import cn.sanenen.dm.client.grpc.ServerStart;
import cn.sanenen.dm.client.grpc.client.ServerClient;
import cn.sanenen.dm.grpc.GrpcClient;
import io.grpc.ManagedChannel;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sun
 **/
public class MainController implements Initializable {
    private static final Log log = Log.get();

    public TextField serverIp;
    public TextArea logTextArea;
    public TextField serverPort;
    public TextField registerPort;

    private static final ServerStart serverStart = new ServerStart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            int port = serverStart.start();
            registerPort.setText(String.valueOf(port));
            
            String controlHost = DmSetting.getControlHost();
            int controlPort = DmSetting.getControlPort();
            GrpcClient controlClient = new GrpcClient(controlHost, controlPort);
            serverIp.setText(controlHost);
            serverPort.setText(String.valueOf(controlPort));
            ManagedChannel channel = controlClient.getChannel();
            ServerClient serverClient = new ServerClient(channel);
            String string = serverClient.registerDmClient(port);
            Platform.runLater(() -> {
                logTextArea.appendText("连接成功，注册服务成功。111" );
            });
            controlClient.setConnectSuccessHandler(() -> {
                String ip = serverClient.registerDmClient(port);
                Platform.runLater(() -> {
                    logTextArea.appendText("连接成功，注册服务成功。" + ip);
                });
            });
            controlClient.setConnectFailHandler(() -> {
                Platform.runLater(() -> {
                    logTextArea.appendText("连接失败。");
                });
                
            });
        } catch (Exception e) {
            log.error(e);
        }
    }
}
