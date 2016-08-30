package lesson5;

import java.awt.*;

/**
 * Created by alpo123 on 17.04.16.
 */
public class Mouse {
    public static void main(String[] args) {
        while (true) {
            Point location = MouseInfo.getPointerInfo().getLocation();
            double x = location.getX();
            double y = location.getY();
            System.out.println(x + " : " + y);
        }
    }
}
