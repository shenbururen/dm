package cn.sanenen.dm.server.fx.controller;

import cn.sanenen.dm.server.fx.model.entity.TableData;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author sun
 **/
public class TerminalOperateController implements Initializable {

    public Label ip_label;
    
    
    private TableData tableData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void setIp(String ip) {
        ip_label.setText(ip);
        //ip_label的text值绑定到tableData的ip属性
        ip_label.textProperty().bind(tableData.ipProperty());
    }
    
    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }
}
