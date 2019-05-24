import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixelize extends CustomImage {
    private int pixelSize = 0;
    Pixel[][] originalPixels;
    public Pixelize(String fileName, int x, int y) {
        super(fileName, x, y);
        originalPixels = getPixels();
    }

    public Pixelize(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
        originalPixels = getPixels();
    }

    public void pixelize(int pixelSize){
        setImage(originalPixels);
        Pixel[][] pixelGrid = getPixels();
        this.pixelSize = pixelSize;
        for (int r = 0; r < pixelGrid.length; r+=pixelSize) {
            for (int c = 0; c < pixelGrid[0].length; c+=pixelSize) {
                int totalRed=0;
                int totalGreen=0;
                int totalBlue=0;
                for (int r2 = r; r2 < r+pixelSize && r2 < pixelGrid.length; r2++) {
                    for (int c2 = c; c2 < c+pixelSize && c2 < pixelGrid[0].length; c2++) {
                        totalRed += pixelGrid[r2][c2].getRed();
                        totalBlue += pixelGrid[r2][c2].getBlue();
                        totalGreen += pixelGrid[r2][c2].getGreen();
                    }
                }
                int averageRed = totalRed/(pixelSize*pixelSize);
                int averageBlue = totalBlue/(pixelSize*pixelSize);
                int averageGreen = totalGreen/(pixelSize*pixelSize);

                averageBlue = Math.max(0, averageBlue);
                averageBlue = Math.min(255,averageBlue);

                averageGreen = Math.max(0, averageGreen);
                averageGreen = Math.min(255, averageGreen);

                averageRed = Math.max(0, averageRed);
                averageRed = Math.min(255, averageRed);



                for (int r2 = r; r2 < r+pixelSize && r2 < pixelGrid.length; r2++) {
                    for (int c2 = c; c2 < c+pixelSize && c2 < pixelGrid[0].length; c2++) {
                        pixelGrid[r2][c2].setRed(averageRed);
                        pixelGrid[r2][c2].setBlue(averageBlue);
                        pixelGrid[r2][c2].setGreen(averageGreen);
                    }
                }
            }
        }
        setImage(pixelGrid);
    }


    @Override
    public void draw(Graphics2D g2, double scale) {
        // 0.75-0.87 for good comic book dot product
        // under 0.75 for blur/pixelate
        // above 0.87 not great
        super.draw(g2, scale);
//        Point location = getLocation();
//        Pixel[][] pixels = getPixels();
//        for (int r = 0; r < pixels.length; r+=pixelSize*0.87) {
//            for (int c = 0; c < pixels[0].length; c+=pixelSize*0.87) {
//                Pixel pixel = pixels[r][c];
//                g2.setColor(pixel.getColor());
//                g2.fillOval(location.x + c, location.y + r, pixelSize,pixelSize);
//            }
//        }
    }
}
