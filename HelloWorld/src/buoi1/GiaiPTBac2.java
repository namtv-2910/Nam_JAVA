package buoi1;

import java.util.Scanner;

public class GiaiPTBac2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Nhap 3 so nguyen a b c: ");
		Scanner sc = new Scanner(System.in);
		float a, b, c, x1, x2, delta;
		a=sc.nextFloat();
		b=sc.nextFloat();
		c=sc.nextFloat();
		if (a==0) {
			if(b==0){
				if(c==0)
					System.out.println("PT vô số nghiệm");
				else 
					System.out.println("PT vô nghiệm");
			}
			else {
				float x = -c/b;
				System.out.println("PT có 1 nghiệm: "+ x);
			}
		}
		else {
			delta = b*b - 4*a*c;
			if(delta < 0 ) {
				System.out.println("PT vô nghiêm");
			}
				
			else if(delta == 0) {
				x1 = x2 = -b/(2*a);
				System.out.println("PT có nghiệm kép x1 = x2 = "+ x1);
			}
			else {
				x1= (-b -(float)Math.sqrt(delta))/(2*a);
				x2= (-b +(float)Math.sqrt(delta))/(2*a);
				System.out.println("PT có 2 nghiệm");
				System.out.println("x1 = " +x1);
				System.out.println("x2 = " +x2);
				
			}
		}
		
	}

}
