package lesson12;

import javax.swing.*;
import java.awt.*;

/**
 * Created by homenko on 18.07.2016.
 */
public class Ball2 extends JPanel  implements Runnable{

    int x = 0;
    int y = 25;
    int width = 50;
    int height = 50;
    int time = 2;
    Color c = Color.BLUE;


    public Ball2(int x, int y, int width, int height, int time, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.time = time;
        this.c = c;
    }

    public Ball2(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(c);
        g.fillOval(x, y, width, height);
    }

    @Override
    public void run() {
        boolean a = true;
        long t = System.currentTimeMillis();
        while (true) {
            if (a == true) {
                while ((this.x + this.width + 15) < 800) {
                    this.x++;
                    try {
                        Thread.sleep(time);
                        this.repaint();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a = false;
                if (a == false) {
                    while (this.x > 0) {
                        this.x--;
                        try {
                            Thread.sleep(time);
                            this.repaint();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    a = true;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setMinimumSize(new Dimension(800, 600));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Ball2 b = new Ball2();
        Ball2 b1 = new Ball2(0, 0, 50,50,4, Color.CYAN);
        Ball2 b2 = new Ball2(0, 0, 50,50,8, Color.YELLOW);
        Ball2 b3 = new Ball2(0, 0, 50,50,16, Color.BLACK);
        Ball2 b4 = new Ball2(0, 0, 50,50,32, Color.RED);
        Ball2 b5 = new Ball2(0, 0, 50,50,64, Color.PINK);
        Ball2 b6 = new Ball2(0, 0, 50,50,128, Color.BLACK);
        Ball2 b7 = new Ball2(0, 0, 50,50,256, Color.RED);
        Ball2 b8 = new Ball2(0, 0, 50,50,512, Color.PINK);
        b.setSize(new Dimension(800, 100));
        b.setLocation(0,0);
        b1.setSize(new Dimension(800, 100));
        b1.setLocation(0,50);
        b2.setSize(new Dimension(800, 100));
        b2.setLocation(0,100);
        b3.setSize(new Dimension(800, 100));
        b3.setLocation(0,1500);
        b4.setSize(new Dimension(800, 100));
        b4.setLocation(0,200);
        b5.setSize(new Dimension(800, 100));
        b5.setLocation(0,250);
        b6.setSize(new Dimension(800, 100));
        b6.setLocation(0,300);
        b7.setSize(new Dimension(800, 100));
        b7.setLocation(0,350);
        b8.setSize(new Dimension(800, 100));
        b8.setLocation(0,400);
        panel.add(b);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        j.getContentPane().add(panel);

        j.pack();
        j.setVisible(true);

        new Thread(b).start();
        new Thread(b1).start();
        new Thread(b2).start();
        new Thread(b3).start();
        new Thread(b4).start();
        new Thread(b5).start();
        new Thread(b6).start();
        new Thread(b7).start();
        new Thread(b8).start();
    }
}
