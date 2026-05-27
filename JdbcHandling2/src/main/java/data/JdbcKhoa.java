package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Khoa;

public class JdbcKhoa {

    public void themKhoa(Khoa khoa) {
        String sql = "INSERT INTO KHOA(TENKHOA, NGTLAP, TRGKHOA) VALUES (?, ?, ?)";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, khoa.getTenKhoa());
            ps.setString(2, khoa.getNgayThanhLap());
            ps.setString(3, khoa.getTruongKhoa());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Them khoa thanh cong!");
            } else {
                System.out.println("Them khoa that bai!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi them khoa!");
            e.printStackTrace();
        }
    }

    public void suaKhoa(Khoa khoa) {
        String sql = "UPDATE KHOA SET TENKHOA = ?, NGTLAP = ?, TRGKHOA = ? WHERE MAKHOA = ?";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, khoa.getTenKhoa());
            ps.setString(2, khoa.getNgayThanhLap());
            ps.setString(3, khoa.getTruongKhoa());
            ps.setInt(4, khoa.getMaKhoa());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Sua khoa thanh cong!");
            } else {
                System.out.println("Khong tim thay khoa can sua!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi sua khoa!");
            e.printStackTrace();
        }
    }

    public void xoaKhoa(int maKhoa) {
        String sql = "DELETE FROM KHOA WHERE MAKHOA = ?";

        try {
            Connection conn = JavaConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, maKhoa);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Xoa khoa thanh cong!");
            } else {
                System.out.println("Khong tim thay khoa can xoa!");
            }

            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi xoa khoa! Co the khoa nay dang co giao vien.");
            e.printStackTrace();
        }
    }

    public void hienThiDanhSachKhoa() {
        String sql = "SELECT * FROM KHOA";

        try {
            Connection conn = JavaConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("===== DANH SACH KHOA =====");

            while (rs.next()) {
                int maKhoa = rs.getInt("MAKHOA");
                String tenKhoa = rs.getString("TENKHOA");
                String ngayThanhLap = rs.getString("NGTLAP");
                String truongKhoa = rs.getString("TRGKHOA");

                System.out.println(maKhoa + " - " + tenKhoa + " - " + ngayThanhLap + " - " + truongKhoa);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Loi hien thi danh sach khoa!");
            e.printStackTrace();
        }
    }
}