package domain;

public class SinhVien {
    private int    maSo;
    private String hoTen;
    private String ngaySinh;
    private boolean gioiTinh; // true = Nam, false = Nu
    private String diaChi;
    private String dienThoai;
    private String maKhoa;

    public SinhVien() {}
    public SinhVien(int maSo, String hoTen, String ngaySinh,
                    boolean gioiTinh, String diaChi,
                    String dienThoai, String maKhoa) {
        this.maSo      = maSo;
        this.hoTen     = hoTen;
        this.ngaySinh  = ngaySinh;
        this.gioiTinh  = gioiTinh;
        this.diaChi    = diaChi;
        this.dienThoai = dienThoai;
        this.maKhoa    = maKhoa;
    }

    public int     getMaSo()             { return maSo; }
    public void    setMaSo(int v)        { this.maSo = v; }
    public String  getHoTen()            { return hoTen; }
    public void    setHoTen(String v)    { this.hoTen = v; }
    public String  getNgaySinh()         { return ngaySinh; }
    public void    setNgaySinh(String v) { this.ngaySinh = v; }
    public boolean isGioiTinh()          { return gioiTinh; }
    public void    setGioiTinh(boolean v){ this.gioiTinh = v; }
    public String  getDiaChi()           { return diaChi; }
    public void    setDiaChi(String v)   { this.diaChi = v; }
    public String  getDienThoai()        { return dienThoai; }
    public void    setDienThoai(String v){ this.dienThoai = v; }
    public String  getMaKhoa()           { return maKhoa; }
    public void    setMaKhoa(String v)   { this.maKhoa = v; }

    @Override
    public String toString() {
        return String.format("[%3d] %-20s %-12s %-4s %-12s %s",
            maSo, hoTen, ngaySinh,
            gioiTinh ? "Nam" : "Nu",
            dienThoai, maKhoa);
    }
}