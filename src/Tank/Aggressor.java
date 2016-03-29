package Tank;


public class Aggressor extends AbstractTank {
    private ran r;

    public Aggressor(ActionField af, BattleField bf) {
        super(af, bf);
        this.setX(128);
        this.setY(320);
    }

    public Aggressor(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf);
        this.setX(256);
        this.setY(256);
    }

    private void choiceXYAggressor() {
        int choice;
        r = new ran(3);
        choice = r.getRand();
        switch (choice) {
            case 1:
                this.setX(256);
                this.setY(448);
                this.setDirection(Direction.UP);
                break;
            case 2:
                this.setX(7*64);
                this.setY(2*64);
                this.setDirection(Direction.LEFT);
                break;
            case 3:
                this.setX(3*64);
                this.setY(5*64);
                this.setDirection(Direction.DOWN);
                break;

        }


    }
}
