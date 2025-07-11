package uz.lb.utils.theme;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.Map;
import java.util.function.Supplier;

public class ThemeAwareImageView {

    public static void refreshImageView(Map<ImageView, Supplier<Image>> imageMap) {
        imageMap.forEach((iv, supplier) -> iv.setImage(supplier.get()));
    }
}
