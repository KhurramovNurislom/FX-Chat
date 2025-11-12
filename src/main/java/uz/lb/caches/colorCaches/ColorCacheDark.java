package uz.lb.caches.colorCaches;

import uz.lb.caches.imageCaches.login.ImageCacheLoginDark;

public class ColorCacheDark implements ColorCache {
    private ColorCacheDark() {
    }

    private static final ColorCacheDark INSTANCE = new ColorCacheDark();

    public static ColorCacheDark getInstance() {
        return INSTANCE;
    }

    private static String colorCountLabel = "#ADBED2";
    private static String colorCountLabelHover = "#00ACE6";
    private static String colorSettingButton = "#090d10";
    private static String colorSelectSettingButton = "#253541";

    private static String colorPasswordError = "#ff5c33";

    @Override
    public String getColorCountLabel() {
        return colorCountLabel;
    }

    @Override
    public String getColorCountLabelHover() {
        return colorCountLabelHover;
    }

    @Override
    public String getColorSettingButton() {
        return colorSettingButton;
    }

    @Override
    public String getColorSelectSettingButton() {
        return colorSelectSettingButton;
    }

    @Override
    public String getColorPasswordError() {
        return colorPasswordError;
    }

}
