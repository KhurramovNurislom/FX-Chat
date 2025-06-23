package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheLoginDark {
    private static Image imageEyeDark;
    private static Image imageEyeDarkHover;
    private static Image imageUnEyeDark;
    private static Image imageUnEyeDarkHover;

    public static Image getImageEyeDark() {
        if (imageEyeDark == null) {
            imageEyeDark = new Image(ImageCacheSettingDark.class.getResource("/images/login/eye-dark.png").toExternalForm());
        }
        return imageEyeDark;
    }

    public static Image getImageEyeDarkHover() {
        if (imageEyeDarkHover == null) {
            imageEyeDarkHover = new Image(ImageCacheSettingDark.class.getResource("/images/login/eye-dark-hover.png").toExternalForm());
        }
        return imageEyeDarkHover;
    }

    public static Image getImageUnEyeDark() {
        if (imageUnEyeDark == null) {
            imageUnEyeDark = new Image(ImageCacheSettingDark.class.getResource("/images/login/un-eye-dark.png").toExternalForm());
        }
        return imageUnEyeDark;
    }

    public static Image getImageUnEyeDarkHover() {
        if (imageUnEyeDarkHover == null) {
            imageUnEyeDarkHover = new Image(ImageCacheSettingDark.class.getResource("/images/login/un-eye-dark-hover.png").toExternalForm());
        }
        return imageUnEyeDarkHover;
    }
}
