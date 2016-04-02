package tank.bf;

import tank.bf.tanks.SimpleBFObject;

import java.awt.Color;

public class Blank extends SimpleBFObject {

    public Blank(int x, int y) {
        super(x, y);
        color = new Color(180, 180, 180);
    }
}