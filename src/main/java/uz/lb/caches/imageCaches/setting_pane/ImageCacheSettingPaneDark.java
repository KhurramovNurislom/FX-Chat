package uz.lb.caches.imageCaches.setting_pane;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.title.ImageCacheTitleDark;
import uz.lb.controllers.SettingsController;

public class ImageCacheSettingPaneDark implements ImageCacheSettingPane {
    private static Image imageNightMode;

    private ImageCacheSettingPaneDark() {
    }

    private static final ImageCacheSettingPaneDark INSTANCE = new ImageCacheSettingPaneDark();



    public static ImageCacheSettingPaneDark getInstance() {
        return INSTANCE;
    }

    @Override
    public Image getImageNightMode() {
        if (imageNightMode == null) {
            imageNightMode = new Image(ImageCacheSettingPaneDark.class.getResource("/images/dashboard/setting-pane/night.png").toExternalForm());
        }
        return imageNightMode;
    }

}
