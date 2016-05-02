package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Water;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class T34 extends AbstractTank {
    private String IMAGE_NAME;
//    private Image iTank;
    private Image iTank_up;
    private Image iTank_down;
    private Image iTank_left;
    private Image iTank_right;

    public T34(BattleField bf) {
        super(bf);
        try {
            iTank_up = ImageIO.read(new File("t34_up.png").getAbsoluteFile());
            iTank_down = ImageIO.read(new File("t34_down.png").getAbsoluteFile());
            iTank_left = ImageIO.read(new File("t34_left.png").getAbsoluteFile());
            iTank_right = ImageIO.read(new File("t34_right.png").getAbsoluteFile());
        } catch (IOException e) {
            System.err.println("Can't find image: ");
        }


    }
    public T34(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
    }

    private Object[] actions = new Object[] {
            Action.MOVE,
            Action.FIRE,

    };
    private Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };
    public int ran(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }


    @Override
    public Action setUp() throws Exception{

        turn((Direction) actionsDirection[ran(4)]);
        return (Action) actions[ran(2)];
    }
//    public Action setUp() {
//        if (step >= actoins.length) {
//            step = 0;
//        }
//        if (!(actoins[step] instanceof Action)) {
//            turn((Direction) actoins[step++]);
//        }
//        if (step >= actoins.length) {
//            step = 0;
//        }
//        return (Action) actoins[step++];
//    }

//    private void setImage() {
//        tankImage = new Image[5];
//        try{
//
//            tankImage[1] = ImageIO.read(new File(IMAGE1).getAbsoluteFile());
//            tankImage[2] = ImageIO.read(new File(IMAGE2).getAbsoluteFile());
//            tankImage[3] = ImageIO.read(new File(IMAGE3).getAbsoluteFile());
//            tankImage[4] = ImageIO.read(new File(IMAGE4).getAbsoluteFile());
//
//        } catch (IOException e) {
//            System.err.println("T34 can't find image:");
//
//        }
//    }
//
//    }


    @Override
    public void draw(Graphics g) {

        int dx = 0;
        int dy = 0;

        if (!destroyed) {
            if (getDirection() == Direction.UP) {
                iTank = iTank_up;
                dx = 9;
                dy = 3;
            }
            if (getDirection() == Direction.DOWN) {
                iTank = iTank_down;
                dx = 9;
                dy = 3;
            }
            if (getDirection() == Direction.LEFT) {
                iTank = iTank_left;
                dx = 3;
                dy = 9;
            }
            if (getDirection() == Direction.RIGHT) {
                iTank = iTank_right;
                dx = 3;
                dy = 9;
            }

            int v = getY()/64;
            int h = getX()/64;
            float f = 1.0f;
            if (bf.scanQuadrant(v, h) instanceof Water) {
                f = 0.5f;
            } else {
                f = 1.0f;
            }
            Graphics2D g2d = (Graphics2D) g;
            Composite org =g2d.getComposite();
            Composite translucent = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, f);
            g2d.setComposite(translucent);

            g.drawImage(iTank, this.getX() + dx, this.getY() + dy, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y,
                                           int width, int height) {
                    return false;
                }
            });
            g2d.setComposite(org);

        }
    }
}
