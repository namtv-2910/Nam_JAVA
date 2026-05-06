package OOP.com;

import java.util.Scanner;

public class NhanVien {

	private String ho;
	private String ten;
	private int soSP;

	public NhanVien(String ho, String ten, int soSP) {
		this.ho = ho;
		this.ten = ten;
		this.soSP = soSP;
		if (soSP < 0)
			this.soSP = 0;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getSoSP() {
		return soSP;
	}

	public void setSoSP(int soSP) {
		this.soSP = soSP;
	}
	
	public double getLuong()
	{
		double dongia = 0;
		if(this.soSP > 0 && this.soSP <= 199 )
			dongia = 0.55;
		if(this.soSP >= 200 && this.soSP <= 399 )
			dongia = 0.55;
		if(this.soSP >= 400 && this.soSP <= 599 )
			dongia = 0.6;
		if(this.soSP >= 600)
			dongia = 0.65;
		return dongia*this.soSP;
	}
	public boolean LonHon(NhanVien nv2){
		return this.soSP > nv2.soSP;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		NhanVien nv1, nv2;
		System.out.println("Nhập mời nhập thông tin của nhân viên 1: ");
		System.out.println("HỌ : ");
		String ho1 = sc.nextLine();
		System.out.println("TÊN : ");
		String ten1 = sc.nextLine();
		System.out.println("Nhập số sản phẩm: ");
		int	soSP1 = sc.nextInt();
		nv1 = new NhanVien(ho1, ten1, soSP1);
		sc.nextLine(); 
		System.out.println("Nhập mời nhập thông tin của nhân viên 2: ");
		System.out.println("HỌ : ");
		String ho2 = sc.nextLine();
		System.out.println("TÊN : ");
		String ten2 = sc.nextLine();
		System.out.println("Nhập số sản phẩm: ");
		int	soSP2 = sc.nextInt();
		nv2 = new NhanVien(ho2, ten2, soSP2);
		
		System.out.println("Lương của nhân viên 1 = " + nv1.getLuong());
		System.out.println("Lương của nhân viên 2 = " + nv2.getLuong());
		
		if(nv1.LonHon(nv2)) {
			System.out.println("Nhân viên ["+nv1.getHo()+ " " + nv1.getTen() + "] có nhiều số sản phâmt hơn");
		}
		else
			System.out.println("Nhân viên ["+nv1.getHo()+ " " + nv1.getTen() + "] có nhiều số sản phâmt hơn");
				
	}
	
}
