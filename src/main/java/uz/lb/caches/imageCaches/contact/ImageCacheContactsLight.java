package uz.lb.caches.imageCaches.contact;

import javafx.scene.image.Image;

public class ImageCacheContactsLight implements ImageCacheContacts {
    private ImageCacheContactsLight() {
    }

    private static final ImageCacheContactsLight INSTANCE = new ImageCacheContactsLight();

    public static ImageCacheContactsLight getInstance() {
        return INSTANCE;
    }

    private static Image imageClose;
    private static Image imageCloseHover;
    private static Image imageUnLock;
    private static Image imageUnLockHover;


    @Override
    public Image getImageClose() {
        if (imageClose == null) {
            imageClose = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/close-light.png").toExternalForm());
        }
        return imageClose;
    }

    @Override
    public Image getImageCloseHover() {
        if (imageCloseHover == null) {
            imageCloseHover = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/close-light-hover.png").toExternalForm());
        }
        return imageCloseHover;
    }

    @Override
    public Image getImageUnLock() {
        if (imageUnLock == null) {
            imageUnLock = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/un-lock-light.png").toExternalForm());
        }
        return imageUnLock;
    }

    @Override
    public Image getImageUnLockHover() {
        if (imageUnLockHover == null) {
            imageUnLockHover = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/un-lock-light-hover.png").toExternalForm());
        }
        return imageUnLockHover;
    }

}
