package tank;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TanksTemplate extends JPanel {

    private Drawable[] tanks;

    public TanksTemplate(Drawable[] tanks) {
        this.tanks = tanks;
        if (tanks == null || tanks.length < 1) {
            this.tanks = new Drawable[0];
        }
        JFrame frame = new JFrame("BATTLE FIELD, DAY 4");
        frame.setLocation(750, 150);
//        frame.setMinimumSize(new Dimension(bf.getBfWidth(), bf.getBfHeight() + 22));
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        for (Drawable s : tanks) {
            s.draw(g);
        }
    }
}