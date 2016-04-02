package tank.bf.tanks;

import tank.Direction;
import tank.bf.Distroyable;
import tank.bf.Drawable;

public interface Tank extends Drawable, Distroyable {

    public Action setUp() throws Exception;

    public void move();

    public Bullet fire();

    public int getX();

    public int getY();

    public Direction getDirection();

    public void updateX(int x);

    public void updateY(int y);

    public int getSpeed();

    public int getMovePath();
}
