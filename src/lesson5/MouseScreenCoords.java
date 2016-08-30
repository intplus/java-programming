package lesson5;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//@SuppressWarnings("serial")
public class MouseScreenCoords extends JFrame {
    public MouseScreenCoords() {
        super("Mouse Screen Coordinates");
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = new Point(e.getPoint());
                System.out.println("Component coords: x = " + p.x + ", y = " + p.y);
//                SwingUtilities.convertPointToScreen(p, MouseScreenCoords.this);
//                System.out.println("Screen coords: x = " + p.x + ", y = " + p.y);
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MouseScreenCoords();
            }
        });
    }
}
