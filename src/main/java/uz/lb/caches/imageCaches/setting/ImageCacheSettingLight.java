package uz.lb.caches.imageCaches.setting;

import javafx.scene.image.Image;

public class ImageCacheSettingLight implements ImageCacheSetting {
    private ImageCacheSettingLight() {
    }

    private static final ImageCacheSettingLight INSTANCE = new ImageCacheSettingLight();

    public static ImageCacheSettingLight getInstance() {
        return INSTANCE;
    }

    /*******************************************************************/
    private static Image imageAllChats;
    private static Image imageAllChatsHover;
    private static Image imageMenu;
    private static Image imageMenuHover;
    private static Image imageUnreadChat;
    private static Image imageUnreadChatHover;
    private static Image imagePerson;
    private static Image imagePersonHover;

    /*******************************************************************/
    private static Image imageAllChatsHasCount;
    private static Image imageAllChatsHoverHasCount;
    private static Image imageMenuHasCount;
    private static Image imageMenuHoverHasCount;
    private static Image imageUnreadChatHasCount;
    private static Image imageUnreadChatHoverHasCount;
    private static Image imagePersonHasCount;
    private static Image imagePersonHoverHasCount;


    /*******************************************************************/
    public Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/all-chats-light.png").toExternalForm());
        }
        return imageAllChats;
    }

    public Image getImageAllChatsHover() {
        if (imageAllChatsHover == null) {
            imageAllChatsHover = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/all-chats-light-hover.png").toExternalForm());
        }
        return imageAllChatsHover;
    }

    public Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/menu-light.png").toExternalForm());
        }
        return imageMenu;
    }

    public Image getImageMenuHover() {
        if (imageMenuHover == null) {
            imageMenuHover = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/menu-light-hover.png").toExternalForm());
        }
        return imageMenuHover;
    }

    public Image getImageUnreadChat() {
        if (imageUnreadChat == null) {
            imageUnreadChat = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/unread-chat-light.png").toExternalForm());
        }
        return imageUnreadChat;
    }

    public Image getImageUnreadChatHover() {
        if (imageUnreadChatHover == null) {
            imageUnreadChatHover = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/unread-chat-light-hover.png").toExternalForm());
        }
        return imageUnreadChatHover;
    }

    public Image getImagePerson() {
        if (imagePerson == null) {
            imagePerson = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/person-light.png").toExternalForm());
        }
        return imagePerson;
    }

    public Image getImagePersonHover() {
        if (imagePersonHover == null) {
            imagePersonHover = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/person-light-hover.png").toExternalForm());
        }
        return imagePersonHover;
    }

    /*******************************************************************/
    public Image getImageAllChatsHasCount() {
        if (imageAllChatsHasCount == null) {
            imageAllChatsHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/all-chats-light-count.png").toExternalForm());
        }
        return imageAllChatsHasCount;
    }

    public Image getImageAllChatsHoverHasCount() {
        if (imageAllChatsHoverHasCount == null) {
            imageAllChatsHoverHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/all-chats-light-count-hover.png").toExternalForm());
        }
        return imageAllChatsHoverHasCount;
    }

    public Image getImageMenuHasCount() {
        if (imageMenuHasCount == null) {
            imageMenuHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/menu-light-count.png").toExternalForm());
        }
        return imageMenuHasCount;
    }

    public Image getImageMenuHoverHasCount() {
        if (imageMenuHoverHasCount == null) {
            imageMenuHoverHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/menu-light-count-hover.png").toExternalForm());
        }
        return imageMenuHoverHasCount;
    }

    public Image getImageUnreadChatHasCount() {
        if (imageUnreadChatHasCount == null) {
            imageUnreadChatHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/unread-chat-light-count.png").toExternalForm());
        }
        return imageUnreadChatHasCount;
    }

    public Image getImageUnreadChatHoverHasCount() {
        if (imageUnreadChatHoverHasCount == null) {
            imageUnreadChatHoverHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/unread-chat-light-count-hover.png").toExternalForm());
        }
        return imageUnreadChatHoverHasCount;
    }

    public Image getImagePersonHasCount() {
        if (imagePersonHasCount == null) {
            imagePersonHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/person-light-count.png").toExternalForm());
        }
        return imagePersonHasCount;
    }

    public Image getImagePersonHoverHasCount() {
        if (imagePersonHoverHasCount == null) {
            imagePersonHoverHasCount = new Image(ImageCacheSettingLight.class.getResource("/images/dashboard/setting/light/has-count/person-light-count-hover.png").toExternalForm());
        }
        return imagePersonHoverHasCount;
    }
}
