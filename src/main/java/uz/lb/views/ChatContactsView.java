package uz.lb.views;

import javafx.application.Platform;
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
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.models.Contact;
import uz.lb.utils.theme.ThemeBinder;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Supplier;

public class ChatContactsView implements Initializable {
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

    private boolean locked = true;
    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        imageMap.put(id_ivSearchClose, () -> ImageCacheManager.getImageCacheContacts().getImageUnLock());

        ThemeBinder.bind(id_apContacts, "/css/chat-contacts/chat-contacts-dark.css", "/css/chat-contacts/chat-contacts-light.css", imageMap);

        searchFieldHover();

        id_ivSearchClose.setOnMouseClicked(e -> {
            if (locked) {
                id_tfSearch.clear();
                if (id_ivSearchClose.isHover()) {
                    id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLockHover());
                } else {
                    id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLock());
                }
            } else {
                ControllerRegistry.getDashboardController().changeLockWindow("/fxml/Login.fxml");
            }
        });


        List<Contact> contactList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Contact contact = new Contact();
//            contact.setName(contact.getName() + "132456kbj " + i);
//
//            contact.setMessage(contact.getMessage() + " " + i + "132456kbj132456kbj132456kbj132456kbj132456kbj");
            contactList.add(contact);
        }


        for (Contact contact : contactList) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/temp/ContactCard.fxml"));
                Node contactNode = loader.load();


                ContactCardView controller = loader.getController();
                Image image = new Image(getClass().getResourceAsStream("/images/mv.png"));
//                controller.setName(contact.getName());
//                controller.setMessage(contact.getMessage());
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
            id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLock());
        });

        id_ivSearchClose.setOnMouseMoved(m -> {
            id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLockHover());
        });

    }


    private void updateCloseIcon() {
        if (!id_tfSearch.getText().isEmpty()) {
            locked = true;
            id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageClose());

            id_ivSearchClose.hoverProperty().addListener(l -> {

                id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageClose());
            });

            id_ivSearchClose.setOnMouseMoved(m -> {
                id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageCloseHover());
            });
        } else {
            locked = false;
            id_ivSearchClose.hoverProperty().addListener(l -> {
                id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLock());
            });

            id_ivSearchClose.setOnMouseMoved(m -> {
                id_ivSearchClose.setImage(ImageCacheManager.getImageCacheContacts().getImageUnLockHover());
            });
        }
    }

}
