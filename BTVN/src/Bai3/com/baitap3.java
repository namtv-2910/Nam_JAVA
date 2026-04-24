package Bai3.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class baitap3 {
	static HashMap<Integer, String>map = new HashMap<Integer, String>();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("**********************");
		System.out.println("1. Thêm");
		System.out.println("2. Xuất");
		System.out.println("3. Sửa");
		System.out.println("4. Xoá");
		System.out.println("5. Tìm kiếm");
		System.out.println("6. Thoát");
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
			System.err.println("Kết thúc chương trình");
			System.exit(0);

			break;
		}

	}


	private static void timkiem() {
		// TODO Auto-generated method stub
		System.out.println("Nhập tên sách TK");
		String ten = sc.nextLine();
		for(Map.Entry<Integer, String > item : map.entrySet() ) {
			if(item.getValue().contains(ten)) {
				System.out.println(item.getKey()+"_"+item.getValue());
			}
		}
	}

	private static void xoa() {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập mã muốn xoá");
		int ma = sc.nextInt();
		if(map.containsKey(ma) == false ) {
			System.out.println("Mã "+ma+" không tồn tại");
			
		}
		else {
			map.remove(ma);
		}
	}

	private static void sua() {
		// TODO Auto-generated method stub
		System.out.println("Mời bạn nhập mã muốn sửa");
		int ma = sc.nextInt();
		if(map.containsKey(ma) == false ) {
			System.out.println("Mã "+ma+" không tồn tại");
			
		}
		else {
			System.out.println("Nhập tên sách mới");
			String ten = sc.nextLine();
			map.put(ma, ten);
		}
	}

	private static void xuat() {
		// TODO Auto-generated method stub
		System.out.println("Mã\tTên Sách");
		for(Map.Entry<Integer, String > item : map.entrySet() ) {
			System.out.println(item.getKey()+"\t"+	item.getValue());
		}
	}

	private static void them() {
		// TODO Auto-generated method stub
		System.out.println("Nhập mã sách: ");
		int ma = sc.nextInt();
		System.out.println("Nhập tên sách: ");
		String ten = sc.nextLine();
		if(map.containsValue(ma)== false) {
			map.put(ma, ten);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			menu();
		}
	}

}
