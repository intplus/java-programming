package tank.bf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by alpo123 on 13.04.16.
 */
public class Bomb implements Drawable, Distroyable {
    private String IMAGE_NAME = "fire.png";
    private Image iBomb;
    protected boolean destroyed;
    private int x;
    private int y;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
        this.destroyed = false;
        try {
            iBomb = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g) {
        int dx = 0;
        int dy = 0;

        if (!destroyed) {
            g.drawImage(iBomb, this.getX() + dx, this.getY() + dy, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });
        }
    }

    @Override
    public void destroy() {
        destroyed = true;
    }
}
