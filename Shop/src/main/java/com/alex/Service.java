package com.alex;

import java.sql.*;

public class Service {

    private static Connection conn;
    private String[][] data;
    static ConnectionDB connJdbc;

    public Service(){

    }
    private static void initConnect()throws SQLException, ClassNotFoundException {
        connJdbc = new ConnectionDB();
//        connJdbc.init();
        conn = connJdbc.getConnect();
    }
    private static void closeConnect() {
        connJdbc.close();
    }
    public static void addGoods(int productCategory, Goods shop) throws SQLException, ClassNotFoundException {
        initConnect();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM goods WHERE product_category =  " + productCategory + " ORDER BY id;");
            while(rs.next()) {

                Product p = new Product(productCategory, rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
                shop.addProduct(productCategory, p);

            }
            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String[][] sale() throws SQLException, ClassNotFoundException {

        initConnect();

        int totalColumn = 0;
//        data = null;

        try {
            Statement stmt = conn.createStatement();

            ResultSet rs5 = stmt.executeQuery("SELECT orders_id FROM orders;");
            while (rs5.next()) {
                totalColumn++;
            }


            data = new String[totalColumn][6];

            int i = 0;
            ResultSet rs = stmt.executeQuery("SELECT name_client, surname_client, orders_id FROM orders ORDER BY orders_id DESC;");
            while (rs.next()) {
                data[i][0] =rs.getString("orders_id");
                data[i][2] = rs.getString("name_client");
                data[i][3] = rs.getString("surname_client");
                ++i;
            }

            i = 0;
            ResultSet rs2 = stmt.executeQuery("SELECT DATE FROM orders ORDER BY orders_id DESC;");
            while (rs2.next()) {
                data[i][1] = rs2.getString("date");
                ++i;
            }

            i = 0;
            ResultSet rs3 = stmt.executeQuery("SELECT total_price FROM orders ORDER BY orders_id DESC;");
            while (rs3.next()) {
                data[i][4] = Double.toString(rs3.getDouble("total_price"));
                ++i;

            }

            i = 0;
            ResultSet rs4 = stmt.executeQuery("SELECT b.status FROM orders a, status_orders b " +
                    "WHERE b.id = a.status ORDER BY a.orders_id DESC;");
            while (rs4.next()) {
                data[i][5] = rs4.getString("status");
                ++i;

            }
            stmt.close();
            closeConnect();


        } catch(SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public void orders(Purchase purchase) throws SQLException, ClassNotFoundException {
        initConnect();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nextval('orders_orders_id_seq') AS order_id;");

            int newId = 0;
            if (rs.next()) {
                newId = rs.getInt(1);
            }

            stmt.executeUpdate("INSERT INTO orders (orders_id, name_client, surname_client, status, total_price, phone, date) " +
                    "values ('" + newId + "','" + purchase.getC().getName().trim() + "','" + purchase.getC().getSurname().trim() + "','" +
                    purchase.getStatus() + "','" + countTotalPrice(purchase) + "','" + purchase.getC().getPhone().trim() + " ', NOW());");

            for (int i = 0; i < purchase.getGoods_ids().size(); ++i) {
                stmt.executeUpdate("INSERT INTO orders_items(goods_id, qnt, orders_id, price) VALUES('" +
                        purchase.getGoods_ids().get(i) + "','" + purchase.getQuantitys().get(i) + "','" +
                        newId + "','" + purchase.getProducts().get(i).getPrice() * (purchase.getQuantitys().get(i)).intValue() + "');");
            }
            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int returnStatusBox(String str) throws SQLException, ClassNotFoundException {
        initConnect();

        int statusBox = 0;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT status FROM status_orders ORDER BY id;");
            int i = 0;
            while (rs.next()) {
                if (str.equals(rs.getString("status"))) {
                    statusBox = i;
                }
                ++i;
            }

            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusBox;


    }

    public double countTotalPrice(Purchase purchase) {
        int totalPrice = 0;
        for (int i = 0; i < purchase.getProducts().size(); ++i) {
            totalPrice += purchase.getQuantitys().get(i) * purchase.getProducts().get(i).getPrice();
        }
        return totalPrice;
    }

    public String[] productsItemsBox() throws SQLException, ClassNotFoundException {
        initConnect();

        String[] items = new String[3];
        int i = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM category_goods ORDER BY id;");

            while (rs.next()) {
                items[i] = rs.getString("product_category");
                ++i;
            }

            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public String[] statusItemsBox() throws SQLException, ClassNotFoundException {
        initConnect();

        String[] items = new String[4];
        int i = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM status_orders ORDER BY id;");

            while (rs.next()) {
                items[i] = rs.getString("status");
                ++i;
            }

            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
    public String removeChar(String s) {
        if (s == null) {
            System.out.println("NULL");
            return "";
        }
        int k = s.indexOf("  ");
        return s.substring(0, k);

    }

    public void updateService(Purchase purchase, int order_id) throws SQLException, ClassNotFoundException {

        initConnect();

        try {
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE orders SET name_client = '" + purchase.getC().getName() + "', surname_client = '" + purchase.getC().getSurname()
                    + "', phone = '" + purchase.getC().getPhone() + "', status = '" + purchase.getStatus() + "', total_price = '" + countTotalPrice(purchase) +
            "' WHERE orders.orders_id = '" + order_id + "';");

            stmt.execute("DELETE FROM orders_items WHERE orders_id = '" + order_id + "';");

            for (int i = 0; i < purchase.getGoods_ids().size(); ++i) {
                stmt.executeUpdate("INSERT INTO orders_items(goods_id, qnt, orders_id, price) VALUES('" +
                        purchase.getGoods_ids().get(i) + " ', '" + purchase.getQuantitys().get(i) + "' , '" +
                        order_id + "' , '" + purchase.getProducts().get(i).getPrice() * (purchase.getQuantitys().get(i)).intValue() + "');");
            }

            stmt.close();
            closeConnect();

            } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String [][] getOrder(int order_id) throws SQLException, ClassNotFoundException {
        initConnect();


        String [][] items = {};

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT orders_id FROM orders_items WHERE orders_id = " + order_id + " ORDER BY orders_items_id;");
            int i = 0;
            while (rs.next()) {
                ++i;
            }

            items = new String[5][i];

            ResultSet rs1 = stmt.executeQuery("SELECT a.orders_id, b.product_category FROM orders_items a, goods b WHERE a.goods_id = b.id " +
                    "AND orders_id = " + order_id + " ORDER BY orders_items_id; ");
            i = 0;
            while (rs1.next()) {
                items[0][i] = rs1.getString("product_category");
                ++i;

            }

            ResultSet rs2 = stmt.executeQuery("SELECT orders_id, goods_id FROM orders_items WHERE orders_id = " + order_id + " ORDER BY orders_items_id; ");
            i = 0;
            while (rs2.next()) {
                items[1][i] = rs2.getString("goods_id");
                ++i;
            }

            ResultSet rs3 = stmt.executeQuery("SELECT a.orders_id, b.name FROM orders_items a, goods b WHERE a.goods_id = b.id " +
                    "AND orders_id = " + order_id + " ORDER BY orders_items_id;");
            i = 0;
            while (rs3.next()) {
                items[2][i] = rs3.getString("name");
                ++i;
            }

            ResultSet rs4 = stmt.executeQuery("SELECT orders_id, qnt FROM orders_items WHERE orders_id = " + order_id + " ORDER BY orders_items_id; ");
            i = 0;
            while (rs4.next()) {
                items[3][i] = rs4.getString("qnt");
                ++i;
            }

            ResultSet rs5 = stmt.executeQuery("SELECT a.orders_id, b.price FROM orders_items a, goods b WHERE a.goods_id = b.id " +
                    "AND orders_id = " + order_id + " ORDER BY a.orders_items_id; ");
            i = 0;
            while (rs5.next()) {
                items[4][i] = rs5.getString("price");
                ++i;
            }

            stmt.close();
            closeConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }


}
