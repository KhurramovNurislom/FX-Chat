package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCache {
    private static Image imageFullScreenDark;
    private static Image imageUnFullScreenDark;
    private static Image imageDefaultDark;
    private static Image imageMinimizeDark;
    private static Image imageCloseRed;
    private static Image imageCircleDark;
    private static Image imageCircleCloseDark;
    private static Image imageCircleCloseDarkHover;
    private static Image imageAllChats;
    private static Image imageMenu;
    private static Image imageChat;
    private static Image imageCirclePerson;

    public static Image getImageFullScreenDark() {
        if (imageFullScreenDark == null) {
            imageFullScreenDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/full-screen-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageFullScreenDark;
    }

    public static Image getImageUnFullScreenDark() {
        if (imageUnFullScreenDark == null) {
            imageUnFullScreenDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/un-full-screen-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageUnFullScreenDark;
    }

    public static Image getImageDefaultDark() {
        if (imageDefaultDark == null) {
            imageDefaultDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageDefaultDark;
    }

    public static Image getImageMinimizeDark() {
        if (imageMinimizeDark == null) {
            imageMinimizeDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm(), 48, 48,true, true);
        }
        return imageMinimizeDark;
    }

    public static Image getImageCloseRed() {
        if (imageCloseRed == null) {
            imageCloseRed = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/close-dark-red-2.png").toExternalForm(), 32,32, true, true);
        }
        return imageCloseRed;
    }

    public static Image getImageCircleDark() {
        if (imageCircleDark == null) {
            imageCircleDark = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-dark.png").toExternalForm(), 48, 48,true, true);
        }
        return imageCircleDark;
    }

    public static Image getImageCircleCloseDark() {
        if (imageCircleCloseDark == null) {
            imageCircleCloseDark = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-close-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageCircleCloseDark;
    }

    public static Image getImageCircleCloseDarkHover() {
        if (imageCircleCloseDarkHover == null) {
            imageCircleCloseDarkHover = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-close-dark-hover.png").toExternalForm(), 48, 48, true, true);
        }
        return imageCircleCloseDarkHover;
    }

    public static Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/all-chats.png").toExternalForm(), 48, 48, true, true);
        }
        return imageAllChats;
    }

    public static Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/menu.png").toExternalForm(), 48, 48,true, true);
        }
        return imageMenu;
    }

    public static Image getImageChat() {
        if (imageChat == null) {
            imageChat = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/chat.png").toExternalForm(), 32, 32, true, true);
        }
        return imageChat;
    }

    public static Image getImageCirclePerson() {
        if (imageCirclePerson == null) {
            imageCirclePerson = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-person.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePerson;
    }

}
