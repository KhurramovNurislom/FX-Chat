package uz.lb.caches.imageCaches.contact.contact_card;

import javafx.scene.image.Image;

public class ImageCacheContactCardDark implements ImageCacheContactCard {
    private ImageCacheContactCardDark() {
    }
    private static final ImageCacheContactCardDark INSTANCE = new ImageCacheContactCardDark();
    public static ImageCacheContactCardDark getInstance() {
        return INSTANCE;
    }

    private static Image imageCheckMessage;
    private static Image imageDoubleCheckMessage;
    private static Image imageUnReadCheckMessage;
    private static Image imageUnReadDoubleCheckMessage;


    @Override
    public Image getImageCheckMessage() {
        if (imageCheckMessage == null) {
            imageCheckMessage = new Image(ImageCacheContactCardDark.class.getResource("/images/dashboard/chat-contacts/dark/check-message-dark.png").toExternalForm());
        }
        return imageCheckMessage;
    }

    @Override
    public Image getImageDoubleCheckMessage() {
        if (imageDoubleCheckMessage == null) {
            imageDoubleCheckMessage = new Image(ImageCacheContactCardDark.class.getResource("/images/dashboard/chat-contacts/double-check-message-dark.png").toExternalForm());
        }
        return imageDoubleCheckMessage;
    }


    @Override
    public Image getImageUnReadCheckMessage() {
        if (imageUnReadCheckMessage == null) {
            imageUnReadCheckMessage = new Image(ImageCacheContactCardDark.class.getResource("/images/dashboard/chat-contacts/un-read-check-message-dark.png").toExternalForm());
        }
        return imageUnReadCheckMessage;
    }

    @Override
    public Image getImageUnReadDoubleCheckMessage() {
        if (imageUnReadDoubleCheckMessage == null) {
            imageUnReadDoubleCheckMessage = new Image(ImageCacheContactCardDark.class.getResource("/images/dashboard/chat-contacts/un-read-double-check-message-dark.png").toExternalForm());
        }
        return imageUnReadDoubleCheckMessage;
    }




}
