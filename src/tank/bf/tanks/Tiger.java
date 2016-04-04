package tank.bf.tanks;

import tank.ActionField;
import tank.Direction;
import tank.bf.BattleField;

import java.awt.*;
import java.util.Random;


public class Tiger extends AbstractTank {

    private int armor = 1;

    public Tiger(BattleField bf) {
        super(bf);
        tankColor = new Color(100,17,9);
        towerColor = new Color(255, 0 ,0);
        armor = 1;

    }
    public Tiger(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(100,17,9);
        towerColor = new Color(255, 0 ,0);
        armor =1;
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }
    int size = 0;
    @Override
    public Action setUp() {
//        int dir = ran(4);
//        switch (dir) {
//            case 1: setDirection(Direction.UP);
//
//                break;
//            case 2: setDirection(Direction.DOWN);
//
//                break;
//            case 3: setDirection(Direction.RIGHT);
//
//                break;
//            case 4: setDirection(Direction.LEFT);
//
//                break;
//        }

        Random r = new Random();
        int k = 0;
        do {
            k = r.nextInt(3);
            System.out.println("k = " + k);
        } while (k == 0);
        if (k == 1) return Action.FIRE;
        if (k == 2) return Action.MOVE;

        return Action.FIRE;
    }


}
