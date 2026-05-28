package data;

import java.sql.*;
import java.util.*;

import domain.KetQua;

public class JdbcKetQua {

    private final String SQL_INSERT =
        "INSERT INTO KetQua(MaSo, MaMH, Diem) VALUES(?,?,?) " +
        "ON DUPLICATE KEY UPDATE Diem=?";

    
    private final String SQL_BY_MASOSV =
        "SELECT k.MaMH, m.TenMH, k.Diem " +
        "FROM KetQua k JOIN Mon m ON k.MaMH=m.MaMH " +
        "WHERE k.MaSo=? ORDER BY k.MaMH";

    
    private final String SQL_DANHSACH_DIEM =
        "SELECT sv.MaSo, sv.HoTen, kq.MaMH, m.TenMH, kq.Diem " +
        "FROM SinhVien sv " +
        "JOIN KetQua kq ON sv.MaSo=kq.MaSo " +
        "JOIN Mon m ON kq.MaMH=m.MaMH " +
        "ORDER BY sv.MaSo, kq.MaMH";

    public int insertOrUpdate(int maSo, String maMH, int diem) {
        Connection conn = null; PreparedStatement stmt = null; int rows = 0;
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, maSo);
            stmt.setString(2, maMH);
            stmt.setInt(3, diem);
            stmt.setInt(4, diem);
            rows = stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally { JavaConnection.close(stmt); JavaConnection.close(conn); }
        return rows;
    }


    public List<KetQua> selectByMaSo(int maSo) {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<KetQua> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_BY_MASOSV);
            stmt.setInt(1, maSo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new KetQua(maSo,
                    rs.getString(1),   // MaMH
                    rs.getString(2),   // TenMH
                    rs.getInt(3)));    // Diem
            }
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }

    
    public List<String[]> selectDanhSachDiem() {
        Connection conn = null; PreparedStatement stmt = null;
        ResultSet rs = null; List<String[]> list = new ArrayList<>();
        try {
            conn = JavaConnection.getConnection();
            stmt = conn.prepareStatement(SQL_DANHSACH_DIEM);
            rs = stmt.executeQuery();
            while (rs.next())
                list.add(new String[]{
                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                    rs.getString(5)});
        } catch (SQLException e) { e.printStackTrace(System.out); }
        finally {
            JavaConnection.close(rs);
            JavaConnection.close(stmt);
            JavaConnection.close(conn);
        }
        return list;
    }
}