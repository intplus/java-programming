package lesson6.example;

/**
 * Created by alpo123 on 24.04.16.
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        System.out.println("Adapter Pattern Demo");
        System.out.println();

//        Target target1 = new AdapterByObject();
        Target target2 = new AdapterByClass();

//        System.out.println(target1.newRequest());
        System.out.println(target2.newRequest());
    }
}
