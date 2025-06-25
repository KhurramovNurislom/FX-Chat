package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import uz.lb.FXChat;
import uz.lb.caches.ImageCacheSettingDark;
import uz.lb.caches.ImageCacheTitleDark;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {


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


    public DashboardController() {
        fade = new FadeTransition(Duration.millis(250));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_lblChatPerson.setVisible(true);
        id_lblChatPerson.setText("1111");

        FXChat.setTitlePane(id_apTitlePane);
        FXChat.setLockPane(id_spLock);

        fade.setNode(id_apShadow);

        titleHover();

        settingHover();

        setupWindowControls();

        id_btnMenu.setOnAction(e -> {
            openDrawer();
        });


    }

    private void setupWindowControls() {
        id_ivFullScreen.setOnMouseClicked(e -> {
            FXChat.FullScreen();
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

        id_ivMinimize.setOnMouseClicked(e -> FXChat.Minimize());
    }

    public void openDrawer() {
        TranslateTransition open = new TranslateTransition(Duration.millis(250), id_drSettings);
        open.setToX(0);
        open.play();
        toggleSettingsPane();

        id_dsSettings.setMouseTransparent(false);
    }


    public void closeDrawer() {
        TranslateTransition close = new TranslateTransition(Duration.millis(250), id_drSettings);
        close.setToX(-272);
        close.play();

        id_dsSettings.setMouseTransparent(true);
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
                id_ivFullScreen.setImage(ImageCacheTitleDark.getImageFullScreenDark());
                System.out.println("");

            });
        } else {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCacheTitleDark.getImageUnFullScreenDark());

            });
        }

    }

    private void settingHover() {
        id_btnMenu.setOnMouseExited(l -> {
            id_ivMenu.setImage(ImageCacheSettingDark.getImageMenu());
        });

        id_btnMenu.setOnMouseEntered(m -> {
            id_ivMenu.setImage(ImageCacheSettingDark.getImageMenuHover());
        });

        id_btnPersonalChat.setOnMouseExited(l -> {
            id_lblChatPerson.getStyleClass().remove("count-label-hover");
            id_lblChatPerson.getStyleClass().add("count-label");
            id_ivPersonalChat.setImage(ImageCacheSettingDark.getImageCirclePerson());
        });

        id_btnPersonalChat.setOnMouseEntered(m -> {
            id_lblChatPerson.getStyleClass().remove("count-label");
            id_lblChatPerson.getStyleClass().add("count-label-hover");
            id_ivPersonalChat.setImage(ImageCacheSettingDark.getImageCirclePersonHover());
        });


        id_btnAllChats.setOnMouseExited(l -> {
            id_lblAllChats.getStyleClass().remove("count-label");
            id_lblAllChats.getStyleClass().add("count-label-hover");
            id_ivAllChats.setImage(ImageCacheSettingDark.getImageAllChats());
        });

        id_btnAllChats.setOnMouseEntered(m -> {
            id_lblAllChats.getStyleClass().add("count-label-hover");
            id_lblAllChats.getStyleClass().remove("count-label");
            id_ivAllChats.setImage(ImageCacheSettingDark.getImageAllChatsHover());
        });


        id_btnUnreadChats.setOnMouseExited(l -> {
            id_lblUnreadChats.getStyleClass().remove("count-label");
            id_lblUnreadChats.getStyleClass().add("count-label-hover");
            id_ivUnreadChats.setImage(ImageCacheSettingDark.getImageChat());
        });

        id_btnUnreadChats.setOnMouseEntered(m -> {
            id_lblUnreadChats.getStyleClass().add("count-label-hover");
            id_lblUnreadChats.getStyleClass().remove("count-label");
            id_ivUnreadChats.setImage(ImageCacheSettingDark.getImageChatHover());
        });

    }

    private void titleHover() {
        id_ivFullScreen.setOnMouseExited(l -> {
            id_ivFullScreen.setImage(ImageCacheTitleDark.getImageDefaultDark());
        });

        id_ivFullScreen.setOnMouseEntered(m -> {
            id_ivFullScreen.setImage(ImageCacheTitleDark.getImageFullScreenDark());
        });

        id_ivClose.setOnMouseExited(l -> {
            id_ivClose.setImage(ImageCacheTitleDark.getImageDefaultDark());
        });

        id_ivClose.setOnMouseEntered(m -> {
            id_ivClose.setImage(ImageCacheTitleDark.getImageCloseRed());
        });

        id_ivMinimize.setOnMouseExited(l -> {
            id_ivMinimize.setImage(ImageCacheTitleDark.getImageDefaultDark());
        });

        id_ivMinimize.setOnMouseEntered(m -> {
            id_ivMinimize.setImage(ImageCacheTitleDark.getImageMinimizeDark());
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

