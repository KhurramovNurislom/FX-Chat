package uz.lb.controllers;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import uz.lb.caches.ImageCacheDark;
import uz.lb.caches.ImageCacheMessageContentDark;
import uz.lb.models.Contact;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChatContentsController implements Initializable {

    public ScrollPane id_spMessages;
    public VBox id_vbMessages;
    public HBox id_hbTypingMessage;
    public ImageView id_ivFileChooser;
    public JFXTextArea id_taMessageContent;
    public ImageView id_ivMicAndSend;
    public ImageView id_ivSticker;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_ivBackground.setMouseTransparent(true);

        typingSettings();
        hover();

        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
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

    private void hover() {

        id_ivMicAndSend.setOnMouseExited(l -> {
            id_ivMicAndSend.setImage(ImageCacheMessageContentDark.getImageMic());
        });

        id_ivMicAndSend.setOnMouseEntered(m -> {
            id_ivMicAndSend.setImage(ImageCacheMessageContentDark.getImageMicHover());
        });

        id_ivFileChooser.setOnMouseExited(l -> {
            id_ivFileChooser.setImage(ImageCacheMessageContentDark.getImageAddFiles());
        });

        id_ivFileChooser.setOnMouseEntered(m -> {
            id_ivFileChooser.setImage(ImageCacheMessageContentDark.getImageAddFilesHover());
        });


        id_ivSticker.setOnMouseExited(l -> {
            id_ivSticker.setImage(ImageCacheMessageContentDark.getImageSticker());
        });

        id_ivSticker.setOnMouseEntered(m -> {
            id_ivSticker.setImage(ImageCacheMessageContentDark.getImageStickerHover());
        });


    }

    private void typingSettings() {
        id_taMessageContent.setWrapText(true);
        id_taMessageContent.setLabelFloat(false);
        id_taMessageContent.setMinHeight(Region.USE_COMPUTED_SIZE);
        id_taMessageContent.setPrefHeight(Region.USE_COMPUTED_SIZE);
        id_taMessageContent.setMaxHeight(120);

        Text helper = new Text();
        helper.setFont(id_taMessageContent.getFont());

        id_taMessageContent.textProperty().addListener((obs, oldText, newText) -> {
            helper.setWrappingWidth(id_taMessageContent.getWidth() - 20);
            helper.setText(newText.isEmpty() ? " " : newText);

            double textHeight = helper.getLayoutBounds().getHeight() + 24; // padding
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
