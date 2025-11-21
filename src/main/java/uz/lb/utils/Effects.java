package uz.lb.utils;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Effects {
    public static void rotateLogo(ImageView imageView) {

        RotateTransition rotate = new RotateTransition(Duration.seconds(7), imageView);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setAutoReverse(false);
        rotate.play();
    }

    public static void blurEffect(Node node, Double timeSecond, Integer blurDegree) {
        GaussianBlur blur = new GaussianBlur(0);
        node.setEffect(blur);

        Timeline blurAnimation = new Timeline(
                new KeyFrame(Duration.seconds(timeSecond),
                        new KeyValue(blur.radiusProperty(), blurDegree))
        );
        blurAnimation.play();
    }

    public static void hover(Node node, String color, String colorHover) {
        node.setOnMouseEntered(e -> {

        });
        node.setOnMouseExited(e -> {

        });
    }

    public static void customLogoAnimation(ImageView imageView) {

        // --- Boshlang'ich pozitsiya ---
        double originalY = imageView.getTranslateY();

        Timeline timeline = new Timeline(
                // 1) 3 soniya jim turish
                new KeyFrame(Duration.seconds(0), new KeyValue(imageView.translateYProperty(), originalY)),
                new KeyFrame(Duration.seconds(3), new KeyValue(imageView.translateYProperty(), originalY)),

                // 2) 2 soniya davomida 20 px yuqoriga-pastga siljish
                new KeyFrame(Duration.seconds(3), new KeyValue(imageView.translateYProperty(), originalY - 20)),
                new KeyFrame(Duration.seconds(3.5), new KeyValue(imageView.translateYProperty(), originalY + 20)),

                // 3) 2 soniya davomida 15 px yuqoriga-pastga siljish
                new KeyFrame(Duration.seconds(3.8), new KeyValue(imageView.translateYProperty(), originalY - 15)),
                new KeyFrame(Duration.seconds(4.1), new KeyValue(imageView.translateYProperty(), originalY + 15)),

                // 4) 3 soniya jim turish
                new KeyFrame(Duration.seconds(4.2), new KeyValue(imageView.translateYProperty(), originalY))
        );

        timeline.play();
    }

    /******************************************/
    public static void settingButtonHover(JFXButton btn, ImageView imageView, Image image, Image imageHover, Image imageHasCount,
                                          Image imageHasCountHover, Label lbl, String color, String colorHover) {

        lbl.setStyle("-fx-background-color: " + color);

        if (lbl.isVisible()) {
            imageView.setImage(imageHasCount);

            btn.setOnMouseExited(l -> {
                imageView.setImage(imageHasCount);
                lbl.setStyle("-fx-background-color: " + color);
            });

            btn.setOnMouseEntered(m -> {
                imageView.setImage(imageHasCountHover);
                lbl.setStyle("-fx-background-color: " + colorHover);
            });

        } else {
            imageView.setImage(image);

            btn.setOnMouseExited(l -> {
                imageView.setImage(image);
                lbl.setStyle("-fx-background-color: " + color);
            });

            btn.setOnMouseEntered(m -> {
                imageView.setImage(imageHover);
                lbl.setStyle("-fx-background-color: " + colorHover);
            });
        }
    }
}
