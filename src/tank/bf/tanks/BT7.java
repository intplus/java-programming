package tank.bf.tanks;

import tank.Direction;
import tank.bf.BattleField;
import tank.bf.Water;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BT7 extends AbstractTank{
    private Image iTank_up;
    private Image iTank_down;
    private Image iTank_left;
    private Image iTank_right;
//    private Image iTank;
    boolean target = false;
    private int lastX;
    private int lastY;
    private Logic logic;

    int speed = 5;
//    LinkedList<String> rezList2 = new LinkedList<>();

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
        logic = new Logic(bf, this);
//        setImages();
        try {
            iTank_up = ImageIO.read(new File("bt_up.png").getAbsoluteFile());
            iTank_down = ImageIO.read(new File("bt_down.png").getAbsoluteFile());
            iTank_left = ImageIO.read(new File("bt_left.png").getAbsoluteFile());
            iTank_right = ImageIO.read(new File("bt_right.png").getAbsoluteFile());

        } catch (IOException e) {
            System.err.println("Can't find image: ");
        }
    }
//    private void setImages() {
//        images = new Image[4];
//        try {
//            images[0] = ImageIO.read(new File("bt_up.png").getAbsoluteFile());
//            images[1] = ImageIO.read(new File("bt_down.png").getAbsoluteFile());
//            images[2] = ImageIO.read(new File("bt_left.png").getAbsoluteFile());
//            images[3] = ImageIO.read(new File("bt_right.png").getAbsoluteFile());
//        } catch (IOException e) {
//            throw new IllegalStateException("Can't find images");
//        }
//    }
    private Object[] actions = new Object[] {
            Action.MOVE,
            Action.FIRE,
    };
    public Object[] actionsDirection = new Object[] {
            Direction.UP,
            Direction.DOWN,
            Direction.RIGHT,
            Direction.LEFT
    };
    public void attack() {

    }

    @Override
    public Action setUp() throws Exception {

        int act = 0;
        if (!target) {
            logic.searchWay(this, 4, 8);
            target = true;
        }
        int choice;
        choice = logic.ran(2);
        System.out.println(logic.getRezList());

        switch (choice) {
            case 0:
//            case 1:
                logic.moveToQuadrant(this, logic.getRezList().size());
                break;
            case 1:
                act = 1;
                break;
        }
        System.out.println(getDirection());
//        turn((Direction) actionsDirection[ran(4)]);
        return (Action) actions[act];

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
