package uz.lb.caches.imageCaches.message_content;

import javafx.scene.image.Image;
import uz.lb.caches.imageCaches.setting.ImageCacheSettingDark;

public class ImageCacheMessageContentLight implements ImageCacheMessageContent {
    private ImageCacheMessageContentLight() {
    }
    private static final ImageCacheMessageContentLight INSTANCE = new ImageCacheMessageContentLight();
    public static ImageCacheMessageContentLight getInstance() {
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
            imageSearch = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/search-light.png").toExternalForm());
        }
        return imageSearch;
    }

    @Override
    public Image getImageSearchHover() {
        if (imageSearchHover == null) {
            imageSearchHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/search-light-hover.png").toExternalForm());
        }
        return imageSearchHover;
    }

    @Override
    public Image getImageOpenInfo() {
        if (imageOpenInfo == null) {
            imageOpenInfo = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/open-info-light.png").toExternalForm());
        }
        return imageOpenInfo;
    }

    @Override
    public Image getImageOpenInfoHover() {
        if (imageOpenInfoHover == null) {
            imageOpenInfoHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/open-info-light-hover.png").toExternalForm());
        }
        return imageOpenInfoHover;
    }

    @Override
    public Image getImageSetting() {
        if (imageSetting == null) {
            imageSetting = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/setting-light.png").toExternalForm());
        }
        return imageSetting;
    }

    @Override
    public Image getImageSettingHover() {
        if (imageSettingHover == null) {
            imageSettingHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/setting-light-hover.png").toExternalForm());
        }
        return imageSettingHover;
    }

    @Override
    public Image getImagePhone() {
        if (imagePhone == null) {
            imagePhone = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/phone-light.png").toExternalForm());
        }
        return imagePhone;
    }

    @Override
    public Image getImagePhoneHover() {
        if (imagePhoneHover == null) {
            imagePhoneHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/phone-light-hover.png").toExternalForm());
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
            imageAddFiles = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/add-files-light.png").toExternalForm());
        }
        return imageAddFiles;
    }

    @Override
    public Image getImageAddFilesHover() {
        if (imageAddFilesHover == null) {
            imageAddFilesHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/add-files-light-hover.png").toExternalForm());
        }
        return imageAddFilesHover;
    }

    @Override
    public Image getImageMic() {
        if (imageMic == null) {
            imageMic = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/mic-light.png").toExternalForm());
        }
        return imageMic;
    }

    @Override
    public Image getImageMicHover() {
        if (imageMicHover == null) {
            imageMicHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/mic-light-hover.png").toExternalForm());
        }
        return imageMicHover;
    }


    public Image getImageSticker() {
        if (imageSticker == null) {
            imageSticker = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/sticker-light.png").toExternalForm());
        }
        return imageSticker;
    }

    public Image getImageStickerHover() {
        if (imageStickerHover == null) {
            imageStickerHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/sticker-light-hover.png").toExternalForm());
        }
        return imageStickerHover;
    }


    public Image getImageSend() {
        if (imageSendMessage == null) {
            imageSendMessage = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/send-light.png").toExternalForm());
        }
        return imageSendMessage;
    }

    public Image getImageSendHover() {
        if (imageSendMessageHover == null) {
            imageSendMessageHover = new Image(ImageCacheSettingDark.class.getResource("/images/dashboard/chat-contents/light/send-light-hover.png").toExternalForm());
        }
        return imageSendMessageHover;
    }

    /***     Chat-content-background      */
    private static Image imageBackground;

    @Override
    public Image getImageBackground() {
        if (imageBackground == null) {
            imageBackground = new Image(ImageCacheSettingDark.class.getResource("/images/logo-light.png").toExternalForm());
        }
        return imageBackground;
    }





}
