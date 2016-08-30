package lesson6.test.Snake;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.io.*;
import java.util.Random;
import javax.swing.JPanel;

/**
 * In fact the whole game here
 * @see /Snake./java
 */
public class SnakeGame extends JPanel {

    private static final int wallStep = 10;
    private Shape walls1 = new Polygon();
    private Shape walls2 = new Polygon();
    private Shape walls3 = new Polygon();
    private Snake snake = new Snake(2, 2, wallStep);
    private Point orange = new Point();
    private Point cherry = new Point();
    private int points = 0;
    private boolean GameOver;
    private int lastPressedKey = 0;
    private final Random rand = new Random();
    private String message = null;

    /**
     * Cycle of game
     * @link Snake#getSpeed()
     * @see Snake#getSpeed
     */
    public SnakeGame() {
        super(true);
        Dimension d = getLevel("sn1.dat");
        putOrange();
        putCherry();
        setPreferredSize(d);
        setMinimumSize(d);
        setMaximumSize(d);
        setSize(d);
        Thread th = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    gameCycle();
                    try {
                        Thread.sleep(500 - snake.getSpeed());
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        th.start();
    }

    /**
     * Put fruit on map
     */
    private void putOrange() {
        int x = 5;
        int y = 5;
        while (walls2.contains(x, y)) {
            x = wallStep * rand.nextInt(40) + 2;
            y = wallStep * rand.nextInt(40) + 2;
        }
        orange.setLocation(x, y);
    }

    /**
     * Put fruit on map
     */
    private void putCherry() {
        int x = 5;
        int y = 5;
        while (walls2.contains(x, y)) {
            x = wallStep * rand.nextInt(40) + 2;
            y = wallStep * rand.nextInt(40) + 2;
        }
        cherry.setLocation(x, y);
    }

    public Snake getSnake() {
        return snake;
    }

    /**
     * Convert map-file to our map
     *@param fileName Map location
     */
    private Dimension getLevel(String fileName) {
        int minX = 500, maxX = 0, minY = 500, maxY = 0;
        Area w1 = new Area();
        Area w2 = new Area();
        Area w3 = new Area();

        BufferedReader input = null;
        try {
            File file = new File(fileName);
            input = new BufferedReader(new FileReader(file));
            String line = null;

            for (int y = 0; (line = input.readLine()) != null; y++) {
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == '1') {
                        minX = Math.min(minX, x * wallStep);
                        maxX = Math.max(maxX, (x + 1) * wallStep + 4);
                        minY = Math.min(minY, y * wallStep);
                        maxY = Math.max(maxY, (y + 1) * wallStep + 4);

                        w1.add(new Area(new Rectangle(x * wallStep, y * wallStep, wallStep, wallStep)));
                        w2.add(new Area(new Rectangle(x * wallStep + 2, y * wallStep + 2, wallStep, wallStep)));
                        w3.add(new Area(new Rectangle(x * wallStep + 4, y * wallStep + 4, wallStep, wallStep)));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        walls1 = w1;
        walls2 = w2;
        walls3 = w3;
        Dimension d = new Dimension(maxX - minX, maxY - minY);
        return d;
    }

    /**
     * Game cycle.
     * Checking fruit-eating, crash against the wall. Print Game-over-message.
     * @link Snake#getDirection()
     * @see Snake#getDirection
     *@link Snake#expand()
     * @see Snake#expand
     */
    public void gameCycle() {
        if (snake.getDirection() != Snake.DIR_POUSE) {
            setMessage(null);
        }
        Point p = snake.move();
        if (p.x == orange.x && p.y == orange.y) {
            points += 100;
            snake.expand();
            putOrange();
        }
        if (p.x == cherry.x && p.y == cherry.y) {
            points += 100;
            snake.expand();
            putCherry();
        }
        if (walls2.contains(p)) {
            if (snake.getDirection() != Snake.DIR_POUSE) {
                points -= 50;
                GameOver = true;
            }
            snake.setDirection(Snake.DIR_POUSE);
            setMessage("Game over!");
        }
        this.repaint();
    }

    private void setMessage(String msg) {
        message = msg;
    }

    /**
     * Render the game, without snake.
     * @link Snake#paint()
     * @see Snake#paint
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.gray);
        g2.fill(walls3);
        g2.setColor(Color.lightGray);
        g2.fill(walls1);
        g2.setColor(Color.white);
        g2.fill(walls2);
        g2.setColor(Color.orange);
        g2.fillArc(orange.x, orange.y, wallStep, wallStep, 0, 360);
        g2.setColor(Color.black);
        g2.drawArc(orange.x, orange.y, wallStep, wallStep, 0, 360);
        g2.setColor(Color.red);
        g2.fillArc(cherry.x, cherry.y, wallStep, wallStep, 0, 360);
        g2.setColor(Color.black);
        g2.drawArc(cherry.x, cherry.y, wallStep, wallStep, 0, 360);
        snake.paint(g2);
        g2.setColor(Color.black);
        g2.drawString("Points: " + points, 2, 10);
        if (message != null) {
            g2.setColor(Color.yellow);
            g2.fillRect(150, 100, 100, 30);
            g2.setColor(Color.black);
            g2.drawRect(150, 100, 100, 30);
            g2.drawString(message, 160, 120);
        }
    }

    /**
     * Key logger. Checking opposite-moving. Set last pressed key.
     * @link Snake#setDirection()
     * @see Snake#setDirection
     * @param ev
     */
    public void processKey(KeyEvent ev) {
        Snake snake = getSnake();
        switch (ev.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (lastPressedKey != KeyEvent.VK_LEFT && !GameOver) {
                    snake.setDirection(Snake.DIR_RIGHT);
                    lastPressedKey = KeyEvent.VK_RIGHT;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (lastPressedKey != KeyEvent.VK_RIGHT && !GameOver) {
                    snake.setDirection(Snake.DIR_LEFT);
                    lastPressedKey = KeyEvent.VK_LEFT;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (lastPressedKey != KeyEvent.VK_UP && !GameOver) {
                    snake.setDirection(Snake.DIR_DOWN);
                    lastPressedKey = KeyEvent.VK_DOWN;
                }
                break;
            case KeyEvent.VK_UP:
                if (lastPressedKey != KeyEvent.VK_DOWN && !GameOver) {
                    snake.setDirection(Snake.DIR_UP);
                    lastPressedKey = KeyEvent.VK_UP;
                }
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    void setScore(int x) {
        points = points + x;
    }
    /**
     * Nulling gameplay variables
     */
    void newGame() {
        GameOver = false;
        points = 0;
        lastPressedKey = 0;
    }

    int getPoints() {
        return points;
    }
}
