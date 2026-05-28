package domain;

public class Mon {
    private String maMH;
    private String tenMH;
    private int    soTiet;

    public Mon() {}
    public Mon(String maMH, String tenMH, int soTiet) {
        this.maMH   = maMH;
        this.tenMH  = tenMH;
        this.soTiet = soTiet;
    }

    public String getMaMH()          { return maMH; }
    public void   setMaMH(String v)  { this.maMH = v; }
    public String getTenMH()          { return tenMH; }
    public void   setTenMH(String v)  { this.tenMH = v; }
    public int    getSoTiet()          { return soTiet; }
    public void   setSoTiet(int v)     { this.soTiet = v; }

    @Override
    public String toString() {
        return String.format("[%-8s] %-30s (%d tiet)", maMH, tenMH, soTiet);
    }
}