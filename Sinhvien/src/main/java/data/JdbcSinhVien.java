package data;

import domain.SinhVien;
import java.sql.*;
import java.util.*;

public class JdbcSinhVien {

    private final String SQL_SELECT_ALL =
        "SELECT MaSo,HoTen,DATE_FORMAT(NgaySinh,'%d/%m/%Y'),GioiTinh,DiaChi,DienThoai,MaKhoa " +
        "FROM SinhVien ORDER BY MaSo";

    private final String SQL_INSERT =
        "INSERT INTO SinhVien(HoTen,NgaySinh,GioiTinh,DiaChi,DienThoai,MaKhoa) " +
        "VALUES(?,?,?,?,?,?)";

    private final String SQL_UPDATE =
        "UPDATE SinhVien SET HoTen=?,NgaySinh=?,GioiTinh=?,DiaChi=?,DienThoai=?,MaKhoa=? " +
        "WHERE MaSo=?";

    private final String SQL_DELETE = "DELETE FROM SinhVien WHERE MaSo=?";

    // Lấy SV theo khoa (dùng cho báo cáo)
    private final String SQL_SELECT_BY_KHOA =
        "SELECT MaSo,HoTen,DATE_FORMAT(NgaySinh,'%d/%m/%Y'),GioiTinh,DiaChi,DienThoai,MaKhoa " +
        "FROM SinhVien WHERE MaKhoa=? ORDER BY HoTen";

    public List<SinhVien> selectAll() {
        return selectByQuery(SQL_SELECT_ALL, null);
    }

    public List<SinhVien> selectByKhoa(String maKhoa) {
        return selectByQuery(SQL_SELECT_BY_KHOA, maKhoa);
    }

    private List<SinhVien> selectByQuery(String sql, String param) {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<SinhVien> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            if (param != null) stmt.setString(1, param);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getBoolean(4), rs.getString(5),
                    rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    public int insert(SinhVien sv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, sv.getHoTen());
            stmt.setString(2, sv.getNgaySinh());
            stmt.setBoolean(3, sv.isGioiTinh());
            stmt.setString(4, sv.getDiaChi());
            stmt.setString(5, sv.getDienThoai());
            stmt.setString(6, sv.getMaKhoa());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int update(SinhVien sv) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, sv.getHoTen());
            stmt.setString(2, sv.getNgaySinh());
            stmt.setBoolean(3, sv.isGioiTinh());
            stmt.setString(4, sv.getDiaChi());
            stmt.setString(5, sv.getDienThoai());
            stmt.setString(6, sv.getMaKhoa());
            stmt.setInt(7, sv.getMaSo());
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }

    public int delete(int maSo) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, maSo);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }
}