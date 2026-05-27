package test;

import java.util.Scanner;

import data.JdbcGiaoVien;
import data.JdbcKhoa;
import domain.GiaoVien;
import domain.Khoa;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JdbcKhoa jdbcKhoa = new JdbcKhoa();
        JdbcGiaoVien jdbcGiaoVien = new JdbcGiaoVien();

        int chon;

        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them khoa");
            System.out.println("2. Sua khoa");
            System.out.println("3. Xoa khoa");
            System.out.println("4. Hien thi danh sach khoa");
            System.out.println("5. Them giao vien");
            System.out.println("6. Sua giao vien");
            System.out.println("7. Xoa giao vien");
            System.out.println("8. Hien thi danh sach giao vien");
            System.out.println("9. Liet ke giao vien Nam cua khoa CNTT");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themKhoa(sc, jdbcKhoa);
                    break;

                case 2:
                    suaKhoa(sc, jdbcKhoa);
                    break;

                case 3:
                    xoaKhoa(sc, jdbcKhoa);
                    break;

                case 4:
                    jdbcKhoa.hienThiDanhSachKhoa();
                    break;

                case 5:
                    themGiaoVien(sc, jdbcGiaoVien);
                    break;

                case 6:
                    suaGiaoVien(sc, jdbcGiaoVien);
                    break;

                case 7:
                    xoaGiaoVien(sc, jdbcGiaoVien);
                    break;

                case 8:
                    jdbcGiaoVien.hienThiDanhSachGiaoVien();
                    break;

                case 9:
                    jdbcGiaoVien.lietKeGiaoVienNamKhoaCNTT();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }

        } while (chon != 0);

        sc.close();
    }

    public static void themKhoa(Scanner sc, JdbcKhoa jdbcKhoa) {
        System.out.print("Nhap ten khoa: ");
        String tenKhoa = sc.nextLine();

        System.out.print("Nhap ngay thanh lap yyyy-MM-dd: ");
        String ngayThanhLap = sc.nextLine();

        System.out.print("Nhap truong khoa: ");
        String truongKhoa = sc.nextLine();

        Khoa khoa = new Khoa(tenKhoa, ngayThanhLap, truongKhoa);
        jdbcKhoa.themKhoa(khoa);
    }

    public static void suaKhoa(Scanner sc, JdbcKhoa jdbcKhoa) {
        System.out.print("Nhap ma khoa can sua: ");
        int maKhoa = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ten khoa moi: ");
        String tenKhoa = sc.nextLine();

        System.out.print("Nhap ngay thanh lap moi yyyy-MM-dd: ");
        String ngayThanhLap = sc.nextLine();

        System.out.print("Nhap truong khoa moi: ");
        String truongKhoa = sc.nextLine();

        Khoa khoa = new Khoa(maKhoa, tenKhoa, ngayThanhLap, truongKhoa);
        jdbcKhoa.suaKhoa(khoa);
    }

    public static void xoaKhoa(Scanner sc, JdbcKhoa jdbcKhoa) {
        System.out.print("Nhap ma khoa can xoa: ");
        int maKhoa = Integer.parseInt(sc.nextLine());

        jdbcKhoa.xoaKhoa(maKhoa);
    }

    public static void themGiaoVien(Scanner sc, JdbcGiaoVien jdbcGiaoVien) {
        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap hoc vi: ");
        String hocVi = sc.nextLine();

        System.out.print("Nhap hoc ham: ");
        String hocHam = sc.nextLine();

        System.out.print("Nhap gioi tinh: ");
        String gioiTinh = sc.nextLine();

        System.out.print("Nhap he so: ");
        double heSo = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap muc luong: ");
        double mucLuong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap ma khoa: ");
        int maKhoa = Integer.parseInt(sc.nextLine());

        GiaoVien gv = new GiaoVien(hoTen, hocVi, hocHam, gioiTinh, heSo, mucLuong, maKhoa);
        jdbcGiaoVien.themGiaoVien(gv);
    }

    public static void suaGiaoVien(Scanner sc, JdbcGiaoVien jdbcGiaoVien) {
        System.out.print("Nhap ma giao vien can sua: ");
        int maGV = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap ho ten moi: ");
        String hoTen = sc.nextLine();

        System.out.print("Nhap hoc vi moi: ");
        String hocVi = sc.nextLine();

        System.out.print("Nhap hoc ham moi: ");
        String hocHam = sc.nextLine();

        System.out.print("Nhap gioi tinh moi: ");
        String gioiTinh = sc.nextLine();

        System.out.print("Nhap he so moi: ");
        double heSo = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap muc luong moi: ");
        double mucLuong = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap ma khoa moi: ");
        int maKhoa = Integer.parseInt(sc.nextLine());

        GiaoVien gv = new GiaoVien(maGV, hoTen, hocVi, hocHam, gioiTinh, heSo, mucLuong, maKhoa);
        jdbcGiaoVien.suaGiaoVien(gv);
    }

    public static void xoaGiaoVien(Scanner sc, JdbcGiaoVien jdbcGiaoVien) {
        System.out.print("Nhap ma giao vien can xoa: ");
        int maGV = Integer.parseInt(sc.nextLine());

        jdbcGiaoVien.xoaGiaoVien(maGV);
    }
}