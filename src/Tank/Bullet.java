package Tank;

import java.awt.*;

public class Bullet implements Drawable, Distroyable{

    int speed = 2;
    int x;
    int y;
    Direction direction;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
    public Direction getDirection() {
        return direction;
    }
    public int getSpeed() {
        return speed;
    }
    public void updateX (int dx) {
        this.x += dx;
    }
    public void updateY (int dy) {
        this.y += dy;
    }
    public void distroy() {
        x = -100;
        y = -100;
    }
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(this.x, this.y, 14, 14);
    }


}
