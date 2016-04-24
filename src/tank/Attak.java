package tank;

import tank.bf.tanks.AbstractTank;
import tank.bf.tanks.T34;
import tank.bf.tanks.Tiger;

/**
 * Created by alpo123 on 19.04.16.
 */
public class Attak {
//    private ActionField af;
    private AbstractTank tank;
    private Tiger aggressor;
    private T34 defender;

    public void defenderAttak(AbstractTank tank) throws Exception {
        int xd = defender.getX();
        int yd = defender.getY();
        int xa = aggressor.getX();
        int ya = aggressor.getY();
        if (xd != xa) {
            aggressor.turn(xd > xa ? Direction.LEFT : Direction.RIGHT);
        }
        if (yd != ya) {
            aggressor.turn(yd > ya ? Direction.DOWN : Direction.UP);
        }

    }
}
