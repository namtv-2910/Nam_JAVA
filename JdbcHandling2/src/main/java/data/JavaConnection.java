package data;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/db_giaovien";
    private static final String USER = "VANNAM";
    private static final String PASSWORD = "12345678"; 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Loi ket noi database!");
            e.printStackTrace();
            return null;
        }
    }
}