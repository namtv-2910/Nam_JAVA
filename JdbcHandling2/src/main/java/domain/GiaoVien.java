package domain;

public class GiaoVien {
    private int maGV;
    private String hoTen;
    private String hocVi;
    private String hocHam;
    private String gioiTinh;
    private double heSo;
    private double mucLuong;
    private int maKhoa;

    public GiaoVien() {
    }

    public GiaoVien(int maGV, String hoTen, String hocVi, String hocHam,
                    String gioiTinh, double heSo, double mucLuong, int maKhoa) {
        this.maGV = maGV;
        this.hoTen = hoTen;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.gioiTinh = gioiTinh;
        this.heSo = heSo;
        this.mucLuong = mucLuong;
        this.maKhoa = maKhoa;
    }

    public GiaoVien(String hoTen, String hocVi, String hocHam,
                    String gioiTinh, double heSo, double mucLuong, int maKhoa) {
        this.hoTen = hoTen;
        this.hocVi = hocVi;
        this.hocHam = hocHam;
        this.gioiTinh = gioiTinh;
        this.heSo = heSo;
        this.mucLuong = mucLuong;
        this.maKhoa = maKhoa;
    }

    public int getMaGV() {
        return maGV;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public String getHocHam() {
        return hocHam;
    }

    public void setHocHam(String hocHam) {
        this.hocHam = hocHam;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public double getMucLuong() {
        return mucLuong;
    }

    public void setMucLuong(double mucLuong) {
        this.mucLuong = mucLuong;
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Override
    public String toString() {
        return maGV + " - " + hoTen + " - " + hocVi + " - " + hocHam
                + " - " + gioiTinh + " - " + heSo + " - " + mucLuong
                + " - MaKhoa: " + maKhoa;
    }
}