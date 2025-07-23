package uz.lb.caches.imageCaches.setting_pane;

import javafx.scene.image.Image;

public class ImageCacheSettingPaneLight implements ImageCacheSettingPane {
    private static Image imageNightMode;
    private static Image imageArrowClose;
    private static Image imageArrowCloseHover;

    private ImageCacheSettingPaneLight() {
    }

    private static final ImageCacheSettingPaneLight INSTANCE = new ImageCacheSettingPaneLight();


    public static ImageCacheSettingPaneLight getInstance() {
        return INSTANCE;
    }

    @Override
    public Image getArrowClose() {
        if (imageArrowClose == null) {
            imageArrowClose = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/light/arrow-close-light.png").toExternalForm());
        }
        return imageArrowClose;
    }

    @Override
    public Image getArrowCloseHover() {
        if (imageArrowCloseHover == null) {
            imageArrowCloseHover = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/light/arrow-close-light-hover.png").toExternalForm());
        }
        return imageArrowCloseHover;
    }

    @Override
    public Image getImageNightMode() {
        if (imageNightMode == null) {
            imageNightMode = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/light/son.png").toExternalForm());
        }
        return imageNightMode;
    }

}
