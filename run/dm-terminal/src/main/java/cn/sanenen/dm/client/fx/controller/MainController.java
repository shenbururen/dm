package cn.sanenen.dm.client.fx.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.client.Main;
import cn.sanenen.dm.client.common.DmSetting;
import cn.sanenen.dm.client.grpc.ServerStart;
import cn.sanenen.dm.client.grpc.client.ControlClient;
import cn.sanenen.dm.common.fx.FxSub;
import cn.sanenen.dm.grpc.GrpcChannel;
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
    public TextField registerIp;
    public TextField registerPort;

    private static final ServerStart serverStart = new ServerStart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxSub.maxLength(logTextArea, 3000);
        try {
            Platform.runLater(() -> {
                try {
                    appendLog("启动中...");
                    int port = serverStart.start();
                    registerPort.setText(String.valueOf(port));
                    appendLog("终端服务启动完成，端口号{}", port);

                    String controlHost = DmSetting.getControlHost();
                    int controlPort = DmSetting.getControlPort();
                    appendLog("终端服务注册中...中控{}:{}", controlHost, port);
                    GrpcChannel controlChannel = new GrpcChannel(controlHost, controlPort);
                    serverIp.setText(controlHost);
                    serverPort.setText(String.valueOf(controlPort));
                    ManagedChannel channel = controlChannel.getChannel();
                    ControlClient controlClient = new ControlClient(channel);
                    controlChannel.startHeartbeat();
                    controlChannel.setConnectSuccessHandler(() -> {
                        String ip = controlClient.registerDmClient(port);
                        registerIp.setText(ip);
                        appendLog("终端服务注册成功。终端注册ip:{}", ip);
                    });
                    controlChannel.setConnectFailHandler(() -> {
                        Platform.runLater(() -> {
                            appendLog("终端服务注册失败。重新注册中。");
                        });
                    });
                } catch (Exception e) {
                    log.error(e);
                    appendLog("启动异常：{}", e.getMessage());
                }
            });
        } catch (Exception e) {
            log.error(e);
        }
    }

    private void appendLog(CharSequence template, Object... params) {
        Platform.runLater(() -> {
            String log = StrUtil.format(DateUtil.now() + StrUtil.SPACE + template + StrUtil.LF, params);
            logTextArea.appendText(log);
        });
    }

    public void test() {
        try {
            appendLog("当前可执行文件路径：{}", System.getProperty("jpackage.app-path"));
            Main.restart();
        } catch (Exception e) {
        }
    }
}
