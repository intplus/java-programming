package lesson5.shop;

import javax.swing.*;
import java.awt.*;

public class ShopUI {

    public ShopUI() {

        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(800, 600));
        f.setLocation(300, 100);

        f.getContentPane().add(createSellingPannel());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new JLabel("Hello World"));
        f.pack();
        f.setVisible(true);
    }

    private JPanel createSellingPannel() {
        JPanel panel = new JPanel();


        JLabel fName = new JLabel("Your name: ");
        JTextField tfName = new JTextField(10);
        panel.add(fName);
        panel.add(tfName);

        JLabel sName = new JLabel("Your surname: ");
        JTextField tsName = new JTextField(10);
        panel.add(sName);
        panel.add(tsName);

        JRadioButton rButton = new JRadioButton("rb");
        panel.add(rButton);

        String[] items = {
                "1",
                "2",
                "3"
        };
        JComboBox comboBox = new JComboBox(items);
        panel.add(comboBox);



        JButton button = new JButton("BUY");
        panel.add(button);

//        JCheckBox check = new JCheckBox("Check", false);
//        panel.add(check);
//        JMenuItem mi = new JMenuItem("menu");
//        panel.add(mi);


        return panel;
    }
}
