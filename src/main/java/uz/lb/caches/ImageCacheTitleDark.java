package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheTitleDark {
    private static Image imageFullScreenDark;
    private static Image imageUnFullScreenDark;
    private static Image imageMinimizeDark;
    private static Image imageCloseRed;
    private static Image imageDefaultDark;
    private static Image imageCloseRedDefault;

    public static Image getImageFullScreenDark() {
        if (imageFullScreenDark == null) {
            imageFullScreenDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/full-screen-dark.png").toExternalForm());
        }
        return imageFullScreenDark;
    }

    public static Image getImageUnFullScreenDark() {
        if (imageUnFullScreenDark == null) {
            imageUnFullScreenDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/un-full-screen-dark.png").toExternalForm());
        }
        return imageUnFullScreenDark;
    }

    public static Image getImageMinimizeDark() {
        if (imageMinimizeDark == null) {
            imageMinimizeDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm());
        }
        return imageMinimizeDark;
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

    public static Image getImageDefaultDark() {
        if (imageDefaultDark == null) {
            imageDefaultDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
        }
        return imageDefaultDark;
    }
}
