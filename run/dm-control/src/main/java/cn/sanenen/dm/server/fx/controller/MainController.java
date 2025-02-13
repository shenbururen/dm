package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import cn.sanenen.dm.common.Constant;
import cn.sanenen.dm.server.common.StageCache;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sun
 **/
public class MainController implements Initializable {
    private static final Log log = Log.get();

    public TableColumn<TableData, String> col_ip;
    public TableColumn<TableData, Number> col_port;
    public TableColumn<TableData, String> col_version;
    public TableColumn<TableData, String> col_status;
    public TableColumn<TableData, Object> col_action;
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
        col_ip.setCellValueFactory(param -> param.getValue().ipProperty());
        col_port.setCellValueFactory(param -> param.getValue().portProperty());
        col_version.setCellValueFactory(param -> param.getValue().versionProperty());
        col_status.setCellValueFactory(param -> param.getValue().statusProperty());

        col_ip.setCellFactory(TextFieldTableCell.forTableColumn());
        col_action.setCellFactory(param -> new TableCell<>() {
            private final Button button = new Button("操作");

            {
                button.setOnAction(event -> {
                    Stage parentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    TableData tableData = getTableView().getItems().get(getIndex());
                    try {
                        handleAction(tableData, parentStage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            @Override
            protected void updateItem(Object item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(button);
                }
            }
        });
    }

    private void handleAction(TableData data, Stage parentStage) throws IOException {
        Stage terminalStage = StageCache.terminalStage;

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
