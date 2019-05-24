public class FadedEdges extends CustomImage{
    public FadedEdges(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public FadedEdges(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }
    
    public void fadeToWhite() {
        Pixel[][] pixelGrid = getPixels();
        int centerR = pixelGrid.length/2;
        int centerC = pixelGrid[0].length/2;
        for (int r = 0; r < pixelGrid.length; r++) {
            for (int c = 0; c < pixelGrid[0].length; c++){
                double dist = Math.sqrt(Math.pow(centerC-c,2) + Math.pow(centerR-r,2));
                int alpha = 255-(int)(dist/pixelGrid.length*255);
                pixelGrid[r][c].setAlpha(alpha);
            }
        }
        setImage(pixelGrid);
    }

    public void fadeToBlack() {
        Pixel[][] pixelGrid = getPixels();
        int centerR = pixelGrid.length/2;
        int centerC = pixelGrid[0].length/2;
        for (int r = 0; r < pixelGrid.length; r++) {
            for (int c = 0; c < pixelGrid[0].length; c++){
                double dist = Math.sqrt(Math.pow(centerC-c,2) + Math.pow(centerR-r,2));
                double scale = 0.6;
                Pixel pixel = pixelGrid[r][c];
                pixel.setBlue(Math.max(0, pixel.getBlue()-((int)(dist*scale))));
                pixel.setRed(Math.max(0, pixel.getRed()-((int)(dist*scale))));
                pixel.setGreen(Math.max(0, pixel.getGreen()-((int)(dist*scale))));
            }
        }
        setImage(pixelGrid);
    }
}
