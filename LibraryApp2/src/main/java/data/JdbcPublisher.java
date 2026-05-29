package data;

import domain.Publisher;
import java.sql.*;
import java.util.*;

public class JdbcPublisher {

    private final String SQL_SELECT_ALL =
        "SELECT PublisherCode, PublisherName, Address, Phone " +
        "FROM tblPublisher ORDER BY PublisherCode";

    private final String SQL_INSERT =
        "INSERT INTO tblPublisher(PublisherCode,PublisherName,Address,Phone) " +
        "VALUES(?,?,?,?)";

    private final String SQL_UPDATE =
        "UPDATE tblPublisher SET PublisherName=?, Address=?, Phone=? " +
        "WHERE PublisherCode=?";

    private final String SQL_DELETE =
        "DELETE FROM tblPublisher WHERE PublisherCode=?";

    // Thống kê: mỗi NXB có bao nhiêu sách + liệt kê sách
    private final String SQL_THONGKE =
        "SELECT p.PublisherCode, p.PublisherName, COUNT(b.BookCode) AS SoSach " +
        "FROM tblPublisher p " +
        "LEFT JOIN tblBook b ON p.PublisherCode = b.PublisherCode " +
        "GROUP BY p.PublisherCode, p.PublisherName " +
        "ORDER BY SoSach DESC";

    public List<Publisher> selectAll() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Publisher> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new Publisher(rs.getString(1), rs.getString(2),
                                       rs.getString(3), rs.getString(4)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    public int insert(Publisher p) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, p.getPublisherCode());
            stmt.setString(2, p.getPublisherName());
            stmt.setString(3, p.getAddress());
            stmt.setString(4, p.getPhone());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(Publisher p) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, p.getPublisherName());
            stmt.setString(2, p.getAddress());
            stmt.setString(3, p.getPhone());
            stmt.setString(4, p.getPublisherCode());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String publisherCode) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, publisherCode);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    // Thống kê: {PublisherCode, PublisherName, SoSach}
    public List<String[]> thongKe() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<String[]> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_THONGKE);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new String[]{
                    rs.getString(1), rs.getString(2), rs.getString(3)});
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }
}