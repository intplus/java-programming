package lesson12;

import java.awt.*;
import java.io.Serializable;

public class Ball implements Runnable, Serializable {
    private int x;
    private int y;
    private int speed;
    private Color c;

    public Ball(int x, int y, int speed, Color c) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.c = c;

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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void draw(Graphics g) {

        g.setColor(this.c);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void run() {

        while(true) {

            for (int i = 0; i < 380; i++) {
                x = i;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            for (int i = 380; i > 0; i--) {
                x = i;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
