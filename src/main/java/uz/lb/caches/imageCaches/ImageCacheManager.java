package uz.lb.caches.imageCaches;


import uz.lb.caches.imageCaches.setting.ImageCacheSetting;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingLight;
import uz.lb.caches.imageCaches.setting_pane.ImageCacheSettingPane;
import uz.lb.caches.imageCaches.setting_pane.ImageCacheSettingPaneDark;
import uz.lb.caches.imageCaches.setting_pane.ImageCacheSettingPaneLight;
import uz.lb.caches.imageCaches.title.ImageCacheTitle;
import uz.lb.caches.imageCaches.title.ImageCacheTitleDark;
import uz.lb.caches.imageCaches.title.ImageCacheTitleLight;

public class ImageCacheManager {

    private static ImageCacheTitle titleCache;
    private static ImageCacheSettingPane settingPaneCache;
    private static ImageCacheSetting settingCache;

    public static void init(boolean isDark) {
        titleCache = isDark ? ImageCacheTitleDark.getInstance() : ImageCacheTitleLight.getInstance();
        settingPaneCache = isDark ? ImageCacheSettingPaneDark.getInstance() : ImageCacheSettingPaneLight.getInstance();
        settingCache = isDark ? ImageCacheSettingDark.getInstance() : ImageCacheSettingLight.getInstance();
    }

    public static ImageCacheTitle getImageCacheTitle() {
        if (titleCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return titleCache;
    }

    public static ImageCacheSettingPane getImageCacheSettingPane() {
        if (settingPaneCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return settingPaneCache;
    }

    public static ImageCacheSetting getImageCacheSetting() {
        if (settingCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return settingCache;
    }
}
