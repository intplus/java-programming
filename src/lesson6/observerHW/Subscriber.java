package lesson6.observerHW;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by alpo123 on 27.04.16.
 */
public class Subscriber implements Observer {

    public Subscriber() {
    }
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ActionEvent) {
            System.out.println(this.toString() + " notified. Event " + ((ActionEvent) arg).getName());
        } else {
            System.out.println(this.toString() + " notified.");
        }
    }

}
