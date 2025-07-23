package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;
import uz.lb.RemusDesktop;
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.colorCaches.ColorCacheManager;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.utils.theme.ThemeBinder;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

public class DashboardController implements Initializable {

    @FXML
    private ImageView id_ivLogo;
    @FXML
    private JFXDrawersStack id_dsSettings;
    @FXML
    private JFXDrawer id_drSettings;

    @FXML
    private VBox id_vbSettings;
    @FXML
    private HBox id_hbCountAllChats;
    @FXML
    private AnchorPane id_apRoot;

    @FXML
    private Label id_lblPersonalChat;
    @FXML
    private Label id_lblAllChats;
    @FXML
    private Label id_lblUnreadChats;
    @FXML
    private Label id_lblMenu;


    @FXML
    private AnchorPane id_apDashboard;
    @FXML
    private StackPane id_spLock;

    @FXML
    private Pane id_pnLock;
    @FXML
    private AnchorPane id_apContacts;
    @FXML
    private AnchorPane id_apChatContents;
    @FXML
    private SplitPane id_spChat;
    @FXML
    private Pane id_pnShadow;
    @FXML
    private AnchorPane id_apTitlePane;
    @FXML
    private AnchorPane id_apShadow;


    @FXML
    private JFXButton id_btnMenu;
    @FXML
    private JFXButton id_btnAllChats;
    @FXML
    private JFXButton id_btnPersonalChat;
    @FXML
    private JFXButton id_btnUnreadChats;

    @FXML
    private ImageView id_ivMenu;
    @FXML
    private ImageView id_ivAllChats;
    @FXML
    private ImageView id_ivPersonalChat;
    @FXML
    private ImageView id_ivUnreadChats;
    @FXML
    private ImageView id_ivClose;
    @FXML
    private ImageView id_ivFullScreen;
    @FXML
    private ImageView id_ivMinimize;

    private boolean isFullScreen = false;
    private final FadeTransition fade;

    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    private List<JFXButton> settingBtnList = new ArrayList<>();


    public DashboardController() {
        fade = new FadeTransition(Duration.millis(250));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        settingBtnList.addAll(List.of(id_btnMenu, id_btnAllChats, id_btnUnreadChats, id_btnPersonalChat));
        ControllerRegistry.setDashboardController(this);


        imageMap.put(id_ivMinimize, () -> ImageCacheManager.getImageCacheTitle().getImageDefaultMinimize());
        imageMap.put(id_ivFullScreen, () -> ImageCacheManager.getImageCacheTitle().getImageDefaultFullScreen());
        imageMap.put(id_ivClose, () -> ImageCacheManager.getImageCacheTitle().getImageDefaultClose());

        imageMap.put(id_ivMenu, () -> ImageCacheManager.getImageCacheSetting().getImageMenu());
        imageMap.put(id_ivPersonalChat, () -> ImageCacheManager.getImageCacheSetting().getImagePerson());
        imageMap.put(id_ivAllChats, () -> ImageCacheManager.getImageCacheSetting().getImageAllChats());
        imageMap.put(id_ivUnreadChats, () -> ImageCacheManager.getImageCacheSetting().getImageUnreadChat());

        ThemeBinder.bind(
                id_apDashboard,
                "/css/dashboard/dashboard-dark.css",
                "/css/dashboard/dashboard-light.css",
                imageMap
        );


        RemusDesktop.setTitlePane(id_apTitlePane);

        fade.setNode(id_apShadow);

        titleHover();
        settingHover();
        setupWindowControls();

        id_btnMenu.setOnAction(e -> {
            id_btnMenu.setDisable(true);
            openDrawer();
            id_btnMenu.setDisable(false);
        });


        id_btnPersonalChat.setOnAction(e -> {
            id_btnPersonalChat.setDisable(true);

            id_lblPersonalChat.setVisible(true);
            id_lblPersonalChat.setText("1111");
            id_ivPersonalChat.setImage(ImageCacheManager.getImageCacheSetting().getImagePersonHasCount());

            id_lblMenu.setVisible(true);
            id_lblMenu.setText("123");
            id_ivMenu.setImage(ImageCacheManager.getImageCacheSetting().getImageMenuHasCount());

            id_lblAllChats.setVisible(true);
            id_lblAllChats.setText("1");
            id_ivAllChats.setImage(ImageCacheManager.getImageCacheSetting().getImageAllChatsHasCount());

            id_lblUnreadChats.setVisible(true);
            id_lblUnreadChats.setText("15");
            id_ivUnreadChats.setImage(ImageCacheManager.getImageCacheSetting().getImageUnreadChatHasCount());

            settingHover();

            id_btnPersonalChat.setDisable(false);
        });

        id_btnAllChats.setOnAction(e -> {
            id_btnAllChats.setDisable(true);

            id_btnAllChats.setDisable(false);
        });

        id_btnUnreadChats.setOnAction(e -> {
            id_btnUnreadChats.setDisable(true);

            id_lblMenu.setVisible(false);
            id_ivMenu.setImage(ImageCacheManager.getImageCacheSetting().getImageMenu());

            id_lblPersonalChat.setVisible(false);
            id_ivPersonalChat.setImage(ImageCacheManager.getImageCacheSetting().getImagePerson());

            id_lblAllChats.setVisible(false);
            id_ivAllChats.setImage(ImageCacheManager.getImageCacheSetting().getImageAllChats());

            id_lblUnreadChats.setVisible(false);
            id_ivUnreadChats.setImage(ImageCacheManager.getImageCacheSetting().getImageUnreadChat());

            settingHover();

            id_btnUnreadChats.setDisable(false);
        });

    }

