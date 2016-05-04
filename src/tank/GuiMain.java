package tank;

import tank.bf.BattleField;
import tank.bf.tanks.Bullet;
import tank.bf.tanks.Tank;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alpo123 on 03.05.16.
 */
public class GuiMain extends JPanel {
    private BattleField bf;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;

//    public GuiMain(BattleField bf) {
//        this.bf = bf;
//        JFrame frame = new JFrame("BATTLE FIELD, DAY 9");
//        frame.setLocation(750, 150);
//        frame.setMinimumSize(new Dimension(bf.getBfWidth(), bf.getBfHeight() + 22));
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.getContentPane().add(this);
//        frame.pack();
//        frame.setVisible(true);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        int i = 0;
//        Color cc;
//        for (int v = 0; v < 9; v++) {
//            for (int h = 0; h < 9; h++) {
////                grass = new Blank(v, h);
//                cc = new Color(138, 246, 138);
//                i++;
//                g.setColor(cc);
//                g.fillRect(h * 64, v * 64, 64, 64);
//
//            }
//        }
//
//        bf.draw(g);
//        defender.draw(g);
//        aggressor.draw(g);
//        bullet.draw(g);
////        bomb.draw(g);
//    }
//    public void newPicture(int time) throws Exception {
//        repaint();
//        Thread.sleep(time);
//    }
}
