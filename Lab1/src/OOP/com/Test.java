package OOP.com;

public class Test {
	public static void main(String[] args) {

        HinhChuNhat hcn = new HinhChuNhat("Đỏ", 8, 4);

        HinhTron ht = new HinhTron("Xanh", 5);

        HinhVuong hv = new HinhVuong("Vàng", 6);

        System.out.println(hcn.layThongTin());

        System.out.println("----------------------");

        System.out.println(ht.layThongTin());

        System.out.println("----------------------");

        System.out.println(hv.layThongTin());
    }
}
