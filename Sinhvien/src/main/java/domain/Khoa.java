package domain;

public class Khoa {
    private String maKhoa;
    private String tenKhoa;

    public Khoa() {}
    public Khoa(String maKhoa, String tenKhoa) {
        this.maKhoa  = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa()         { return maKhoa; }
    public void   setMaKhoa(String v) { this.maKhoa = v; }
    public String getTenKhoa()         { return tenKhoa; }
    public void   setTenKhoa(String v) { this.tenKhoa = v; }

    @Override
    public String toString() {
        return String.format("[%-6s] %s", maKhoa, tenKhoa);
    }
}