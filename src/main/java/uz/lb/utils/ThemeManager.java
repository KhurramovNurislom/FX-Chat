package uz.lb.utils;

import javafx.scene.Parent;

import java.net.URL;
import java.util.List;

public class ThemeManager {

    // Tashqi CSS faylga yo‘l (resources ichidagi yo‘l)
    private static final String BASE_CSS_PATH = "/css/settings/settings.css";

    // Tema o‘rnatish metodi
    public static void applyTheme(Parent root, boolean darkMode) {
        // Avvalgi barcha stylesheet'larni o‘chirib tashlaymiz
        List<String> stylesheets = root.getStylesheets();
        stylesheets.clear();

        // Tema faylini aniqlaymiz
        String finalPath = darkMode
                ? BASE_CSS_PATH.replace(".css", "-dark.css")
                : BASE_CSS_PATH;

        // Faylni yuklaymiz
        URL url = ThemeManager.class.getResource(finalPath);

        if (url == null) {
            System.err.println("❌ CSS fayl topilmadi: " + finalPath);
            return;
        }

        // CSS faylni ulaymiz
        stylesheets.add(url.toExternalForm());
        System.out.println("✅ CSS yuklandi: " + url);
    }
}
