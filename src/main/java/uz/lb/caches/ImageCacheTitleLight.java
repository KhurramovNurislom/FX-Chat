package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheTitleLight {
    private static Image imageFullScreen;
    private static Image imageUnFullScreen;
    private static Image imageMinimize;
    private static Image imageCloseRed;
    private static Image imageDefaultMinimize;
    private static Image imageDefaultFullScreen;
    private static Image imageDefaultCloseRed;

    public static Image getImageFullScreen() {
        if (imageFullScreen == null) {
            imageFullScreen = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/full-screen-light.png").toExternalForm());
        }
        return imageFullScreen;
    }

    public static Image getImageUnFullScreen() {
        if (imageUnFullScreen == null) {
            imageUnFullScreen = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/un-full-screen-light.png").toExternalForm());
        }
        return imageUnFullScreen;
    }

    public static Image getImageMinimize() {
        if (imageMinimize == null) {
            imageMinimize = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/minimize-light.png").toExternalForm());
        }
        return imageMinimize;
    }

    public static Image getImageCloseRed() {
        if (imageCloseRed == null) {
            imageCloseRed = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/close-dark-red-3.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRed;
    }

    public static Image getImageDefaultCloseRed() {
        if (imageDefaultCloseRed == null) {
            imageDefaultCloseRed = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/close-dark-red.png").toExternalForm(), 32, 32, true, true);
        }
        return imageDefaultCloseRed;
    }

    public static Image getImageDefaultFullScreen() {
        if (imageDefaultFullScreen == null) {
            imageDefaultFullScreen = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/default-full-screen-light.png").toExternalForm());
        }
        return imageDefaultFullScreen;
    }

    public static Image getImageDefaultMinimize() {
        if (imageDefaultMinimize == null) {
            imageDefaultMinimize = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/default-minimize-light.png").toExternalForm());
        }
        return imageDefaultMinimize;
    }


}
