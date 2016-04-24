package tank.bf.tanks;

import tank.ActionField;
import tank.Attak;
import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Water;

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

    private ActionField af;

    private int armor = 1;

    public Tiger(ActionField af, BattleField bf) {
        super(bf);
        this.af = af;
        movePath = 2;
        armor = 1;

    }
    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        this.af = af;
        movePath = 2;
        setImage();

        armor =1;
    }
    private void setImage() {
        images = new Image[4];
        try {
            iTank_up = ImageIO.read(new File("tiger_up.png").getAbsoluteFile());
            iTank_down = ImageIO.read(new File("tiger_down.png").getAbsoluteFile());
            iTank_left = ImageIO.read(new File("tiger_left.png").getAbsoluteFile());
            iTank_right = ImageIO.read(new File("tiger_right.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image: ");
        }

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


    @Override
    public Action setUp() throws Exception{
        Random r = new Random();
        int k = 0;
        int i = attack();

        switch (i) {
            case 1: turn(Direction.UP);
                break;
            case 2: turn(Direction.DOWN);
                break;
            case 3: turn(Direction.LEFT);
                break;
            case 4: turn(Direction.RIGHT);
                break;
        }

        do {
            k = r.nextInt(3);
        } while (k == 0);
        if (k == 2) return Action.FIRE;
        if (k == 1) return Action.MOVE;

        return Action.MOVE;
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
    int i = 1;
    public int attack() throws Exception {

        T34 defender = (T34) af.getDefender();

        System.out.println("aggressor = " + this.getX()/64 + " : " + this.getY()/64);

        int xd = defender.getX();
        int yd = defender.getY();
        System.out.println("defender = " + xd + " : " + yd);
        int xa = this.getX();
        int ya = this.getY();
        i++;
        if (i % 2 == 0) {
            if (xa != xd) {
                return (this.getX() > xd ? 3 : 4);
            }
        }
        if (i % 2 != 0) {
            if (ya != yd) {
                return (this.getY() > yd ? 1 : 2);
            }
        }
        return i;
    }


}
