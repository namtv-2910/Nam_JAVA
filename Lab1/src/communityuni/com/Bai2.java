package communityuni.com;

public class Bai2 {

	 public static void NegativeNumberInStrings(String str) {

	        for (int i = 0; i < str.length(); i++) {

	            if (str.charAt(i) == '-') {

	                String result = "-";
	                i++;

	                while (i < str.length() && Character.isDigit(str.charAt(i))) {
	                    result += str.charAt(i);
	                    i++;
	                }

	                if (result.length() > 1) {
	                    System.out.println(result);
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {

	        String str = "abc-5xyz-12k-9l--p";

	        System.out.println("Các số âm trong chuỗi:");

	        NegativeNumberInStrings(str);
	    }

}
