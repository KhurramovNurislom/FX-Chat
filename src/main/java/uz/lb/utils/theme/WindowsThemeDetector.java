package uz.lb.utils.theme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WindowsThemeDetector {
    public static boolean isNightTheme() {
        try {
            Process process = Runtime.getRuntime().exec(
                    "reg query HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize /v AppsUseLightTheme"
            );

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("AppsUseLightTheme")) {
                    // 0 = dark mode, 1 = light mode
                    String[] parts = line.trim().split("\\s+");
                    String value = parts[parts.length - 1];
                    return "0x0".equalsIgnoreCase(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
