package uz.lb.caches.imageCaches.login;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;

public class ImageCacheLoginDark implements ImageCacheLogin {

    private ImageCacheLoginDark() {
    }

    private static final ImageCacheLoginDark INSTANCE = new ImageCacheLoginDark();

    public static ImageCacheLoginDark getInstance() {
        return INSTANCE;
    }


    private static Image imageEye;
    private static Image imageEyeHover;
    private static Image imageUnEye;
    private static Image imageUnEyeHover;
    private static Image imageLogo;
    @Override
    public Image getImageLogo() {
        if (imageEye == null) {
            imageEye = new Image(ImageCacheSettingDark.class.getResource("/images/login/dark/logo-dark.png").toExternalForm());
        }
        return imageEye;
    }

    @Override
    public Image getImageEye() {
        if (imageEye == null) {
            imageEye = new Image(ImageCacheSettingDark.class.getResource("/images/login/dark/eye-dark.png").toExternalForm());
        }
        return imageEye;
    }

    @Override
    public Image getImageEyeHover() {
        if (imageEyeHover == null) {
            imageEyeHover = new Image(ImageCacheSettingDark.class.getResource("/images/login/dark/eye-dark-hover.png").toExternalForm());
        }
        return imageEyeHover;
    }

    @Override
    public Image getImageUnEye() {
        if (imageUnEye == null) {
            imageUnEye = new Image(ImageCacheSettingDark.class.getResource("/images/login/dark/un-eye-dark.png").toExternalForm());
        }
        return imageUnEye;
    }

    @Override
    public Image getImageUnEyeHover() {
        if (imageUnEyeHover == null) {
            imageUnEyeHover = new Image(ImageCacheSettingDark.class.getResource("/images/login/dark/un-eye-dark-hover.png").toExternalForm());
        }
        return imageUnEyeHover;
    }
}
