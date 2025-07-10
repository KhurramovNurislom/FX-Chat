package uz.lb.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import uz.lb.utils.ImageCompressor;
import uz.lb.utils.ThemeBinder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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

//        ThemeBinder.bind(
//                id_apDashboard,
//                "/css/dashboard/dashboard-dark.css",
//                "/css/dashboard/dashboard-light.css"
//        );


        File file = ImageCompressor.saveProfileAvatar("E:\\test.jpg", 0.4f);
        Image image = new Image(file.toURI().toString());


        id_crAvatar.setFill(new ImagePattern(image));



        id_hbContactCard.setOnMouseEntered(e -> {

        });



        id_hbContactCard.setOnMouseExited(e -> {

        });
    }
}
