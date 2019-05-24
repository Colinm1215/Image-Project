public class Mirror extends CustomImage {
    public Mirror(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public Mirror(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }

    public void mirrorHorizontal() {
        Pixel[][] pixelGrid = getPixels();
        int midAxis = pixelGrid[0].length/2;
        for (int r = 0; r < pixelGrid.length; r++) {
            for (int c = 0; c < midAxis; c++) {
                Pixel pixel = pixelGrid[r][c];
                pixelGrid[r][pixelGrid[0].length-1-c].setGreen(pixel.getGreen());
                pixelGrid[r][pixelGrid[0].length-1-c].setRed(pixel.getRed());
                pixelGrid[r][pixelGrid[0].length-1-c].setBlue(pixel.getBlue());
            }
        }
        setImage(pixelGrid);
    }

    public void mirrorVertical() {
        Pixel[][] pixelGrid = getPixels();
        int midAxis = pixelGrid.length/2;
        for (int r = 0; r < midAxis; r++) {
            for (int c = 0; c < pixelGrid[0].length; c++) {
                Pixel pixel = pixelGrid[r][c];
                pixelGrid[pixelGrid.length-1-r][c].setGreen(pixel.getGreen());
                pixelGrid[pixelGrid.length-1-r][c].setRed(pixel.getRed());
                pixelGrid[pixelGrid.length-1-r][c].setBlue(pixel.getBlue());
            }
        }
        setImage(pixelGrid);
    }
}
