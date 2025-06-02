package uz.lb.utils;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ResizableWindowHelper {
    private static final int RESIZE_MARGIN = 8;

    private static double startX;
    private static double startY;
    private static double startWidth;
    private static double startHeight;
    private static double windowX;
    private static double windowY;

    public static void makeResizable(Stage stage) {
        Scene scene = stage.getScene();
        if (scene == null) {
            throw new IllegalStateException("Stage must have a Scene before calling makeResizable");
        }

        scene.setOnMousePressed(e -> {
            Cursor cursor = scene.getCursor();
            if (cursor == null || cursor == Cursor.DEFAULT) return;

            startX = e.getScreenX();
            startY = e.getScreenY();

            startWidth = stage.getWidth();
            startHeight = stage.getHeight();

            windowX = stage.getX();
            windowY = stage.getY();
        });

        scene.setOnMouseDragged(e -> {
            Cursor cursor = scene.getCursor();
            if (cursor == null || cursor == Cursor.DEFAULT) return;

            double dx = e.getScreenX() - startX;
            double dy = e.getScreenY() - startY;

            double newX = windowX;
            double newY = windowY;
            double newWidth = startWidth;
            double newHeight = startHeight;

            if (cursor == Cursor.E_RESIZE || cursor == Cursor.SE_RESIZE || cursor == Cursor.NE_RESIZE) {
                newWidth += dx;
            } else if (cursor == Cursor.W_RESIZE || cursor == Cursor.SW_RESIZE || cursor == Cursor.NW_RESIZE) {
                newWidth -= dx;
                newX += dx;
            }

            if (cursor == Cursor.S_RESIZE || cursor == Cursor.SE_RESIZE || cursor == Cursor.SW_RESIZE) {
                newHeight += dy;
            } else if (cursor == Cursor.N_RESIZE || cursor == Cursor.NE_RESIZE || cursor == Cursor.NW_RESIZE) {
                newHeight -= dy;
                newY += dy;
            }

            if (newWidth >= stage.getMinWidth()) {
                stage.setWidth(newWidth);
                stage.setX(newX);
            }

            if (newHeight >= stage.getMinHeight()) {
                stage.setHeight(newHeight);
                stage.setY(newY);
            }
        });

        scene.setOnMouseMoved(e -> updateCursor(stage, scene, e.getSceneX(), e.getSceneY()));

        scene.setOnMouseReleased(e -> updateCursor(stage, scene, e.getSceneX(), e.getSceneY()));

    }

    private static void updateCursor(Stage stage, Scene scene, double mouseX, double mouseY) {
        double width = stage.getWidth();
        double height = stage.getHeight();

        Cursor cursor = Cursor.DEFAULT;

        boolean left = mouseX < RESIZE_MARGIN;
        boolean right = mouseX > width - RESIZE_MARGIN;
        boolean top = mouseY < RESIZE_MARGIN;
        boolean bottom = mouseY > height - RESIZE_MARGIN;

        if (left && top) {
            cursor = Cursor.NW_RESIZE;
        } else if (left && bottom) {
            cursor = Cursor.SW_RESIZE;
        } else if (right && top) {
            cursor = Cursor.NE_RESIZE;
        } else if (right && bottom) {
            cursor = Cursor.SE_RESIZE;
        } else if (left) {
            cursor = Cursor.W_RESIZE;
        } else if (right) {
            cursor = Cursor.E_RESIZE;
        } else if (top) {
            cursor = Cursor.N_RESIZE;
        } else if (bottom) {
            cursor = Cursor.S_RESIZE;
        }

        scene.setCursor(cursor);
    }


}
