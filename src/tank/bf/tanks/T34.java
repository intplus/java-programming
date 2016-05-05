package tank.bf.tanks;

import tank.ActionField;
import tank.Direction;
import tank.bf.*;

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
    private ActionField af;
    private Logic logic;

    public T34(ActionField af, BattleField bf) {
        super(bf);
        this.af = af;
        logic = new Logic(bf, this);

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

    public int ran(int i) {
        Random r = new Random();
        return r.nextInt(i);
    }

    @Override
    public Action setUp() throws Exception {
        int xd = 0;
        int yd = 0;

        int act = 0;
        if (af.getAggressor() instanceof BT7) {
            BT7 aggressor = (BT7) af.getAggressor();
            xd = aggressor.getX()/64;
            yd = aggressor.getY()/64;

        }

        if (af.getAggressor() instanceof Tiger) {
            Tiger aggressor = (Tiger) af.getAggressor();
            xd = aggressor.getX()/64;
            yd = aggressor.getY()/64;

        }

        logic.searchWay(this, xd, yd);

        int choice;
        choice = logic.ran(2);
        System.out.println(logic.getRezList());

        if (lineScanner()) {
            choice = 1;
        }
        if (lineScannerEagle()) {
            choice = 0;
        }

        switch (choice) {
            case 0:
                logic.moveToQuadrant(this, logic.getRezList().size());
                break;
            case 1:

                act = 1;
                break;
        }
        return (Action) actions[act];

    }
    private boolean lineScannerEagle() {
        for (int i = 1; i < 9; ++i) {
            if (checkBrick(this.getY(), this.getX() - i)) {
                break;
            }
            if (checkBrick(this.getY(), this.getX() + i)) {
                break;
            }
            if (checkBrick(this.getY() + i, this.getX())) {
                break;
            }
            if (checkEagle(this.getY(), this.getX() - i)) {
                return true;
            }
            if (checkEagle(this.getY(), this.getX() + i)) {
                return true;
            }
            if (checkEagle(this.getY() + i, this.getX())) {
                return true;
            }

        }
        return false;
    }
    private boolean checkBrick(int v, int h) {
        if (v > 8 || v < 0 || h > 8 || h < 0) {
            return false;
        }
        if (bf.scanQuadrant(v, h) instanceof Brick) {
            return true;
        }
        return false;
    }

    private boolean checkEagle(int v, int h) {
        if (v > 8 || v < 0 || h > 8 || h < 0) {
            return false;
        }
        if (bf.scanQuadrant(v, h) instanceof Eagle) {
            return true;
        }
        return false;
    }

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
//public void cleanPoint() throws Exception {
//
//    for (int i = 1; i < 5; i++) {
//        direction.setId(i);
//        while (lineScanner(direction.getId())) {
//            processFire();
//        }
//    }
//}
    private boolean checkRock(int v, int h) {
        if (v > 8 || v < 0 || h > 8 || h < 0) {
            return false;
        }
        if (bf.scanQuadrant(v, h) instanceof Rock) {
            return true;
        }
        return false;
    }
    private boolean lineScanner() {

        int xa = 0;
        int ya = 0;
        if (af.getAggressor() instanceof BT7) {
            BT7 aggressor = (BT7) af.getAggressor();
            xa = aggressor.getX()/64;
            ya = aggressor.getY()/64;

        }

        if (af.getAggressor() instanceof Tiger) {
            Tiger aggressor = (Tiger) af.getAggressor();
            xa = aggressor.getX()/64;
            ya = aggressor.getY()/64;

        }
        for (int i = 1; i < 9; ++i) {

            if (!checkRock(this.getY()/64 - i, this.getX()/64)) {
                if (this.getX() / 64 == xa && this.getY() / 64 - i == ya) {
                    turn(Direction.UP);
                    return true;
                }
            } else {
                break;
            }
            if (!checkRock(this.getY() + i, this.getX() / 64)) {
                if (this.getX() / 64 == xa && this.getY() / 64 + i == ya) {
                    turn(Direction.DOWN);
                    return true;
                }
            } else {
                break;
            }

            if (!checkRock(this.getY()/64, this.getX()/64 - i)) {
                if (this.getX() / 64 - i == xa && this.getY() / 64 == ya) {
                    turn(Direction.LEFT);
                    return true;
                }
            } else {
                break;
            }
            if (!checkRock(this.getY()/64, this.getX()/64 + i)) {
                if (this.getX()/64 + i == xa && this.getX() / 64 == ya) {
                    turn(Direction.RIGHT);
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
    }



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
