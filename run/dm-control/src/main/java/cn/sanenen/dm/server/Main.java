package cn.sanenen.dm.server;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.cron.CronUtil;
import cn.hutool.log.Log;
import cn.sanenen.dm.server.common.StageCache;
import cn.sanenen.dm.server.grpc.ServerStart;
import com.google.errorprone.annotations.Keep;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


@Keep
/**
 * @author sun
 **/
public class Main extends javafx.application.Application{
    private static final Log log = Log.get();
    private static final ServerStart serverStart = new ServerStart();
    public static void main(String[] args) {
        Singleton.put(serverStart);
        try {
            serverStart.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        primaryStage.setTitle("DM Control");
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> {
            if (CronUtil.getScheduler().isStarted()) {
                CronUtil.stop();
            }
            serverStart.shutdown();
            System.exit(0);
        });
        StageCache.initTerminalStage(primaryStage);
        primaryStage.show();
    }
}
