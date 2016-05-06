package lesson5.graphic;

import javax.swing.*;
import java.awt.*;

public class Main_Graphic {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLocation(300, 100);
        f.setMinimumSize(new Dimension(800, 600));

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();

        f.setVisible(true);
    }
}
