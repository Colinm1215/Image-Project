public class NegativeImage extends CustomImage {
    public NegativeImage(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public NegativeImage(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }

    public void makeNegative() {
        Pixel[][] pixelGrid = getPixels();
        for (Pixel[] pixels : pixelGrid) {
            for (Pixel pixel : pixels) {
                pixel.setRed(255-pixel.getRed());
                pixel.setBlue(255-pixel.getBlue());
                pixel.setGreen(255-pixel.getGreen());
            }
        }
        setImage(pixelGrid);
    }
}
