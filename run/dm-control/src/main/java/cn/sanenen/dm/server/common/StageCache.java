package cn.sanenen.dm.server.common;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.log.Log;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author sun
 **/
public class StageCache {
    private static final Log log = Log.get();
    public static Stage terminalStage;

    public static void initTerminalStage(Stage parentStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fxml/terminal_operate.fxml"));
        fxmlLoader.setControllerFactory(param -> {
            //将所有controller生成并放入单例工具类中，方便项目其他地方使用。
            Object o = Singleton.get(param);
            log.info("fxml terminal_operate controller生成：{}", o);
            return o;
        });
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            log.info(e);
            System.exit(0);
        }
        Scene scene = new Scene(root);
        terminalStage = new Stage();
        terminalStage.initOwner(parentStage);
        terminalStage.initModality(Modality.APPLICATION_MODAL);
        terminalStage.setScene(scene);
        terminalStage.setTitle("terminal_operate");
        terminalStage.getIcons().add(new Image("icon.png"));
        terminalStage.sizeToScene();
        terminalStage.setResizable(false);
    }
}
