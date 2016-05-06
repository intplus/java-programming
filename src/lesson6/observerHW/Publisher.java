package lesson6.observerHW;

import java.util.Observable;

public class Publisher extends Observable {

    private double jobResult = 0;

    public Publisher() {
    }
    public void doTheJob() {
        Issue issue = new Issue();
        issue.number();
        if (issue.isHaveIssue()) {
            System.out.println(this.toString());
            setChanged();
            notifyObservers();
        }
    }

    public double getJobResult() {
        return jobResult;
    }

}
