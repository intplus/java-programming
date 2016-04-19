package tank.bf.tanks;

import tank.ActionField;
import tank.Direction;
import tank.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Tiger extends AbstractTank {
    private Image iTank_up;
    private Image iTank_down;
    private Image iTank_left;
    private Image iTank_right;
//    private Image iTank;

    private int armor = 1;

    public Tiger(BattleField bf) {
        super(bf);
        movePath = 2;
        armor = 1;

    }
    public Tiger(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        movePath = 2;
        try {
            iTank_up = ImageIO.read(new File("tiger_up.png").getAbsoluteFile());
            iTank_down = ImageIO.read(new File("tiger_down.png").getAbsoluteFile());
            iTank_left = ImageIO.read(new File("tiger_left.png").getAbsoluteFile());
            iTank_right = ImageIO.read(new File("tiger_right.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image: ");
        }
        armor =1;
    }
    private Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }
    int size = 0;
    @Override
    public Action setUp() throws Exception{


        Random r = new Random();
        int k = 0;

//        attack();




        turn((Direction) actionsDirection[ran(4)]);
        do {
            k = r.nextInt(3);
        } while (k == 0);
        if (k == 1) return Action.FIRE;
        if (k == 2) return Action.MOVE;

        return Action.FIRE;
    }
    private void attack() {
        int x = this.getX()/64;
        int y = this.getY()/64;

    }

    @Override
    public void draw(Graphics g) {
        int dx = 0;
        int dy = 0;

        if (!destroyed) {
            if (getDirection() == Direction.UP) {
                iTank = iTank_up;
                dx = 9;
                dy = 0;
            }
            if (getDirection() == Direction.DOWN) {
                iTank = iTank_down;
                dx = 9;
                dy = 0;
            }
            if (getDirection() == Direction.LEFT) {
                iTank = iTank_left;
                dx = 0;
                dy = 9;
            }
            if (getDirection() == Direction.RIGHT) {
                iTank = iTank_right;
                dx = 0;
                dy = 9;
            }


            g.drawImage(iTank, this.getX() + dx, this.getY() + dy, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });

        }
    }


}
