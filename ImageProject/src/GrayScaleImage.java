public class GrayScaleImage extends CustomImage{

    public GrayScaleImage(String fileName, int x, int y) {
        super(fileName, x, y);
        makeGrayScale();
    }

    public GrayScaleImage(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
        makeGrayScale();
    }

    public void makeGrayScale(){
        //set each pixel's RGB to be the average of its original RGB...
        //(100, 150, 200) -> (150, 150, 150)
        Pixel[][] pix = getPixels();

        for(Pixel[] row: pix){
            for(Pixel p : row){
                int sum = p.getRed() + p.getBlue() + p.getGreen();
                int ave = sum / 3;
                p.setBlue(ave);
                p.setGreen(ave);
                p.setRed(ave);
            }
        }
        setImage(pix);
    }


}
