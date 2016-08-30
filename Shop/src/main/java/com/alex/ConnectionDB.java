package com.alex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private Connection connect;

    public ConnectionDB() {
        try {
            String url = "jdbc:postgresql://localhost:5434/shop";
            String user = "shop";
            String password = "1234";

            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ConnectionDB(Connection connect) {
        this.connect = connect;
    }

//    public void init() throws SQLException, ClassNotFoundException{
//
//        try {
//            String url = "jdbc:postgresql://localhost:5434/shop";
//            String user = "shop";
//            String password = "1234";
//
//            Class.forName("org.postgresql.Driver");
//            connect = DriverManager.getConnection(url, user, password);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void close() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        return connect;
    }
}
