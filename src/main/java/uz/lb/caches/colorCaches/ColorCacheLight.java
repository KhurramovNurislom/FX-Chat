package uz.lb.caches.colorCaches;

import javafx.scene.paint.Color;

public class ColorCacheLight implements ColorCache{
    private ColorCacheLight() {
    }
    private static final ColorCacheLight INSTANCE = new ColorCacheLight();

    public static ColorCacheLight getInstance() {
        return INSTANCE;
    }

    private static String colorCountLabel = "#E6E6E6";
    private static String colorCountLabelHover = "#ffffff";

    @Override
    public String getColorCountLabel() {
        return colorCountLabel;
    }

    @Override
    public String getColorCountLabelHover() {
        return colorCountLabelHover;
    }

}
