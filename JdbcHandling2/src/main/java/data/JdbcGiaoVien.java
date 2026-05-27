package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.GiaoVien;

public class JdbcGiaoVien {

    public void themGiaoVien(GiaoVien gv) {
        String sql = "INSERT INTO GIAOVIEN(HOTEN, HOCVI, HOCHAM, GIOITINH, HESO, MUCLUONG, MAKHOA) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, gv.getHoTen());
            ps.setString(2, gv.getHocVi());
            ps.setString(3, gv.getHocHam());
            ps.setString(4, gv.getGioiTinh());
            ps.setDouble(5, gv.getHeSo());
            ps.setDouble(6, gv.getMucLuong());
            ps.setInt(7, gv.getMaKhoa());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Them giao vien thanh cong!");
            } else {
                System.out.println("Them giao vien that bai!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi them giao vien!");
            e.printStackTrace();
        }
    }

    public void suaGiaoVien(GiaoVien gv) {
        String sql = "UPDATE GIAOVIEN SET HOTEN = ?, HOCVI = ?, HOCHAM = ?, GIOITINH = ?, "
                   + "HESO = ?, MUCLUONG = ?, MAKHOA = ? WHERE MAGV = ?";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, gv.getHoTen());
            ps.setString(2, gv.getHocVi());
            ps.setString(3, gv.getHocHam());
            ps.setString(4, gv.getGioiTinh());
            ps.setDouble(5, gv.getHeSo());
            ps.setDouble(6, gv.getMucLuong());
            ps.setInt(7, gv.getMaKhoa());
            ps.setInt(8, gv.getMaGV());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Sua giao vien thanh cong!");
            } else {
                System.out.println("Khong tim thay giao vien can sua!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi sua giao vien!");
            e.printStackTrace();
        }
    }

    public void xoaGiaoVien(int maGV) {
        String sql = "DELETE FROM GIAOVIEN WHERE MAGV = ?";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maGV);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Xoa giao vien thanh cong!");
            } else {
                System.out.println("Khong tim thay giao vien can xoa!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi xoa giao vien!");
            e.printStackTrace();
        }
    }

    public void hienThiDanhSachGiaoVien() {
        String sql = "SELECT * FROM GIAOVIEN";

        try {
            Connection conn = JavaConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("===== DANH SACH GIAO VIEN =====");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("MAGV") + " - "
                        + rs.getString("HOTEN") + " - "
                        + rs.getString("HOCVI") + " - "
                        + rs.getString("HOCHAM") + " - "
                        + rs.getString("GIOITINH") + " - "
                        + rs.getDouble("HESO") + " - "
                        + rs.getDouble("MUCLUONG") + " - "
                        + rs.getInt("MAKHOA")
                );
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi hien thi danh sach giao vien!");
            e.printStackTrace();
        }
    }

    public void lietKeGiaoVienNamKhoaCNTT() {
        String sql = "SELECT gv.* "
                   + "FROM GIAOVIEN gv "
                   + "JOIN KHOA k ON gv.MAKHOA = k.MAKHOA "
                   + "WHERE gv.GIOITINH = ? AND k.TENKHOA = ?";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Nam");
            ps.setString(2, "CNTT");

            ResultSet rs = ps.executeQuery();

            System.out.println("===== GIAO VIEN NAM CUA KHOA CNTT =====");

            boolean coDuLieu = false;

            while (rs.next()) {
                coDuLieu = true;

                System.out.println(
                        rs.getInt("MAGV") + " - "
                        + rs.getString("HOTEN") + " - "
                        + rs.getString("HOCVI") + " - "
                        + rs.getString("HOCHAM") + " - "
                        + rs.getString("GIOITINH") + " - "
                        + rs.getDouble("HESO") + " - "
                        + rs.getDouble("MUCLUONG") + " - "
                        + rs.getInt("MAKHOA")
                );
            }

            if (!coDuLieu) {
                System.out.println("Khong co giao vien Nam nao thuoc khoa CNTT.");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi liet ke giao vien Nam cua khoa CNTT!");
            e.printStackTrace();
        }
    }
}