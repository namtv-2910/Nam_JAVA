package data;

import java.sql.*;

public class JavaConnection {

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/sinhvien_db?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER   = "VANNAM";   
    private static final String JDBC_PASS   = "";  
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay JDBC Driver!");
            e.printStackTrace(System.out);
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    public static void close(ResultSet rs) {
        try { if (rs   != null) rs.close();   } catch (SQLException e) { e.printStackTrace(); }
    }
    public static void close(PreparedStatement stmt) {
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
    public static void close(Connection conn) {
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}