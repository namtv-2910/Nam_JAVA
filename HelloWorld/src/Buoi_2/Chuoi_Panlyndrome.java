package Buoi_2;

import java.util.Scanner;

public class Chuoi_Panlyndrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Nhap 1 chuoi: ");
			String s = sc.nextLine();
			boolean ck = true;
			char []arr = s.toCharArray();
			for (int i =0; i< s.length()/2; i++) {
				if(arr[i] != arr[s.length()-1-i])
				{
					ck = false;
					break; 	
				}
			}
			if(ck) {
				System.out.println("LÀ CHUỖI PANLYNDRONE");
			}
			else {
				System.out.println("Ko phai chuoi panlyndroned");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
