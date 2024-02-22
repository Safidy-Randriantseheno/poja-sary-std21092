package com.poja.poja_sary_std21092.service.event;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Service
public class BlackAndWhiteService {

    public void convertToBlackAndWhite(String id, byte[] imageBytes) {
        try {

            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage originalImage = ImageIO.read(bis);

            BufferedImage blackAndWhiteImage = new BufferedImage(
                    originalImage.getWidth(),
                    originalImage.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY);

            for (int y = 0; y < originalImage.getHeight(); y++) {
                for (int x = 0; x < originalImage.getWidth(); x++) {
                    Color color = new Color(originalImage.getRGB(x, y));
                    int luminance = (int) (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue());
                    int grayscale = new Color(luminance, luminance, luminance).getRGB();
                    blackAndWhiteImage.setRGB(x, y, grayscale);
                }
            }

            File output = new File("black_and_white_" + id + ".png");
            ImageIO.write(blackAndWhiteImage, "png", output);

            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

