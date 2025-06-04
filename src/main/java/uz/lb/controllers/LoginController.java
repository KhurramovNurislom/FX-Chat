package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ChangeListener;
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
import uz.lb.caches.ImageCache;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

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

    private boolean eyebool = false;

    private String passOld = "";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hover();

        id_ivEye.setOnMouseClicked(e -> {
            id_tfPassword.setText(id_pfPassword.getText());

            id_pfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
                id_tfPassword.setText(newValue);
            });

            id_tfPassword.textProperty().addListener((observable, oldValue, newValue) -> {
                id_pfPassword.setText(newValue);
            });

            eyebool = !eyebool;
            if (eyebool) {
                id_ivEye.setImage(ImageCache.getImageUnEyeDark());
                id_tfPassword.setVisible(true);
                id_pfPassword.setVisible(false);
            } else {
                id_ivEye.setImage(ImageCache.getImageEyeDark());
                id_tfPassword.setVisible(false);
                id_pfPassword.setVisible(true);
            }
        });




        id_pfPassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() < 6) {
                    id_tfPassword.setStyle("-fx-text-fill:  RED");
                    id_pfPassword.setStyle("-fx-text-fill:  RED");
                } else if (newValue.length() < 17) {
                    passOld = newValue;
                    id_tfPassword.setStyle("-fx-text-fill:  #0F2A62");
                    id_pfPassword.setStyle("-fx-text-fill:  #0F2A62");
                } else {
                    id_tfPassword.setText(passOld);
                    id_pfPassword.setText(passOld);
                    id_tfPassword.setStyle("-fx-text-fill:  RED");
                    id_pfPassword.setStyle("-fx-text-fill:  RED");
                }
            }
        });














    }

    private void hover() {

        id_ivEye.hoverProperty().addListener(l -> {
            id_ivEye.setImage(ImageCache.getImageEyeDarkHover());
        });

        id_ivEye.setOnMouseMoved(m -> {
            id_ivEye.setImage(ImageCache.getImageEyeDark());
        });

    }
}
