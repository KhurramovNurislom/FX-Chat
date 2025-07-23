package uz.lb.caches.imageCaches.setting_pane;

import javafx.scene.image.Image;

public class ImageCacheSettingPaneDark implements ImageCacheSettingPane {
    private static Image imageNightMode;

    private static Image imageArrowClose;
    private static Image imageArrowCloseHover;

    private ImageCacheSettingPaneDark() {
    }

    private static final ImageCacheSettingPaneDark INSTANCE = new ImageCacheSettingPaneDark();


    public static ImageCacheSettingPaneDark getInstance() {
        return INSTANCE;
    }

    @Override
    public Image getArrowClose() {
        if (imageArrowClose == null) {
            imageArrowClose = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/dark/arrow-close-dark.png").toExternalForm());
        }
        return imageArrowClose;
    }

    @Override
    public Image getArrowCloseHover() {
        if (imageArrowCloseHover == null) {
            imageArrowCloseHover = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/dark/arrow-close-dark-hover.png").toExternalForm());
        }
        return imageArrowCloseHover;
    }

    @Override
    public Image getImageNightMode() {
        if (imageNightMode == null) {
            imageNightMode = new Image(ImageCacheSettingPaneDark.class.getResource("/images/dashboard/setting-pane/dark/night.png").toExternalForm());
        }
        return imageNightMode;
    }

}
