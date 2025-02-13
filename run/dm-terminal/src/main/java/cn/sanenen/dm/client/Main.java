package cn.sanenen.dm.client;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Singleton;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.log.Log;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author sun
 **/
public class Main extends javafx.application.Application{
    private static final Log log = Log.get();
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void restart() {
        try {
            String exePath = System.getProperty("jpackage.app-path");
            if (exePath == null) {
                log.error("无法获取 EXE 路径，程序可能不是通过 jpackage 运行！");
                return;
            }

            File exeFile = new File(exePath);
            if (!exeFile.exists()) {
                log.error("EXE 文件不存在：{}", exeFile.getAbsolutePath());
                return;
            }
            new ProcessBuilder(exeFile.getAbsolutePath()).start();
            System.exit(0);
        } catch (Exception e) {
            log.error(e);
            ThreadUtil.sleep(5000);
            restart();
        }
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
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> {
            if (CronUtil.getScheduler().isStarted()) {
                CronUtil.stop();
            }
            System.exit(0);
        });
        primaryStage.show();
    }
}