    private void selectButton(JFXButton btn) {
        for (JFXButton b : settingBtnList) {
            b.setStyle("-fx-background-color: " + ColorCacheManager.getColorCache().getColorSettingButton());
        }
        btn.setStyle("-fx-background-color: " + ColorCacheManager.getColorCache().getColorSelectSettingButton());
    }

    private void setupWindowControls() {
        id_ivFullScreen.setOnMouseClicked(e -> {
            RemusDesktop.FullScreen();
            hoverFullScreen();

            if (isFullScreen) {
                id_apDashboard.setTopAnchor(id_apRoot, 0.0);
                id_apDashboard.setRightAnchor(id_apRoot, 0.0);
                id_apDashboard.setLeftAnchor(id_apRoot, 0.0);
                id_apDashboard.setBottomAnchor(id_apRoot, 0.0);
                id_apTitlePane.setStyle("-fx-background-radius: 0");
                id_vbSettings.setStyle("-fx-background-radius: 0");
            } else {
                id_apDashboard.setTopAnchor(id_apRoot, 8.0);
                id_apDashboard.setRightAnchor(id_apRoot, 8.0);
                id_apDashboard.setLeftAnchor(id_apRoot, 8.0);
                id_apDashboard.setBottomAnchor(id_apRoot, 8.0);
                id_apTitlePane.setStyle("-fx-background-radius: 10 10 0 0;");
                id_vbSettings.setStyle("-fx-background-radius: 0 0 0 10;");
            }
        });

        id_ivClose.setOnMouseClicked(e -> System.exit(1));

        id_ivMinimize.setOnMouseClicked(e -> RemusDesktop.Minimize());
    }

    private void openDrawer() {
        TranslateTransition open = new TranslateTransition(Duration.millis(250), id_drSettings);
        open.setToX(0);
        open.play();
        toggleSettingsPane();

        id_dsSettings.setMouseTransparent(false);
    }


    private void closeDrawer() {
        TranslateTransition close = new TranslateTransition(Duration.millis(250), id_drSettings);
        close.setToX(-272);
        close.play();

        id_dsSettings.setMouseTransparent(true);
    }

    public void closeDrawerForOut() {
        fade.setFromValue(0.5);
        fade.setToValue(0.0);
        fade.play();
        closeDrawer();
        fade.setOnFinished(ev -> id_apShadow.setVisible(false));
    }

