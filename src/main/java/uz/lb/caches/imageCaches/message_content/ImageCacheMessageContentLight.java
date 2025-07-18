package uz.lb.caches.imageCaches.message_content;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;

public class ImageCacheMessageContentLight {
    private ImageCacheMessageContentLight() {
    }

    private static Image imageAddFiles;
    private static Image imageAddFilesHover;
    private static Image imageMic;
    private static Image imageMicHover;
    private static Image imageSticker;
    private static Image imageStickerHover;
    private static Image imageSendMessage;
    private static Image imageSendMessageHover;

    public static Image getImageAddFiles() {
        if (imageAddFiles == null) {
            imageAddFiles = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/add-files-dark.png").toExternalForm());
        }
        return imageAddFiles;
    }

    public static Image getImageAddFilesHover() {
        if (imageAddFilesHover == null) {
            imageAddFilesHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/add-files-dark-hover.png").toExternalForm());
        }
        return imageAddFilesHover;
    }

    public static Image getImageMic() {
        if (imageMic == null) {
            imageMic = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/mic-dark.png").toExternalForm());
        }
        return imageMic;
    }

    public static Image getImageMicHover() {
        if (imageMicHover == null) {
            imageMicHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/mic-dark-hover.png").toExternalForm());
        }
        return imageMicHover;
    }


    public static Image getImageSticker() {
        if (imageSticker == null) {
            imageSticker = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/sticker-dark.png").toExternalForm());
        }
        return imageSticker;
    }

    public static Image getImageStickerHover() {
        if (imageStickerHover == null) {
            imageStickerHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/sticker-dark-hover.png").toExternalForm());
        }
        return imageStickerHover;
    }


    public static Image getImageSend() {
        if (imageSendMessage == null) {
            imageSendMessage = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/send-dark.png").toExternalForm());
        }
        return imageSendMessage;
    }

    public static Image getImageSendHover() {
        if (imageSendMessageHover == null) {
            imageSendMessageHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/send-dark-hover.png").toExternalForm());
        }
        return imageSendMessageHover;
    }

    /***     Chat-content-background      */
    private static Image imageBackgroundMono;

    public static Image getImageBackgroundMono() {
        if (imageBackgroundMono == null) {
            imageBackgroundMono = new Image(ImageCacheSettingDark.class.getResource("/images/logo-dark.png").toExternalForm());
        }
        return imageBackgroundMono;
    }



}
