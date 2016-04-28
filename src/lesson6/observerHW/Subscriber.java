package lesson6.observerHW;

/**
 * Created by alpo123 on 27.04.16.
 */
public class Subscriber implements Observer {
    private String name;
    public Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update() {
        System.out.println("         " + this.toString() + " notified.");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
