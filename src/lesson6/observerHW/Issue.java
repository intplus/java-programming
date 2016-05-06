package lesson6.observerHW;

import java.util.Random;

/**
 * Created by alpo123 on 27.04.16.
 */
public class Issue {
    private boolean haveIssue;
    public Issue() {

    }
    public void number() {

        Issue issue = new Issue();
        Random r = new Random();
        int i = r.nextInt(2);
        switch (i) {
            case 0:
                haveIssue = true;
                break;
            case 1:
                haveIssue = false;
                break;
        }

    }

    public boolean isHaveIssue() {
        return haveIssue;
    }
}
