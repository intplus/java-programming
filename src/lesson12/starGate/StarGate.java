package lesson12.starGate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Random;

public class StarGate extends JPanel {

    public static void main(String[] args) throws Exception {
        new StarGate();
    }
    private static final int WIDHT = 400;

    private Ship ship;

    private Gates gates;
    int topY;
    int bottomY;
    int openBottomY;
    int closeBottomY;
    private static final Color[] COLORS = new Color[] {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            new Color(30, 144, 255),
            Color.BLUE,
            new Color(123, 104, 238),
            Color.WHITE,
            Color.BLACK
    };

    public StarGate() {
        JFrame frame = new JFrame("STARGATE");
        frame.setLocation(650, 150);
        frame.setMinimumSize(new Dimension(WIDHT, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        move();

    }

    private void move() {

        Random rnd = new Random();
        ship = new Ship(10, 150, 5, COLORS[rnd.nextInt(8)]);
        gates = new Gates();

        turnOnGates();

        turnOffGates();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    moveShip();
                } catch (Exception e) {
                    //ignore
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
                while (true) {
                    repaint();
                    sleep(1000 / 60);
                }

            }
        }).start();

    }

    private void turnOnGates() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (gates) {
                        System.out.println("Mothrship: Waiting for the ship.");
                        gates.wait();
                    }
                    while(!gates.isOpen()) {
                        animateOpenGates();
                    }
                    synchronized (ship) {
                        ship.notify();
                    }
                    synchronized (gates) {
                        gates.notify();
                    }

                } catch (Exception e) {
                    //ignore
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void turnOffGates() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (gates) {
                        System.out.println("Mothrship: Gates turn off");
                        gates.wait();
                    }
                    while(gates.isOpen()) {
                        animateCloseGate();
                    }
//                    synchronized (ship) {
//                        ship.notify();
//                    }

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }).start();

    }

    private boolean isShipInRange() {
        return ship.getX() > (gates.getTopX() - 20) && ship.getX() < (gates.getTopX() + 20);
    }

    private void animateCloseGate() {
        topY = gates.getTopY();
        bottomY = gates.getBottomY();
        closeBottomY = gates.getCloseBottomY();

        System.out.print("");

        if (gates.isOpen() & !isShipInRange()) {
            if (gates.getTopY() < gates.getCloseTopY()) {
                topY++;
                gates.setTopY(topY);
            }
            if (gates.getBottomY() > gates.getCloseBottomY()) {
                bottomY--;
                gates.setBottomY(bottomY);
            }
            if (gates.getTopY() == gates.getCloseTopY()) {
                gates.setBottomY(closeBottomY);
                gates.setOpen(true);
                System.out.println("Mothrship: Gate closed");
                gates.setOpen(false);
//                synchronized (ship) {
//                    ship.notify();
//                }
            } else {
                sleep(25);
            }
        }
    }
    private void animateOpenGates() {

        topY = gates.getTopY();
        bottomY = gates.getBottomY();
        openBottomY = gates.getOpenBottomY();

        if (!gates.isOpen()) {
            if (gates.getTopY() > gates.getOpenTopY()) {
                topY--;
                gates.setTopY(topY);
            }
            if (gates.getBottomY() < gates.getOpenBottomY()) {
                bottomY++;
                gates.setBottomY(bottomY);
            }
            if (gates.getTopY() == gates.getOpenTopY()) {
                gates.setBottomY(openBottomY);
                gates.setOpen(true);
                System.out.println("Mothrship: Gates opened, please come in");
                synchronized (ship) {
                    ship.notify();
                }
            } else {
                sleep(25);
            }
        }

    }


    private void moveShip() throws Exception {
        System.out.println("move Ship");
        int x = ship.getX();

        while (ship.getX() <= WIDHT - ship.getRadius() * 5) {
            if (!gates.isOpen() && isShipInRange()) {
                synchronized (gates) {
                    gates.notify();
                    System.out.println("Ship: Asked permission");
                }
                synchronized (ship) {
                    System.out.println(" and waiting gates to open");
                    ship.wait();
                }
            }

//            x = ship.getX();
            ship.setX(x++);
            sleep(10);

        }
        System.out.println("Ship: Back home, waiting for other tasks.");
        sleep(1000);
        move();


    }

    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ship.getC());
        g.fillOval(ship.getX(), ship.getY(), ship.getRadius() * 3, ship.getRadius() * 3);

        g.setColor(gates.getC());
        g.fillRect(gates.getTopX(), gates.getTopY(), gates.getTopWidht(), gates.getDoorHeight());
        g.fillRect(gates.getBottomX(), gates.getBottomY(), gates.getBottomWidth(), gates.getDoorHeight());
//        g.fillRect(300, 50, 22, 100);
//        g.fillRect(300, 150, 20, 100);

    }
}
