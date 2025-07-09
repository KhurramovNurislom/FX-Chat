package uz.lb.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class AppConfig {
    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "/config/config.properties";

    static {
        try (InputStream input = AppConfig.class.getResourceAsStream(CONFIG_PATH)) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("config.properties topilmadi!");
            }
        } catch (IOException e) {
            System.err.println("Konfiguratsiyani o‘qishda xatolik: " + e.getMessage());
        }
    }

    public static boolean isDarkThemeEnabled() {
        return Boolean.parseBoolean(properties.getProperty("theme.dark", "false"));
    }

    public static void setDarkTheme(boolean enabled) {

        properties.setProperty("theme.dark", String.valueOf(enabled));

        /** Jar fayl bo'lsa bu yo'l ishlamaydi, faqat develop vaqtida */

        try (OutputStream out = new FileOutputStream("config/config.properties")) {
            properties.store(out, "Updated theme");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
