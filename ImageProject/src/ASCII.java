import java.awt.*;

public class ASCII extends CustomImage {
    private String[][] stringGrid;

    private static String densityString = "@#$%&8BMW*mwqpdbkhaoQ0OZXYUJCL][}{1)(|\\/?Il!i><+_-~;\":^,`'.";
    public ASCII(String fileName, int x, int y) {
        super(fileName, x, y);
    }

    public ASCII(Pixel[][] pixels, int x, int y) {
        super(pixels, x, y);
    }

    public void genASCII(){
        Pixel[][] pixelGrid = getPixels();
        stringGrid = new String[pixelGrid.length][pixelGrid[0].length];
        for (int r = 0; r < pixelGrid.length; r++) {
            for (int c = 0; c < pixelGrid[0].length; c++) {
                int totalCol = pixelGrid[r][c].getRed()+pixelGrid[r][c].getGreen()+pixelGrid[r][c].getBlue();
                int aveCol = totalCol/3;
                int strIndex = (aveCol*(densityString.length()-1))/255;
                stringGrid[r][c] = densityString.substring(strIndex, strIndex+1);
            }
        }
    }

    @Override
    public void draw(Graphics2D g2, double scale) {
//        super.draw(g2, scale);
        Point location = getLocation();
        String[][] strings = stringGrid;
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        for (int r = 0; r < stringGrid.length; r+=4) {
            for (int c = 0; c < stringGrid[0].length; c+=4) {
                g2.drawString(strings[r][c], location.x + c, location.y + r);
            }
        }
    }
}
