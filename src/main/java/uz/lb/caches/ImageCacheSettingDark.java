package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheSettingDark {
    private ImageCacheSettingDark() {
    }

    private static Image imageAllChats;
    private static Image imageAllChatsHover;
    private static Image imageMenu;
    private static Image imageMenuHover;
    private static Image imageChat;
    private static Image imageChatHover;
    private static Image imageCirclePerson;
    private static Image imageCirclePersonHover;


    public static Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/all-chats-dark.png").toExternalForm());
        }
        return imageAllChats;
    }

    public static Image getImageAllChatsHover() {
        if (imageAllChatsHover == null) {
            imageAllChatsHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/all-chats-hover.png").toExternalForm());
        }
        return imageAllChatsHover;
    }

    public static Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/menu-dark.png").toExternalForm());
        }
        return imageMenu;
    }

    public static Image getImageMenuHover() {
        if (imageMenuHover == null) {
            imageMenuHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/menu-hover.png").toExternalForm());
        }
        return imageMenuHover;
    }

    public static Image getImageChat() {
        if (imageChat == null) {
            imageChat = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/chat-dark.png").toExternalForm());
        }
        return imageChat;
    }
    public static Image getImageChatHover() {
        if (imageChatHover == null) {
            imageChatHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/chat-hover.png").toExternalForm());
        }
        return imageChatHover;
    }

    public static Image getImageCirclePerson() {
        if (imageCirclePerson == null) {
            imageCirclePerson = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/circle-person-dark.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePerson;
    }

    public static Image getImageCirclePersonHover() {
        if (imageCirclePersonHover == null) {
            imageCirclePersonHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/setting/circle-person-hover.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePersonHover;
    }


}
