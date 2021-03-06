package tank.tanks;

import tank.ActionField;
import tank.Direction;
import tank.bf.BattleField;
import java.awt.*;

public abstract class AbstractTank implements Tank {

    protected int x;
    protected int y;

    protected Direction direction;

    protected BattleField bf;
    private int speed = 10;
    protected int movePath = 1;

    protected Image iTank;
    private ActionField af;


    protected Color tankColor;
    protected Color towerColor;
    protected boolean destroyed;
    protected Image[] images;

    public AbstractTank(BattleField bf) {
        this(bf, 64, 512, Direction.UP);

    }
    public AbstractTank(BattleField bf, int x, int y, Direction direction) {
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;

    }
    protected Object[] actions = new Object[] {
            Action.MOVE,
            Action.FIRE,
    };
    protected Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };

    public void turn(Direction direction){
        this.direction = direction;
    }

    public void move() throws Exception {
//        System.out.println("move. the end");
//        System.exit(0);
//        af.processMove();
//
    }

    public Bullet fire() {
        int bulletX = -100;
        int bulletY = -100;

        if (direction == Direction.UP) {
            bulletX = x + 23;
            bulletY = y - 10;
        } else if (direction == Direction.DOWN) {
            bulletX = x + 23;
            bulletY = y + 64;
        } else if (direction == Direction.LEFT) {
            bulletX = x - 10;
            bulletY = y + 23;
        } else if (direction == Direction.RIGHT) {
            bulletX = x + 64;
            bulletY = y + 23;
        }
        return new Bullet(bulletX, bulletY, direction);
    }

    @Deprecated
    public void clean() throws Exception {

    }
    public void updateX (int x) {
        this.x += x;
    }
    public void updateY (int y) {
        this.y += y;
    }



    public void draw(Graphics g) {

        if (!destroyed) {
            g.setColor(tankColor);
            g.fillRect(this.getX() + 20, this.getY() + 20, 24, 24);

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
    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        System.err.println("destroyed");
        destroyed = true;
    }
    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public int getMovePath() {
        return movePath;
    }

}
