package uz.lb.controllers;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import uz.lb.FXChat;
import uz.lb.caches.ImageCacheContactsDark;
import uz.lb.caches.ImageCacheContactsDark;
import uz.lb.models.Contact;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChatContactsController implements Initializable {
    @FXML
    private ScrollPane id_spContacts;
    @FXML
    private AnchorPane id_apSearch;
    @FXML
    private ScrollBar id_sbScrollContacts;
    @FXML
    private AnchorPane id_apContacts;
    @FXML
    private TextField id_tfSearch;
    @FXML
    private ImageView id_ivSearchClose;
    @FXML
    private VBox id_vbContacts;

    private boolean isUnlock = true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        searchFieldHover();

        id_ivSearchClose.setOnMouseClicked(e -> {
            if (isUnlock) {
                FXChat.Lock("/fxml/Login.fxml");
            } else {
                id_tfSearch.clear();
                id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleUnLockDark());
            }
        });

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
                Node contactNode = loader.load();


                ContactCardController controller = loader.getController();
                Image image = new Image(getClass().getResourceAsStream("/images/mv.png"));
                controller.setName(contact.getName());
                controller.setMessage(contact.getMessage());
                controller.setAvatarImage(image);
                id_vbContacts.getChildren().add(contactNode);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        id_spContacts.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        id_spContacts.setOnMouseEntered(l -> {
            id_spContacts.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        });

        id_spContacts.setOnMouseExited(m -> {
            id_spContacts.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });

        Platform.runLater(() -> {
            if (id_spContacts.isHover()) {
                id_spContacts.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            }
        });

    }

    private void searchFieldHover() {

        id_tfSearch.focusedProperty().addListener((obs, oldVal, newVal) -> updateCloseIcon());
        id_tfSearch.textProperty().addListener((obs, oldText, newText) -> updateCloseIcon());

        id_ivSearchClose.hoverProperty().addListener(l -> {
            id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleUnLockDarkHover());
        });

        id_ivSearchClose.setOnMouseMoved(m -> {
            id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleUnLockDark());
        });

    }

    private void updateCloseIcon() {
        if (!id_tfSearch.getText().isEmpty()) {
            isUnlock = false;
            id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleCloseDarkHover());

            id_ivSearchClose.hoverProperty().addListener(l -> {
                id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleCloseDarkHover());
            });

            id_ivSearchClose.setOnMouseMoved(m -> {
                id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleCloseDark());
            });
        } else {
            isUnlock = true;
            id_ivSearchClose.hoverProperty().addListener(l -> {
                id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleUnLockDarkHover());
            });

            id_ivSearchClose.setOnMouseMoved(m -> {
                id_ivSearchClose.setImage(ImageCacheContactsDark.getImageCircleUnLockDark());
            });
        }
    }

}
