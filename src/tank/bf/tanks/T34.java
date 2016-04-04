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
            Action.MOVE,
            Action.FIRE,

    };
    private Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };

    private int step = 0;

    @Override
    public Action setUp() throws Exception{

        turn((Direction) actionsDirection[ran(4)]);
        return (Action) actions[ran(2)];
    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(tankColor);
//            g.fillRect(this.getX() + 20, this.getY() + 20, 24, 24);
            g.fillOval(this.getX() + 18, this.getY() + 18, 28, 28);

            g.setColor(towerColor);
            if (getDirection() == Direction.UP) {
                g.fillRect(getX() + 12, getY() + 16, 8, 32);
                g.fillRect(getX() + 44, getY() + 16, 8, 32);
                g.fillRect(getX() + 28, getY() + 4, 8, 34);
            }
            if (getDirection() == Direction.DOWN) {
                g.fillRect(getX() + 12, getY() + 16, 8, 32);
                g.fillRect(getX() + 44, getY() + 16, 8, 32);
                g.fillRect(getX() + 28, getY() + 26, 8, 34);
            }
            if (getDirection() == Direction.LEFT) {
                g.fillRect(getX() + 16, getY() + 12, 32, 8);
                g.fillRect(getX() + 16, getY() + 44, 32, 8);
                g.fillRect(getX() + 4, getY() + 28, 34, 8);
            }
            if (getDirection() == Direction.RIGHT) {
                g.fillRect(getX() + 16, getY() + 12, 32, 8);
                g.fillRect(getX() + 16, getY() + 44, 32, 8);
                g.fillRect(getX() + 26, getY() + 28, 34, 8);
            }
        }
    }
}
