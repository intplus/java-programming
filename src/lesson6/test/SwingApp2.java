package lesson6.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingApp2 {

    private JFrame frame;
    private JButton btn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try {
                    SwingApp2 app = new SwingApp2();
                    app.frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    public SwingApp2(){
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Hello Swing");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 80));
        frame.setSize(300, 80);
        frame.setLocationRelativeTo(null);
//        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SwingApp2.class.getResource("tiger_up.png")));
        frame.getContentPane().setLayout(new BorderLayout());

        btn = new JButton("PUSH");
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Thread thr = new Thread(){
                    @Override
                    public void run(){
                        try {
                            Thread.sleep(2000);
                            System.out.println("Done");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                };
                thr.start();

            }
        });
        frame.add(btn, BorderLayout.CENTER);
    }
}
