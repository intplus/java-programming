package lesson12;

import javax.swing.*;
import java.awt.*;

public class Balls extends JPanel implements Runnable{

    private static final int WIDTH = 400;

    private int x = 100;
    int y = 100;
    private int speed;
    Color c;

    private static int count = 8;

    private static Balls[] balls;
//    private static Integer[] time = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28};

    public Balls(int x, int y, int speed, Color c) throws Exception {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.c = c;

    }

    public static void main(String[] args) throws Exception{
        new Balls();
    }

    public Balls() throws Exception {

//        Random rnd = new Random();

        balls = new Balls[count];
        Integer[] time = {10, 12, 14, 16, 18, 20, 22, 24, 26, 28};

//        for(int i = 0; i < count; ++i) {
//
//            balls[i] = new Balls(0, 0, time[rnd.nextInt(10)], COLORS[rnd.nextInt(8)]);
//        }

        JFrame frame = new JFrame("BALLS");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, 400));

        JPanel panel = new JPanel();
        panel.setLayout(null);

        for(int i = 0; i < count; ++i) {

            balls[i] = new Balls(0, 0, time[i], COLORS[i]);
            balls[i].setSize(new Dimension(800, 100));
            balls[i].setLocation(0, i * 400 / count);
        }


//        for( int i = 0; i < count; ++i) {
//            newThread(i);
//
////            new Thread(new Runnable() {
////                @Override
////                public void run() {
////
////
////                }
////            }).start();
//        }
//        Thread.sleep(500);
//        for( int i = 0; i < count; ++i) {
//            panel.add(balls[i]);
//
//        }


        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);


        for (Balls b: balls) {
            new Thread(b).start();

        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running! " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
                while (true) {
                    repaint();
                    sleep(1000 / 60);
                }

            }
        }).start();



    }
    private void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void newThread(int i) {
        Thread t = new Thread() {
            public void run() {
                try {
                    balls[i] = new Balls(0, 0, 5 * i , COLORS[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balls[i].setSize(new Dimension(800, 100));
                balls[i].setLocation(0, i * 400 / count);
                System.out.println("Running new location " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());
                // put whatever code you want to run inside the thread here.
            }
        };
        t.start();
    }

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

    @Override
    public void run() {
        System.out.println("Running repaint " + Thread.currentThread().getName() + " " + this.getClass().getSimpleName());

        while(true) {

            for (int i = 0; i < 380; i++) {
                this.x = i;
                try {
                    Thread.sleep(speed);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();


            }
            for (int i = 380; i > 0; i--) {
                this.x = i;
                try {
                    Thread.sleep(speed);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();


            }
        }


    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(c);
        g.fillOval(this.x, this.y, 20, 20);

    }



}
