package bai2.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baitap2 {
	static ArrayList<Integer> ds = new ArrayList<Integer>();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("**********************");
		System.out.println("1. Thêm");
		System.out.println("2. Xuất");
		System.out.println("3. Sửa");
		System.out.println("4. Xoá");
		System.out.println("5. Tìm kiếm");
		System.out.println("6. Sắp xếp");
		System.out.println("7. Thoát");
		System.out.print("CHọn số ?");
		int chon = sc.nextInt();
		switch (chon) {
		case 1:
			them();
			break;
		case 2:
			xuat();
			break;
		case 3:
			sua();
			break;
		case 4:
			xoa();
			break;
		case 5:
			timkiem();
			break;
		case 6:
			sapxep();
			break;
		case 7:
			System.err.println("Kết thúc chương trình");
			System.exit(0);

			break;
		}

	}

	private static void sapxep() {
		// TODO Auto-generated method stub
		Collections.sort(ds);
	}

	private static void timkiem() {
		// TODO Auto-generated method stub
		System.out.println("Nhập số muốn kiếm");
		int K = sc.nextInt();
		if(ds.contains(K)) {
			System.out.println("Có "+K+" trong dánh sách");
		}
		else 
			System.out.println("Ko thấy "+ K);
	}

	private static void xuat() {
		// TODO Auto-generated method stub
		System.out.println("Ds hiện tại: ");
		for (int i = 0; i < ds.size(); i++) {
			System.out.print(ds.get(i) + "\t");
		}
		System.out.println();
	}

	private static void xoa() {
		// TODO Auto-generated method stub
		System.out.println("Nhập vị trí muốn xoá");
		int vt  = sc.nextInt();
		ds.remove(vt);
		
	}

	private static void sua() {
		// TODO Auto-generated method stub
		System.out.println("vị trí muốn sửa: ");
		int vt = sc.nextInt();
		System.out.println("Nhập giá trị mới");
		int value = sc.nextInt();
		ds.set(vt, value);
	}

	private static void them() {
		// TODO Auto-generated method stub
		System.out.println("nhập giá trị muốn thêm: ");
		int value = sc.nextInt();
		ds.add(value);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true) {
			menu();
		}

	}

}
