package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;
import java.awt.*;

public class BT7 extends AbstractTank {
    int speed = 2 * this.speed;
    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(2, 40, 8);
        towerColor = new Color(46, 46, 3);
        movePath = 2;
    }
    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(2, 40, 8);
        towerColor = new Color(46, 46, 3);
        movePath = 2;
    }
    private Object[] actions = new Object[] {
            Action.MOVE,
            Action.FIRE,
    };
    private Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };

    @Override
    public Action setUp() throws Exception {
//        attack();
//        turn(getDirection());
        turn((Direction) actionsDirection[ran(4)]);
        return (Action) actions[ran(2)];

    }
    private void attack() throws Exception {
        int x = 0;
        int y = 0;
        int v = 5;
        int h = 8;
            x = getX()/64 + 1;
            if (x > v) {
                setDirection(Direction.LEFT);
            }
            if (x < v) {
                setDirection(Direction.RIGHT);
            }

            y = getY()/64 + 1;
            if (y > h) {
                setDirection(Direction.UP);
            }
            if (y < h) {
                setDirection(Direction.DOWN);
        }
    }
}
