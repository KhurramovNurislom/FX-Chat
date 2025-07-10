package uz.lb.utils;

import javafx.scene.Parent;

public class ThemeManager {
    public static void applyTheme(Parent parent, String darkCss, String lightCss) {
        parent.getStylesheets().clear();
        parent.getStylesheets().add(ThemeState.isDarkMode() ? darkCss : lightCss);
    }
}
