package data;

import domain.Mon;
import java.sql.*;
import java.util.*;

public class JdbcMon {

    private final String SQL_SELECT_ALL = "SELECT MaMH, TenMH, SoTiet FROM Mon ORDER BY MaMH";
    private final String SQL_INSERT     = "INSERT INTO Mon(MaMH, TenMH, SoTiet) VALUES(?,?,?)";
    private final String SQL_UPDATE     = "UPDATE Mon SET TenMH=?, SoTiet=? WHERE MaMH=?";
    private final String SQL_DELETE     = "DELETE FROM Mon WHERE MaMH=?";

    public List<Mon> selectAll() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Mon> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new Mon(rs.getString(1), rs.getString(2), rs.getInt(3)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    public int insert(Mon m) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, m.getMaMH());
            stmt.setString(2, m.getTenMH());
            stmt.setInt(3, m.getSoTiet());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(Mon m) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, m.getTenMH());
            stmt.setInt(2, m.getSoTiet());
            stmt.setString(3, m.getMaMH());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String maMH) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, maMH);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }
}