package lesson6.observerHW;

/**
 * Created by alpo123 on 27.04.16.
 */
public interface Subject {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}