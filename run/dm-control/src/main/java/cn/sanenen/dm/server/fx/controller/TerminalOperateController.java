package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.lang.Singleton;
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
    }
    
    public void setTableData(TableData tableData) {
        this.tableData = tableData;
        ip_label.textProperty().bind(tableData.ipProperty());
    }

    @FXML
    public void delFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.delFiles(tableData.getIp());
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
            log_textArea.setText(String.join("\n", hasFiles));
        });
    }

    @FXML
    public void getDmVer(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            String dmVer = terminalService.getDmVer(tableData.getIp());
            tableData.setStatus("获取大漠版本");
            tableData.setVersion(dmVer);
            log_textArea.appendText(dmVer + "\n");
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
}
