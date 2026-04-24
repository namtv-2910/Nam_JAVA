package Bai1.com;

import java.util.Random;
import java.util.Scanner;

public class baitap1 {
	static Scanner sc = new Scanner(System.in);
	static int[] M;
	public static boolean laSoNguyenTo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Nhập mảng
		System.out.print("Nhập số phần từ của mảng: ");
		int n = sc.nextInt();
		M = new int[n];
		Random rd = new Random();
		for(int i = 0; i < n; i++) {
			M[i] = rd.nextInt(100);	
		}
		
//		Xuất mảng
		System.out.println("Các phần tử của mảng sau khi nhập là");
		for(int i = 0; i < M.length; i++) {
			System.out.print(M[i]+"\t");	
		}
		System.out.println();
//		Tính tổng mảng
		int sum = 0;
		for(int i : M)
			sum += i;
		System.out.println("Tổng các phần tửu trong mảng là: " + sum);
		
//		Tìm kiếm giá trị K
		System.out.print("Nhập giá trị K: ");
		int K = sc.nextInt();
		int soLan = 0;
		for( int i =0 ; i < M.length; i++) {
			if(M[i] == K)
				soLan++;
		}
		
		if(soLan == 0) {
			System.out.println("Không tìm thấy "+K+" trong mảng");
		}
		else {
			System.out.println(K+" xuất hiện "+ soLan +" trong mảng");
		}
//		Tìm giá trị lớn nhất
		int max = M[0];
		for (int x : M) {
            if (x > max) max = x;
        }
        System.out.println("Phần tử lớn nhất: " + max);
//      Tìm giá trị nhỏ nhất
        int min = M[0];
        for (int x : M) {
            if (x < min) min = x;
        }
        System.out.println("Phần tử nhỏ nhất: " + min);
//        Tìm số nguyên tố
        System.out.print("Các số nguyên tố: ");
        for (int x : M) {
            if (laSoNguyenTo(x)) {
                System.out.print(x + " ");
            }
        }
//        Sắp xếp tăng
		for (int i = 0; i < M.length - 1; i++) {
			for (int j = M.length - 1; j > i; j--) {
				if (M[j] < M[j - 1])
				{
					int temp = M[j];
					M[j] = M[j - 1];
					M[j - 1] = temp;
				}
			}
		}
		
		System.out.println("\nMảng sau khi sắp xếp tăng là");
		for(int x : M) {
			System.out.print(x + "\t");
		}
//		sắp xếp giảm
		for (int i = 0; i < M.length - 1; i++) {
			for (int j = M.length - 1; j > i; j--) {
				if (M[j] > M[j - 1])
				{
					int temp = M[j];
					M[j] = M[j - 1];
					M[j - 1] = temp;
				}
			}
		}
		System.out.println("\nMảng sau khi sắp xếp giảm là");
		for(int x : M) {
			System.out.print(x + "\t");
		}
		
	}
}
