package tank;

import javax.swing.*;
import java.awt.*;


public class ActionField extends JPanel {
    final boolean COLORDED_MODE = false;
    private BattleField bf;

    private T34 t34;
    private Tiger tiger;
    private Bullet b;
    private Direction direction;

    void runTheGame() throws Exception {

        long time = System.currentTimeMillis() / 1000;
//        long time4 = 0;
//        int i = 0;

        for (int k = 0; k < 4; ++k) {
            t34.fire();
            t34.fire();
            t34.move();

        }

//        while (cleanField()) {
//            cleanPoint();
//            clean();
//
//            if (!haveAggressor() & (i % 2 == 0)) {
//                time4 = System.currentTimeMillis() / 1000;
//                ++i;
//            }
//            long timeCheck = System.currentTimeMillis() / 1000;
//            if ((!haveAggressor()) & (timeCheck - time4 > 3)) {
////                t2 = new Aggressor(this, bf);
//                tiger = new Tiger(this, bf, 1);
//                ++i;
//                repaint();
//
//            }
//        }


        time = System.currentTimeMillis() / 1000 - time;
        int min = (int) time / 60;
        time = time % 60;
        int sec = (int) time;
        System.out.print(min + " min" + ":" + sec + " sec");
    }
//    private boolean timer() {
//        int i = 1;
//        if (i % 2 == 0) {
//            long t = System.currentTimeMillis() / 1000;
//            ++i;
//        }
//
//
//
//    }

    void clean() throws Exception {

//            if (haveAggressor()) {
//                System.out.println("aggressor = " + bf.coordFieldY(t2.getX()/64) + " : " + bf.coordFieldX(t2.getY()/64));
//                moveToQuadrant(bf.coordFieldY(t2.getX()/64), t2.getY()/64);
//            }
            String quad = radar_v4();
            int quadY = giveY(quad);
            int quadX = giveX(quad);

            System.out.println("move to: " + bf.coordFieldX(quadX) + " : " + bf.coordFieldY(quadY));

            if (checkQuadrant(quadX, quadY))
                moveToQuadrant(bf.coordFieldX(quadX), bf.coordFieldY(quadY));
    }

    void moveToQuadrant(int v, int h) throws Exception {
        int x = 0;
        int y = 0;
        while (x != v) {
            x = bf.coordFieldX(t34.getX()/bf.QUADRANT);
            if (x > v) {
                t34.turn(Direction.LEFT);
                t34.move();
            }
            if (x < v) {
                t34.turn(Direction.RIGHT);
                t34.move();
            }
        }
        while (y != h) {
            y = bf.coordFieldY(t34.getY()/bf.QUADRANT);
            if (y > h) {
                t34.turn(Direction.UP);
                t34.move();
            }
            if (y < h) {
                t34.turn(Direction.DOWN);
                t34.move();
            }
        }
    }

    void cleanPoint() throws Exception {
        Direction [] dir = Direction.values();
        for (int i = 0; i < dir.length; ++i) {

            while (lineScanner(dir[i])) {
                t34.turn(dir[i]);
                t34.fire();
            }
        }
    }
    boolean lineScanner(Direction direction) throws Exception {
        String quad = getQuadrant(t34.getX(), t34.getY());
        int quadY = giveY(quad);
        int quadX = giveX(quad);

        if (checkQuadrant(quadX, quadY)) {
            switch (direction) {
                case UP:
                    for (int i = quadY; i >= 0; i--) {
                        if (bricks(i, quadX))
                            return true;
                    }
                    break;
                case DOWN:
                    for (int i = quadY; i < bf.getDimentionY(); i++) {
                        if (bricks(i, quadX))
                            return true;
                    }
                    break;
                case LEFT:
                    for (int i = quadX; i >= 0; i--) {
                        if (bricks(quadY, i))
                            return true;
                    }
                    break;
                case RIGHT:
                    for (int i = quadX; i < bf.getDimentionX(); i++) {
                        if (bricks(quadY, i))
                            return true;
                    }
                    break;
            }

        }
        return false;
    }
    String nextTankCoord(Direction direction) throws Exception {
        int nextTankX = 0;
        int nextTankY = 0;

        switch (direction) {
            case UP:
            case DOWN:
                nextTankY = direction == Direction.UP ? t34.getY() - bf.QUADRANT : t34.getY() + bf.QUADRANT;
                nextTankX = t34.getX();

                break;
            case LEFT:
            case RIGHT:
                nextTankY = t34.getY();
                nextTankX = direction == Direction.LEFT ? t34.getX() - bf.QUADRANT : t34.getX() + bf.QUADRANT;

                break;
        }
        return getQuadrant(nextTankX, nextTankY);

    }
    void scanner(Direction direction) throws Exception {
        String quad = nextTankCoord(direction);
        int quadY = giveY(quad);
        int quadX = giveX(quad);
        if (((quadY == tiger.getY()/64) & (quadX == tiger.getX()/64))) {
            t34.fire();
        }

        if (checkBricks(quadY, quadX)) {
            t34.fire();
        }

    }
    boolean checkQuadrant(int x, int y) throws Exception {
        if (x >= 0 && x < bf.getBfWidth() && y >= 0 && y < bf.getBfHeight())
            return true;
        return false;
    }
    boolean bricks(int v, int h) throws Exception {
        if (bf.scanQuadrant(v, h).equals("B") || ((tiger.getY()/64 == v) & (tiger.getX()/64 == h)))
            return true;
        else
            return false;
    }

