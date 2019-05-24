public class ColorSkewedImage extends CustomImage{

    public ColorSkewedImage(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public ColorSkewedImage(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }

    public void skewToRed() {
        Pixel[][] pixelGrid = getPixels();
        for (Pixel[] pixels : pixelGrid) {
            for (Pixel pixel : pixels) {
                pixel.setBlue(pixel.getBlue()-5);
                pixel.setGreen(pixel.getGreen()-5);
//                pixel.setRed(pixel.getRed()-5);
            }
        }
        setImage(pixelGrid);
    }

    public void skewToGreen() {
        Pixel[][] pixelGrid = getPixels();
        for (Pixel[] pixels : pixelGrid) {
            for (Pixel pixel : pixels) {
                pixel.setBlue(pixel.getBlue()-5);
//                pixel.setGreen(pixel.getGreen()-5);
                pixel.setRed(pixel.getRed()-5);
            }
        }
        setImage(pixelGrid);
    }

    public void skewToBlue() {
        Pixel[][] pixelGrid = getPixels();
        for (Pixel[] pixels : pixelGrid) {
            for (Pixel pixel : pixels) {
//                pixel.setBlue(pixel.getBlue()-5);
                pixel.setGreen(pixel.getGreen()-5);
                pixel.setRed(pixel.getRed()-5);
            }
        }
        setImage(pixelGrid);
    }
}
