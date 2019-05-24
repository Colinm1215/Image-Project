import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


// Colin Mettler
public class Main extends JPanel {

    static int SCALE_MIN = 1;
    static int SCALE_INIT = 10;
    static int SCALE_MAX = 20;
    double scale = 1;
    JLabel label = new JLabel("");

    private CustomImage img, img2;

    public Main(int w, int h){
        setSize(w, h);
        String filename = "iu-2.jpeg";
//        img = new GrayScaleImage(filename, 0, 0);
        img2 = new Mirror(filename, 0, 0);
        ((Mirror) img2).mirrorVertical();
//        }

    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        img2.draw(g2, scale);
    }

    public static void main(String[] args) {
        //The JFrame class represents the window that holds the graphics
        JFrame window = new JFrame("Images!");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1200, 800 + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main(1200, 800);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
//        window.setResizable(false);
    }
}
