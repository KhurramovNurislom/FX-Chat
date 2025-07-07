package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheSettingDark {
    private ImageCacheSettingDark() {
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
    public static Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/all-chats-dark.png").toExternalForm());
        }
        return imageAllChats;
    }

    public static Image getImageAllChatsHover() {
        if (imageAllChatsHover == null) {
            imageAllChatsHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/all-chats-dark-hover.png").toExternalForm());
        }
        return imageAllChatsHover;
    }

    public static Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/menu-dark.png").toExternalForm());
        }
        return imageMenu;
    }

    public static Image getImageMenuHover() {
        if (imageMenuHover == null) {
            imageMenuHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/menu-dark-hover.png").toExternalForm());
        }
        return imageMenuHover;
    }

    public static Image getImageUnreadChat() {
        if (imageUnreadChat == null) {
            imageUnreadChat = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/unread-chat-dark.png").toExternalForm());
        }
        return imageUnreadChat;
    }

    public static Image getImageUnreadChatHover() {
        if (imageUnreadChatHover == null) {
            imageUnreadChatHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/unread-chat-dark-hover.png").toExternalForm());
        }
        return imageUnreadChatHover;
    }

    public static Image getImagePerson() {
        if (imagePerson == null) {
            imagePerson = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/person-dark.png").toExternalForm());
        }
        return imagePerson;
    }

    public static Image getImagePersonHover() {
        if (imagePersonHover == null) {
            imagePersonHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/person-dark-hover.png").toExternalForm());
        }
        return imagePersonHover;
    }

    /*******************************************************************/
    public static Image getImageAllChatsHasCount() {
        if (imageAllChatsHasCount == null) {
            imageAllChatsHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/all-chats-dark-count.png").toExternalForm());
        }
        return imageAllChatsHasCount;
    }

    public static Image getImageAllChatsHoverHasCount() {
        if (imageAllChatsHoverHasCount == null) {
            imageAllChatsHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/all-chats-dark-count-hover.png").toExternalForm());
        }
        return imageAllChatsHoverHasCount;
    }

    public static Image getImageMenuHasCount() {
        if (imageMenuHasCount == null) {
            imageMenuHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/menu-dark-count.png").toExternalForm());
        }
        return imageMenuHasCount;
    }

    public static Image getImageMenuHoverHasCount() {
        if (imageMenuHoverHasCount == null) {
            imageMenuHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/menu-dark-count-hover.png").toExternalForm());
        }
        return imageMenuHoverHasCount;
    }

    public static Image getImageUnreadChatHasCount() {
        if (imageUnreadChatHasCount == null) {
            imageUnreadChatHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/unread-chat-dark-count.png").toExternalForm());
        }
        return imageUnreadChatHasCount;
    }

    public static Image getImageUnreadChatHoverHasCount() {
        if (imageUnreadChatHoverHasCount == null) {
            imageUnreadChatHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/unread-chat-dark-count-hover.png").toExternalForm());
        }
        return imageUnreadChatHoverHasCount;
    }

    public static Image getImagePersonHasCount() {
        if (imagePersonHasCount == null) {
            imagePersonHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/person-dark-count.png").toExternalForm());
        }
        return imagePersonHasCount;
    }

    public static Image getImagePersonHoverHasCount() {
        if (imagePersonHoverHasCount == null) {
            imagePersonHoverHasCount = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/dark/has-count/person-dark-count-hover.png").toExternalForm());
        }
        return imagePersonHoverHasCount;
    }
}
