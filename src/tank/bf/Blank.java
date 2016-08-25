package tank.bf;

import tank.tanks.SimpleBFObject;

import java.awt.*;

public class Blank extends SimpleBFObject {
    private String IMAGE_NAME = "grass2.png";
    private Image iGrass;

    public Blank(int x, int y) {
        super(x, y);
//        try {
//            iGrass = ImageIO.read(new File(IMAGE_NAME).getAbsoluteFile());
//        } catch (IOException e) {
//            System.err.println("Can't find image: " + IMAGE_NAME);
//        }
//        color = new Color(138, 246, 138);

    }

    @Override
    public void draw(Graphics g) {
//        if (!isDestroyed) {
//
//
//            g.drawImage(iGrass, this.getX(), this.getY(), new ImageObserver() {
//                @Override
//                public boolean imageUpdate(Image img, int infoflags, int x, int y,
//                                           int width, int height) {
//                    return false;
//                }
//            });
//        }
    }

    @Override
    public String toString() {
        return " ";
    }
}