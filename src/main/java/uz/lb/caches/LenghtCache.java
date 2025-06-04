package uz.lb.caches;

import javafx.scene.image.Image;

public class LenghtCache {
    private LenghtCache() {
    }

    /**     password-lenght     */
    private static Integer minPassword = 4;
    private static Integer maxPassword = 8;

    public static Integer getMinPassword() {
        return minPassword;
    }

    public static Integer getMaxPassword() {
        return maxPassword;
    }


}
