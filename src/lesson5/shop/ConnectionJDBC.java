package lesson5.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private Connection connect;

    public ConnectionJDBC() {
    }

    public ConnectionJDBC(Connection connect) {
        this.connect = connect;
    }

    public void init() throws SQLException, ClassNotFoundException{

        try {
            String url = "jdbc:postgresql://localhost:5432/shop";
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
