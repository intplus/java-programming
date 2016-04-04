package tank;

import tank.bf.BFObject;
import tank.bf.BattleField;
import tank.bf.Blank;
import tank.bf.tanks.*;
import tank.bf.tanks.Action;

import javax.swing.*;
import java.awt.*;


public class ActionField extends JPanel {
    final boolean COLORDED_MODE = false;

    private BattleField bf;
    private Tank defender;
    private Tank aggressor;
    private Bullet bullet;

    void runTheGame() throws Exception {

        while (true) {
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(aggressor.setUp(), aggressor);
            }
            if (!aggressor.isDestroyed() && !defender.isDestroyed()) {
                processAction(defender.setUp(), defender);
            }
        }
    }
    private void processAction(Action a, Tank t) throws Exception {
        if (a == Action.MOVE) {
            processMove(t);
        } else if (a == Action.FIRE) {
            processTurn(t);
            processFire(t.fire());
        }
    }

    int giveX(String quad) throws Exception {
        return Integer.parseInt(quad.substring(quad.indexOf("_") + 1));
    }

    int giveY(String quad) throws Exception {
        return Integer.parseInt(quad.substring(0, quad.indexOf("_")));
    }
    private boolean processInterception() throws Exception {
        String quad = getQuadrant(bullet.getX(), bullet.getY());
        int y = giveY(quad);
        int x = giveX(quad);

        if (y >= 0 && y < 9 && x >= 0 && x < 9) {
            BFObject bfObject = bf.scanQuadrant(y, x);
            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank)) {
                bf.destroyObject(y, x);
                return true;
            }

            // check aggressor
            if (!aggressor.isDestroyed() && checkInterception(getQuadrant(aggressor.getX(),
                    aggressor.getY()), quad)) {
                aggressor.destroy();
                return true;
            }

            // check aggressor
            if (!defender.isDestroyed() && checkInterception(getQuadrant(defender.getX(),
                    defender.getY()), quad)) {
                defender.destroy();
                return true;
            }

        }
        return false;
    }
    public String getQuadrant(int x, int y) {
        // input data should be correct
        return y / 64 + "_" + x / 64;
    }
    private boolean checkInterception(String object, String quadrant) {
        int oy = Integer.parseInt(object.split("_")[0]);
        int ox = Integer.parseInt(object.split("_")[1]);

        int qy = Integer.parseInt(quadrant.split("_")[0]);
        int qx = Integer.parseInt(quadrant.split("_")[1]);

        if (oy >= 0 && oy < 9 && ox >= 0 && ox < 9) {
            if (oy == qy && ox == qx) {
                return true;
            }
        }
        return false;
    }

    public void processTurn(Tank tank)  throws Exception {
        repaint();
    }
    public void processMove(Tank tank) throws Exception {
        processTurn(tank);
        Direction direction = tank.getDirection();
        int step = 1;

        for (int i = 0; i < tank.getMovePath(); i++) {
            int covered = 0;

            String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
            int v = Integer.parseInt(tankQuadrant.split("_")[0]);
            int h = Integer.parseInt(tankQuadrant.split("_")[1]);

            // check limits x: 0, 513; y: 0, 513
            if ((direction == Direction.UP && tank.getY() == 0) || (direction == Direction.DOWN && tank.getY() >= 512)
                    || (direction == Direction.LEFT && tank.getX() == 0) || (direction == Direction.RIGHT && tank.getX() >= 512)) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }

            // check next quadrant before move
            if (direction == Direction.UP) {
                v--;
            } else if (direction == Direction.DOWN) {
                v++;
            } else if (direction == Direction.RIGHT) {
                h++;
            } else if (direction == Direction.LEFT) {
                h--;
            }

            BFObject bfobject = bf.scanQuadrant(v, h);
            if (!(bfobject instanceof Blank) && !bfobject.isDestroyed()) {
                System.out.println("[illegal move] direction: " + direction
                        + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
                return;
            }

            while (covered < 64) {
                switch (direction) {
                    case UP:
                    case DOWN:
                        tank.updateY(direction == Direction.UP ? -step : step);
                        break;
                    case LEFT:
                    case RIGHT:
                        tank.updateX(direction == Direction.LEFT ? -step : step);
                        break;
                }
                covered += step;
                newPicture(tank.getSpeed());
            }
        }

    }
    void newPicture(int time) throws Exception {
        repaint();
        Thread.sleep(time);
    }

    void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while (checkBullet()) {

            if (processInterception()) {
                bullet.destroy();
            } else
                switch (bullet.getDirection()) {
                    case UP:
                    case DOWN:
                        bullet.updateY(bullet.getDirection() == Direction.UP ? -step : step);
                        break;
                    case LEFT:
                    case RIGHT:
                        bullet.updateX(bullet.getDirection() == Direction.LEFT ? -step : step);
                        break;
                }
            newPicture(bullet.getSpeed());
            if (bullet.isDestroyed()) {
                break;
            }

        }

    }
    boolean checkBullet() throws Exception {
        if ((bullet.getX() > -14 && bullet.getX() <= 9 * 64 + 10)
                && (bullet.getY() > -14 && bullet.getY() <= 9 * 64 + 10))
            return true;
        return false;
    }
	/*
	 * magic
	 */


    public ActionField() throws Exception {
        bf = new BattleField();

        defender = new T34(bf);
        String location = bf.getAggressorLocation();
        aggressor = new BT7(bf,
                Integer.parseInt(location.split("_")[1]), Integer.parseInt(location.split("_")[0]), Direction.RIGHT);


        bullet = new Bullet(-100, -100, Direction.NONE);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 7");
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
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
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
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }


        bf.draw(g);
        defender.draw(g);
        aggressor.draw(g);
        bullet.draw(g);
    }

}
