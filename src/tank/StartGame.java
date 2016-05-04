package tank;

import tank.bf.BattleField;

import javax.management.BadAttributeValueExpException;
import java.awt.*;

/**
 * Created by alpo123 on 01.05.16.
 */
public class StartGame {

    public StartGame(int ch) throws Exception{
//        int ch = 1;
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    ActionField af = new ActionField(ch);
//                    af.runTheGame();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        ActionField af = new ActionField(ch);
        af.runTheGame();

    }
}
