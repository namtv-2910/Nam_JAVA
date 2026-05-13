package OOP.com;

public class HinhTron extends Hinh {
	 private double banKinh;

	    public HinhTron(String mau, double banKinh) {

	        super(mau);

	        this.banKinh = banKinh;
	    }

	    @Override
	    public double tinhDienTich() {
	        return Math.PI * banKinh * banKinh;
	    }

	    @Override
	    public double tinhChuVi() {
	        return 2 * Math.PI * banKinh;
	    }

	    @Override
	    public String layThongTin() {

	        return "Hình tròn"
	                + "\nMàu: " + mau
	                + "\nBán kính: " + banKinh
	                + "\nDiện tích: " + tinhDienTich()
	                + "\nChu vi: " + tinhChuVi();
	    }
}
