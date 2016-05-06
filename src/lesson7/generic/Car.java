package lesson7.generic;

import java.awt.*;

/**
 * Created by alpo123 on 06.05.16.
 */
public abstract class Car {

    private int countDoor;
    private Color color;

    public Car() {

    }

    public void startEngine() {
        //code
    }
    public void stopEngine() {
        //code
    }

    public int getCountDoor() {
        return countDoor;
    }

    public void setCountDoor(int countDoor) {
        this.countDoor = countDoor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
