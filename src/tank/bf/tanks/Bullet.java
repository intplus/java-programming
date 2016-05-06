package tank.bf.tanks;

import tank.Direction;
import tank.bf.Distroyable;
import tank.bf.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Bullet implements Drawable, Distroyable {

    private int speed = 2;
    private int x;
    private int y;
    private Direction direction;
    protected boolean destroyed;

    public Bullet() {

    }

    private String IMAGE_NAME = "bullet.png";
    private Image iBullet;

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.destroyed = false;
        try {
            iBullet = ImageIO.read(new File(IMAGE_NAME).getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }

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
    public int getSpeed() {
        return speed;
    }
    public void updateX (int x) {
        this.x += x;
    }
    public void updateY (int y) {
        this.y += y;
    }

    @Override
    public void draw(Graphics g) {
        int dx = 0;
        int dy = 0;

        if (!destroyed) {
            g.drawImage(iBullet, this.getX() + dx, this.getY() + dy, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });

        }
    }
    public void destroy() {
        destroyed = true;
    }
    @Override
    public boolean isDestroyed() {
        return destroyed;
    }
}
