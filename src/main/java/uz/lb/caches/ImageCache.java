package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCache {
    private ImageCache() {
    }

    /***     Title-pane      */
    private static Image imageFullScreenDark;
    private static Image imageUnFullScreenDark;
    private static Image imageMinimizeDark;
    private static Image imageCloseRed;
    private static Image imageDefaultDark;

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

    public static Image getImageMinimizeDark() {
        if (imageMinimizeDark == null) {
            imageMinimizeDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageMinimizeDark;
    }

    public static Image getImageCloseRed() {
        if (imageCloseRed == null) {
            imageCloseRed = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/close-dark-red-2.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRed;
    }

    public static Image getImageDefaultDark() {
        if (imageDefaultDark == null) {
            imageDefaultDark = new Image(ImageCache.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageDefaultDark;
    }

    /***        Chat-contact      */

    private static Image imageCircleDark;
    private static Image imageCircleCloseDark;
    private static Image imageCircleCloseDarkHover;
    private static Image imageCircleUnLockDark;
    private static Image imageCircleUnLockDarkHover;

    public static Image getImageCircleDark() {
        if (imageCircleDark == null) {
            imageCircleDark = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-dark.png").toExternalForm(), 48, 48, true, true);
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

    public static Image getImageCircleUnLockDark() {
        if (imageCircleUnLockDark == null) {
            imageCircleUnLockDark = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/un-lock-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageCircleUnLockDark;
    }

    public static Image getImageCircleUnLockDarkHover() {
        if (imageCircleUnLockDarkHover == null) {
            imageCircleUnLockDarkHover = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/un-lock-dark-hover.png").toExternalForm(), 48, 48, true, true);
        }
        return imageCircleUnLockDarkHover;
    }


    /***     Chat-content-background      */
    private static Image imageBackgroundMono;

    public static Image getImageBackgroundMono() {
        if (imageBackgroundMono == null) {
            imageBackgroundMono = new Image(ImageCache.class.getResource("/images/mv-mono.png").toExternalForm(), 48, 48, true, true);
        }
        return imageBackgroundMono;
    }


    /***      Setting page      */
    private static Image imageAllChats;
    private static Image imageMenu;
    private static Image imageChat;
    private static Image imageCirclePerson;


    public static Image getImageAllChats() {
        if (imageAllChats == null) {
            imageAllChats = new Image(ImageCache.class.getResource("/images/dashboard/all-chats.png").toExternalForm(), 48, 48, true, true);
        }
        return imageAllChats;
    }

    public static Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCache.class.getResource("/images/dashboard/menu.png").toExternalForm(), 48, 48, true, true);
        }
        return imageMenu;
    }

    public static Image getImageChat() {
        if (imageChat == null) {
            imageChat = new Image(ImageCache.class.getResource("/images/dashboard/setting/chat.png").toExternalForm(), 48, 48, true, true);
        }
        return imageChat;
    }

    public static Image getImageCirclePerson() {
        if (imageCirclePerson == null) {
            imageCirclePerson = new Image(ImageCache.class.getResource("/images/dashboard/chat-contacts/circle-person.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePerson;
    }

    /***     Login      */
    private static Image imageEyeDark;
    private static Image imageEyeDarkHover;
    private static Image imageUnEyeDark;
    private static Image imageUnEyeDarkHover;

    public static Image getImageEyeDark() {
        if (imageEyeDark == null) {
            imageEyeDark = new Image(ImageCache.class.getResource("/images/login/eye-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageEyeDark;
    }

    public static Image getImageEyeDarkHover() {
        if (imageEyeDarkHover == null) {
            imageEyeDarkHover = new Image(ImageCache.class.getResource("/images/login/eye-dark-hover.png").toExternalForm(), 48, 48, true, true);
        }
        return imageEyeDarkHover;
    }

    public static Image getImageUnEyeDark() {
        if (imageUnEyeDark == null) {
            imageUnEyeDark = new Image(ImageCache.class.getResource("/images/login/un-eye-dark.png").toExternalForm(), 48, 48, true, true);
        }
        return imageUnEyeDark;
    }

    public static Image getImageUnEyeDarkHover() {
        if (imageUnEyeDarkHover == null) {
            imageUnEyeDarkHover = new Image(ImageCache.class.getResource("/images/login/un-eye-dark-hover.png").toExternalForm(), 48, 48, true, true);
        }
        return imageUnEyeDarkHover;
    }

}
