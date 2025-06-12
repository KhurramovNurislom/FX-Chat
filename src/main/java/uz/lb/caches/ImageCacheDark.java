package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheDark {
    private ImageCacheDark() {
    }

    /***     Title-pane      */
    private static Image imageFullScreenDark;
    private static Image imageUnFullScreenDark;
    private static Image imageMinimizeDark;
    private static Image imageCloseRed;
    private static Image imageDefaultDark;
    private static Image imageCloseRedDefault;

    public static Image getImageFullScreenDark() {
        if (imageFullScreenDark == null) {
            imageFullScreenDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/full-screen-dark.png").toExternalForm());
        }
        return imageFullScreenDark;
    }

    public static Image getImageUnFullScreenDark() {
        if (imageUnFullScreenDark == null) {
            imageUnFullScreenDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/un-full-screen-dark.png").toExternalForm());
        }
        return imageUnFullScreenDark;
    }

    public static Image getImageMinimizeDark() {
        if (imageMinimizeDark == null) {
            imageMinimizeDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/minimize-dark.png").toExternalForm());
        }
        return imageMinimizeDark;
    }

    public static Image getImageCloseRed() {
        if (imageCloseRed == null) {
            imageCloseRed = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/close-dark-red-2.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRed;
    }

    public static Image getImageCloseRedDefault() {
        if (imageCloseRedDefault == null) {
            imageCloseRedDefault = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/close-dark-red.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCloseRedDefault;
    }

    public static Image getImageDefaultDark() {
        if (imageDefaultDark == null) {
            imageDefaultDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/title-pane/default-dark.png").toExternalForm());
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
            imageCircleDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contacts/circle-dark.png").toExternalForm());
        }
        return imageCircleDark;
    }

    public static Image getImageCircleCloseDark() {
        if (imageCircleCloseDark == null) {
            imageCircleCloseDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contacts/circle-close-dark.png").toExternalForm());
        }
        return imageCircleCloseDark;
    }

    public static Image getImageCircleCloseDarkHover() {
        if (imageCircleCloseDarkHover == null) {
            imageCircleCloseDarkHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contacts/circle-close-dark-hover.png").toExternalForm());
        }
        return imageCircleCloseDarkHover;
    }

    public static Image getImageCircleUnLockDark() {
        if (imageCircleUnLockDark == null) {
            imageCircleUnLockDark = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contacts/un-lock-dark.png").toExternalForm());
        }
        return imageCircleUnLockDark;
    }

    public static Image getImageCircleUnLockDarkHover() {
        if (imageCircleUnLockDarkHover == null) {
            imageCircleUnLockDarkHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contacts/un-lock-dark-hover.png").toExternalForm());
        }
        return imageCircleUnLockDarkHover;
    }


    /***     Chat-content-background      */
    private static Image imageBackgroundMono;

    public static Image getImageBackgroundMono() {
        if (imageBackgroundMono == null) {
            imageBackgroundMono = new Image(ImageCacheDark.class.getResource("/images/mv-mono.png").toExternalForm());
        }
        return imageBackgroundMono;
    }


    /***      Setting page      */
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
            imageAllChats = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/all-chats-dark.png").toExternalForm());
        }
        return imageAllChats;
    }

    public static Image getImageAllChatsHover() {
        if (imageAllChatsHover == null) {
            imageAllChatsHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/all-chats-hover.png").toExternalForm());
        }
        return imageAllChatsHover;
    }

    public static Image getImageMenu() {
        if (imageMenu == null) {
            imageMenu = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/menu-dark.png").toExternalForm());
        }
        return imageMenu;
    }

    public static Image getImageMenuHover() {
        if (imageMenuHover == null) {
            imageMenuHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/menu-hover.png").toExternalForm());
        }
        return imageMenuHover;
    }

    public static Image getImageChat() {
        if (imageChat == null) {
            imageChat = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/chat-dark.png").toExternalForm());
        }
        return imageChat;
    }
    public static Image getImageChatHover() {
        if (imageChatHover == null) {
            imageChatHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/chat-hover.png").toExternalForm());
        }
        return imageChatHover;
    }

    public static Image getImageCirclePerson() {
        if (imageCirclePerson == null) {
            imageCirclePerson = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/circle-person-dark.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePerson;
    }

    public static Image getImageCirclePersonHover() {
        if (imageCirclePersonHover == null) {
            imageCirclePersonHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/setting/circle-person-hover.png").toExternalForm(), 32, 32, true, true);
        }
        return imageCirclePersonHover;
    }
    /***     Login      */
    private static Image imageEyeDark;
    private static Image imageEyeDarkHover;
    private static Image imageUnEyeDark;
    private static Image imageUnEyeDarkHover;

    public static Image getImageEyeDark() {
        if (imageEyeDark == null) {
            imageEyeDark = new Image(ImageCacheDark.class.getResource("/images/login/eye-dark.png").toExternalForm());
        }
        return imageEyeDark;
    }

    public static Image getImageEyeDarkHover() {
        if (imageEyeDarkHover == null) {
            imageEyeDarkHover = new Image(ImageCacheDark.class.getResource("/images/login/eye-dark-hover.png").toExternalForm());
        }
        return imageEyeDarkHover;
    }

    public static Image getImageUnEyeDark() {
        if (imageUnEyeDark == null) {
            imageUnEyeDark = new Image(ImageCacheDark.class.getResource("/images/login/un-eye-dark.png").toExternalForm());
        }
        return imageUnEyeDark;
    }

    public static Image getImageUnEyeDarkHover() {
        if (imageUnEyeDarkHover == null) {
            imageUnEyeDarkHover = new Image(ImageCacheDark.class.getResource("/images/login/un-eye-dark-hover.png").toExternalForm());
        }
        return imageUnEyeDarkHover;
    }

}
