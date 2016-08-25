package lesson12.example;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alpo123 on 27.07.16.
 */
public class DemoJList {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FRAME");

        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        String []str = {"11111", "22222", "333333", "44", "5555555", "666666", "77777", "88", "9",
                    "22222", "333333", "44", "5555555", "666666", "77777", "88", "9",
                    "22222", "333333", "44", "5555555", "666666", "77777", "88", "9",
                    "22222", "333333", "44", "5555555", "666666", "77777", "88", "9",
                    "22222", "333333", "44", "5555555", "666666", "77777", "88", "9"};
        JList myList = new JList(str);
        JScrollPane myScrollPaneList = new JScrollPane(myList);
        myScrollPaneList.setPreferredSize(new Dimension(200, 200));
        myList.setLayoutOrientation(JList.VERTICAL);

        frame.add(myScrollPaneList);


        frame.setVisible(true);
        frame.pack();
    }
}
