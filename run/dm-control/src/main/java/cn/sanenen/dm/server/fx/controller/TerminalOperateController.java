package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.lang.Singleton;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import cn.sanenen.dm.server.fx.service.TerminalService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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

    public void delFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.delFiles(tableData);
        });
    }

    public void uploadFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.uploadFiles(tableData);
        });
    }

    public void getHasFiles(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            List<String> hasFiles = terminalService.getHasFiles(tableData);
            log_textArea.setText(String.join("\n", hasFiles));
        });
    }
}
