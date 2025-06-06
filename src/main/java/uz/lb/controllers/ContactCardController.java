package uz.lb.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uz.lb.caches.ImageCache;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactCardController implements Initializable {

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
