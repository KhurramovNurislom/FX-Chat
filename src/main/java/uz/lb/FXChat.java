package uz.lb;


import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import uz.lb.controllers.LoginController;
import uz.lb.utils.ResizableWindowHelper;
import uz.lb.utils.SystemThemeDetector;

import javax.swing.*;
import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.security.Security;

public class FXChat extends Application {

    private static Stage stage;
    private static Pane titlePane;
    private static Pane lockPane;

    private static final DoubleProperty x = new SimpleDoubleProperty();
    private static final DoubleProperty y = new SimpleDoubleProperty();
    private static final DoubleProperty x_point = new SimpleDoubleProperty();
    private static final DoubleProperty y_point = new SimpleDoubleProperty();

    private static Boolean isFullScreen = false;

    public static void setLockPane(Pane lockPane) {
        FXChat.lockPane = lockPane;
    }

    public static void setTitlePane(Pane titlePane) {
        FXChat.titlePane = titlePane;
    }


    @Override
    public void start(Stage stage) throws Exception {


        Security.addProvider(new BouncyCastleProvider());


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
        Parent root = loader.load();

//        stage.getIcons().add(new Image("/images/icon.png"));

        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.setMinHeight(500);
        stage.setMinWidth(700);
        setStage(stage, scene);

        stage.show();


        if (SystemThemeDetector.isDarkTheme()) {
            System.out.println("Dark-theme");
//            scene.getStylesheets().add(getClass().getResource("/css/dark-theme.css").toExternalForm());
        } else {

            System.out.println("light-theme");
//            scene.getStylesheets().add(getClass().getResource("/css/light-theme.css").toExternalForm());
        }

    }


    public static void Lock(String fxmlPath) {

        try {
            FXMLLoader loader = new FXMLLoader(FXChat.class.getResource(fxmlPath));
            Parent loginRoot = loader.load();
            lockPane.getChildren().setAll(loginRoot);
            lockPane.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), lockPane);

        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    public static void UnLock() {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), lockPane);
        fadeIn.setFromValue(1);
        fadeIn.setToValue(0);
        fadeIn.setOnFinished(e -> lockPane.setVisible(false));
        fadeIn.play();
    }





    public static void Minimize() {
        stage.setIconified(true);
    }

    public static void FullScreen() {

        if (!isFullScreen) {
            x_point.set(stage.getX());
            y_point.set(stage.getY());

        } else {
            stage.setX(x_point.get());
            stage.setY(y_point.get());
        }

        stage.setFullScreen(!isFullScreen);
        isFullScreen = !isFullScreen;

    }

    public void setStage(Stage stage, Scene scene) {
        this.stage = stage;
        titlePane.setOnMousePressed(this::onMousePressed);
        titlePane.setOnMouseDragged(this::onMouseDragged);
        ResizableWindowHelper.makeResizable(stage);
    }

    private void onMousePressed(MouseEvent e) {
        x.set(e.getSceneX());
        y.set(e.getSceneY());
    }

    private void onMouseDragged(MouseEvent e) {
        stage.setX(e.getScreenX() - x.get());
        stage.setY(e.getScreenY() - y.get());
    }


    public static void main(String[] args) {
//        SQLiteUtil.createDatabaseAndTables();
        launch(args);
    }
}