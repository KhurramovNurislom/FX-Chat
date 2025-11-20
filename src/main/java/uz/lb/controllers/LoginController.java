package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.colorCaches.ColorCacheManager;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.caches.LenghtCache;
import uz.lb.config.AppConfig;
import uz.lb.utils.Effects;
import uz.lb.utils.theme.ThemeBinder;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class LoginController implements Initializable {

    public ImageView id_ivLogo;
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
    private boolean isEffect = false;

    private String passOld = "";
    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ControllerRegistry.setLoginController(this);

        defaultSetting();

        id_ivEye.setOnMouseClicked(e -> {
            eyeBool = !eyeBool;
            if (eyeBool) {
                id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageEye());
                hoverEye();
            } else {
                id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageUnEye());
                hoverUnEye();
            }
            id_tfPassword.setVisible(!eyeBool);
            id_pfPassword.setVisible(eyeBool);
        });

        id_btnEnter.setOnAction(e -> {
            id_btnEnter.setDisable(true);

            if (id_tfPassword.getText().equals("qweqwe")) {
                ControllerRegistry.getDashboardController().UnLock();
            } else {
                id_tfPassword.setStyle("-fx-text-fill: " + ColorCacheManager.getColorCache().getColorPasswordError());
                id_pfPassword.setStyle("-fx-text-fill: " + ColorCacheManager.getColorCache().getColorPasswordError());
                id_lnLine.setStyle("-fx-stroke: " + ColorCacheManager.getColorCache().getColorPasswordError());
                id_lblEnteredPassword.setStyle("-fx-text-fill: " + ColorCacheManager.getColorCache().getColorPasswordError());
                id_lblTextDesc.setVisible(true);

                if (!isEffect) {
                    Effects.blurEffect(id_ivLogo, 0.8, 15);
                    Effects.blurEffect(id_lblText, 0.8, 15);
                    isEffect = true;
                }

            }

            id_btnEnter.setDisable(false);
        });

        id_txtRegistration.setOnMouseClicked(e -> {
            ControllerRegistry.getDashboardController().changeOtherWindow("/fxml/Registration.fxml");
        });

    }


    private void defaultSetting() {

        imageMap.put(id_ivLogo, () -> ImageCacheManager.getImageCacheLogin().getImageLogo());
        imageMap.put(id_ivEye, () -> ImageCacheManager.getImageCacheLogin().getImageEyeHover());

        ThemeBinder.bind(
                id_apLogin,
                "/css/login/login-dark.css",
                "/css/login/login-light.css",
                imageMap
        );

        hoverEye();

        Effects.rotateLogo(id_ivLogo);


        id_tfPassword.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            hoverField(newValue);
        });

        id_pfPassword.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            hoverField(newValue);
        });

        id_pfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            id_tfPassword.setText(newValue);
        });

        id_tfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
            id_pfPassword.setText(newValue);
        });

    }

    private void hoverEye() {

        id_ivEye.hoverProperty().addListener(l -> {
            id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageEyeHover());
        });

        id_ivEye.setOnMouseMoved(m -> {
            id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageEye());
        });

    }

    private void hoverUnEye() {

        id_ivEye.hoverProperty().addListener(l -> {
            id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageUnEyeHover());
        });

        id_ivEye.setOnMouseMoved(m -> {
            id_ivEye.setImage(ImageCacheManager.getImageCacheLogin().getImageUnEye());
        });

    }

    private void hoverField(String newValue) {

        if (AppConfig.getBoolean("theme.night")) {
            hover(newValue, "#a6a6a6", "#f2f2f2");
        } else {
            hover(newValue, "#366bb0", "#2a5389");
        }

    }

    private void hover(String newValue, String color, String colorHover) {
        if (newValue.length() < LenghtCache.getMinPassword()) {
            id_tfPassword.setStyle("-fx-text-fill:  " + color);
            id_pfPassword.setStyle("-fx-text-fill:  " + color);
        } else if (newValue.length() <= LenghtCache.getMaxPassword()) {
            passOld = newValue;
            id_tfPassword.setStyle("-fx-text-fill:  " + colorHover);
            id_pfPassword.setStyle("-fx-text-fill:  " + colorHover);
        } else {
            id_tfPassword.setText(passOld);
            id_pfPassword.setText(passOld);
            id_tfPassword.setStyle("-fx-text-fill:  " + color);
            id_pfPassword.setStyle("-fx-text-fill:  " + color);
        }
    }


}
