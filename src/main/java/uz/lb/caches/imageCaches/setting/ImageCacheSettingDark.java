package uz.lb.caches.imageCaches.setting;

import javafx.scene.image.Image;

public class ImageCacheSettingDark implements ImageCacheSetting {
    private ImageCacheSettingDark() {
    }
    private static final ImageCacheSettingDark INSTANCE = new ImageCacheSettingDark();

    public static ImageCacheSettingDark getInstance() {
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
    public  Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/all-chats-dark.png").toExternalForm());
        }
        return imageAllChats;
    }

    public Image getImageAllChatsHover() {
        if (imageAllChatsHover == null) {
            imageAllChatsHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/all-chats-dark-hover.png").toExternalForm());
        }
        return imageAllChatsHover;
    }

    public Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/menu-dark.png").toExternalForm());
        }
        return imageMenu;
    }

    public Image getImageMenuHover() {
        if (imageMenuHover == null) {
            imageMenuHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/menu-dark-hover.png").toExternalForm());
        }
        return imageMenuHover;
    }

    public Image getImageUnreadChat() {
        if (imageUnreadChat == null) {
            imageUnreadChat = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/unread-chat-dark.png").toExternalForm());
        }
        return imageUnreadChat;
    }

    public Image getImageUnreadChatHover() {
        if (imageUnreadChatHover == null) {
            imageUnreadChatHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/unread-chat-dark-hover.png").toExternalForm());
        }
        return imageUnreadChatHover;
    }

    public Image getImagePerson() {
        if (imagePerson == null) {
            imagePerson = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/person-dark.png").toExternalForm());
        }
        return imagePerson;
    }

    public Image getImagePersonHover() {
        if (imagePersonHover == null) {
            imagePersonHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/person-dark-hover.png").toExternalForm());
        }
        return imagePersonHover;
    }

    /*******************************************************************/
    public Image getImageAllChatsHasCount() {
        if (imageAllChatsHasCount == null) {
            imageAllChatsHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/all-chats-dark-count.png").toExternalForm());
        }
        return imageAllChatsHasCount;
    }

    public Image getImageAllChatsHoverHasCount() {
        if (imageAllChatsHoverHasCount == null) {
            imageAllChatsHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/all-chats-dark-count-hover.png").toExternalForm());
        }
        return imageAllChatsHoverHasCount;
    }

    public Image getImageMenuHasCount() {
        if (imageMenuHasCount == null) {
            imageMenuHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/menu-dark-count.png").toExternalForm());
        }
        return imageMenuHasCount;
    }

    public Image getImageMenuHoverHasCount() {
        if (imageMenuHoverHasCount == null) {
            imageMenuHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/menu-dark-count-hover.png").toExternalForm());
        }
        return imageMenuHoverHasCount;
    }

    public Image getImageUnreadChatHasCount() {
        if (imageUnreadChatHasCount == null) {
            imageUnreadChatHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/unread-chat-dark-count.png").toExternalForm());
        }
        return imageUnreadChatHasCount;
    }

    public Image getImageUnreadChatHoverHasCount() {
        if (imageUnreadChatHoverHasCount == null) {
            imageUnreadChatHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/unread-chat-dark-count-hover.png").toExternalForm());
        }
        return imageUnreadChatHoverHasCount;
    }

    public Image getImagePersonHasCount() {
        if (imagePersonHasCount == null) {
            imagePersonHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/person-dark-count.png").toExternalForm());
        }
        return imagePersonHasCount;
    }

    public Image getImagePersonHoverHasCount() {
        if (imagePersonHoverHasCount == null) {
            imagePersonHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/person-dark-count-hover.png").toExternalForm());
        }
        return imagePersonHoverHasCount;
    }
}
