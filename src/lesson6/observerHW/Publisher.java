package lesson6.observerHW;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements Subject {

    private List<Observer> observers;

    public Publisher() {
        observers = new ArrayList<>();
    }
    public void doTheJob() {
        Issue issue = new Issue();
        issue.number();
        if (issue.isHaveIssue()) {
            System.out.println(this.toString());
            notifyObservers();
        }
    }
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
