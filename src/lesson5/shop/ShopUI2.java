package lesson5.shop;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.*;

public class ShopUI2 {
    private Goods shop;
    private JFrame f;
    private Map<Product, Integer> order;


    public ShopUI2(Goods shop, Map order) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        this.shop = shop;
        this.order = order;

        f = new JFrame("Best Shop2");
        f.setMinimumSize(new Dimension(1200, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new BorderLayout());

        ShopPanel shopPanel = new ShopPanel(shop, order);
        f.add(shopPanel, BorderLayout.CENTER);
        shopPanel.init();

        f.setVisible(true);
        f.pack();
    }

}
