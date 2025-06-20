package uz.lb.caches;

import javafx.scene.image.Image;

public class ImageCacheMessageContentDark {
    private ImageCacheMessageContentDark() {
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
            imageAddFiles = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/add-files-dark.png").toExternalForm());
        }
        return imageAddFiles;
    }

    public static Image getImageAddFilesHover() {
        if (imageAddFilesHover == null) {
            imageAddFilesHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/add-files-dark-hover.png").toExternalForm());
        }
        return imageAddFilesHover;
    }

    public static Image getImageMic() {
        if (imageMic == null) {
            imageMic = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/mic-dark.png").toExternalForm());
        }
        return imageMic;
    }

    public static Image getImageMicHover() {
        if (imageMicHover == null) {
            imageMicHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/mic-dark-hover.png").toExternalForm());
        }
        return imageMicHover;
    }


    public static Image getImageSticker() {
        if (imageSticker == null) {
            imageSticker = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/sticker-dark.png").toExternalForm());
        }
        return imageSticker;
    }

    public static Image getImageStickerHover() {
        if (imageStickerHover == null) {
            imageStickerHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/sticker-dark-hover.png").toExternalForm());
        }
        return imageStickerHover;
    }


    public static Image getImageSend() {
        if (imageSendMessage == null) {
            imageSendMessage = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/send-dark.png").toExternalForm());
        }
        return imageSendMessage;
    }

    public static Image getImageSendHover() {
        if (imageSendMessageHover == null) {
            imageSendMessageHover = new Image(ImageCacheDark.class.getResource("/images/dashboard/chat-contents/send-dark-hover.png").toExternalForm());
        }
        return imageSendMessageHover;
    }

    /***     Chat-content-background      */
    private static Image imageBackgroundMono;

    public static Image getImageBackgroundMono() {
        if (imageBackgroundMono == null) {
            imageBackgroundMono = new Image(ImageCacheDark.class.getResource("/images/mv-mono.png").toExternalForm());
        }
        return imageBackgroundMono;
    }



}