    boolean empty(int v, int h) throws Exception {
        if (bf.scanQuadrant(v, h).equals("") || bf.scanQuadrant(v, h).equals(" "))
            return true;
        else
            return false;
    }

    boolean checkBricks(int i, int k) throws Exception {
        if (checkQuadrant(i, k) && bricks(i, k))
            return true;
        return false;
    }
    boolean cleanField() throws Exception {
        int count = 0;
        for (int v = 0; v < bf.getDimentionY(); ++v) {
            for (int h = 0; h < bf.getDimentionX(); ++h) {
                if (empty(v, h))
                    count++;
            }
        }
        if (win(count))
            return false;
        return true;
    }
    boolean haveAggressor() throws Exception {
        int BAX = tiger.getX();
        int BAY = tiger.getY();
        if (BAX < 0 || BAY < 0 || BAX > 512 || BAY > 512 ) {
            return false;
        } else return true;

//        for (int i = 0; i < bf.getDimentionY(); ++i) {
//            for (int k = 0; k < bf.getDimentionX(); ++k) {
//                if (bf.scanQuadrant(i, k).equals("B")) ;
//
//            }
//        }
    }

    String radar_v4() throws Exception {
        int min = bf.getBfHeight() * 64;
        String min_coord = "0_0";

        for (int i = 0; i < bf.getDimentionY(); ++i) {
            for (int k = 0; k < bf.getDimentionX(); ++k) {
                if ((checkBricks(i, k)) && (dlina(getQuadrantXY(bf.coordFieldX(i), bf.coordFieldY(k))) < min)) {
                    min = dlina(getQuadrantXY(bf.coordFieldX(i), bf.coordFieldY(k)));
                    min_coord = i + "_" + k;
                }
            }
        }
        return min_coord;
    }
    boolean win(int count) throws Exception {
        if (count == 81) {
            System.out.println("WIN");
            return true;
        }
        return false;
    }
    int dlina(String str) throws Exception {
        int x = giveX(str) - t34.getX();
        int y = giveY(str) - t34.getY();
        int rez = (int) Math.sqrt(x * x + y * y);
        return rez;
    }


    int giveX(String quad) throws Exception {
        return Integer.parseInt(quad.substring(quad.indexOf("_") + 1));
    }

    int giveY(String quad) throws Exception {
        return Integer.parseInt(quad.substring(0, quad.indexOf("_")));
    }
    private boolean processInterception() throws Exception {
        String quad = getQuadrant(b.getX(), b.getY());
        int quadY = giveY(quad);
        int quadX = giveX(quad);
        if (quadX > 8 || quadY > 8) return false;


        if (!bf.scanQuadrant(quadY, quadX).trim().isEmpty()) {
            bf.updateQuadrant(quadY, quadX, "");
            return true;
        }

        if (damage(tiger)) {
            return true;
        }
        return false;
    }
    private boolean damage (AbstractTank tank) {
        if (tank.getX()/64 == b.getX()/64 & tank.getY()/64 == b.getY()/64) {
//            tank.setArmor(tank);
            tiger.destroy();
            return true;
        }
        return false;
    }

