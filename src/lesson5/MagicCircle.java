package lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Created by alpo123 on 16.04.16.
 */
public class MagicCircle extends JPanel {

    private Color color = new Color(200, 100, 100);
    static int a = 100;
    static int b = 100;
    static int c;
    int da = 5;
    int db = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,600,400);

        Graphics2D g2d = (Graphics2D) g;
        Composite org =g2d.getComposite();
        Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_IN, 0.5f);
        g2d.setComposite(translucent);

        g.setColor(color);
        g.fillOval(a, b, 70, 70);
        g.drawString("c = " + c, 550, 350);
        g2d.setComposite(org);

    }
    private void check() {
        Random r = new Random();
        if (a + 35 < 0 || a + 35 > 600 || b + 35 < 0 || b + 35 > 400) {
            do {
                a = r.nextInt(550);
                b = r.nextInt(350);
            } while (a > 50 & b > 50);
        }

    }
    public MagicCircle() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Click");
                System.out.println(e.getX() + " : " + e.getY()+ " ; " + a + " : " + b);
                if (Math.abs(e.getX() - a + 35) < 35 && Math.abs(e.getY() - b + 35) < 35) {
                    System.out.println("YOU WIN");
                    System.exit(0);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = new Point(e.getPoint());
                c = (int) Math.sqrt((a + 35 - p.x)*(a + 35 - p.x) + (b + 35 - p.y)*(b + 35 - p.y));
                if (c < 80) {
                    check();
                    if (p.x < a + 35 & p.y < b + 35) {
                        a = a + da;
                        b = b + db;
                    }
                    if (p.x > a + 35 & p.y > b + 35) {
                        a = a - da;
                        b = b - db;
                    }
                    if (p.x < a + 35 & p.y > b + 35) {
                        a = a + da;
                        b = b - db;
                    }
                    if (p.x > a + 35 & p.y < b + 35) {
                        a = a - da;
                        b = b + db;
                    }
                    repaint();
                }

            }
        });

    }

    public static void main(String[] args) throws Exception{
        JFrame frame = new JFrame("Magic Circle");
        frame.setLocation(550, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.add(new MagicCircle());
        frame.pack();
        frame.setVisible(true);

    }

}
