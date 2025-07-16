package uz.lb.caches.imageCaches.title;

import javafx.scene.image.Image;

public class ImageCacheTitleDark implements ImageCacheTitle {
    private static Image imageFullScreen;
    private static Image imageUnFullScreen;
    private static Image imageMinimize;
    private static Image imageClose;
    private static Image imageDefault;
    private static Image imageLogo;
    private static final ImageCacheTitleDark INSTANCE = new ImageCacheTitleDark();

    private ImageCacheTitleDark() {
    }

    public static ImageCacheTitleDark getInstance() {
        return INSTANCE;
    }

    @Override
    public Image getImageLogo() {
        if (imageFullScreen == null) {
            imageFullScreen = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/logo-dark.png").toExternalForm());
        }
        return imageFullScreen;
    }

    @Override
    public Image getImageFullScreen() {
        if (imageFullScreen == null) {
            imageFullScreen = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/full-screen-dark.png").toExternalForm());
        }
        return imageFullScreen;
    }

    @Override
    public Image getImageUnFullScreen() {
        if (imageUnFullScreen == null) {
            imageUnFullScreen = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/un-full-screen-dark.png").toExternalForm());
        }
        return imageUnFullScreen;
    }

    @Override
    public Image getImageMinimize() {
        if (imageMinimize == null) {
            imageMinimize = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm());
        }
        return imageMinimize;
    }

    @Override
    public Image getImageClose() {
        if (imageClose == null) {
            imageClose = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/close-dark-red-2.png").toExternalForm());
        }
        return imageClose;
    }

    @Override
    public Image getImageDefaultClose() {
        if (imageDefault == null) {
            imageDefault = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
        }
        return imageDefault;
    }

    @Override
    public Image getImageDefaultFullScreen() {
        if (imageDefault == null) {
            imageDefault = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
        }
        return imageDefault;
    }

    @Override
    public Image getImageDefaultMinimize() {
        if (imageDefault == null) {
            imageDefault = new Image(ImageCacheTitleDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
        }
        return imageDefault;
    }

}
