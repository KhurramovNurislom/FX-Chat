package uz.lb.utils;

import javafx.scene.Parent;


public class ThemeBinder {
    public static void bind(Parent parent, String darkCss, String lightCss) {
        Runnable apply = () -> ThemeManager.applyTheme(parent, darkCss, lightCss);
        apply.run();
        ThemeState.darkModeProperty().addListener((obs, oldVal, newVal) -> apply.run());
    }
}