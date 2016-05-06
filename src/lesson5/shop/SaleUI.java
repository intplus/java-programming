package lesson5.shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class SaleUI {
    private Goods shop;

    public SaleUI(Goods shop) {
        this.shop = shop;
        JFrame f = new JFrame("Best Shop");
        f.setMinimumSize(new Dimension(800, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(300, 100);

        JMenu fileMenu = new JMenu("Shop");

        JMenuItem newMenu = new JMenuItem("Buy Cameras");
        newMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new ShopUI(shop);
            }
        });
        JMenuBar menuBar = new JMenuBar();

        fileMenu.add(newMenu);

        menuBar.add(fileMenu);

        f.setJMenuBar(menuBar);

        f.getContentPane().add(createBuyingPannel());
        String[] columnNames = {"ID", "Date", "Product", "Count", "Customer"};
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        Object [][] data = new Object[10][5];
        for(int i = 0; i < Service.getPurchase().size(); ++i) {
            data[i][0] = i + 1;
            data[i][1] = sdf.format(Service.getPurchase().get(i).date);
            data[i][2] = Service.getPurchase().get(i).p;
            data[i][3] = Service.getPurchase().get(i).quantity;
            data[i][4] = Service.getPurchase().get(i).c;
        }

        final JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        f.getContentPane().add(scrollPane);

        f.pack();
        f.setVisible(true);
    }

    private JPanel createBuyingPannel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        return panel;
    }

}