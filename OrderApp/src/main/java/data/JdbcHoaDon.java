package data;

import domain.ChiTietOrder;
import domain.MonAn;
import java.sql.*;
import java.util.*;

public class JdbcHoaDon {

    private final String SQL_INSERT_HD =
        "INSERT INTO hoadon(so_ban) VALUES(?)";
    private final String SQL_INSERT_CT =
        "INSERT INTO chitiet_order(ma_hd, ma_mon, so_luong) VALUES(?,?,?)";
    private final String SQL_SELECT_CHO =
        "SELECT ma_hd, so_ban, DATE_FORMAT(thoi_gian,'%d/%m %H:%i'), trang_thai " +
        "FROM hoadon WHERE trang_thai='CHO_XU_LY' ORDER BY ma_hd DESC";
    private final String SQL_SELECT_CT =
        "SELECT ct.ma_mon, m.ten_mon, m.gia, m.loai, ct.so_luong " +
        "FROM chitiet_order ct JOIN monan m ON ct.ma_mon=m.ma_mon " +
        "WHERE ct.ma_hd = ?";
    private final String SQL_UPDATE =
        "UPDATE hoadon SET trang_thai=? WHERE ma_hd=?";

    // Tạo order mới (dùng Transaction)
    public int insertOrder(int soBan, List<ChiTietOrder> dsMonDat) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int maHd = -1;
        try {
            conn = JavaConnection.getConnection();
            conn.setAutoCommit(false); // bắt đầu transaction

            // 1. Tạo hóa đơn
            stmt = conn.prepareStatement(SQL_INSERT_HD, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, soBan);
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if (rs.next()) maHd = rs.getInt(1);
            JavaConnection.close(rs);
            JavaConnection.close(stmt);

            // 2. Thêm chi tiết từng món
            stmt = conn.prepareStatement(SQL_INSERT_CT);
            for (ChiTietOrder ct : dsMonDat) {
                stmt.setInt(1, maHd);
                stmt.setInt(2, ct.getMonAn().getMaMon());
                stmt.setInt(3, ct.getSoLuong());
                stmt.addBatch();
            }
            stmt.executeBatch();

            conn.commit(); // lưu tất cả
            System.out.println("  >> Gui order thanh cong! Ma HD: #" + maHd);

        } catch (SQLException e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
            System.out.println("  >> Loi! Da rollback.");
            e.printStackTrace(System.out);
        } finally {
            try { if (conn != null) conn.setAutoCommit(true); } catch (SQLException ex) {}
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return maHd;
    }

    // Lấy danh sách order đang chờ
    public List<String[]> selectCho() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String[]> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CHO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new String[]{
                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)
                });
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    // Lấy chi tiết 1 order
    public List<ChiTietOrder> selectChiTiet(int maHd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ChiTietOrder> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_CT);
            stmt.setInt(1, maHd);
            rs = stmt.executeQuery();
            while (rs.next()) {
                MonAn m = new MonAn(rs.getInt(1), rs.getString(2),
                                    rs.getLong(3), rs.getString(4));
                list.add(new ChiTietOrder(m, rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    // Cập nhật trạng thái order
    public int updateTrangThai(int maHd, String trangThai) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, trangThai);
            stmt.setInt(2, maHd);
            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return rows;
    }
}