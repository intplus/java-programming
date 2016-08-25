package lesson12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Balls3 extends JPanel{

    public static void main(String[] args) throws Exception{
        new Balls3();
    }

    private static final int WIDTH = 400;
    private Boll b;
    private List<Boll> bolls = new LinkedList();

    private static final Color[] COLORS = new Color[]{
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            new Color(30,144,255),
            Color.BLUE,
            new Color(123,104,238),
            Color.WHITE,
            Color.BLACK
    };


    public Balls3()  throws InterruptedException{
        JFrame frame = new JFrame("BOLLS");
        frame.setLocation(450, 150);
        frame.setMinimumSize(new Dimension(WIDTH, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        createBalls();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    repaint();
                    try {
                        Thread.sleep(1000/60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    public  void createBalls(){
        int line = 10;
        int speed = 10;
        for(Color col: COLORS){
            b = new Boll(col,20,line,20,20,speed);
            bolls.add(b);
            new Thread(b).start();
            line+=30;
            speed++;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Boll boll: bolls){
            boll.draw(g);
        }
    }


    class Boll implements Runnable{
        Color color;
        int x;
        int y;
        int w;
        int h;
        int speed;

        Boll(Color color, int x, int y, int w, int h, int speed){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.speed = speed;
            this.color = color;
        }

        public void action() throws InterruptedException{
            int step = 1;
            while(true){
                x+=step;
                if(x<0 || x>(WIDTH-36)){step*=-1;}
                Thread.sleep(speed);
            }
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, w , h);
        }

        @Override
        public void run() {
            try {
                action();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
