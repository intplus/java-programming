package tank.tanks;

import java.awt.*;

public class SuperBullet extends Bullet {
    public SuperBullet() {

    }

    @Override
    public void draw(Graphics g) {
        if (!destroyed) {
            g.setColor(new Color(255, 0, 0));
//            g.fillRect(this.x, this.y, 14, 14);
        }
    }
}
