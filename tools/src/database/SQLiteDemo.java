package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDemo {

    public static void main(String[] args) {
        SQLiteDemo.createNewDB("E:/", "test.db");
    }

    public static void createNewDB(String location, String dbName) { // Create new SQLiteDemo database
        String url = "jdbc:sqlite:" + location + (location.charAt(location.length() - 1) == '/' ? "" : "/") + dbName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Driver name is: " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
