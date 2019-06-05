package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDemo {

    private final static String HOST = "127.0.0.1";
    private final static int PORT = 3306;
    private final static String DB_NAME = "test_db";
    private final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

    private final static String USERNAME = "root";
    private final static String PASSWORD = "";

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            System.out.println("Connection success !");
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return con;
    }

    public static void main(String[] args) {
        Connection con = getConnection();
    }
}
