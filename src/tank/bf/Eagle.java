package tank.bf;

import tank.bf.tanks.SimpleBFObject;

import java.awt.*;

public class Eagle extends SimpleBFObject {
    public Eagle(int x, int y) {
        super(x, y);
        color = new Color(255, 0, 0);

    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {
            g.setColor(this.color);
            int[] x = {this.getX()+32, this.getX()+25,this.getX()+5, this.getX()+18,
                    this.getX()+10, this.getX()+32, this.getX()+54, this.getX()+46, this.getX()+59, this.getX()+39};
            int[] y = {this.getY()+5, this.getY()+23, this.getY()+23, this.getY()+37, this.getY()+59, this.getY()+45,
                    this.getY()+59, this.getY()+37, this.getY()+23, this.getY()+23};
            g.fillPolygon(x, y, 10);
        }
    }

}
