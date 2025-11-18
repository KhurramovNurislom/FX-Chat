package uz.lb.caches.windowParametrCaches;

import javafx.beans.property.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;
import uz.lb.utils.ResizableWindowHelper;

public class WindowManager {

    // 1. SINGLETON CORE
    private static WindowManager instance;

    // 2. PRIVATE CONSTRUCTOR
    private WindowManager() {}

    // 3. GLOBAL ACCESS POINT
    public static WindowManager getInstance() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
    }

    // FIELD LAR - endi private
    private Stage stage;
    private Pane titlePane;
    private boolean isFullScreen = false;

    // Snap/Maximize uchun
    private double prevX, prevY, prevW, prevH;
    private boolean snappedOrMaximized = false;
    private static final double SNAP_THRESHOLD = 20;

    // Animatsiya uchun
    private final DoubleProperty animX = new SimpleDoubleProperty();
    private final DoubleProperty animY = new SimpleDoubleProperty();

    // Fullscreen uchun eski holat
    private final DoubleProperty x_point = new SimpleDoubleProperty();
    private final DoubleProperty y_point = new SimpleDoubleProperty();
    private final DoubleProperty w_point = new SimpleDoubleProperty();
    private final DoubleProperty h_point = new SimpleDoubleProperty();

    // Drag uchun
    private final DoubleProperty dragX = new SimpleDoubleProperty();
    private final DoubleProperty dragY = new SimpleDoubleProperty();

    // INITIALIZE METHOD
    public void initialize(Stage stage, Pane titlePane) {
        this.stage = stage;
        this.titlePane = titlePane;
        setupEventHandlers();
        initStageBindings();
    }

    private void setupEventHandlers() {
        // Drag handlers
        titlePane.setOnMousePressed(this::onMousePressed);
        titlePane.setOnMouseDragged(this::onMouseDragged);

        // Snap handler
        titlePane.setOnMouseReleased(e -> {
            snapIfNearEdges(e.getScreenX(), e.getScreenY());
        });

        // Double-click handler
        titlePane.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                handleDoubleClick(e.getScreenX(), e.getScreenY());
            }
        });

        // Resize helper
        ResizableWindowHelper.makeResizable(stage);
    }

    // METHOD LAR - sizning mavjud methodlaringiz, lekin endi instance methodlar
    private void onMousePressed(MouseEvent e) {
        if (snappedOrMaximized) {
            double ratioX = e.getX() / stage.getWidth();
            double ratioY = e.getY() / stage.getHeight();

            stage.setWidth(prevW);
            stage.setHeight(prevH);
            stage.setX(e.getScreenX() - prevW * ratioX);
            stage.setY(e.getScreenY() - prevH * ratioY);

            snappedOrMaximized = false;
        }

        dragX.set(e.getSceneX());
        dragY.set(e.getSceneY());
    }

    private void onMouseDragged(MouseEvent e) {
        stage.setX(e.getScreenX() - dragX.get());
        stage.setY(e.getScreenY() - dragY.get());
    }

    private void handleDoubleClick(double screenX, double screenY) {
        if (snappedOrMaximized) {
            restorePreviousBounds();
        } else {
            maximizeToScreen(screenX, screenY);
        }
    }

    private void maximizeToScreen(double screenX, double screenY) {
        Screen screen = getScreenForMouse(screenX, screenY);
        Rectangle2D bounds = screen.getVisualBounds();

        prevX = stage.getX();
        prevY = stage.getY();
        prevW = stage.getWidth();
        prevH = stage.getHeight();
        snappedOrMaximized = true;

        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        animateStageXY(bounds.getMinX(), bounds.getMinY());
    }

    private void snapIfNearEdges(double mouseScreenX, double mouseScreenY) {
        Screen currentScreen = getScreenForMouse(mouseScreenX, mouseScreenY);
        Rectangle2D bounds = currentScreen.getVisualBounds();

        if (!snappedOrMaximized) {
            prevX = stage.getX();
            prevY = stage.getY();
            prevW = stage.getWidth();
            prevH = stage.getHeight();
        }

        // ... sizning snap logikangiz
        // Tepaga, chapga, o'ngga snap qilish
    }

    private void animateStageXY(double targetX, double targetY) {
        animX.set(stage.getX());
        animY.set(stage.getY());

        Timeline tl = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(animX, stage.getX()),
                        new KeyValue(animY, stage.getY())
                ),
                new KeyFrame(Duration.millis(200),
                        new KeyValue(animX, targetX, Interpolator.EASE_BOTH),
                        new KeyValue(animY, targetY, Interpolator.EASE_BOTH)
                )
        );
        tl.play();
    }

    private void initStageBindings() {
        animX.addListener((obs, oldVal, newVal) -> stage.setX(newVal.doubleValue()));
        animY.addListener((obs, oldVal, newVal) -> stage.setY(newVal.doubleValue()));
    }

    private Screen getScreenForMouse(double mouseX, double mouseY) {
        for (Screen screen : Screen.getScreens()) {
            Rectangle2D b = screen.getBounds();
            if (b.contains(mouseX, mouseY)) {
                return screen;
            }
        }
        return Screen.getPrimary();
    }

    private void restorePreviousBounds() {
        if (!snappedOrMaximized) return;
        snappedOrMaximized = false;
        stage.setWidth(prevW);
        stage.setHeight(prevH);
        animateStageXY(prevX, prevY);
    }

    // PUBLIC API - FXML controllerlar uchun
    public static void minimize() {
        getInstance()._minimize();
    }

    public static void toggleFullScreen() {
        getInstance()._toggleFullScreen();
    }

    public static void close() {
        getInstance()._close();
    }

    // PRIVATE IMPLEMENTATION
    private void _minimize() {
        if (stage != null) {
            stage.setIconified(true);
        }
    }

    private void _toggleFullScreen() {
        if (stage != null) {
            if (!isFullScreen) {
                // fullscreenga o'tish
                x_point.set(stage.getX());
                y_point.set(stage.getY());
                w_point.set(stage.getWidth());
                h_point.set(stage.getHeight());
                stage.setFullScreen(true);
            } else {
                // fullscreendan chiqish
                stage.setFullScreen(false);
                stage.setX(x_point.get());
                stage.setY(y_point.get());
                stage.setWidth(w_point.get());
                stage.setHeight(h_point.get());
            }
            isFullScreen = !isFullScreen;
        }
    }

    private void _close() {
        if (stage != null) {
            stage.close();
        }
    }

    // Getters
    public Stage getStage() {
        return stage;
    }

    public Pane getTitlePane() {
        return titlePane;
    }
}