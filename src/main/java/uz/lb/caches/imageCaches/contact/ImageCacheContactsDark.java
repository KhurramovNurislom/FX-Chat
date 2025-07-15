package uz.lb.caches.imageCaches.contact;

import javafx.scene.image.Image;

public class ImageCacheContactsDark implements ImageCacheContacts {
    private ImageCacheContactsDark() {
    }
    private static final ImageCacheContactsDark INSTANCE = new ImageCacheContactsDark();
    public static ImageCacheContactsDark getInstance() {
        return INSTANCE;
    }

    private static Image imageClose;
    private static Image imageCloseHover;
    private static Image imageUnLock;
    private static Image imageUnLockHover;

    @Override
    public Image getImageClose() {
        if (imageClose == null) {
            imageClose = new Image(ImageCacheContactsDark.class.getResource("/images/dashboard/chat-contacts/dark/close-dark.png").toExternalForm());
        }
        return imageClose;
    }

    @Override
    public Image getImageCloseHover() {
        if (imageCloseHover == null) {
            imageCloseHover = new Image(ImageCacheContactsDark.class.getResource("/images/dashboard/chat-contacts/dark/close-dark-hover.png").toExternalForm());
        }
        return imageCloseHover;
    }

    @Override
    public Image getImageUnLock() {
        if (imageUnLock == null) {
            imageUnLock = new Image(ImageCacheContactsDark.class.getResource("/images/dashboard/chat-contacts/dark/un-lock-dark.png").toExternalForm());
        }
        return imageUnLock;
    }

    @Override
    public Image getImageUnLockHover() {
        if (imageUnLockHover == null) {
            imageUnLockHover = new Image(ImageCacheContactsDark.class.getResource("/images/dashboard/chat-contacts/dark/un-lock-dark-hover.png").toExternalForm());
        }
        return imageUnLockHover;
    }


}
