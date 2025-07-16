package uz.lb.caches.colorCaches;


public class ColorCacheManager {

    private static ColorCache colorCache;

    public static void init(boolean isDark) {
        colorCache = isDark ? ColorCacheDark.getInstance() : ColorCacheLight.getInstance();
    }

    public static ColorCache getColorCache() {
        if (colorCache == null) {
            throw new IllegalStateException("ImageCacheManager not initialized!");
        }
        return colorCache;
    }

}
