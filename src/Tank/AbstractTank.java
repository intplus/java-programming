package tank;


import java.awt.*;

public abstract class AbstractTank implements Drawable, Distroyable {

    protected int x;
    protected int y;
    protected Direction direction;
    private ActionField af;
    private BattleField bf;
    protected int SPEED = 5;
    protected int armor;
    protected Color tankColor;
    protected Color towerColor;

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public AbstractTank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }
    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public void destroy () {
        this.armor = armor - 1;
        if (armor < 0 ) {
            x = -100;
            y = -100;
        }
    }

    public void turn(Direction direction) throws Exception{
        this.direction = direction;
        af.processTurn(this);
    }

    public void move() throws Exception {
        af.processMove(this);
    }

    public void fire() throws Exception {
        Bullet b = new Bullet((x + 25), (y + 25), direction);
        af.processFire(b);
    }

    public int getSpeed() {
        return SPEED;
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

    public void moveRandom() throws Exception {

    }
    public void moveToQuadrant(int v, int h) throws Exception {

    }
    public void clean() throws Exception {

    }
    public void updateX (int x) {
        this.x += x;
    }
    public void updateY (int y) {
        this.y += y;
    }

    public void draw(Graphics g) {

        g.setColor(tankColor);
        g.fillRect(getX() + 20, getY() + 20, 24, 24);
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
