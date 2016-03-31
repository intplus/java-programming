package lesson4.collection;

public class Main {
    public static void main(String[] args) {

        Person p = new Person("Alexander", 35, 10000, new Address("Kyiv", "Glubochitskaya", 44));

        System.out.println(p.hashCode());
    }
}
