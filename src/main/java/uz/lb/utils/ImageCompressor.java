package uz.lb.utils;

import javafx.embed.swing.SwingFXUtils;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class ImageCompressor {


    public static File saveProfileAvatar(String imagePath, Float outputQuality) {

        String nameWithoutExt = imagePath.contains(".") ? imagePath.substring(0, imagePath.lastIndexOf(".")) : imagePath;

        File output = new File(nameWithoutExt + Instant.now().getEpochSecond() + ".jpg");

        try {

            File input = new File(imagePath);

            int x = 0;
            int y = 0;

            BufferedImage image = ImageIO.read(input);

            int width = image.getWidth();
            int height = image.getHeight();

            if (width > height) {

                x = (width - height) / 2;
                width = height;

            } else if (width < height) {

                y = (height - width) / 2;
                height = width;

            }

            Thumbnails.of(input)

                    .sourceRegion(x, y, width, height)
                    .scale(1.0)
                    .outputQuality(outputQuality)
                    .toFile(output);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return output;
    }


}
