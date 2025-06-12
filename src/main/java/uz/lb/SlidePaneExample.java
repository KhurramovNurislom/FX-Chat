package uz.lb;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SlidePaneExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(800, 1000);

        double paneWidth = 200;
        double paneHeight = 800;

        // Dashboard oynasi uchun konteyner
        Pane dashboardPane = new Pane();
        dashboardPane.setLayoutX(100); // X=100 chiziqdan boshlanadi
        dashboardPane.setLayoutY(100);
        dashboardPane.setPrefSize(800 - 100, 1000 - 100);

        // Clip mask faqat dashboard uchun — x=100 chiziqdan boshlab ko'rinadi
        Rectangle clip = new Rectangle(0, 0, 800 - 100, 1000 - 100);
        dashboardPane.setClip(clip);

        // id_vbSetting Pane — bu slidelanadigan qism
        VBox id_vbSetting = new VBox();
        id_vbSetting.setStyle("-fx-background-color: lightblue;");
        id_vbSetting.setPrefSize(paneWidth, paneHeight);
        id_vbSetting.setLayoutX(0); // dashboardPane ichida X=0 bo'ladi
        id_vbSetting.setLayoutY(0); // dashboardPane ichida Y=0 bo'ladi

        Label label = new Label("asdasdqweqweasdasdqweqweasdasdqweqweasdasdqweqwe");
        label.setStyle("-fx-background-color: RED");
        id_vbSetting.getChildren().add(label);
        dashboardPane.getChildren().add(id_vbSetting);

        // Show tugma
        Button showButton = new Button("Show Settings Pane");
        showButton.setLayoutX(50);
        showButton.setLayoutY(50);

        // Hide tugma
        Button hideButton = new Button("Hide Settings Pane");
        hideButton.setLayoutX(200);
        hideButton.setLayoutY(50);

        // Show action
        showButton.setOnAction(e -> {
            TranslateTransition slideIn = new TranslateTransition(Duration.millis(500), id_vbSetting);
            slideIn.setToX(0); // X=0 → x=100 chiziqda ko'rinadi
            slideIn.play();
        });

        // Hide action
        hideButton.setOnAction(e -> {
            TranslateTransition slideOut = new TranslateTransition(Duration.millis(500), id_vbSetting);
            slideOut.setToX(-paneWidth); // Chapga o'tadi, x=100 chiziqdan chapga ko'rinmaydi
            slideOut.play();
        });

        // Qo'shish
        root.getChildren().addAll(dashboardPane, showButton, hideButton);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Slide Pane with True Clipping Example");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
