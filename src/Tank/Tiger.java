package tank;

import java.awt.*;


public class Tiger extends AbstractTank {
    private int armor = 1;
    public Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        this.setX(128);
        this.setY(320);
        tankColor = new Color(100,17,9);
        towerColor = new Color(255, 0 ,0);

    }
    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        this.setX(128);
        this.setY(320);
        tankColor = new Color(100,17,9);
        towerColor = new Color(255, 0 ,0);

    }

    @Override
    public void destroy() {
        this.armor = armor - 1;
        if (armor < 0 ) {
            x = -100;
            y = -100;
        }
    }


}
