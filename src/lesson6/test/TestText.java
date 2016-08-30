package lesson6.test;

import java.awt.*;
import javax.swing.*;

/**
 * Created by alpo123 on 04.05.16.
 */
public class TestText extends JPanel {

    public TestText() {
        super(new FlowLayout());

        //Create and set up the window.
        JFrame frame = new JFrame("Tank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(400, 200));

        //Create and set up the content pane.
        JLabel text = new JLabel("text");

        frame.getContentPane().add(text);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new TestText();
    }

}
