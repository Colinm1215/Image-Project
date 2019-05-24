public class Sepia extends CustomImage{
    public Sepia(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public Sepia(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }

    public void makeSepia(){
        Pixel[][] pixelGrid = getPixels();
        for (Pixel[] pixels : pixelGrid) {
            for (Pixel pixel : pixels) {
                int inputRed = pixel.getRed();
                int inputGreen = pixel.getGreen();
                int inputBlue = pixel.getBlue();
                pixel.setRed(((int)((inputRed * .393) + (inputGreen *.769) + (inputBlue * .189))));
                pixel.setGreen((int)((inputRed * .349) + (inputGreen *.686) + (inputBlue * .168)));
                pixel.setBlue((int)((inputRed * .272) + (inputGreen *.534) + (inputBlue * .131)));
                if (pixel.getBlue() > 255)
                    pixel.setBlue(255);
                if (pixel.getGreen() > 255)
                    pixel.setGreen(255);
                if (pixel.getRed() > 255)
                    pixel.setRed(255);
            }
        }
        setImage(pixelGrid);
    }
}
