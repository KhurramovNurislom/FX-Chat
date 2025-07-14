package uz.lb.config;


import uz.lb.utils.theme.OSIdentifier;
import uz.lb.utils.theme.WindowsThemeDetector;

import java.io.*;
import java.util.Properties;


public class AppConfig {
    private static final Properties properties = new Properties();
    private static final String CONFIG_PATH = "config/config.properties";

    public static void config() {
        File configFile = new File(CONFIG_PATH);
        if (!configFile.exists()) {
            if (OSIdentifier.getOSName().equals("Windows")) {
                System.out.println(WindowsThemeDetector.isNightTheme());
                properties.setProperty("theme.night", String.valueOf(WindowsThemeDetector.isNightTheme()));
            } else {
                properties.setProperty("theme.night", "true");
            }
            saveProperties();
        }

    }

    public static void add(String key, String value) {
        loadProperties();
        if (!properties.containsKey(key)) {
            properties.setProperty(key, value);
            saveProperties();
        }
    }

    public static void remove(String key) {
        if (properties.containsKey(key)) {
            properties.remove(key);
            saveProperties();
        }
    }

    public static boolean contains(String key) {
        return properties.containsKey(key);
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static void set(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    private static void loadProperties() {
        File file = new File(CONFIG_PATH);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void saveProperties() {
        try {
            File file = new File(CONFIG_PATH);
            file.getParentFile().mkdirs();
            try (FileOutputStream fos = new FileOutputStream(file)) {
                properties.store(fos, "Application Configuration");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
