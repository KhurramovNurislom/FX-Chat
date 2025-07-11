package uz.lb.caches.imageCaches.setting_pane;

import javafx.scene.image.Image;

public class ImageCacheSettingPaneLight implements ImageCacheSettingPane {
    private static Image imageNightMode;

    private ImageCacheSettingPaneLight() {
    }

    private static final ImageCacheSettingPaneLight INSTANCE = new ImageCacheSettingPaneLight();


    public static ImageCacheSettingPaneLight getInstance() {
        return INSTANCE;
    }

    @Override
    public Image getImageNightMode() {
        if (imageNightMode == null) {
            imageNightMode = new Image(ImageCacheSettingPaneLight.class.getResource("/images/dashboard/setting-pane/son.png").toExternalForm());
        }
        return imageNightMode;
    }

}
