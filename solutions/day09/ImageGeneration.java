package solutions.day09;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageGeneration {
    private static int height = 100;
    private static int width = 100;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("inputs/day09"));

        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        for (int i = 0; i < height; i++) {
            int[] heights = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < width; j++) {
                int rgb = heights[j] * 28;
                g.setColor(new Color(rgb, rgb, rgb));
                g.fillRect(i, j, width, height);
            }
        }
        image = resizeImage(image, 1000, 1000);
        File outputfile = new File("solutions/day09/heightmap.jpg");
        ImageIO.write(image, "jpg", outputfile);
    }

    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
            throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
