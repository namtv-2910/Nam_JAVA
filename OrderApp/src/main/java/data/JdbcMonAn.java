package data;

import domain.MonAn;
import java.sql.*;
import java.util.*;

public class JdbcMonAn {

    private final String SQL_SELECT_ALL =
        "SELECT ma_mon, ten_mon, gia, loai FROM monan ORDER BY loai, ma_mon";
    private final String SQL_SELECT_BY_ID =
        "SELECT ma_mon, ten_mon, gia, loai FROM monan WHERE ma_mon = ?";

    // Lấy toàn bộ thực đơn
    public List<MonAn> selectAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<MonAn> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs   = stmt.executeQuery();
            while (rs.next()) {
                list.add(new MonAn(rs.getInt(1), rs.getString(2),
                                   rs.getLong(3), rs.getString(4)));
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

    // Lấy 1 món theo mã
    public MonAn selectById(int maMon) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MonAn monAn = null;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, maMon);
            rs = stmt.executeQuery();
            if (rs.next()) {
                monAn = new MonAn(rs.getInt(1), rs.getString(2),
                                  rs.getLong(3), rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return monAn;
    }
}