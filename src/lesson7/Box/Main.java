package lesson7.Box;

import lesson7.generic.BatmanCar;
import lesson7.generic.Car;
import lesson7.generic.JamesBondCar;

import java.util.ArrayList;

/**
 * Created by alpo123 on 06.05.16.
 */
public class Main {
    public static void main(String[] args) {

        Box b = new Box();
        b.setItem(new BatmanCar());
        b.setItem(new JamesBondCar());
        b.setItem(new BatmanCar());

        System.out.println(b.getItem(2));

        System.out.println(b);

    }
}
