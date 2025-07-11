package uz.lb.utils.theme;

import javafx.scene.Parent;
import uz.lb.config.AppConfig;

import java.util.ArrayList;
import java.util.List;

public class ThemeManager {
    public static void applyTheme(Parent parent, String darkCss, String lightCss) {
        parent.getStylesheets().clear();
        parent.getStylesheets().add(ThemeState.isDarkMode() ? darkCss : lightCss);
    }

    private static final List<Runnable> listeners = new ArrayList<>();

    public static void addListener(Runnable listener) {
        listeners.add(listener);
    }

    public static void notifyThemeChanged() {
        for (Runnable listener : listeners) {
            listener.run();
        }
    }

    public static void switchTheme(boolean light) {
        AppConfig.set("theme.light", String.valueOf(light));
        notifyThemeChanged();
    }
}
