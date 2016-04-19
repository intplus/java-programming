package tank.bf;

import tank.bf.tanks.SimpleBFObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {
    private String IMAGE_NAME = "rock.png";
    private Image iRock;

    public Rock(int x, int y) {
        super(x, y);
        try {
            iRock = ImageIO.read(new File(IMAGE_NAME).getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Can't find image: " + IMAGE_NAME);
        }
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {

            g.drawImage(iRock, this.getX(), this.getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });

        }
    }
}
