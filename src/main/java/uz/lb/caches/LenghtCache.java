package uz.lb.caches;

public class LenghtCache {
    private LenghtCache() {
    }

    /**     password-lenght     */
    private static Integer minPassword = 4;
    private static Integer maxPassword = 12;

    public static Integer getMinPassword() {
        return minPassword;
    }

    public static Integer getMaxPassword() {
        return maxPassword;
    }


}
