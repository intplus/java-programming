package lesson6.test;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculator {

    //Обьявление всех компонентов калькулятора.

    JPanel windowContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonToch;
    JButton buttonPoint;
    JPanel p1;

    //В конструкторе создаются все компоненты
    //и добавляются на фрейм с помощью комбинации
    //BorderLayout и GridLayout.

    Calculator(){
        windowContent = new JPanel();

        //Задаем схему для этой панели.
        BorderLayout b1 = new BorderLayout();
        windowContent.setLayout(b1);

        //Создаем и отображаем поле
        //Дабавляем его в Северную часть.

        displayField =new JTextField(30);
        windowContent.add("North", displayField);

        //Создаем кнопки.

        button0=new JButton("0");
        button1=new JButton("1");
        button2=new JButton("2");
        button3=new JButton("3");
        button4=new JButton("4");
        button5=new JButton("5");
        button6=new JButton("6");
        button7=new JButton("7");
        button8=new JButton("8");
        button9=new JButton("9");
        buttonToch=new JButton(".");
        buttonPoint=new JButton("=");

        //Создаем панель с GridLayout
        //которая содержит 12 кнопок и 10 кнопок с числами
        //и кнопку сточкой и знаком равно.

        p1 = new JPanel();
        GridLayout g1 =new GridLayout(4,3);
        p1.setLayout(g1);

        //Дабавляем кнопки на панель p1

        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonToch);
        p1.add(buttonPoint);

        //Помещаем p1 в центральную область окна

        windowContent.add("Center",p1);

        //Создаем фрейм и задаем его оснавную панель

        JFrame frame =new JFrame("Calculator");
        frame.setContentPane(windowContent);

        //создаем размер ока достаточным

        frame.pack();

        //наконец отображаем окно

        frame.setVisible(true);
    }
    public static void main(String[]args){


        Calculator calc =new Calculator();

    }
}