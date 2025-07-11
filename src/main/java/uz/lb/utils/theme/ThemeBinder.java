package uz.lb.utils.theme;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uz.lb.caches.imageCaches.ImageCacheManager;

import java.util.Map;
import java.util.function.Supplier;


public class ThemeBinder {
    public static void bind(Parent parent, String darkCss, String lightCss, Map<ImageView, Supplier<Image>> imageMap) {
        Runnable apply = () -> {
            ThemeManager.applyTheme(parent, darkCss, lightCss);
            if (imageMap != null)
                ThemeAwareImageView.refreshImageView(imageMap);
        };
        apply.run();
        ThemeState.darkModeProperty().addListener((obs, oldVal, newVal) -> {
            ImageCacheManager.init(newVal);
            apply.run();
        });
    }
}