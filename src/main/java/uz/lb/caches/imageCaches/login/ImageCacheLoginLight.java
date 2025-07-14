package uz.lb.caches.imageCaches.login;

import javafx.scene.image.Image;

public class ImageCacheLoginLight implements ImageCacheLogin {

    private ImageCacheLoginLight() {
    }

    private static final ImageCacheLoginLight INSTANCE = new ImageCacheLoginLight();

    public static ImageCacheLoginLight getInstance() {
        return INSTANCE;
    }


    private static Image imageLogo;
    private static Image imageEye;
    private static Image imageEyeHover;
    private static Image imageUnEye;
    private static Image imageUnEyeHover;

    @Override
    public Image getImageLogo() {
        if (imageLogo == null) {
            imageLogo = new Image(ImageCacheLoginLight.class.getResource("/images/login/light/logo-light.png").toExternalForm());
        }
        return imageLogo;
    }

    @Override
    public Image getImageEye() {
        if (imageEye == null) {
            imageEye = new Image(ImageCacheLoginLight.class.getResource("/images/login/light/eye-light.png").toExternalForm());
        }
        return imageEye;
    }


    @Override
    public Image getImageEyeHover() {
        if (imageEyeHover == null) {
            imageEyeHover = new Image(ImageCacheLoginLight.class.getResource("/images/login/light/eye-light-hover.png").toExternalForm());
        }
        return imageEyeHover;
    }

    @Override
    public Image getImageUnEye() {
        if (imageUnEye == null) {
            imageUnEye = new Image(ImageCacheLoginLight.class.getResource("/images/login/light/un-eye-light.png").toExternalForm());
        }
        return imageUnEye;
    }

    @Override
    public Image getImageUnEyeHover() {
        if (imageUnEyeHover == null) {
            imageUnEyeHover = new Image(ImageCacheLoginLight.class.getResource("/images/login/light/un-eye-light-hover.png").toExternalForm());
        }
        return imageUnEyeHover;
    }
}
