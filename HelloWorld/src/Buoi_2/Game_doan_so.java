package Buoi_2;

import java.util.Random;
import java.util.Scanner;

public class Game_doan_so {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();



		try {
			while (true) {
				int soMay = rand.nextInt(101);
				int soLanDoan = 0;
				boolean thang = false;

				System.out.println("=== GAME DOÁN SỐ ===");
				System.out.println("Đoán số từ 0 đến 100. Bạn có 7 lần đoán!");

				while (soLanDoan < 7) {
					System.out.print("Nhập số bạn đoán: ");

					int doan = sc.nextInt();

					if (doan < 0 || doan > 100) {
						throw new Exception("Số ngoài phạm vi!");
					}

					if (doan == soMay) {
						System.out.println("WIN");
						thang = true;
						break;
					} else if (doan < soMay) {
						System.out.println("Nhỏ hơn máy!");
					} else {
						System.out.println("Lớn hơn máy!");
					}

				}

				if (!thang) {
					System.out.println("YOU LOST! Số đúng là: " + soMay);
				
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("Finally");

		}
	}

}
