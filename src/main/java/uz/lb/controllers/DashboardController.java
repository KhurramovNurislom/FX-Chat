package uz.lb.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import uz.lb.FXChat;
import uz.lb.caches.ImageCache;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

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
    private AnchorPane id_bpChats;
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
        fade = new FadeTransition(Duration.seconds(0.25));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FXChat.setTitlePane(id_apTitlePane);
        slide.setNode(id_vbSettings);

        fade.setNode(id_apShadow);

        titleHover();
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
        slide.setFromX(-2);
        slide.setToX(280);
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

            slide.setFromX(280);
            slide.setToX(-2);
            slide.play();

            fade.setFromValue(0.4);
            fade.setToValue(0.0);
            fade.play();

            fade.setOnFinished(ev -> id_apShadow.setVisible(false));
        });
    }

    private void hoverFullScreen() {
        isFullScreen = !isFullScreen;

        if (!isFullScreen) {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCache.getImageFullScreenDark());
            });
        } else {
            id_ivFullScreen.setOnMouseMoved(m -> {
                id_ivFullScreen.setImage(ImageCache.getImageUnFullScreenDark());
            });
        }
    }

    private void titleHover() {
        id_ivFullScreen.hoverProperty().addListener(l -> {
            id_ivFullScreen.setImage(ImageCache.getImageDefaultDark());
        });

        id_ivFullScreen.setOnMouseMoved(m -> {
            id_ivFullScreen.setImage(ImageCache.getImageFullScreenDark());
        });

        id_ivClose.hoverProperty().addListener(l -> {
            id_ivClose.setImage(ImageCache.getImageDefaultDark());
        });

        id_ivClose.setOnMouseMoved(m -> {
            id_ivClose.setImage(ImageCache.getImageCloseRed());
        });

        id_ivMinimize.hoverProperty().addListener(l -> {
            id_ivMinimize.setImage(ImageCache.getImageDefaultDark());
        });

        id_ivMinimize.setOnMouseMoved(m -> {
            id_ivMinimize.setImage(ImageCache.getImageMinimizeDark());
        });
    }
}

