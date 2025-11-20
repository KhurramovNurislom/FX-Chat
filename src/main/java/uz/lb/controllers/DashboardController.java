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
import uz.lb.caches.windowParametrCaches.WindowManager;
import uz.lb.utils.Effects;
import uz.lb.utils.theme.ThemeBinder;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane id_apDragPane;

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

    private final FadeTransition fade;

    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    private List<JFXButton> settingBtnList = new ArrayList<>();


    public DashboardController() {
        fade = new FadeTransition(Duration.millis(250));
    }

    public AnchorPane getTitlePane() {
        return id_apDragPane;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        settingBtnList.addAll(List.of(id_btnMenu, id_btnAllChats, id_btnUnreadChats, id_btnPersonalChat));
        ControllerRegistry.setDashboardController(this);
        setupFullScreenBinding();   // <-- yangi metod chaqiramiz
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

    private void setupFullScreenBinding() {
        // WindowManager'dagi fullscreen propertyga listener ulaymiz
        WindowManager.getInstance().fullScreenProperty().addListener((obs, oldVal, isFull) -> {
            // Holat o'zgarganda layoutni moslashtiramiz
            applyFullScreenLayout(isFull);
            // Iconni ham moslab qo'yamiz (agar kerak bo'lsa)
            updateFullScreenIcon(isFull);
        });

        // Dastlabki holat uchun ham qo'llab qo'yamiz
        boolean initial = WindowManager.isWindowFullScreen();
        applyFullScreenLayout(initial);
        updateFullScreenIcon(initial);
    }
    private void applyFullScreenLayout(boolean isFull) {
        if (isFull) {
            AnchorPane.setTopAnchor(id_apRoot, 0.0);
            AnchorPane.setRightAnchor(id_apRoot, 0.0);
            AnchorPane.setLeftAnchor(id_apRoot, 0.0);
            AnchorPane.setBottomAnchor(id_apRoot, 0.0);

            id_apTitlePane.setStyle("-fx-background-radius: 0");
            id_vbSettings.setStyle("-fx-background-radius: 0");
        } else {
            AnchorPane.setTopAnchor(id_apRoot, 8.0);
            AnchorPane.setRightAnchor(id_apRoot, 8.0);
            AnchorPane.setLeftAnchor(id_apRoot, 8.0);
            AnchorPane.setBottomAnchor(id_apRoot, 8.0);

            id_apTitlePane.setStyle("-fx-background-radius: 10 10 0 0;");
            id_vbSettings.setStyle("-fx-background-radius: 0 0 0 10;");
        }
    }

    private void updateFullScreenIcon(boolean isFull) {
        if (isFull) {
            // Fullscreen rejimida – "unfullscreen" default icon
            id_ivFullScreen.setImage(
                    ImageCacheManager.getImageCacheTitle().getImageUnFullScreen()
            );
        } else {
            // Oddiy rejimda – "fullscreen" default icon
            id_ivFullScreen.setImage(
                    ImageCacheManager.getImageCacheTitle().getImageDefaultFullScreen()
            );
        }
    }




    private void selectButton(JFXButton btn) {
        for (JFXButton b : settingBtnList) {
            b.setStyle("-fx-background-color: " + ColorCacheManager.getColorCache().getColorSettingButton());
        }
        btn.setStyle("-fx-background-color: " + ColorCacheManager.getColorCache().getColorSelectSettingButton());
    }

    private void setupWindowControls() {
        id_ivFullScreen.setOnMouseClicked(e -> {
            WindowManager.toggleFullScreenWindow();
            hoverFullScreen();
            if (WindowManager.getInstance().isFullScreen()) {
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
                id_spChat.setStyle("-fx-background-radius: 10 0 0 0;");
            }
        });

        id_ivClose.setOnMouseClicked(e -> System.exit(1));

        id_ivMinimize.setOnMouseClicked(e -> WindowManager.minimizeWindow());
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

        // Fullscreen ikonka ustidan sichqoncha chiqqanda
        id_ivFullScreen.setOnMouseExited(e -> {
            if (WindowManager.isWindowFullScreen()) {
                // Hozir fullscreen bo'lsa – "unfullscreen" default ikonka
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageDefaultFullScreen());
            } else {
                // Hozir fullscreen emas bo'lsa – "fullscreen" default ikonka
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageDefaultFullScreen());
            }
        });

        // Fullscreen ikonka ustiga sichqoncha kirganda
        id_ivFullScreen.setOnMouseEntered(e -> {
            if (WindowManager.isWindowFullScreen()) {
                // Fullscreen rejimida hozir "unfullscreen" hover ko'rinishi bo'lsin
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageUnFullScreen());
            } else {
                // Oddiy rejimda "fullscreen" hover ko'rinishi bo'lsin
                id_ivFullScreen.setImage(ImageCacheManager.getImageCacheTitle().getImageFullScreen());
            }
        });

    }


    public void settingHover() {
        Effects.settingButtonHover(id_btnMenu, id_ivMenu,
                ImageCacheManager.getImageCacheSetting().getImageMenu(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHover(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageMenuHoverHasCount(),
                id_lblMenu, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        Effects.settingButtonHover(id_btnPersonalChat, id_ivPersonalChat,
                ImageCacheManager.getImageCacheSetting().getImagePerson(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHover(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHasCount(),
                ImageCacheManager.getImageCacheSetting().getImagePersonHoverHasCount(),
                id_lblPersonalChat, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        Effects.settingButtonHover(id_btnAllChats, id_ivAllChats,
                ImageCacheManager.getImageCacheSetting().getImageAllChats(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHover(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageAllChatsHoverHasCount(),
                id_lblAllChats, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());

        Effects.settingButtonHover(id_btnUnreadChats, id_ivUnreadChats,
                ImageCacheManager.getImageCacheSetting().getImageUnreadChat(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHover(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHasCount(),
                ImageCacheManager.getImageCacheSetting().getImageUnreadChatHoverHasCount(),
                id_lblUnreadChats, ColorCacheManager.getColorCache().getColorCountLabel(), ColorCacheManager.getColorCache().getColorCountLabelHover());
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

    public void changeLockWindow(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(RemusDesktop.class.getResource(fxmlPath));
            Parent root = loader.load();
            id_spLock.getChildren().setAll(root);
            id_spLock.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), id_spLock);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.play();
    }

    public void changeOtherWindow(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(RemusDesktop.class.getResource(fxmlPath));
            Parent root = loader.load();
            id_spLock.getChildren().setAll(root);
            id_spLock.setVisible(true);
        } catch (IOException e) {
            System.out.println("changeOtherWindow -> " + fxmlPath);
            e.printStackTrace();
        }
    }


    public void UnLock() {
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.2), id_spLock);
        fadeIn.setFromValue(1);
        fadeIn.setToValue(0);
        fadeIn.setOnFinished(e -> id_spLock.setVisible(false));
        fadeIn.play();
    }

}

