package domain;

public class Khoa {
    private int maKhoa;
    private String tenKhoa;
    private String ngayThanhLap;
    private String truongKhoa;

    public Khoa() {
    }

    public Khoa(int maKhoa, String tenKhoa, String ngayThanhLap, String truongKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.ngayThanhLap = ngayThanhLap;
        this.truongKhoa = truongKhoa;
    }

    public Khoa(String tenKhoa, String ngayThanhLap, String truongKhoa) {
        this.tenKhoa = tenKhoa;
        this.ngayThanhLap = ngayThanhLap;
        this.truongKhoa = truongKhoa;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    public String getTruongKhoa() {
        return truongKhoa;
    }

    public void setTruongKhoa(String truongKhoa) {
        this.truongKhoa = truongKhoa;
    }

    @Override
    public String toString() {
        return maKhoa + " - " + tenKhoa + " - " + ngayThanhLap + " - " + truongKhoa;
    }
}