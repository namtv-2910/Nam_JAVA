package test;

import data.JdbcHoaDon;
import data.JdbcMonAn;
import domain.ChiTietOrder;
import domain.MonAn;

import java.util.*;

public class EOrderApp {

    static JdbcMonAn  jdbcMonAn  = new JdbcMonAn();
    static JdbcHoaDon jdbcHoaDon = new JdbcHoaDon();
    static Scanner    sc         = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== HE THONG E-ORDER - QUAN AN NHANH ===");
        boolean chay = true;
        while (chay) {
            System.out.println("\n[1] Tao order moi");
            System.out.println("[2] Xem order dang cho");
            System.out.println("[3] Cap nhat trang thai order");
            System.out.println("[4] Xem thuc don");
            System.out.println("[0] Thoat");
            int chon = nhapInt("Chon: ");
            switch (chon) {
                case 1: taoOrder();       break;
                case 2: xemOrder();       break;
                case 3: capNhatOrder();   break;
                case 4: xemThucDon();     break;
                case 0: chay = false;     break;
                default: System.out.println("Sai lua chon!");
            }
        }
        System.out.println("Tam biet!");
        sc.close();
    }

    static void taoOrder() {
        System.out.println("\n--- TAO ORDER MOI ---");
        int soBan = nhapInt("Nhap so ban: ");
        xemThucDon();

        List<ChiTietOrder> dsMonDat = new ArrayList<>();
        while (true) {
            int maMon = nhapInt("Nhap ma mon (0=xong): ");
            if (maMon == 0) {
                if (dsMonDat.isEmpty()) { System.out.println("Chua chon mon!"); continue; }
                break;
            }
            MonAn monAn = jdbcMonAn.selectById(maMon);
            if (monAn == null) { System.out.println("Ma mon khong ton tai!"); continue; }

            int soLuong = nhapInt("So luong: ");
            if (soLuong <= 0) { System.out.println("So luong phai > 0!"); continue; }

            // Nếu món đã có → cộng thêm số lượng
            boolean daCoMon = false;
            for (ChiTietOrder ct : dsMonDat) {
                if (ct.getMonAn().getMaMon() == maMon) {
                    ct.setSoLuong(ct.getSoLuong() + soLuong);
                    daCoMon = true; break;
                }
            }
            if (!daCoMon) dsMonDat.add(new ChiTietOrder(monAn, soLuong));

            // Hiện giỏ hàng
            long tong = 0;
            for (ChiTietOrder ct : dsMonDat) { System.out.println(ct); tong += ct.thanhTien(); }
            System.out.printf("  TONG: %,d VND%n", tong);
        }

        System.out.print("Xac nhan gui order? (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
            jdbcHoaDon.insertOrder(soBan, dsMonDat);
        } else {
            System.out.println("Da huy.");
        }
    }

    static void xemOrder() {
        System.out.println("\n--- ORDER DANG CHO XU LY ---");
        List<String[]> ds = jdbcHoaDon.selectCho();
        if (ds.isEmpty()) { System.out.println("Khong co order nao!"); return; }
        System.out.printf("%-6s %-5s %-14s %-12s%n", "MA_HD", "BAN", "THOI_GIAN", "TRANG_THAI");
        for (String[] row : ds) {
            System.out.printf("%-6s %-5s %-14s %-12s%n", row[0], row[1], row[2], row[3]);
        }
        int maHd = nhapInt("Nhap ma HD xem chi tiet (0=bo qua): ");
        if (maHd > 0) {
            List<ChiTietOrder> ctList = jdbcHoaDon.selectChiTiet(maHd);
            long tong = 0;
            for (ChiTietOrder ct : ctList) { System.out.println(ct); tong += ct.thanhTien(); }
            System.out.printf("  TONG: %,d VND%n", tong);
        }
    }

    static void capNhatOrder() {
        System.out.println("\n--- CAP NHAT TRANG THAI ---");
        xemOrder();
        int maHd = nhapInt("Nhap ma HD can cap nhat (0=huy): ");
        if (maHd == 0) return;
        System.out.println("[1] DANG_LAM  [2] HOAN_TAT");
        int chon = nhapInt("Chon: ");
        String tt = chon == 1 ? "DANG_LAM" : chon == 2 ? "HOAN_TAT" : null;
        if (tt == null) { System.out.println("Sai!"); return; }
        int rows = jdbcHoaDon.updateTrangThai(maHd, tt);
        System.out.println(rows > 0 ? "Cap nhat thanh cong!" : "Khong tim thay HD!");
    }

    static void xemThucDon() {
        System.out.println("\n--- THUC DON ---");
        String loaiHT = "";
        for (MonAn m : jdbcMonAn.selectAll()) {
            if (!m.getLoai().equals(loaiHT)) { loaiHT = m.getLoai(); System.out.println("  [" + loaiHT + "]"); }
            System.out.println("  " + m);
        }
    }

    static int nhapInt(String msg) {
        while (true) {
            System.out.print(msg);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Vui long nhap so!"); }
        }
    }
}