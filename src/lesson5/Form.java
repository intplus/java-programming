package lesson5;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Class Form.
 *
 * Created on: 28.03.2012
 *
 * @author: M128K145
 */
public class Form extends JFrame {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1450150616029361695L;

    /**
     * Instantiates a new form.
     */
    public Form() {
        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                get().setTitle("X: " + e.getX() + "; Y: " + e.getY());
            }
        });
        this.getContentPane().add(panel);
    }

    /**
     * Gets the.
     *
     * @return the j frame
     */
    private JFrame get() {
        return this;
    }

    /**
     * The main method.
     *
     * @param args
     *           the arguments
     */
    public static void main(String[] args) {
        new Form();
    }
}