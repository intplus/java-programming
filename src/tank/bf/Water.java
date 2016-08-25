package tank.bf;

import tank.tanks.SimpleBFObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {
    private String IMAGE_NAME = "water.png";
    private Image iWater;

    public Water(int x, int y) {
        super(x, y);
        try {
            iWater = ImageIO.read(new File(IMAGE_NAME).getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Composite org =g2d.getComposite();
        Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
        g2d.setComposite(translucent);


        g.drawImage(iWater, this.getX(), this.getY(), new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                       int width, int height) {
                return false;
            }
        });
        g2d.setComposite(org);
    }

    @Override
    public String toString() {
        return "W";
    }
}
