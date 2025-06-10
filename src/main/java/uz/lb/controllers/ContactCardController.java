package uz.lb.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import uz.lb.caches.ImageCache;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactCardController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
