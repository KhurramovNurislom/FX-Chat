package uz.lb.caches;

public class ColorCache {
    private ColorCache() {
    }

    private static String color = "#ADBED2";
    private static String colorHover = "#00ACE6";

    public static String getColor() {
        return color;
    }

    public static String getColorHover() {
        return colorHover;
    }

}
