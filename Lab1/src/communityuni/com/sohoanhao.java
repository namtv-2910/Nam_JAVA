package communityuni.com;

import java.util.Scanner;

public class sohoanhao {

	public static boolean isPerfect(int n) {

        int tong = 1;

        for (int i = 2; i  <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                tong += i;
                if(i != n/i)
                	tong += n/i;
            }
        }
        
        
        return tong == n && n != 1;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số n: ");
        int n = sc.nextInt();
        System.out.println(isPerfect(n) ? "true" : "false");
	}

}
