package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class BT7 extends AbstractTank {
    private Image iTank_up;
    private Image iTank_down;
    private Image iTank_left;
    private Image iTank_right;
    private Image iTank;
    boolean target = false;

    int speed = 5;

    @Override
    public int getSpeed() {
        return speed;
    }

    public BT7(BattleField bf) {
        super(bf);
        movePath = 1;
    }
    public BT7(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        movePath = 1;
        try {
            iTank_up = ImageIO.read(new File("bt_up.png"));
            iTank_down = ImageIO.read(new File("bt_down.png"));
            iTank_left = ImageIO.read(new File("bt_left.png"));
            iTank_right = ImageIO.read(new File("bt_right.png"));

        } catch (IOException e) {
            System.err.println("Can't find image: ");
        }
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

    @Override
    public Action setUp() throws Exception {
        if (!target) {
            searchWay(this);
            target = true;
        }
        System.out.println(rezList.size());
        int choice;
        choice = ran(1);

        switch (choice) {
            case 0: if (rezList.size() != 0) {
                System.out.println(rezList);
                step(rezList.getLast());
                rezList.removeLast();
            } else {
                target = false;
            }
                break;
            case 1: break;
        }

//        turn((Direction) actionsDirection[ran(4)]);
        return (Action) actions[choice];

    }

    private void step(String str) throws Exception {
        System.out.println("str = " + str);

        int separator = str.indexOf("_");
        int x = Integer.parseInt(str
                .substring(0, separator));
        int y = Integer.parseInt(str
                .substring(separator + 1));

        int xt = this.getX()/64;
        int yt = this.getY()/64;
        System.out.println("tan = " + xt + "_" + yt);

        if (xt != x) {
            turn(xt > x ? Direction.LEFT : Direction.RIGHT);
        }
        if (yt != y) {
            turn(yt > y ? Direction.UP : Direction.DOWN);
        }

    }

    @Override
    public void draw(Graphics g) {
        int dx = 0;
        int dy = 0;

        if (!destroyed) {
            if (getDirection() == Direction.UP) {
                iTank = iTank_up;
                dx = 11;
                dy = 3;
            }
            if (getDirection() == Direction.DOWN) {
                iTank = iTank_down;
                dx = 11;
                dy = 3;
            }
            if (getDirection() == Direction.LEFT) {
                iTank = iTank_left;
                dx = 3;
                dy = 11;
            }
            if (getDirection() == Direction.RIGHT) {
                iTank = iTank_right;
                dx = 3;
                dy = 11;
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
