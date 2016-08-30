package lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MagicQuadrant extends JPanel{

    private Color color = new Color(100, 100, 100);

    public MagicQuadrant() {
        JFrame frame = new JFrame("Magic Mouse");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);

        frame.addMouseListener(new CustomMouseListener());

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,600,400);

        g.setColor(color);
        g.fillRect(200,100,200,200);

    }

    public static void main(String[] args) throws Exception{
        new MagicQuadrant();

    }

    private void setColor(Color color){
        this.color = color;
    }
    private void click() {
        System.out.println("click");
        Random ran = new Random();
        int r = ran.nextInt(255);
        int g = ran.nextInt(255);
        int b = ran.nextInt(255);
        System.out.println("RGB = " + r + " , " + g + " , " + b);
        setColor(new Color(r, g, b));

        repaint();

    }

    class CustomMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX() + " : " + e.getY());
            if ((e.getX() >= 200 & e.getX() <= 400) && (e.getY() >= 125) & (e.getY() <= 325)) {
                click();
            }

        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {
        }
    }


}
