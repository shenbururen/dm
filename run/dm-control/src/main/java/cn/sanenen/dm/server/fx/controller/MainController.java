package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.common.TerminalStatus;
import cn.sanenen.dm.common.fx.ButtonTableCell;
import cn.sanenen.dm.server.common.StageCache;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import cn.sanenen.dm.server.fx.service.TerminalService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sun
 **/
public class MainController implements Initializable {
    private static final Log log = Log.get();

    public TableColumn<TableData, Boolean> col_select;
    public TableColumn<TableData, String> col_ip;
    public TableColumn<TableData, Number> col_port;
    public TableColumn<TableData, String> col_version;
    public TableColumn<TableData, String> col_status;
    public TableColumn<TableData, Object> col_action;
    public TableColumn<TableData, Object> col_restart;
    public TableView<TableData> tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initColumn();
    }

    public void addDmTerminal(TableData sqlTableData) {
        tableView.getItems().remove(sqlTableData);
        tableView.getItems().add(sqlTableData);
    }

    private void initColumn() {
        col_select.setCellValueFactory(param -> param.getValue().selectProperty());
        col_ip.setCellValueFactory(param -> param.getValue().ipProperty());
        col_port.setCellValueFactory(param -> param.getValue().portProperty());
        col_version.setCellValueFactory(param -> param.getValue().versionProperty());
        col_status.setCellValueFactory(param -> param.getValue().statusProperty());

        col_select.setCellFactory(CheckBoxTableCell.forTableColumn(null, null));
        col_action.setCellFactory(ButtonTableCell.forTableColumn("查看", (TableData data) -> {
            Stage parentStage = (Stage) tableView.getScene().getWindow();
            handleAction(data, parentStage);
        }));
        col_restart.setCellFactory(ButtonTableCell.forTableColumn("重启", (TableData data) -> {
            TerminalService terminalService = Singleton.get(TerminalService.class);
            terminalService.restart(data.getIp());
        }));
    }

    private void handleAction(TableData data, Stage parentStage) {
        Stage terminalStage = StageCache.terminalStage;
        if (data.getStatusEnum() == TerminalStatus.grpc_error) {
            log.info("连接异常，正在重新连接...");
            // 创建一个警告类型的消息框
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("警告");
            alert.setX(parentStage.getX() + 50);
            alert.setX(parentStage.getY() + 50);
            alert.setHeaderText("连接异常");
            alert.setContentText("连接异常，正在重新连接...");
            // 显示对话框
            alert.showAndWait();
            return;
        }
        TerminalOperateController terminalOperateController = Singleton.get(TerminalOperateController.class);
        terminalOperateController.setTableData(data);
        terminalStage.setX(parentStage.getX() + 50);
        terminalStage.setY(parentStage.getY() + 50);

        terminalStage.show();
    }

    @FXML
    private void addData(ActionEvent actionEvent) {
        File mkdir = FileUtil.file("test");
        File dmFilesDir = FileUtil.file(Constant.DM_FILES);
        log.info("test：{}", mkdir.getPath());
        log.info("资源目录：{}", dmFilesDir.getPath());
    }

    public TableData getDmTerminal(String ip) {
        return tableView.getItems().stream()
                .filter(item -> item.getIp().equals(ip))
                .findFirst()
                .orElse(null);
    }
}
