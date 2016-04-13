package tank.bf;

import tank.bf.tanks.SimpleBFObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {
    private String IMAGE_NAME = "water.png";
    private Image iWater;

    public Blank(int x, int y) {
        super(x, y);
        try {
            iWater = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {

            g.drawImage(iWater, this.getX(), this.getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });
        }
    }
}