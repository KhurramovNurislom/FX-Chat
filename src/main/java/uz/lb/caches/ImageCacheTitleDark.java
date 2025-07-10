package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheTitleDark {
    private static Image imageFullScreen;
    private static Image imageUnFullScreen;
    private static Image imageMinimize;
    private static Image imageCloseRed;
    private static Image imageDefault;
    private static Image imageCloseRedDefault;

    public static Image getImageFullScreen() {
        if (imageFullScreen == null) {
            imageFullScreen = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/full-screen-dark.png").toExternalForm());
        }
        return imageFullScreen;
    }

    public static Image getImageUnFullScreen() {
        if (imageUnFullScreen == null) {
            imageUnFullScreen = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/un-full-screen-dark.png").toExternalForm());
        }
        return imageUnFullScreen;
    }

    public static Image getImageMinimize() {
        if (imageMinimize == null) {
            imageMinimize = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm());
        }
        return imageMinimize;
    }

    public static Image getImageCloseRed() {
        if (imageCloseRed == null) {
            imageCloseRed = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/close-dark-red-2.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRed;
    }

    public static Image getImageCloseRedDefault() {
        if (imageCloseRedDefault == null) {
            imageCloseRedDefault = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/close-dark-red.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRedDefault;
    }

    public static Image getImageDefault() {
        if (imageDefault == null) {
            imageDefault = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
        }
        return imageDefault;
    }
}
