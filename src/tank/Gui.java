package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;

/**
 * Created by alpo123 on 30.04.16.
 */
public class Gui extends JPanel implements ActionListener {
    static String tigerString = "tiger_up";
    static String bt7String = "bt7_up";

    JLabel picture;
    JButton b1, exitButton;
    JRadioButton tigerButton, bt7Button;


    public Gui() {

        super(new FlowLayout());

        tigerButton = new JRadioButton(tigerString);
        tigerButton.setActionCommand(tigerString);
        tigerButton.setSelected(true);

        bt7Button = new JRadioButton(bt7String);
        bt7Button.setActionCommand(bt7String);
        bt7Button.setSelected(false);

        ButtonGroup group = new ButtonGroup();
        group.add(tigerButton);
        group.add(bt7Button);

//        tigerButton.addActionListener(this);
//        bt7Button.addActionListener(this);

        System.out.println(Paths.get("tiger_up.png").toAbsolutePath());
        picture = new JLabel(createImageIcon(tigerString + ".png"));


        picture.setPreferredSize(new Dimension(120, 140));

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(tigerButton);
        radioPanel.add(bt7Button);

        add(radioPanel, BorderLayout.LINE_START);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        b1 = new JButton("OK");
//        b1.setVerticalTextPosition(AbstractButton.CENTER);
//        b1.setHorizontalTextPosition(AbstractButton.LEADING);
        b1.setLocation(300, 30);
        b1.setSize(50, 40);
        b1.setActionCommand("disable");
        b1.addActionListener(this);
        b1.setToolTipText("Click this button to disable the middle button.");
        add(b1);

        exitButton = new JButton("EXIT");
        exitButton.setLocation(350, 30);
        exitButton.setSize(50, 40);
        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        add(exitButton);

    }
    int ch = 1;
    public void actionPerformed(ActionEvent e) {

        if (tigerButton.isSelected()) {
            System.err.println("tiger");
            ch = 2;

        }
        if (bt7Button.isSelected()) {
            System.err.println("bt7");
            ch = 1;
        }
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new StartGame(ch);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

        Thread thr = new Thread() {
            @Override
            public void run() {
                try {
                    new StartGame(ch);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thr.start();

//        try {
//            new StartGame(ch);
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
    }

//    public void actionPerformed(ActionEvent e) {
//        picture.setIcon(createImageIcon(e.getActionCommand()
//                + ".png"));
//    }

    protected static ImageIcon createImageIcon(String path) {
//        System.out.println(Gui.class.getResource(path));
        java.net.URL imgURL = Gui.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Tank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 200));

        //Create and set up the content pane.
        JComponent newContentPane = new Gui();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
