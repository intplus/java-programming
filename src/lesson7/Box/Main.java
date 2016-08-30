package lesson7.Box;

import lesson7.generic.BatmanCar;
import lesson7.generic.Car;
import lesson7.generic.JamesBondCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by alpo123 on 06.05.16.
 */
public class Main {
    public static void main(String[] args) {

        Box b = new Box();
        b.setItem(new BatmanCar(2));
        b.setItem(new JamesBondCar(5));
        b.setItem(new BatmanCar(4));
        b.setItem(new BatmanCar());

        System.out.println(b);

        Collections.sort(b.getItems(), new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.getClass().getName().compareTo(o2.getClass().getName());
            }
        });

        System.out.println(b);

    }
}


