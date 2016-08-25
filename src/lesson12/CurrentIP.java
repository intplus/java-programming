package lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class CurrentIP {
    public static void main(String [] args) {
        JFrame frame = new JFrame("Current IP");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        String IP = "";
        try {
            IP = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Exception e) {
            IP = "Error finding IP";
        }
        //Создается панель,
        //которая будет содржать информацию о IP адресе
        JPanel panel = new JPanel();
        //добавление границы к панели
        panel.setBorder(BorderFactory.createTitledBorder("Current IP Address"));
                panel.add(new JLabel("          " + IP + "          "));
        //Добавление панели к фрейму
        frame.getContentPane().add(panel);
        //метод рack(); сообщает Swing о том,
        //что нужно придать компонентам необходимые размеры для
        //правильного помещения их в форму.
        //Другой способ - вызвать setSize(int width, int height).
        frame.pack();
        //Для того, чтобы увидеть окно на экране
        //вы должны вызвать метод setVisible(true)
        frame.setVisible(true);
    }
}
