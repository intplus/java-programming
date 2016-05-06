package lesson5.graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class HowToDraw extends JPanel {
    static int x = 50;
    private final static String IMAGE_NAME = "t34_up.png";
    private Image iTank;

    public HowToDraw() {
        try {
            iTank = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,600,400);

        g.setColor(Color.RED);
        g.fillRect(x,100,50,50);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString("Hello World", 150, 200);

        g.drawImage(iTank, 0, 0, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                    int width, int height) {
                return false;
            }
        });
    }

    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("DAY 8, 2D Graphics");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(new HowToDraw());
        frame.pack();
        frame.setVisible(true);



        HowToDraw htd = new HowToDraw();
        Thread.sleep(3000);
        System.out.println("woke up");
        x = 150;
        htd.repaint();

    }

}
