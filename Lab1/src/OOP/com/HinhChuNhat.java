package OOP.com;

public class HinhChuNhat extends Hinh {
	 	protected double chieuDai;
	    protected double chieuRong;

	    // Constructor
	    public HinhChuNhat(String mau, double chieuDai, double chieuRong) {

	        super(mau);

	        this.chieuDai = chieuDai;
	        this.chieuRong = chieuRong;
	    }

	    @Override
	    public double tinhDienTich() {
	        return chieuDai * chieuRong;
	    }

	    @Override
	    public double tinhChuVi() {
	        return (chieuDai + chieuRong) * 2;
	    }

	    @Override
	    public String layThongTin() {

	        return "Hình chữ nhật"
	                + "\nMàu: " + mau
	                + "\nChiều dài: " + chieuDai
	                + "\nChiều rộng: " + chieuRong
	                + "\nDiện tích: " + tinhDienTich()
	                + "\nChu vi: " + tinhChuVi();
	    }
}
