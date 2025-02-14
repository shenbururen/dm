package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.StrUtil;
import cn.sanenen.dm.common.TerminalStatus;
import cn.sanenen.dm.common.fx.FxSub;
import cn.sanenen.dm.server.common.TerminalCache;
import cn.sanenen.dm.server.common.TerminalContext;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import cn.sanenen.dm.server.fx.service.TerminalService;
import cn.sanenen.dm.server.game.GameStart;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import lombok.Data;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author sun
 **/
@Data
public class TerminalOperateController implements Initializable {

    public Label ip_label;
    public TextArea log_textArea;

    private TableData tableData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FxSub.maxLength(log_textArea, 1000);
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
        if (this.tableData != null && !this.tableData.getIp().equals(tableData.getIp())) {
            log_textArea.setText("");
        }
        ip_label.textProperty().bind(tableData.ipProperty());
    }

    @FXML
    public void delFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.delFiles(tableData.getIp());
            appendLog("delFiles");
        });
    }

    @FXML
    public void uploadFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.uploadFiles(tableData.getIp());
        });
    }

    @FXML
    public void getHasFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            List<String> hasFiles = terminalService.getHasFiles(tableData.getIp());
            appendLog("getHasFiles {}", String.join("\n", hasFiles));
        });
    }

    @FXML
    public void getDmVer(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            String dmVer = terminalService.getDmVer(tableData.getIp());
            tableData.setStatus("获取大漠版本");
            tableData.setVersion(dmVer);
            appendLog("获取大漠版本 {}", dmVer);
        });
    }

    @FXML
    public void test(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.test(tableData.getIp());
        });
    }

    @FXML
    public void start() {
        Platform.runLater(() -> {
            GameStart gameStart = GameStart.getInstance(tableData.getIp());
            gameStart.start();
        });
    }

    @FXML
    public void restart() {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.restart(tableData.getIp());
            TerminalContext terminalContext = TerminalCache.getTerminalContext(tableData.getIp());
            terminalContext.connectFailProcess(TerminalStatus.restart);
            appendLog("重启中");
        });
    }

    private void appendLog(CharSequence template, Object... params) {
        Platform.runLater(() -> {
            String log = StrUtil.format(DateUtil.now() + StrUtil.SPACE + template + StrUtil.LF, params);
            log_textArea.appendText(log);
        });
    }
}
