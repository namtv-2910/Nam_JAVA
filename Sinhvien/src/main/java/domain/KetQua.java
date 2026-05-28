package domain;

public class KetQua {
    private int    maSo;
    private String maMH;
    private String tenMH;  // dùng khi JOIN với bảng Mon
    private int    diem;

    public KetQua() {}

    public KetQua(int maSo, String maMH, int diem) {
        this.maSo = maSo;
        this.maMH = maMH;
        this.diem = diem;
    }

    public KetQua(int maSo, String maMH, String tenMH, int diem) {
        this.maSo  = maSo;
        this.maMH  = maMH;
        this.tenMH = tenMH;
        this.diem  = diem;
    }

    public int    getMaSo()           { return maSo; }
    public void   setMaSo(int v)      { this.maSo = v; }
    public String getMaMH()           { return maMH; }
    public void   setMaMH(String v)   { this.maMH = v; }
    public String getTenMH()          { return tenMH; }
    public void   setTenMH(String v)  { this.tenMH = v; }
    public int    getDiem()           { return diem; }
    public void   setDiem(int v)      { this.diem = v; }

    @Override
    public String toString() {
        return String.format("  %-10s %-25s Diem: %d", maMH, tenMH, diem);
    }
}