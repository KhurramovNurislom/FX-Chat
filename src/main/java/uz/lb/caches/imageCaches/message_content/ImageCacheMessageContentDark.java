package uz.lb.caches.imageCaches.message_content;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;

public class ImageCacheMessageContentDark implements ImageCacheMessageContent {
    private ImageCacheMessageContentDark() {
    }
    private static final ImageCacheMessageContentDark INSTANCE = new ImageCacheMessageContentDark();
    public static ImageCacheMessageContentDark getInstance() {
        return INSTANCE;
    }

    /***     Chat-content-header      */
    private static Image imageSearch;
    private static Image imageSearchHover;
    private static Image imageOpenInfo;
    private static Image imageOpenInfoHover;
    private static Image imageSetting;
    private static Image imageSettingHover;
    private static Image imagePhone;
    private static Image imagePhoneHover;

    @Override
    public Image getImageSearch() {
        if (imageSearch == null) {
            imageSearch = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/search-dark.png").toExternalForm());
        }
        return imageSearch;
    }

    @Override
    public Image getImageSearchHover() {
        if (imageSearchHover == null) {
            imageSearchHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/search-dark-hover.png").toExternalForm());
        }
        return imageSearchHover;
    }

    @Override
    public Image getImageOpenInfo() {
        if (imageOpenInfo == null) {
            imageOpenInfo = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/open-info-dark.png").toExternalForm());
        }
        return imageOpenInfo;
    }

    @Override
    public Image getImageOpenInfoHover() {
        if (imageOpenInfoHover == null) {
            imageOpenInfoHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/open-info-dark-hover.png").toExternalForm());
        }
        return imageOpenInfoHover;
    }

    @Override
    public Image getImageSetting() {
        if (imageSetting == null) {
            imageSetting = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/setting-dark.png").toExternalForm());
        }
        return imageSetting;
    }

    @Override
    public Image getImageSettingHover() {
        if (imageSettingHover == null) {
            imageSettingHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/setting-dark-hover.png").toExternalForm());
        }
        return imageSettingHover;
    }

    @Override
    public Image getImagePhone() {
        if (imagePhone == null) {
            imagePhone = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/phone-dark.png").toExternalForm());
        }
        return imagePhone;
    }

    @Override
    public Image getImagePhoneHover() {
        if (imagePhoneHover == null) {
            imagePhoneHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/phone-dark-hover.png").toExternalForm());
        }
        return imagePhoneHover;
    }

    /***     Chat-content-footer      */

    private static Image imageAddFiles;
    private static Image imageAddFilesHover;
    private static Image imageMic;
    private static Image imageMicHover;
    private static Image imageSticker;
    private static Image imageStickerHover;
    private static Image imageSendMessage;
    private static Image imageSendMessageHover;

    @Override
    public Image getImageAddFiles() {
        if (imageAddFiles == null) {
            imageAddFiles = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/add-files-dark.png").toExternalForm());
        }
        return imageAddFiles;
    }

    @Override
    public Image getImageAddFilesHover() {
        if (imageAddFilesHover == null) {
            imageAddFilesHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/add-files-dark-hover.png").toExternalForm());
        }
        return imageAddFilesHover;
    }

    @Override
    public Image getImageMic() {
        if (imageMic == null) {
            imageMic = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/mic-dark.png").toExternalForm());
        }
        return imageMic;
    }

    @Override
    public Image getImageMicHover() {
        if (imageMicHover == null) {
            imageMicHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/mic-dark-hover.png").toExternalForm());
        }
        return imageMicHover;
    }


    public Image getImageSticker() {
        if (imageSticker == null) {
            imageSticker = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/sticker-dark.png").toExternalForm());
        }
        return imageSticker;
    }

    public Image getImageStickerHover() {
        if (imageStickerHover == null) {
            imageStickerHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/sticker-dark-hover.png").toExternalForm());
        }
        return imageStickerHover;
    }


    public Image getImageSend() {
        if (imageSendMessage == null) {
            imageSendMessage = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/send-dark.png").toExternalForm());
        }
        return imageSendMessage;
    }

    public Image getImageSendHover() {
        if (imageSendMessageHover == null) {
            imageSendMessageHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/dark/send-dark-hover.png").toExternalForm());
        }
        return imageSendMessageHover;
    }

    /***     Chat-content-background      */
    private static Image imageBackground;

    @Override
    public Image getImageBackground() {
        if (imageBackground == null) {
            imageBackground = new Image(ImageCacheSettingDark.class.getResource("/images/logo-dark.png").toExternalForm());
        }
        return imageBackground;
    }





}
