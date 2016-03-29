package Tank;

import java.util.Random;

public class ran {
    private int rand;
    public ran(int x) {
        Random r = new Random();
        int i = r.nextInt(x);
        if (i == 0) i = x;
        this.setRand(i);
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }
}
