package tank.bf;

import tank.bf.tanks.SimpleBFObject;

import java.awt.*;

public class Brick extends SimpleBFObject {
    public Brick(int x, int y) {
        super(x, y);
        color = new Color(239, 126, 13);

    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(this.color);
            g.fillRect(getX(), getY(), 64, 64);
            g.setColor(new Color(149, 133, 117));
            for (int m = 0; m < 64; m += (64 / 4)) {
                g.drawLine(getX(), getY() + m, getX() + 63, getY() + m);
            }

            for (int m = 0, count = 0; m < 64; m += 16, count += 1) {
                int dl = 0;
                if (count % 2 == 0) {
                    dl = 10;
                }
                for (int l = 0; l < 64; l += 24) {
                    g.drawLine(getX() + l + dl, getY() + m, getX() + l + dl, (getY() + 16) + m);
                }
            }
        }
    }
}

