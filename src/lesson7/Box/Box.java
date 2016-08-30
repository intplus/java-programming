package lesson7.Box;

import lesson7.generic.BatmanCar;
import lesson7.generic.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by alpo123 on 06.05.16.
 */
public class Box<T extends Car>
//        implements Comparable<T>
 {

    private ArrayList <T> items;

    public Box() {
        items = new ArrayList<>();
    }

    private boolean checkI(int i) {
        if (i > items.size() - 1 || i < 0) {
            return false;
        }
        return true;
    }

    public T getItem(int i) {
        if (checkI(i)) {
            return items.get(i);
        }
        return null;
    }

    public void setItem(T item) {
        items.add(item);
    }

    public void deleteItem(T item) {
        items.remove(item);
    }
    public void deleteItem(int i) {
        if (checkI(i)) {
            items.remove(i);
        }
    }

    @Override
    public String toString() {
        String str = "";
//        System.out.println(items);
        for (T num: items) {
            str += num + "; ";
        }
        return str;
    }
     public ArrayList<T> getItems() {
         return items;
     }
 }


