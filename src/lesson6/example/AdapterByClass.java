package lesson6.example;

/**
 * Created by alpo123 on 25.04.16.
 */
public class AdapterByClass extends Adaptee implements Target {
    @Override
    public String newRequest() {
        return oldRequest();
    }
}
