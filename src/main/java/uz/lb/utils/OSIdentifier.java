package uz.lb.utils;

public class OSIdentifier {
    public static String getOSName() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("mac")) {
            return "macOS";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return "Linux/Unix";
        } else {
            return null;
        }
    }
}
