package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;
import java.awt.*;

public class BT7 extends AbstractTank {
    int speed = 2 * this.speed;
    public BT7(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }
    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        movePath = 2;
    }

    @Override
    public Action setUp() {
        return Action.MOVE;
    }
}
