package communityuni.com;

import java.util.Scanner;

public class chusochan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        boolean check = true;

        while (n > 0) {

            int digit = n % 10;

            if (digit % 2 != 0) {
                check = false;
                break;
            }

            n = n / 10;
        }

        if (check) {
            System.out.println("Toàn chữ số chẵn");
        } else {
            System.out.println("Không phải toàn chữ số chẵn");
        }
	}

}
