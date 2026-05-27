package domain;

public class ChiTietOrder {
    private MonAn monAn;
    private int   soLuong;

    public ChiTietOrder(MonAn monAn, int soLuong) {
        this.monAn   = monAn;
        this.soLuong = soLuong;
    }

    public MonAn getMonAn()        { return monAn; }
    public int   getSoLuong()      { return soLuong; }
    public void  setSoLuong(int v) { this.soLuong = v; }

    public long thanhTien() { return monAn.getGia() * soLuong; }

    @Override
    public String toString() {
        return String.format("  %-20s x%d = %,8d VND",
                monAn.getTenMon(), soLuong, thanhTien());
    }
}