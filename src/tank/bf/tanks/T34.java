package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;

import java.awt.*;

public class T34 extends AbstractTank {
    public T34(BattleField bf) {
        super(bf);
        tankColor = new Color(0,80,0);
        towerColor = new Color(0, 100, 0);

    }
    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(0,80,0);
        towerColor = new Color(0,100,0);
    }
    private Object[] actions = new Object[] {
            Direction.RIGHT,
            Action.FIRE,
            Action.MOVE,
            Direction.LEFT,
            Action.FIRE,
            Action.MOVE,
            Direction.UP,
            Action.FIRE,
            Action.MOVE,
            Direction.DOWN,
            Action.FIRE,
            Action.MOVE
    };

    private int step = 0;

    @Override
    public Action setUp() throws Exception {
        if (step >= actions.length) {
            step = 0;
        }
        if (!(actions[step] instanceof Action)) {
            turn((Direction) actions[step++]);
        }
        if (step >= actions.length) {
            step = 0;
        }
        return (Action) actions[step++];
    }

}
