package communityuni.com;

import java.util.Scanner;

public class UCLN {

	public static int gcd(int a,int b) {
		return (b==0) ? a : gcd(b, a%b);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int a = sc.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int b = sc.nextInt();
        
        System.out.println(gcd(a, b)); 
	}

}
