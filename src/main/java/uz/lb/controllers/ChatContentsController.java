package uz.lb.controllers;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.models.Contact;
import uz.lb.utils.theme.ThemeBinder;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

public class ChatContentsController implements Initializable {

    @FXML
    private ImageView id_ivInfo;
    @FXML
    private ImageView id_ivSettingChat;
    @FXML
    private ImageView id_ivSearch;
    @FXML
    private ImageView id_ivCall;
    @FXML
    private VBox id_vbUserData;
    @FXML
    private Label id_lblUserName;
    @FXML
    private Label id_lblLastTime;
    @FXML
    private ScrollPane id_spMessages;
    @FXML
    private VBox id_vbMessages;
    @FXML
    private HBox id_hbTypingMessage;
    @FXML
    private ImageView id_ivFileChooser;
    @FXML
    private TextArea id_taMessageContent;
    @FXML
    private ImageView id_ivMicAndSend;
    @FXML
    private ImageView id_ivSticker;
    @FXML
    private BorderPane id_bpChatContents;
    @FXML
    private AnchorPane id_apNoThinks;
    @FXML
    private StackPane id_spNoThinks;
    @FXML
    private Label id_lblNoThinks;

    @FXML
    private AnchorPane id_apChatContents;
    @FXML
    private VBox id_vbChatContent;
    @FXML
    private ImageView id_ivBackground;
    @FXML
    private StackPane id_spBackground;
    @FXML
    private AnchorPane id_apBackground;
    @FXML
    private ScrollBar id_sbScrollContents;
    @FXML
    private AnchorPane id_apCenter;
    @FXML
    private AnchorPane id_pnInterlocutorProperties;
    @FXML
    private AnchorPane id_pnMessageTypes;

    private Integer chatId = null;


    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ControllerRegistry.setChatContentsController(this);

        imageMap.put(id_ivFileChooser, () -> ImageCacheManager.getImageCacheMessageContent().getImageAddFiles());
        imageMap.put(id_ivMicAndSend, () -> ImageCacheManager.getImageCacheMessageContent().getImageMic());
        imageMap.put(id_ivSticker, () -> ImageCacheManager.getImageCacheMessageContent().getImageSticker());
        imageMap.put(id_ivCall, () -> ImageCacheManager.getImageCacheMessageContent().getImagePhone());
        imageMap.put(id_ivSearch, () -> ImageCacheManager.getImageCacheMessageContent().getImageSearch());
        imageMap.put(id_ivInfo, () -> ImageCacheManager.getImageCacheMessageContent().getImageOpenInfo());
        imageMap.put(id_ivSettingChat, () -> ImageCacheManager.getImageCacheMessageContent().getImageSetting());
        imageMap.put(id_ivBackground, () -> ImageCacheManager.getImageCacheMessageContent().getImageBackground());

        ThemeBinder.bind(id_apChatContents, "/css/chat-contents/chat-contents-dark.css", "/css/chat-contents/chat-contents-light.css", imageMap);

        typingSettings();
        hover();

        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            Contact contact = new Contact();
            contact.setName(contact.getName() + "132456kbj " + i);
            contact.setMessage(contact.getMessage() + " " + i + "132456kbj132456kbj132456kbj132456kbj132456kbj");
            contactList.add(contact);
        }


        for (Contact contact : contactList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/temp/ContactCard.fxml"));
                HBox contactNode = loader.load();

                ContactCardController controller = loader.getController();
                Image image = new Image(getClass().getResourceAsStream("/images/mv.png"));
                controller.setName(contact.getName());
                controller.setMessage(contact.getMessage());
                controller.setAvatarImage(image);
                id_vbMessages.getChildren().add(contactNode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void openNoThings(Integer chatId) {
        id_apNoThinks.setVisible(false);
        System.out.println(chatId + " yozishmalar chiqishi kerak");
    }


    private void hover() {

        id_ivMicAndSend.setOnMouseExited(l -> {
            id_ivMicAndSend.setImage(ImageCacheManager.getImageCacheMessageContent().getImageMic());
        });

        id_ivMicAndSend.setOnMouseEntered(m -> {
            id_ivMicAndSend.setImage(ImageCacheManager.getImageCacheMessageContent().getImageMicHover());
        });

        id_ivFileChooser.setOnMouseExited(l -> {
            id_ivFileChooser.setImage(ImageCacheManager.getImageCacheMessageContent().getImageAddFiles());
        });

        id_ivFileChooser.setOnMouseEntered(m -> {
            id_ivFileChooser.setImage(ImageCacheManager.getImageCacheMessageContent().getImageAddFilesHover());
        });


        id_ivSticker.setOnMouseExited(l -> {
            id_ivSticker.setImage(ImageCacheManager.getImageCacheMessageContent().getImageSticker());
        });

        id_ivSticker.setOnMouseEntered(m -> {
            id_ivSticker.setImage(ImageCacheManager.getImageCacheMessageContent().getImageStickerHover());
        });

        id_ivCall.setOnMouseExited(l -> {
            id_ivCall.setImage(ImageCacheManager.getImageCacheMessageContent().getImagePhone());
        });

        id_ivCall.setOnMouseEntered(m -> {
            id_ivCall.setImage(ImageCacheManager.getImageCacheMessageContent().getImagePhoneHover());
        });

        id_ivInfo.setOnMouseExited(l -> {
            id_ivInfo.setImage(ImageCacheManager.getImageCacheMessageContent().getImageOpenInfo());
        });

        id_ivInfo.setOnMouseEntered(m -> {
            id_ivInfo.setImage(ImageCacheManager.getImageCacheMessageContent().getImageOpenInfoHover());
        });

        id_ivSearch.setOnMouseExited(l -> {
            id_ivSearch.setImage(ImageCacheManager.getImageCacheMessageContent().getImageSearch());
        });

        id_ivSearch.setOnMouseEntered(m -> {
            id_ivSearch.setImage(ImageCacheManager.getImageCacheMessageContent().getImageSearchHover());
        });

        id_ivSettingChat.setOnMouseExited(l -> {
            id_ivSettingChat.setImage(ImageCacheManager.getImageCacheMessageContent().getImageSetting());
        });

        id_ivSettingChat.setOnMouseEntered(m -> {
            id_ivSettingChat.setImage(ImageCacheManager.getImageCacheMessageContent().getImageSettingHover());
        });
    }

    private void typingSettings() {
        id_taMessageContent.setMinHeight(Region.USE_COMPUTED_SIZE);
        id_taMessageContent.setPrefHeight(Region.USE_COMPUTED_SIZE);
        id_taMessageContent.setMaxHeight(120);

        Text helper = new Text();
        helper.setFont(id_taMessageContent.getFont());

        id_taMessageContent.textProperty().addListener((obs, oldText, newText) -> {
            helper.setWrappingWidth(id_taMessageContent.getWidth() - 20);
            helper.setText(newText.isEmpty() ? " " : newText);

            double textHeight = helper.getLayoutBounds().getHeight() + 10; // padding
            double maxHeight = 120;
            double adjustedHeight = Math.min(textHeight, maxHeight);

            id_taMessageContent.setPrefHeight(adjustedHeight);

            // Force HBox height based on the tallest child (TextArea)
            id_hbTypingMessage.setMinHeight(Region.USE_PREF_SIZE);
            id_hbTypingMessage.setPrefHeight(Region.USE_COMPUTED_SIZE);
            id_hbTypingMessage.layout();
        });

    }


}