    String getQuadrantXY(int v, int h) {
        return bf.QUADRANT * (v - 1) + "_" + bf.QUADRANT * (h - 1);
    }

    String getQuadrant(int x, int y) throws Exception {
        return (int) y / bf.QUADRANT + "_" + (int) x / bf.QUADRANT;
    }
    public void processTurn(AbstractTank t34)  throws Exception {
        repaint();
    }
    public void processMove(AbstractTank t) throws Exception {
        this.t34 = t34;
        Direction direction = t34.getDirection();
        int step = 1;
        int covered = 0;

        if (noValidMove(direction)) {
            System.out.println("ignor");
            return;
        }

        t34.turn(direction);
        scanner(direction);

        while (covered < bf.QUADRANT) {
            switch (direction) {
                case UP:
                case DOWN:
                    t34.updateY(direction == Direction.UP ? - step : step);
                    break;
                case LEFT:
                case RIGHT:
                    t34.updateX(direction == Direction.LEFT ? -step : step);
                    break;
            }
            covered += step;
            newPicture(t34.getSpeed());
        }

    }
    void newPicture(int time) throws Exception {
        repaint();
        Thread.sleep(time);
    }
    boolean noValidMove(Direction direction) throws Exception {
        if ((direction == Direction.UP && t34.getY() == 0) || (direction == Direction.DOWN && t34.getY() >= bf.QUADRANT * (bf.getDimentionX() - 1))
                || (direction == Direction.LEFT && t34.getX() == 0)
                || (direction == Direction.RIGHT && t34.getX() >= bf.QUADRANT * (bf.getDimentionY() - 1)))
            return true;
        else
            return false;
    }
    void processFire(Bullet b) throws Exception {
        this.b = b;
        int step = 1;
        while (checkBullet()) {

            if (processInterception()) {
                b.distroy();
            } else
                switch (b.getDirection()) {
                    case UP:
                    case DOWN:
                        b.updateY(b.getDirection() == Direction.UP ? -step : step);
                        break;
                    case LEFT:
                    case RIGHT:
                        b.updateX(b.getDirection() == Direction.LEFT ? -step : step);
                        break;
                }
            newPicture(b.getSpeed());

        }

    }
    boolean checkBullet() throws Exception {
        if ((b.getX() > -14 && b.getX() <= bf.SIZE_FIELD * bf.QUADRANT + 10)
                && (b.getY() > -14 && b.getY() <= bf.SIZE_FIELD * bf.QUADRANT + 10))
            return true;
        return false;
    }
	/*
	 * magic
	 */


    public ActionField() throws Exception {
        bf = new BattleField();

        t34 = new T34(this, bf);
        tiger = new Tiger(this, bf);

        b = new Bullet(-100, -100, Direction.UP);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 4");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(bf.getBfWidth(), bf.getBfHeight() + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < bf.getDimentionY(); v++) {
            for (int h = 0; h < bf.getDimentionX(); h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(204, 255, 204);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(138, 246, 138);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * bf.QUADRANT, v * bf.QUADRANT, bf.QUADRANT, bf.QUADRANT);
            }
        }

        for (int j = 0; j < bf.getDimentionY(); j++) {
            for (int k = 0; k < bf.getDimentionX(); k++) {
                if (bf.scanQuadrant(j, k).equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(239, 126, 13));
                    g.fillRect(x, y, bf.QUADRANT, bf.QUADRANT);

                    g.setColor(new Color(149, 133, 117));
                    for (int m = 0; m < bf.QUADRANT; m += (bf.QUADRANT / 4))
                        g.drawLine(x, y + m, x + 63, y + m);

                    for (int m = 0, count = 0; m < bf.QUADRANT; m += 16, count += 1) {
                        int dl = 0;
                        if (count % 2 == 0)
                            dl = 10;
                        for (int l = 0; l < bf.QUADRANT; l += 24) {
                            g.drawLine(x + l + dl, y + m, x + l + dl, (y + 16) + m);
                        }
                    }
                }
            }
        }

        t34.draw(g);
        tiger.draw(g);
        b.draw(g);
    }

}
