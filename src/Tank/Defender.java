package Tank;

public class Defender extends AbstractTank {
    private int x;
    private int y;
    private Direction direction;
    private ActionField af;
    private BattleField bf;

    public Defender(ActionField af, BattleField bf) {
        super(af, bf);


    }

    public Defender(ActionField af, BattleField bf, int x, int y, Direction direction) {

        super(af, bf, x, y, direction);

    }
}
