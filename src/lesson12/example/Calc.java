package lesson12.example;

import javax.swing.*;
import java.awt.*;

public class Calc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        frame.setSize(250, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panelCenter = new JPanel(new GridLayout(3,3));
        JPanel panelNorth = new JPanel(new BorderLayout());

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b0 = new JButton("0");

        JTextField textField = new JTextField(10);

        panelCenter.add(b1);
        panelCenter.add(b2);
        panelCenter.add(b3);
        panelCenter.add(b4);
        panelCenter.add(b5);
        panelCenter.add(b6);
        panelCenter.add(b7);
        panelCenter.add(b8);
        panelCenter.add(b9);
        panelCenter.add(b0);

        panelNorth.add(textField, BorderLayout.CENTER);

        frame.add(panelCenter, BorderLayout.CENTER);
        frame.add(panelNorth, BorderLayout.NORTH);

        frame.setVisible(true);

    }
}
