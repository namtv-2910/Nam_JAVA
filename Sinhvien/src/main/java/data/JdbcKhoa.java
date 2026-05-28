package data;

import domain.Khoa;
import java.sql.*;
import java.util.*;

public class JdbcKhoa {

    private final String SQL_SELECT_ALL = "SELECT MaKhoa, TenKhoa FROM KHOA ORDER BY MaKhoa";
    private final String SQL_INSERT     = "INSERT INTO KHOA(MaKhoa, TenKhoa) VALUES(?,?)";
    private final String SQL_UPDATE     = "UPDATE KHOA SET TenKhoa=? WHERE MaKhoa=?";
    private final String SQL_DELETE     = "DELETE FROM KHOA WHERE MaKhoa=?";

    public List<Khoa> selectAll() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Khoa> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new Khoa(rs.getString(1), rs.getString(2)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    public int insert(Khoa k) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, k.getMaKhoa());
            stmt.setString(2, k.getTenKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(Khoa k) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, k.getTenKhoa());
            stmt.setString(2, k.getMaKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String maKhoa) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maKhoa);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }
}