package uz.lb;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PhoneLoginView extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login");

        // Asosiy konteyner
        VBox root = new VBox(15);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #1E1E2F;");

        Label title = new Label("Ваш номер телефона");
        title.setFont(Font.font(16));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("Проверьте код страны и введите свой номер телефона.");
        subtitle.setFont(Font.font(12));
        subtitle.setTextFill(Color.GRAY);

        // Country va phone number
        ComboBox<String> countryBox = new ComboBox<>();
        countryBox.getItems().addAll("Uzbekistan");
        countryBox.setValue("Uzbekistan");
        countryBox.setPrefWidth(250);

        HBox phoneBox = new HBox(10);
        phoneBox.setAlignment(Pos.CENTER_LEFT);

        Label prefix = new Label("+998");
        prefix.setTextFill(Color.WHITE);
        prefix.setFont(Font.font(14));

        TextField phoneField = new TextField();
        phoneField.setPromptText(" __ ___ __ __");
        phoneField.setPrefWidth(180);
        phoneField.setStyle("-fx-background-color: #2C2F48; -fx-text-fill: white;");

        phoneBox.getChildren().addAll(prefix, phoneField);

        Button continueBtn = new Button("Продолжить");
        continueBtn.setPrefWidth(250);
        continueBtn.setStyle("-fx-background-color: #2787F5; -fx-text-fill: white;");

        Label qrHint = new Label("Быстрый вход по QR-коду");
        qrHint.setTextFill(Color.GRAY);
        qrHint.setFont(Font.font(12));

        root.getChildren().addAll(title, subtitle, countryBox, phoneBox, continueBtn, qrHint);

        Scene scene = new Scene(root, 320, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
