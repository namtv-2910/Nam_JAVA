package test;

import data.JdbcBook;
import data.JdbcPublisher;
import domain.Book;
import domain.Publisher;

import java.util.*;

public class LibraryApp {

    static JdbcPublisher jdbcPub  = new JdbcPublisher();
    static JdbcBook      jdbcBook = new JdbcBook();
    static Scanner       sc       = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== QUAN LY THU VIEN ===");
        boolean chay = true;
        while (chay) {
            System.out.println("\n--- MENU CHINH ---");
            System.out.println("[1] Quan ly Sach (them/xoa/sua)");
            System.out.println("[2] Tim kiem sach");
            System.out.println("[3] Xem danh sach Nha xuat ban");
            System.out.println("[4] Quan ly Nha xuat ban (them/xoa/sua)");
            System.out.println("[5] Thong ke sach theo NXB");
            System.out.println("[0] Thoat");
            int chon = nhapInt("Chon: ");
            switch (chon) {
                case 1: menuSach();       break;
                case 2: timKiemSach();    break;
                case 3: xemNXB();         break;
                case 4: menuNXB();        break;
                case 5: thongKe();        break;
                case 0: chay = false;     break;
                default: System.out.println("Sai lua chon!");
            }
        }
        System.out.println("Tam biet!"); sc.close();
    }

    // ===================== MENU SACH =====================
    static void menuSach() {
        while (true) {
            System.out.println("\n-- QUAN LY SACH --");
            System.out.println("[1] Xem tat ca sach");
            System.out.println("[2] Them sach moi");
            System.out.println("[3] Cap nhat sach");
            System.out.println("[4] Xoa sach");
            System.out.println("[0] Quay lai");
            int chon = nhapInt("Chon: ");
            if (chon == 0) break;
            switch (chon) {
                case 1: xemTatCaSach();   break;
                case 2: themSach();       break;
                case 3: capNhatSach();    break;
                case 4: xoaSach();        break;
                default: System.out.println("Sai lua chon!");
            }
        }
    }

    static void xemTatCaSach() {
        List<Book> ds = jdbcBook.selectAll();
        System.out.println("\n  Tong so: " + ds.size() + " quyen sach");
        System.out.printf("  %-14s %-52s %s%n", "BookCode", "BookName", "NXB");
        System.out.println("  " + "-".repeat(80));
        for (Book b : ds)
            System.out.printf("  %-14s %-52s %s%n",
                b.getBookCode(), b.getBookName(), b.getPublisherCode());
    }

    static void themSach() {
        System.out.println("\n  -- Them Sach Moi --");
        System.out.print("  Book Code: ");    String bc = sc.nextLine().trim();
        System.out.print("  Ten sach: ");     String bn = sc.nextLine().trim();
        xemNXB();
        System.out.print("  Ma NXB: ");       String pc = sc.nextLine().trim();

        int rows = jdbcBook.insert(new Book(bc, bn, pc));
        System.out.println(rows > 0 ? "  >> Them thanh cong!" : "  >> That bai!");
    }

    static void capNhatSach() {
        System.out.print("  Nhap Book Code can sua: "); String bc = sc.nextLine().trim();
        System.out.print("  Ten sach moi: ");           String bn = sc.nextLine().trim();
        xemNXB();
        System.out.print("  Ma NXB moi: ");             String pc = sc.nextLine().trim();

        int rows = jdbcBook.update(new Book(bc, bn, pc));
        System.out.println(rows > 0 ? "  >> Cap nhat thanh cong!" : "  >> Khong tim thay!");
    }

    static void xoaSach() {
        System.out.print("  Nhap Book Code can xoa: "); String bc = sc.nextLine().trim();
        int rows = jdbcBook.delete(bc);
        System.out.println(rows > 0 ? "  >> Xoa thanh cong!" : "  >> Khong tim thay!");
    }

    // ===================== TIM KIEM SACH =====================
    static void timKiemSach() {
        System.out.println("\n-- TIM KIEM SACH --");
        System.out.print("  Nhap tu khoa (ma hoac ten): "); 
        String kw = sc.nextLine().trim();

        List<Book> ds = jdbcBook.search(kw);
        if (ds.isEmpty()) {
            System.out.println("  Khong tim thay ket qua nao!");
            return;
        }
        System.out.println("  Tim thay " + ds.size() + " ket qua:");
        System.out.println("  " + "-".repeat(80));
        for (Book b : ds) {
            System.out.printf("  %-14s %-50s%n", b.getBookCode(), b.getBookName());
            System.out.printf("  %-14s NXB: %s - %s%n", "",
                b.getPublisherCode(),
                b.getPublisherName() != null ? b.getPublisherName() : "");
            System.out.println("  " + "-".repeat(80));
        }
    }

    // ===================== XEM NXB =====================
    static void xemNXB() {
        List<Publisher> ds = jdbcPub.selectAll();
        System.out.printf("  %-14s %-22s %-40s %s%n",
            "Code", "Ten NXB", "Dia chi", "SDT");
        System.out.println("  " + "-".repeat(85));
        for (Publisher p : ds)
            System.out.printf("  %-14s %-22s %-40s %s%n",
                p.getPublisherCode(), p.getPublisherName(),
                p.getAddress(), p.getPhone());
    }

    // ===================== MENU NXB =====================
    static void menuNXB() {
        while (true) {
            System.out.println("\n-- QUAN LY NHA XUAT BAN --");
            System.out.println("[1] Xem danh sach NXB");
            System.out.println("[2] Them NXB moi");
            System.out.println("[3] Cap nhat NXB");
            System.out.println("[4] Xoa NXB");
            System.out.println("[0] Quay lai");
            int chon = nhapInt("Chon: ");
            if (chon == 0) break;
            switch (chon) {
                case 1: xemNXB(); break;
                case 2: themNXB(); break;
                case 3: capNhatNXB(); break;
                case 4: xoaNXB(); break;
                default: System.out.println("Sai lua chon!");
            }
        }
    }

    static void themNXB() {
        System.out.println("\n  -- Them NXB Moi --");
        System.out.print("  Publisher Code: ");  String pc = sc.nextLine().trim();
        System.out.print("  Ten NXB: ");         String pn = sc.nextLine().trim();
        System.out.print("  Dia chi: ");          String ad = sc.nextLine().trim();
        System.out.print("  So dien thoai: ");    String ph = sc.nextLine().trim();

        int rows = jdbcPub.insert(new Publisher(pc, pn, ad, ph));
        System.out.println(rows > 0 ? "  >> Them thanh cong!" : "  >> That bai!");
    }

    static void capNhatNXB() {
        System.out.print("  Ma NXB can sua: ");  String pc = sc.nextLine().trim();
        System.out.print("  Ten NXB moi: ");     String pn = sc.nextLine().trim();
        System.out.print("  Dia chi moi: ");      String ad = sc.nextLine().trim();
        System.out.print("  SDT moi: ");          String ph = sc.nextLine().trim();

        int rows = jdbcPub.update(new Publisher(pc, pn, ad, ph));
        System.out.println(rows > 0 ? "  >> Cap nhat thanh cong!" : "  >> Khong tim thay!");
    }

    static void xoaNXB() {
        System.out.print("  Ma NXB can xoa: "); String pc = sc.nextLine().trim();
        int rows = jdbcPub.delete(pc);
        System.out.println(rows > 0 ? "  >> Xoa thanh cong!" : "  >> Khong tim thay (hoac NXB con sach)!");
    }

    // ===================== THONG KE =====================
    static void thongKe() {
        System.out.println("\n=== THONG KE SACH THEO NXB ===");
        List<String[]> ds = jdbcPub.thongKe();

        System.out.printf("  %-14s %-25s %s%n", "Ma NXB", "Ten NXB", "So sach");
        System.out.println("  " + "-".repeat(50));
        for (String[] row : ds)
            System.out.printf("  %-14s %-25s %s quyen%n", row[0], row[1], row[2]);

        // Xem chi tiết sách của 1 NXB
        System.out.println();
        System.out.print("  Nhap ma NXB xem chi tiet sach (Enter de bo qua): ");
        String maNXB = sc.nextLine().trim();
        if (maNXB.isEmpty()) return;

        List<Book> dsSach = jdbcBook.selectByPublisher(maNXB);
        if (dsSach.isEmpty()) {
            System.out.println("  NXB nay chua co sach nao!");
            return;
        }
        System.out.println("  Danh sach sach cua NXB [" + maNXB + "]:");
        System.out.println("  " + "-".repeat(70));
        for (Book b : dsSach)
            System.out.printf("  %-14s %s%n", b.getBookCode(), b.getBookName());
        System.out.println("  Tong: " + dsSach.size() + " quyen");
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