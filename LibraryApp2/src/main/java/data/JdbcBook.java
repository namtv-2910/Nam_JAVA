package data;

import domain.Book;
import java.sql.*;
import java.util.*;

public class JdbcBook {

    private final String SQL_SELECT_ALL =
        "SELECT b.BookCode, b.BookName, b.PublisherCode, p.PublisherName " +
        "FROM tblBook b " +
        "LEFT JOIN tblPublisher p ON b.PublisherCode = p.PublisherCode " +
        "ORDER BY b.BookCode";

    private final String SQL_INSERT =
        "INSERT INTO tblBook(BookCode, BookName, PublisherCode) VALUES(?,?,?)";

    private final String SQL_UPDATE =
        "UPDATE tblBook SET BookName=?, PublisherCode=? WHERE BookCode=?";

    private final String SQL_DELETE =
        "DELETE FROM tblBook WHERE BookCode=?";

    // Tìm kiếm theo tên HOẶC mã (dùng LIKE)
    private final String SQL_SEARCH =
        "SELECT b.BookCode, b.BookName, b.PublisherCode, p.PublisherName " +
        "FROM tblBook b " +
        "LEFT JOIN tblPublisher p ON b.PublisherCode = p.PublisherCode " +
        "WHERE b.BookCode LIKE ? OR b.BookName LIKE ? " +
        "ORDER BY b.BookCode";

    // Lấy sách theo NXB (dùng cho thống kê)
    private final String SQL_BY_PUBLISHER =
        "SELECT BookCode, BookName, PublisherCode FROM tblBook " +
        "WHERE PublisherCode=? ORDER BY BookCode";

    public List<Book> selectAll() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Book> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs   = stmt.executeQuery();
            while (rs.next())
                list.add(new Book(rs.getString(1), rs.getString(2),
                                  rs.getString(3), rs.getString(4)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    public int insert(Book b) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, b.getBookCode());
            stmt.setString(2, b.getBookName());
            stmt.setString(3, b.getPublisherCode());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(Book b) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, b.getBookName());
            stmt.setString(2, b.getPublisherCode());
            stmt.setString(3, b.getBookCode());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(String bookCode) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, bookCode);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    // Tìm kiếm theo từ khóa (tên hoặc mã)
    public List<Book> search(String keyword) {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Book> list = new ArrayList<>();
        try {
            String kw = "%" + keyword + "%"; // thêm % để tìm tương đối
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SEARCH);
            stmt.setString(1, kw); // tìm theo mã
            stmt.setString(2, kw); // tìm theo tên
            rs = stmt.executeQuery();
            while (rs.next())
                list.add(new Book(rs.getString(1), rs.getString(2),
                                  rs.getString(3), rs.getString(4)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    // Lấy sách theo mã NXB
    public List<Book> selectByPublisher(String publisherCode) {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<Book> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_BY_PUBLISHER);
            stmt.setString(1, publisherCode);
            rs = stmt.executeQuery();
            while (rs.next())
                list.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3)));
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }
}