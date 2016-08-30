package lesson7.reflection;

import tank.tanks.BT7;

/**
 * Created by alpo123 on 11.05.16.
 */
public class Main {
    public static void main(String[] args) {
        RefInfo ri = new RefInfo();

        Class cl = BT7.class;
        ri.printClassinfo(cl);
        ri.printClassFields(cl);
        ri.printClassMethod(cl);
    }
}
