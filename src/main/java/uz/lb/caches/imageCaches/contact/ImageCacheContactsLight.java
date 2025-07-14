package uz.lb.caches.imageCaches.contact;

import javafx.scene.image.Image;

public class ImageCacheContactsLight implements ImageCacheContacts {
    private ImageCacheContactsLight() {
    }

    private static final ImageCacheContactsLight INSTANCE = new ImageCacheContactsLight();

    public static ImageCacheContactsLight getInstance() {
        return INSTANCE;
    }

    private static Image imageCircle;
    private static Image imageClose;
    private static Image imageCloseHover;
    private static Image imageUnLock;
    private static Image imageUnLockHover;

    private static Image imageCheckMessage;
    private static Image imageDoubleCheckMessage;
    private static Image imageUnReadCheckMessage;
    private static Image imageUnReadDoubleCheckMessage;


    @Override
    public Image getImageCheckMessage() {
        if (imageCheckMessage == null) {
            imageCheckMessage = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/check-message.png").toExternalForm());
        }
        return imageCheckMessage;
    }

    @Override
    public Image getImageDoubleCheckMessage() {
        if (imageDoubleCheckMessage == null) {
            imageDoubleCheckMessage = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/double-check-message.png").toExternalForm());
        }
        return imageDoubleCheckMessage;
    }


    @Override
    public Image getImageUnReadCheckMessage() {
        if (imageUnReadCheckMessage == null) {
            imageUnReadCheckMessage = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/check-message-light.png").toExternalForm());
        }
        return imageUnReadCheckMessage;
    }

    @Override
    public Image getImageUnReadDoubleCheckMessage() {
        if (imageUnReadDoubleCheckMessage == null) {
            imageUnReadDoubleCheckMessage = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/double-check-message-light.png").toExternalForm());
        }
        return imageUnReadDoubleCheckMessage;
    }


    @Override
    public Image getImageCircle() {
        if (imageCircle == null) {
            imageCircle = new Image(ImageCacheContactsLight.class.getResource("/images/dashboard/chat-contacts/light/circle-light.png").toExternalForm());
        }
        return imageCircle;
    }

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
