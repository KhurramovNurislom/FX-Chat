package uz.lb.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.config.AppConfig;
import uz.lb.utils.theme.ThemeBinder;
import uz.lb.utils.theme.ThemeState;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class SettingsController implements Initializable {


    @FXML
    private Circle id_crlProfileImage;

    @FXML
    private VBox id_vbSettings;

    @FXML
    private ImageView id_ivMyProfile, id_ivContacts, id_ivCalls, id_ivSaveMessages, id_ivNightMode, id_ivSettings, id_ivCloseSetting;

    @FXML
    private Label id_lblUserName, id_lblMyProfile, id_lblContacts, id_lblCalls, id_lblSaveMessages, id_lblSettings, id_lblNightMode;

    @FXML
    private TitledPane id_tpAccounts;

    @FXML
    private JFXToggleButton id_tglBtnNightMode;
    private Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        hover();

        imageMap.put(id_ivNightMode, () -> ImageCacheManager.getImageCacheSettingPane().getImageNightMode());
        imageMap.put(id_ivCloseSetting, () -> ImageCacheManager.getImageCacheSettingPane().getArrowClose());

        id_tglBtnNightMode.setSelected(AppConfig.getBoolean("theme.night"));

        ThemeBinder.bind(
                id_vbSettings,
                "/css/settings/settings-dark.css",
                "/css/settings/settings-light.css",
                imageMap
        );

        id_tglBtnNightMode.setSelected(ThemeState.isDarkMode());

        id_tglBtnNightMode.setOnAction(e -> {
            AppConfig.set("theme.night", String.valueOf(id_tglBtnNightMode.isSelected()));
            ThemeState.setDarkMode(id_tglBtnNightMode.isSelected());

            DashboardController dashboardController = ControllerRegistry.getDashboardController();
            if (dashboardController != null) {
                dashboardController.settingHover();
            }

        });

        id_ivCloseSetting.setOnMouseClicked(e -> {
            DashboardController dashboardController = ControllerRegistry.getDashboardController();
            if (dashboardController != null) {
                dashboardController.closeDrawerForOut();
            }
        });
    }

    private void hover() {

        id_ivCloseSetting.setOnMouseEntered(e -> {
            id_ivCloseSetting.setImage(ImageCacheManager.getImageCacheSettingPane().getArrowCloseHover());
        });

        id_ivCloseSetting.setOnMouseExited(e -> {
            id_ivCloseSetting.setImage(ImageCacheManager.getImageCacheSettingPane().getArrowClose());
        });
    }

}