    private void toggleSettingsPane() {
        id_apShadow.setVisible(true);
        fade.setFromValue(0.0);
        fade.setToValue(0.5);
        fade.play();

        fade.setOnFinished(e -> {
            backSettingPage();
        });
    }

    private void backSettingPage() {
        id_apShadow.setOnMouseClicked(e -> {
            fade.setFromValue(0.5);
            fade.setToValue(0.0);
            fade.play();
            closeDrawer();
            fade.setOnFinished(ev -> id_apShadow.setVisible(false));
        });
    }


    private void hoverFullScreen() {

        isFullScreen = !isFullScreen;

        if (!isFullScreen) {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageFullScreen());
            });
        } else {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageUnFullScreen());
            });
        }

    }


    public void settingHover() {

        settingButtonHover(id_btnMenu, id_ivMenu,
                ImageCacheManager.getImageCacheSetting().getImageMenu(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHover(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHoverHasCount(),
                id_lblMenu, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        settingButtonHover(id_btnPersonalChat, id_ivPersonalChat,
                ImageCacheManager.getImageCacheSetting().getImagePerson(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHover(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHasCount(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHoverHasCount(),
                id_lblPersonalChat, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        settingButtonHover(id_btnAllChats, id_ivAllChats,
                ImageCacheManager.getImageCacheSetting().getImageAllChats(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHover(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHoverHasCount(),
                id_lblAllChats, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        settingButtonHover(id_btnUnreadChats, id_ivUnreadChats,
                ImageCacheManager.getImageCacheSetting().getImageUnreadChat(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHover(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHoverHasCount(),
                id_lblUnreadChats, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());


    }


    private void settingButtonHover(JFXButton btn, ImageView imageView, Image image, Image imageHover, Image imageHasCount,
                                    Image imageHasCountHover, Label lbl, String color, String colorHover) {

        lbl.setStyle("-fx-background-color: " + color);

        if (lbl.isVisible()) {
            imageView.setImage(imageHasCount);

            btn.setOnMouseExited(l -> {
                imageView.setImage(imageHasCount);
                lbl.setStyle("-fx-background-color: " + color);
            });

            btn.setOnMouseEntered(m -> {
                imageView.setImage(imageHasCountHover);
                lbl.setStyle("-fx-background-color: " + colorHover);
            });

        } else {
            imageView.setImage(image);

            btn.setOnMouseExited(l -> {
                imageView.setImage(image);
                lbl.setStyle("-fx-background-color: " + color);
            });

            btn.setOnMouseEntered(m -> {
                imageView.setImage(imageHover);
                lbl.setStyle("-fx-background-color: " + colorHover);
            });
        }
    }

    private void titleHover() {
        id_ivFullScreen.setOnMouseExited(l -> {
            id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageDefaultFullScreen());
        });

        id_ivFullScreen.setOnMouseEntered(m -> {
            id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageFullScreen());
        });

        id_ivClose.setOnMouseExited(l -> {
            id_ivClose.setImage(ImageCacheManager.getImageCacheTitle().getImageDefaultClose());
        });

        id_ivClose.setOnMouseEntered(m -> {
            id_ivClose.setImage(ImageCacheManager.getImageCacheTitle().getImageClose());
        });

        id_ivMinimize.setOnMouseExited(l -> {
            id_ivMinimize.setImage(ImageCacheManager.getImageCacheTitle().getImageDefaultMinimize());
        });

        id_ivMinimize.setOnMouseEntered(m -> {
            id_ivMinimize.setImage(ImageCacheManager.getImageCacheTitle().getImageMinimize());
        });
    }

    public void Lock(String fxmlPath) {


        try {
            FXMLLoader loader = new FXMLLoader(RemusDesktop.class.getResource(fxmlPath));
            Parent loginRoot = loader.load();
            id_spLock.getChildren().setAll(loginRoot);
            id_spLock.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), id_spLock);

        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    public void UnLock() {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), id_spLock);
        fadeIn.setFromValue(1);
        fadeIn.setToValue(0);
        fadeIn.setOnFinished(e -> id_spLock.setVisible(false));
        fadeIn.play();
    }

}

