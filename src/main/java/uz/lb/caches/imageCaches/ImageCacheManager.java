package uz.lb.caches.imageCaches;


import uz.lb.caches.imageCaches.contact.ImageCacheContacts;
import uz.lb.caches.imageCaches.contact.ImageCacheContactsDark;
import uz.lb.caches.imageCaches.contact.ImageCacheContactsLight;
import uz.lb.caches.imageCaches.contact.contact_card.ImageCacheContactCard;
import uz.lb.caches.imageCaches.contact.contact_card.ImageCacheContactCardDark;
import uz.lb.caches.imageCaches.contact.contact_card.ImageCacheContactCardLight;
import uz.lb.caches.imageCaches.login.ImageCacheLogin;
import uz.lb.caches.imageCaches.login.ImageCacheLoginDark;
import uz.lb.caches.imageCaches.login.ImageCacheLoginLight;
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
    private static ImageCacheContacts contactsCache;
    private static ImageCacheLogin loginCache;
    private static ImageCacheContactCard contactCardCache;

    public static void init(boolean isDark) {
        titleCache = isDark ? ImageCacheTitleDark.getInstance() : ImageCacheTitleLight.getInstance();
        settingPaneCache = isDark ? ImageCacheSettingPaneDark.getInstance() : ImageCacheSettingPaneLight.getInstance();
        settingCache = isDark ? ImageCacheSettingDark.getInstance() : ImageCacheSettingLight.getInstance();
        contactsCache = isDark ? ImageCacheContactsDark.getInstance() : ImageCacheContactsLight.getInstance();
        loginCache = isDark ? ImageCacheLoginDark.getInstance() : ImageCacheLoginLight.getInstance();
        contactCardCache = isDark ? ImageCacheContactCardDark.getInstance() : ImageCacheContactCardLight.getInstance();
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

    public static ImageCacheContacts getImageCacheContacts() {
        if (contactsCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return contactsCache;
    }

    public static ImageCacheLogin getImageCacheLogin() {
        if (loginCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return loginCache;
    }

    public static ImageCacheContactCard getImageCacheContactCard() {
        if (contactCardCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return contactCardCache;
    }
}
