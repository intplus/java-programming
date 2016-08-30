package lesson6.example;

/**
 * Created by alpo123 on 24.04.16.
 */
public class AdapterByObject implements Target {

    private Adaptee adaptee;

    public AdapterByObject() {
        adaptee = new Adaptee();
    }

    @Override
    public String newRequest() {
        return adaptee.oldRequest();
    }
}
