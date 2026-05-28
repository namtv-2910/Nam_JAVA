package test;

import data.*;
import domain.*;
import java.util.*;

public class SinhVienApp {

    static JdbcKhoa     jdbcKhoa     = new JdbcKhoa();
    static JdbcMon      jdbcMon      = new JdbcMon();
    static JdbcSinhVien jdbcSV       = new JdbcSinhVien();
    static JdbcKetQua   jdbcKQ       = new JdbcKetQua();
    static Scanner      sc           = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== QUAN LY THONG TIN SINH VIEN ===");
        boolean chay = true;
        while (chay) {
            System.out.println("\n--- MENU CHINH ---");
            System.out.println("[1] Quan ly Khoa");
            System.out.println("[2] Quan ly Mon hoc");
            System.out.println("[3] Quan ly Sinh vien");
            System.out.println("[4] Nhap diem sinh vien");
            System.out.println("[5] Bao cao: Danh sach SV va diem");
            System.out.println("[6] Bao cao: SV theo khoa");
            System.out.println("[0] Thoat");
            int chon = nhapInt("Chon: ");
            switch (chon) {
                case 1: menuKhoa();      break;
                case 2: menuMon();       break;
                case 3: menuSinhVien();  break;
                case 4: nhapDiem();      break;
                case 5: baoCaoDiem();    break;
                case 6: baoCaoTheoKhoa();break;
                case 0: chay = false;    break;
                default: System.out.println("Sai lua chon!");
            }
        }
        System.out.println("Tam biet!"); sc.close();
    }

    // ===================== MENU KHOA =====================
    static void menuKhoa() {
        while (true) {
            System.out.println("\n-- QUAN LY KHOA --");
            System.out.println("[1] Xem ds khoa  [2] Them  [3] Sua  [4] Xoa  [0] Quay lai");
            int chon = nhapInt("Chon: ");
            if (chon == 0) break;
            switch (chon) {
                case 1:
                    for (Khoa k : jdbcKhoa.selectAll()) System.out.println("  " + k);
                    break;
                case 2:
                    System.out.print("  Ma khoa: "); String mk = sc.nextLine().trim();
                    System.out.print("  Ten khoa: "); String tk = sc.nextLine().trim();
                    int r2 = jdbcKhoa.insert(new Khoa(mk, tk));
                    System.out.println(r2 > 0 ? "  >> Them thanh cong!" : "  >> That bai!");
                    break;
                case 3:
                    System.out.print("  Ma khoa can sua: "); String mk3 = sc.nextLine().trim();
                    System.out.print("  Ten khoa moi: ");    String tk3 = sc.nextLine().trim();
                    int r3 = jdbcKhoa.update(new Khoa(mk3, tk3));
                    System.out.println(r3 > 0 ? "  >> Sua thanh cong!" : "  >> Khong tim thay!");
                    break;
                case 4:
                    System.out.print("  Ma khoa can xoa: "); String mk4 = sc.nextLine().trim();
                    int r4 = jdbcKhoa.delete(mk4);
                    System.out.println(r4 > 0 ? "  >> Xoa thanh cong!" : "  >> Khong tim thay!");
                    break;
            }
        }
    }

    // ===================== MENU MON =====================
    static void menuMon() {
        while (true) {
            System.out.println("\n-- QUAN LY MON HOC --");
            System.out.println("[1] Xem ds mon  [2] Them  [3] Sua  [4] Xoa  [0] Quay lai");
            int chon = nhapInt("Chon: ");
            if (chon == 0) break;
            switch (chon) {
                case 1:
                    for (Mon m : jdbcMon.selectAll()) System.out.println("  " + m);
                    break;
                case 2:
                    System.out.print("  Ma MH: ");   String mm = sc.nextLine().trim();
                    System.out.print("  Ten MH: ");  String tm = sc.nextLine().trim();
                    int st = nhapInt("  So tiet: ");
                    int r2 = jdbcMon.insert(new Mon(mm, tm, st));
                    System.out.println(r2 > 0 ? "  >> Them thanh cong!" : "  >> That bai!");
                    break;
                case 3:
                    System.out.print("  Ma MH can sua: ");  String mm3 = sc.nextLine().trim();
                    System.out.print("  Ten MH moi: ");     String tm3 = sc.nextLine().trim();
                    int st3 = nhapInt("  So tiet moi: ");
                    int r3 = jdbcMon.update(new Mon(mm3, tm3, st3));
                    System.out.println(r3 > 0 ? "  >> Sua thanh cong!" : "  >> Khong tim thay!");
                    break;
                case 4:
                    System.out.print("  Ma MH can xoa: "); String mm4 = sc.nextLine().trim();
                    int r4 = jdbcMon.delete(mm4);
                    System.out.println(r4 > 0 ? "  >> Xoa thanh cong!" : "  >> Khong tim thay!");
                    break;
            }
        }
    }

    // ===================== MENU SINH VIEN =====================
    static void menuSinhVien() {
        while (true) {
            System.out.println("\n-- QUAN LY SINH VIEN --");
            System.out.println("[1] Xem ds SV  [2] Them  [3] Sua  [4] Xoa  [0] Quay lai");
            int chon = nhapInt("Chon: ");
            if (chon == 0) break;
            switch (chon) {
                case 1:
                    System.out.printf("  %-4s %-20s %-12s %-4s %-12s %s%n",
                        "MSV","Ho ten","Ngay sinh","GT","Dien thoai","Khoa");
                    System.out.println("  " + "-".repeat(65));
                    for (SinhVien sv : jdbcSV.selectAll()) System.out.println("  " + sv);
                    break;
                case 2: themSinhVien();  break;
                case 3: suaSinhVien();   break;
                case 4:
                    int ms4 = nhapInt("  Ma so SV can xoa: ");
                    int r4 = jdbcSV.delete(ms4);
                    System.out.println(r4 > 0 ? "  >> Xoa thanh cong!" : "  >> Khong tim thay!");
                    break;
            }
        }
    }

    static void themSinhVien() {
        System.out.println("  -- Them Sinh Vien --");
        System.out.print("  Ho ten: ");       String ht = sc.nextLine().trim();
        System.out.print("  Ngay sinh (yyyy-MM-dd): "); String ns = sc.nextLine().trim();
        int gt = nhapInt("  Gioi tinh (1=Nam, 0=Nu): ");
        System.out.print("  Dia chi: ");       String dc = sc.nextLine().trim();
        System.out.print("  Dien thoai: ");    String dt = sc.nextLine().trim();
        System.out.println("  Danh sach khoa:");
        for (Khoa k : jdbcKhoa.selectAll()) System.out.println("    " + k);
        System.out.print("  Ma khoa: ");       String mk = sc.nextLine().trim();

        SinhVien sv = new SinhVien(0, ht, ns, gt == 1, dc, dt, mk);
        int rows = jdbcSV.insert(sv);
        System.out.println(rows > 0 ? "  >> Them thanh cong!" : "  >> That bai!");
    }

    static void suaSinhVien() {
        int maSo = nhapInt("  Ma so SV can sua: ");
        System.out.print("  Ho ten moi: ");    String ht = sc.nextLine().trim();
        System.out.print("  Ngay sinh (yyyy-MM-dd): "); String ns = sc.nextLine().trim();
        int gt = nhapInt("  Gioi tinh (1=Nam, 0=Nu): ");
        System.out.print("  Dia chi moi: ");   String dc = sc.nextLine().trim();
        System.out.print("  Dien thoai moi: ");String dt = sc.nextLine().trim();
        System.out.print("  Ma khoa moi: ");   String mk = sc.nextLine().trim();

        SinhVien sv = new SinhVien(maSo, ht, ns, gt == 1, dc, dt, mk);
        int rows = jdbcSV.update(sv);
        System.out.println(rows > 0 ? "  >> Sua thanh cong!" : "  >> Khong tim thay!");
    }

    // ===================== NHAP DIEM =====================
    static void nhapDiem() {
        System.out.println("\n-- NHAP DIEM SINH VIEN --");
        int maSo = nhapInt("  Nhap ma so SV: ");

        System.out.println("  Danh sach mon hoc:");
        for (Mon m : jdbcMon.selectAll()) System.out.println("    " + m);

        System.out.print("  Nhap ma MH: ");
        String maMH = sc.nextLine().trim();
        int diem = nhapInt("  Nhap diem: ");

        int rows = jdbcKQ.insertOrUpdate(maSo, maMH, diem);
        System.out.println(rows > 0 ? "  >> Luu diem thanh cong!" : "  >> That bai!");
    }

    // ===================== BAO CAO =====================
    static void baoCaoDiem() {
        System.out.println("\n=== BAO CAO: DANH SACH SV VA DIEM ===");
        System.out.printf("%-4s %-20s %-10s %-25s %s%n",
            "MSV","Ho ten","MaMH","Ten mon","Diem");
        System.out.println("-".repeat(70));
        List<String[]> ds = jdbcKQ.selectDanhSachDiem();
        if (ds.isEmpty()) { System.out.println("  Chua co du lieu!"); return; }
        String maSoHT = "";
        for (String[] row : ds) {
            // In tên SV chỉ lần đầu (nhóm theo MaSo)
            String ten = row[0].equals(maSoHT) ? "" : row[1];
            maSoHT = row[0];
            System.out.printf("%-4s %-20s %-10s %-25s %s%n",
                row[0], ten, row[2], row[3], row[4]);
        }
    }

    static void baoCaoTheoKhoa() {
        System.out.println("\n=== BAO CAO: SINH VIEN THEO KHOA ===");
        System.out.println("  Danh sach khoa:");
        for (Khoa k : jdbcKhoa.selectAll()) System.out.println("    " + k);
        System.out.print("  Nhap ma khoa: ");
        String maKhoa = sc.nextLine().trim();

        List<SinhVien> dsSV = jdbcSV.selectByKhoa(maKhoa);
        if (dsSV.isEmpty()) { System.out.println("  Khong co SV trong khoa nay!"); return; }

        System.out.println("\n  Danh sach sinh vien:");
        System.out.printf("  %-4s %-20s %-12s %-4s %s%n",
            "MSV","Ho ten","Ngay sinh","GT","Dien thoai");
        System.out.println("  " + "-".repeat(55));
        for (SinhVien sv : dsSV) System.out.println("  " + sv);
        System.out.println("  Tong so: " + dsSV.size() + " sinh vien");
    }

    // ===================== TIEN ICH =====================
    static int nhapInt(String msg) {
        while (true) {
            System.out.print(msg);
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("  Vui long nhap so!"); }
        }
    }
}