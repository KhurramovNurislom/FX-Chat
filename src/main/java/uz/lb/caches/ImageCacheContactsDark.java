package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheContactsDark {

    private static Image imageCircleDark;
    private static Image imageCircleCloseDark;
    private static Image imageCircleCloseDarkHover;
    private static Image imageCircleUnLockDark;
    private static Image imageCircleUnLockDarkHover;

    private static Image imageCheckMessage;
    private static Image imageDoubleCheckMessage;
    private static Image imageCheckMessageLight;
    private static Image imageDoubleCheckMessageLight;


    public static Image getImageCheckMessage() {
        if (imageCheckMessage == null) {
            imageCheckMessage = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/check-message.png").toExternalForm());
        }
        return imageCheckMessage;
    }

    public static Image getImageDoubleCheckMessage() {
        if (imageDoubleCheckMessage == null) {
            imageDoubleCheckMessage = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/double-check-message.png").toExternalForm());
        }
        return imageDoubleCheckMessage;
    }


    public static Image getImageCheckMessageLight() {
        if (imageCheckMessageLight == null) {
            imageCheckMessageLight = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/check-message-light.png").toExternalForm());
        }
        return imageCheckMessageLight;
    }

    public static Image getImageDoubleCheckMessageLight() {
        if (imageDoubleCheckMessageLight == null) {
            imageDoubleCheckMessageLight = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/double-check-message-light.png").toExternalForm());
        }
        return imageDoubleCheckMessageLight;
    }






    public static Image getImageCircleDark() {
        if (imageCircleDark == null) {
            imageCircleDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/circle-dark.png").toExternalForm());
        }
        return imageCircleDark;
    }

    public static Image getImageCircleCloseDark() {
        if (imageCircleCloseDark == null) {
            imageCircleCloseDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/circle-close-dark.png").toExternalForm());
        }
        return imageCircleCloseDark;
    }

    public static Image getImageCircleCloseDarkHover() {
        if (imageCircleCloseDarkHover == null) {
            imageCircleCloseDarkHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/circle-close-dark-hover.png").toExternalForm());
        }
        return imageCircleCloseDarkHover;
    }

    public static Image getImageCircleUnLockDark() {
        if (imageCircleUnLockDark == null) {
            imageCircleUnLockDark = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/un-lock-dark.png").toExternalForm());
        }
        return imageCircleUnLockDark;
    }

    public static Image getImageCircleUnLockDarkHover() {
        if (imageCircleUnLockDarkHover == null) {
            imageCircleUnLockDarkHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contacts/un-lock-dark-hover.png").toExternalForm());
        }
        return imageCircleUnLockDarkHover;
    }


}
