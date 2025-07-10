package uz.lb.utils;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import uz.lb.config.AppConfig;

public class ThemeState {
    private static final BooleanProperty darkMode = new SimpleBooleanProperty(AppConfig.getBoolean("theme.night"));

    public static BooleanProperty darkModeProperty() {
        return darkMode;
    }

    public static boolean isDarkMode() {
        return darkMode.get();
    }

    public static void setDarkMode(boolean value) {
        darkMode.set(value);
    }
}
