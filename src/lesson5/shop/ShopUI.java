package lesson5.shop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;


public class ShopUI {
    private Goods shop;
    private JTextField tfName;
    private JFormattedTextField tfCount;
    private int productIndex = 0;

    public ShopUI(Goods shop) {
        this.shop = shop;

        JFrame f = new JFrame("Best Shop");
        f.setMinimumSize(new Dimension(800, 600));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(300, 100);

        f.getContentPane().add(createSellingPannel());

        f.pack();
        f.setVisible(true);
    }

    private JPanel createSellingPannel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());


        JLabel fName = new JLabel("Your name: ");
        JTextField tfName = new JTextField();
        tfName.setColumns(25);
        panel.add(fName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0 , 0));
        panel.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        JLabel lProducts = new JLabel("Goods: ");
        List<Product> products = shop.getProducts();
        ButtonGroup productsGroup = new ButtonGroup();

        JPanel pProducts = new JPanel();
        pProducts.setLayout(new GridLayout(products.size(), 0));
        pProducts.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        ActionListener rbListener = new RBListener();

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);

            JRadioButton rb = new JRadioButton(p.toString());
            rb.setActionCommand(String.valueOf(i));
            rb.addActionListener(rbListener);
            if (i == 0) {
                rb.setSelected(true);
            }

            productsGroup.add(rb);
            pProducts.add(rb);
        }

        panel.add(lProducts, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(pProducts, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 3, 0, 0), 0, 0));

        JLabel lCount = new JLabel("Count: ");
        NumberFormat nf = NumberFormat.getNumberInstance();
        JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setColumns(2);
        tfCount.setValue(1);

        panel.add(lCount, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));
        panel.add(tfCount, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

        JButton btnBuy = new JButton("BUY");
        panel.add(btnBuy, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0, 0, 0, 0), 0, 0));

        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer c = new Customer();
                c.setName(tfName.getText());

                Product p = shop.getProducts().get(productIndex);

                int count = Integer.parseInt(tfCount.getText());

//                Service.sale(p, c, count);

            }
        });

        return panel;
    }

    private class RBListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productIndex = Integer.parseInt(e.getActionCommand());
        }
    }
}
