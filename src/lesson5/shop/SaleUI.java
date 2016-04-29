package lesson5.shop;

import javax.swing.*;
import java.awt.*;

public class SaleUI {
    private Goods shop;

    public SaleUI(Goods shop) {
        this.shop = shop;

        JFrame f = new JFrame("Best Shop");
        f.setMinimumSize(new Dimension(800, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(300, 100);
        f.getContentPane().add(createBuyingPannel());
        String[] columnNames = {"ID", "Date", "Product", "Count", "Customer"};
        Object [][] data = new Object[10][5];
        for(int i = 0; i < Service.getPurchase().size(); ++i) {
            data[i][0] = i + 1;
            data[i][1] = Service.getPurchase().get(i).date;
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