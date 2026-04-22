package Buoi_2;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s = "D:/music/bolero/longme.mp3";
			String s2 = s.substring(s.lastIndexOf("/")+1);
			System.out.println(s2);
			
			String s3 = s2.substring(0, s2.lastIndexOf("."));
			
			System.out.println(s3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			System.out.println("KT");
		}

	}

}
