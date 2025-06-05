package uz.lb.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.prefs.Preferences;

public class SystemThemeDetector {
    public static boolean isDarkTheme() {

        try {
            Preferences systemRoot = Preferences.userRoot().node("Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize");
            int appsUseLightTheme = systemRoot.getInt("AppsUseLightTheme", 1);
            return appsUseLightTheme == 0; // 0 - dark, 1 - light
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Default to light theme
        }
    }
}
