package cn.sanenen.dm.server.fx.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.server.fx.model.entity.TableData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    Stage terminalStage;

    private void handleAction(TableData data, Stage parentStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fxml/terminal_operate.fxml"));
        fxmlLoader.setControllerFactory(param -> {
            //将所有controller生成并放入单例工具类中，方便项目其他地方使用。
            Object o = Singleton.get(param);
            log.info("fxml terminal_operate controller生成：{}", o);
            return o;
        });
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        terminalStage = new Stage();
        terminalStage.initModality(Modality.APPLICATION_MODAL);
        terminalStage.setScene(scene);
        terminalStage.setTitle("terminal_operate");
        terminalStage.getIcons().add(new Image("icon.png"));
        terminalStage.sizeToScene();
        TerminalOperateController terminalOperateController = Singleton.get(TerminalOperateController.class);
        terminalOperateController.setTableData(data);
        terminalOperateController.setIp(data.getIp());

        terminalStage.setX(parentStage.getX() + 50);
        terminalStage.setY(parentStage.getY() + 50);

        terminalStage.show();
    }

    @FXML
    private void addData(ActionEvent actionEvent) {
        TableData sqlTableData = new TableData();
        sqlTableData.setIp("127.0.0.1" + RandomUtil.randomString(3));
        sqlTableData.setVersion("1");
        tableView.getItems().add(sqlTableData);
        ObservableList<TableData> items = tableView.getItems();
        for (TableData item : items) {
            item.setIp(item.getIp()+"1");
        }
    }

    public void showTest(ActionEvent actionEvent) {
        Window window = ((Button) actionEvent.getSource()).getScene().getWindow();
        terminalStage.setX(window.getX() + 100);
        terminalStage.setY(window.getY() + 50);
        terminalStage.show();
    }
}
