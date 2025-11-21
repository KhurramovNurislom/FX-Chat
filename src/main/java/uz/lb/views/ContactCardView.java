package uz.lb.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import uz.lb.caches.ControllerRegistry;
import uz.lb.caches.imageCaches.ImageCacheManager;
import uz.lb.utils.ImageCompressor;
import uz.lb.utils.theme.ThemeBinder;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class ContactCardView implements Initializable {

    @FXML
    private HBox id_hbContactCard;

    @FXML
    private Circle id_crAvatar;

    @FXML
    private HBox id_hbUserInfo;

    @FXML
    private ImageView id_ivCheck;

    @FXML
    private Text id_txtTime;

    @FXML
    private Label id_lblMessageCount;

    @FXML
    private Label id_lblName;

    @FXML
    private Label id_lblLastMessage;

    @FXML
    private ImageView id_ivAvatar;


    public void setName(String name) {
        id_lblName.setText(name);
    }

    public void setMessage(String message) {
        id_lblLastMessage.setText(message);
    }

    public void setAvatarImage(Image image) {
//        id_ivAvatar.setImage(image);
    }

    Map<ImageView, Supplier<Image>> imageMap = new HashMap<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_hbContactCard.setOnMouseClicked(e -> {
            ControllerRegistry.getChatContentsController().openNoThings(123);
        });

        imageMap.put(id_ivCheck, () -> ImageCacheManager.getImageCacheContactCard().getImageUnReadCheckMessage());
        ThemeBinder.bind(
                id_hbContactCard,
                "/css/chat-contacts/contact-card/contact-card-dark.css",
                "/css/chat-contacts/contact-card/contact-card-light.css",
                imageMap
        );


        id_ivCheck.setOnMouseClicked(e -> {
            id_ivCheck.setImage(ImageCacheManager.getImageCacheContactCard().getImageUnReadDoubleCheckMessage());
            id_ivCheck.setOnMouseClicked(ex -> {
                id_ivCheck.setImage(ImageCacheManager.getImageCacheContactCard().getImageDoubleCheckMessage());
            });

        });

        File file = ImageCompressor.saveProfileAvatar("E:\\test.jpg", 0.1f);
        Image image = new Image(file.toURI().toString());


        id_crAvatar.setFill(new ImagePattern(image));


    }
}
