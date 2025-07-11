package uz.lb.caches.imageCaches.title;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;

public class ImageCacheTitleLight implements ImageCacheTitle {
    private static Image imageFullScreen;
    private static Image imageUnFullScreen;
    private static Image imageMinimize;
    private static Image imageClose;
    private static Image imageDefaultMinimize;
    private static Image imageDefaultFullScreen;
    private static Image imageDefaultClose;

    private static final ImageCacheTitleLight INSTANCE = new ImageCacheTitleLight();

    private ImageCacheTitleLight() {
    }

    public static ImageCacheTitleLight getInstance() {
        return INSTANCE;
    }

    @Override
    public  Image getImageFullScreen() {
        if (imageFullScreen == null) {
            imageFullScreen = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/full-screen-light.png").toExternalForm());
        }
        return imageFullScreen;
    }

    @Override
    public Image getImageUnFullScreen() {
        if (imageUnFullScreen == null) {
            imageUnFullScreen = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/un-full-screen-light.png").toExternalForm());
        }
        return imageUnFullScreen;
    }

    @Override
    public Image getImageMinimize() {
        if (imageMinimize == null) {
            imageMinimize = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/minimize-light.png").toExternalForm());
        }
        return imageMinimize;
    }

    @Override
    public Image getImageClose() {
        if (imageClose == null) {
            imageClose = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/close-dark-red-3.png").toExternalForm(), 32, 32, true, true);
        }
        return imageClose;
    }

    @Override
    public Image getImageDefaultClose() {
        if (imageDefaultClose == null) {
            imageDefaultClose = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/close-dark-red.png").toExternalForm(), 32, 32, true, true);
        }
        return imageDefaultClose;
    }


    @Override
    public Image getImageDefaultFullScreen() {
        if (imageDefaultFullScreen == null) {
            imageDefaultFullScreen = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/default-full-screen-light.png").toExternalForm());
        }
        return imageDefaultFullScreen;
    }

    @Override
    public Image getImageDefaultMinimize() {
        if (imageDefaultMinimize == null) {
            imageDefaultMinimize = new Image(ImageCacheTitleLight.class.getResource("/images/dashboard/title-pane/default-minimize-light.png").toExternalForm());
        }
        return imageDefaultMinimize;
    }



}
