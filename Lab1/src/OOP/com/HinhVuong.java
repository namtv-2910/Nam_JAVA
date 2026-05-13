package OOP.com;

public class HinhVuong extends HinhChuNhat {
	public HinhVuong(String mau, double canh) {

        super(mau, canh, canh);
    }

    @Override
    public String layThongTin() {

        return "Hình vuông"
                + "\nMàu: " + mau
                + "\nCạnh: " + chieuDai
                + "\nDiện tích: " + tinhDienTich()
                + "\nChu vi: " + tinhChuVi();
    }
}
