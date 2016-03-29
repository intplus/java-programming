package Tank;

import java.awt.*;

public abstract class AbstractObject implements Drawable, Distroyable {
    protected int x;
    protected int y;
    private BattleField bf;
    private ActionField af;
    protected Color color;
    protected int armor;
    public AbstractObject(ActionField af, BattleField bf) {
        this.af = af;
        this.bf = bf;

    }
    public void draw(Graphics g) {
        g.setColor(color);
        for (int j = 0; j < bf.getDimentionY(); j++) {
            for (int k = 0; k < bf.getDimentionX(); k++) {
                if (bf.scanQuadrant(j,k).equals("B")) {
                    String coordinates = af.getQuadrantXY(k + 1, j + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.fillRect(x, y, 64, 64);
                }
            }
        }
    }
    public void destroy () {
        this.armor = armor - 1;
        if (armor < 0 ) {
            x = -100;
            y = -100;
        }
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
