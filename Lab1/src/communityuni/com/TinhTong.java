package communityuni.com;

import java.util.Scanner;

public class TinhTong {

	public static long factorial(int n) {
        long gt = 1;

        for (int i = 1; i <= n; i++) {
            gt *= i;
        }

        return gt;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập x: ");
        double x = sc.nextDouble();

        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        double S = 0;

        for (int i = 0; i <= n; i++) {

            int mu = 2 * i + 1;

            S += Math.pow(x, mu) / factorial(mu);
        }

        System.out.println("S = " + S);


    }

}
