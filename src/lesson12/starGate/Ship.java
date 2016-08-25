package lesson12.starGate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Ship {
    private int x;
    private int y;
    private Color c;
    private int time;
    private int radius;
    private boolean inSide;

    public Ship() {

    }
    public Ship (int x, int y, int radius, Color c) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.c = c;
        inSide = false;

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

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isInSide() {
        return inSide;
    }

    public void setInSide(boolean inSide) {
        this.inSide = inSide;
    }
}
