package uz.lb;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import uz.lb.caches.windowParametrCaches.WindowManager;
import uz.lb.config.AppConfig;

import java.security.Security;

public class RemusDesktop extends Application {
    private static Pane titlePane;
    public static void setTitlePane(Pane titlePane) {
        RemusDesktop.titlePane = titlePane;
    }



    @Override
    public void start(Stage stage) throws Exception {

        AppConfig.config();
        Security.addProvider(new BouncyCastleProvider());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
        Parent root = loader.load();


        stage.getIcons().add(new Image("/images/logo.png"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setFullScreenExitHint("");
        stage.setScene(scene);
        stage.setMinHeight(570);
        stage.setMinWidth(700);

        // ✅ ENDI: WindowManager orqali barchasini boshqaramiz
        WindowManager windowManager = WindowManager.getInstance();
        windowManager.initialize(stage, titlePane);

        stage.show();
    }




    /********* Static stage helper'lar *********/

    public static void Minimize() {
        WindowManager.minimize();
    }

    // EKRAN FULLSCREEN (OS level) – ishlatyapsan, lekin snap/max bundan alohida
    public static void FullScreen() {
        WindowManager.toggleFullScreen(); // ← Singleton orqali
    }


}
