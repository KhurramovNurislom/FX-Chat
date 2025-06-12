package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import uz.lb.FXChat;
import uz.lb.caches.ImageCacheDark;
import uz.lb.caches.ImageCacheLight;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


    public HBox id_hbCountAllChats;
    public AnchorPane id_apRoot;
    public StackPane stackPane;
    public Pane id_pnSettingsContainer;
    @FXML
    private Label id_lblChatPerson;
    @FXML
    private Label id_lblAllChats;
    @FXML
    private Label id_lblUnreadChats;

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
    private VBox id_vbSettings;

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
    private final TranslateTransition slide;
    private final FadeTransition fade;


    public DashboardController() {
        slide = new TranslateTransition(Duration.seconds(0.25));
        slide.setInterpolator(Interpolator.EASE_BOTH);
        fade = new FadeTransition(Duration.seconds(0.25));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Rectangle clip = new Rectangle();
        clip.setWidth(id_pnSettingsContainer.getWidth());
        clip.setHeight(id_pnSettingsContainer.getHeight());
        id_pnSettingsContainer.setClip(clip);

// Dinamik o'zgartirish uchun listener qo'shish mumkin:
        id_pnSettingsContainer.widthProperty().addListener((obs, oldVal, newVal) -> clip.setWidth(newVal.doubleValue()));
        id_pnSettingsContainer.heightProperty().addListener((obs, oldVal, newVal) -> clip.setHeight(newVal.doubleValue()));




        id_lblChatPerson.setVisible(true);
        id_lblChatPerson.setText("1111");
        
        FXChat.setTitlePane(id_apTitlePane);
        FXChat.setLockPane(id_spLock);

        slide.setNode(id_vbSettings);

        fade.setNode(id_apShadow);

        titleHover();
        settingHover();

        setupWindowControls();

        id_btnMenu.setOnAction(e -> toggleSettingsPane());

    }

    private void setupWindowControls() {
        id_ivFullScreen.setOnMouseClicked(e -> {
            FXChat.FullScreen();
            hoverFullScreen();
        });

        id_ivClose.setOnMouseClicked(e -> System.exit(1));

        id_ivMinimize.setOnMouseClicked(e -> FXChat.Minimize());
    }

    private void toggleSettingsPane() {
        slide.setFromX(0);
        slide.setToX(270);
        slide.play();

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

            slide.setFromX(270);
            slide.setToX(0);
            slide.play();

            fade.setFromValue(0.5);
            fade.setToValue(0.0);
            fade.play();

            fade.setOnFinished(ev -> id_apShadow.setVisible(false));
        });
    }


    private void hoverFullScreen() {
        isFullScreen = !isFullScreen;

        if (!isFullScreen) {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCacheDark.getImageFullScreenDark());

            });
        } else {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCacheDark.getImageUnFullScreenDark());
            });
        }
    }

    private void settingHover() {
        id_btnMenu.setOnMouseExited(l -> {
            id_ivMenu.setImage(ImageCacheDark.getImageMenu());
        });

        id_btnMenu.setOnMouseEntered(m -> {
            id_ivMenu.setImage(ImageCacheDark.getImageMenuHover());
        });

        id_btnPersonalChat.setOnMouseExited(l -> {
            id_lblChatPerson.getStyleClass().remove("count-label-hover");
            id_lblChatPerson.getStyleClass().add("count-label");
            id_ivPersonalChat.setImage(ImageCacheDark.getImageCirclePerson());
        });

        id_btnPersonalChat.setOnMouseEntered(m -> {
            id_lblChatPerson.getStyleClass().remove("count-label");
            id_lblChatPerson.getStyleClass().add("count-label-hover");
            id_ivPersonalChat.setImage(ImageCacheDark.getImageCirclePersonHover());
        });


        id_btnAllChats.setOnMouseExited(l -> {
            id_lblAllChats.getStyleClass().remove("count-label");
            id_lblAllChats.getStyleClass().add("count-label-hover");
            id_ivAllChats.setImage(ImageCacheDark.getImageAllChats());
        });

        id_btnAllChats.setOnMouseEntered(m -> {
            id_lblAllChats.getStyleClass().add("count-label-hover");
            id_lblAllChats.getStyleClass().remove("count-label");
            id_ivAllChats.setImage(ImageCacheDark.getImageAllChatsHover());
        });


        id_btnUnreadChats.setOnMouseExited(l -> {
            id_lblUnreadChats.getStyleClass().remove("count-label");
            id_lblUnreadChats.getStyleClass().add("count-label-hover");
            id_ivUnreadChats.setImage(ImageCacheDark.getImageChat());
        });

        id_btnUnreadChats.setOnMouseEntered(m -> {
            id_lblUnreadChats.getStyleClass().add("count-label-hover");
            id_lblUnreadChats.getStyleClass().remove("count-label");
            id_ivUnreadChats.setImage(ImageCacheDark.getImageChatHover());
        });

    }

    private void titleHover() {
        id_ivFullScreen.setOnMouseExited(l -> {
            id_ivFullScreen.setImage(ImageCacheDark.getImageDefaultDark());
        });

        id_ivFullScreen.setOnMouseEntered(m -> {
            id_ivFullScreen.setImage(ImageCacheDark.getImageFullScreenDark());
        });

        id_ivClose.setOnMouseExited(l -> {
            id_ivClose.setImage(ImageCacheDark.getImageDefaultDark());
        });

        id_ivClose.setOnMouseEntered(m -> {
            id_ivClose.setImage(ImageCacheDark.getImageCloseRed());
        });

        id_ivMinimize.setOnMouseExited(l -> {
            id_ivMinimize.setImage(ImageCacheDark.getImageDefaultDark());
        });

        id_ivMinimize.setOnMouseEntered(m -> {
            id_ivMinimize.setImage(ImageCacheDark.getImageMinimizeDark());
        });
    }


    public void openWindow() {
        try {
            // Login.fxml faylini yuklash
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
            Parent loginRoot = loader.load();

            // Login controllerga murojaat qilish (ixtiyoriy)
            LoginController loginController = loader.getController();

            // Yangi oynani yaratish
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(loginRoot));

            // Dashboard oynasini o‘chirib yubormasdan yangi oynani ochamiz
            loginStage.initOwner(id_apDashboard.getScene().getWindow()); // Dashboard oynasi parent bo‘ladi

            // MODAL EMAS qilish uchun quyidagini **yozmaymiz** yoki WINDOW_MODAL o‘rniga NONE:
            // loginStage.initModality(Modality.WINDOW_MODAL);

            loginStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

