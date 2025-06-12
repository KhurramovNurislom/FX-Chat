package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import uz.lb.FXChat;
import uz.lb.caches.ImageCacheLight;
import uz.lb.caches.LenghtCache;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Text id_txtRegistration;

    @FXML
    private Label id_lblText;

    @FXML
    private Label id_lblTextDesc;

    @FXML
    private Label id_lblEnteredPassword;

    @FXML
    private JFXButton id_btnEnter;

    @FXML
    private AnchorPane id_apLogin;

    @FXML
    private PasswordField id_pfPassword;

    @FXML
    private TextField id_tfPassword;

    @FXML
    private Line id_lnLine;

    @FXML
    private ImageView id_ivEye;

    private boolean eyeBool = true;

    private String passOld = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hoverEye();

        id_txtRegistration.setOnMouseClicked(e -> {
            FXChat.Lock("/fxml/Registration.fxml");
//            Stage currentStage = (Stage) id_apLogin.getScene().getWindow();
//
//            WindowUtil.openWindow("/fxml/Registration.fxml", "Registration", currentStage);
        });

        id_pfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            id_tfPassword.setText(newValue);
        });

        id_tfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            id_pfPassword.setText(newValue);
        });

        id_ivEye.setOnMouseClicked(e -> {
            eyeBool = !eyeBool;
            if (eyeBool) {
                id_ivEye.setImage(ImageCacheLight.getImageEyeDark());
                hoverEye();
            } else {
                id_ivEye.setImage(ImageCacheLight.getImageUnEyeDark());
                hoverUnEye();
            }
            id_tfPassword.setVisible(!eyeBool);
            id_pfPassword.setVisible(eyeBool);
        });

        id_tfPassword.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            hoverField(newValue);
        });

        id_pfPassword.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            hoverField(newValue);
        });

        id_btnEnter.setOnAction(e -> {
            id_btnEnter.setDisable(true);

            if (id_tfPassword.getText().equals("qweqwe")) {
                FXChat.UnLock();
            } else {
                id_tfPassword.setStyle("-fx-text-fill:  #ff5c33");
                id_pfPassword.setStyle("-fx-text-fill:  #ff5c33");
                id_lnLine.setStyle("-fx-stroke: #ff5c33");
                id_lblEnteredPassword.setStyle("-fx-text-fill:  #ff5c33");
                id_lblTextDesc.setVisible(true);
            }
            id_btnEnter.setDisable(false);
        });

    }

    private void hoverEye() {

        id_ivEye.hoverProperty().addListener(l -> {
            id_ivEye.setImage(ImageCacheLight.getImageEyeDarkHover());
        });

        id_ivEye.setOnMouseMoved(m -> {
            id_ivEye.setImage(ImageCacheLight.getImageEyeDark());
        });

    }

    private void hoverUnEye() {

        id_ivEye.hoverProperty().addListener(l -> {
            id_ivEye.setImage(ImageCacheLight.getImageUnEyeDarkHover());
        });

        id_ivEye.setOnMouseMoved(m -> {
            id_ivEye.setImage(ImageCacheLight.getImageUnEyeDark());
        });

    }

    private void hoverField(String newValue) {
        if (newValue.length() < LenghtCache.getMinPassword()) {
            id_tfPassword.setStyle("-fx-text-fill:  #a6a6a6");
            id_pfPassword.setStyle("-fx-text-fill:  #a6a6a6");
        } else if (newValue.length() <= LenghtCache.getMaxPassword()) {
            passOld = newValue;
            id_tfPassword.setStyle("-fx-text-fill:  #f2f2f2");
            id_pfPassword.setStyle("-fx-text-fill:  #f2f2f2");
        } else {
            id_tfPassword.setText(passOld);
            id_pfPassword.setText(passOld);
            id_tfPassword.setStyle("-fx-text-fill:  #a6a6a6");
            id_pfPassword.setStyle("-fx-text-fill:  #a6a6a6");
        }
    }


}
