package OOP.com;

public class Hinh {
	protected String mau;


	
    public Hinh() {
		super();
	}

	public Hinh(String mau) {
		super();
		this.mau = mau;
	}

	public String getMau() {
		return mau;
	}

	public void setMau(String mau) {
		this.mau = mau;
	}


    public double tinhDienTich() {
        return 0;
    }

    public double tinhChuVi() {
        return 0;
    }

    public String layThongTin() {
        return "Màu: " + mau;
    }
}
