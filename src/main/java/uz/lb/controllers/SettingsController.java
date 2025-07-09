package uz.lb.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import uz.lb.utils.ThemeManager;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Circle id_crlProfileImage;

    @FXML
    private VBox id_vbSettings;

    @FXML
    private ImageView id_ivMyProfile, id_ivContacts, id_ivCalls, id_ivSaveMessages, id_ivNightMode, id_ivSettings;

    @FXML
    private Label id_lblUserName, id_lblMyProfile, id_lblContacts, id_lblCalls, id_lblSaveMessages, id_lblSettings, id_lblNightMode;

    @FXML
    private TitledPane id_tpAccounts;

    @FXML
    private JFXToggleButton id_tglBtnNightMode;

    public boolean isNightMode = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        id_tglBtnNightMode.setOnAction(e -> {
//            isNightMode = !isNightMode;
//            System.out.println("isNightMode => " + isNightMode);
//        });
        id_tglBtnNightMode.setSelected(false);


        id_tglBtnNightMode.selectedProperty().addListener((obs, oldVal, newVal) -> {
            ThemeManager.applyTheme(id_vbSettings, newVal); // true bo‘lsa, dark.css ulanadi
        });



    }
}
