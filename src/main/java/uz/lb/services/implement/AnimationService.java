package uz.lb.services.implement;

import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import javafx.util.Duration;
import uz.lb.utils.WindowBounds;

public class AnimationService {
    private static final int ANIMATION_DURATION = 200;
    
    public void animateWindowPosition(Stage stage, double targetX, double targetY) {
        DoubleProperty animX = new SimpleDoubleProperty(stage.getX());
        DoubleProperty animY = new SimpleDoubleProperty(stage.getY());
        
        animX.addListener((obs, oldVal, newVal) -> stage.setX(newVal.doubleValue()));
        animY.addListener((obs, oldVal, newVal) -> stage.setY(newVal.doubleValue()));
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(animX, stage.getX()),
                new KeyValue(animY, stage.getY())
            ),
            new KeyFrame(Duration.millis(ANIMATION_DURATION),
                new KeyValue(animX, targetX, Interpolator.EASE_BOTH),
                new KeyValue(animY, targetY, Interpolator.EASE_BOTH)
            )
        );
        timeline.play();
    }
    
    public void animateWindowBounds(Stage stage, WindowBounds targetBounds) {
        DoubleProperty animX = new SimpleDoubleProperty(stage.getX());
        DoubleProperty animY = new SimpleDoubleProperty(stage.getY());
        DoubleProperty animWidth = new SimpleDoubleProperty(stage.getWidth());
        DoubleProperty animHeight = new SimpleDoubleProperty(stage.getHeight());
        
        animX.addListener((obs, oldVal, newVal) -> stage.setX(newVal.doubleValue()));
        animY.addListener((obs, oldVal, newVal) -> stage.setY(newVal.doubleValue()));
        animWidth.addListener((obs, oldVal, newVal) -> stage.setWidth(newVal.doubleValue()));
        animHeight.addListener((obs, oldVal, newVal) -> stage.setHeight(newVal.doubleValue()));
        
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(animX, stage.getX()),
                new KeyValue(animY, stage.getY()),
                new KeyValue(animWidth, stage.getWidth()),
                new KeyValue(animHeight, stage.getHeight())
            ),
            new KeyFrame(Duration.millis(ANIMATION_DURATION),
                new KeyValue(animX, targetBounds.getX(), Interpolator.EASE_BOTH),
                new KeyValue(animY, targetBounds.getY(), Interpolator.EASE_BOTH),
                new KeyValue(animWidth, targetBounds.getWidth(), Interpolator.EASE_BOTH),
                new KeyValue(animHeight, targetBounds.getHeight(), Interpolator.EASE_BOTH)
            )
        );
        timeline.play();
    }
}