package uz.lb.caches.colorCaches;

public class ColorCacheLight implements ColorCache {
    private ColorCacheLight() {
    }

    private static final ColorCacheLight INSTANCE = new ColorCacheLight();

    public static ColorCacheLight getInstance() {
        return INSTANCE;
    }

    private static String colorCountLabel = "#E6E6E6";
    private static String colorCountLabelHover = "#ffffff";

    private static String colorSettingButton = "#2b6fd4";
    private static String colorSelectSettingButton = "#2764be";
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
