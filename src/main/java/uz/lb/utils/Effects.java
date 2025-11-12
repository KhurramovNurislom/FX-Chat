package uz.lb.utils;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
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
        node.setOnMouseEntered(e ->{

        });
        node.setOnMouseExited(e ->{

        });
    }
}
