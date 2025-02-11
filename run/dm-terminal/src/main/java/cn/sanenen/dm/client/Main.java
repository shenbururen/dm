package cn.sanenen.dm.client;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.cron.CronUtil;
import cn.hutool.log.Log;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author sun
 **/
public class Main extends javafx.application.Application{
    private static final Log log = Log.get();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ResourceUtil.getResource("fxml/main.fxml"));
        fxmlLoader.setControllerFactory(param -> {
            //将所有controller生成并放入单例工具类中，方便项目其他地方使用。
            Object o = Singleton.get(param);
            log.info("fxml controller生成：{}", o);
            return o;
        });
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DM Terminal");
        primaryStage.sizeToScene();
        primaryStage.setOnCloseRequest(event -> {
            if (CronUtil.getScheduler().isStarted()) {
                CronUtil.stop();
            }
            System.exit(0);
        });
        primaryStage.show();
    }
}
