package communityuni.com;

import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceTest {
	static ArrayList<Invoice> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void inputInvoice() {
		System.out.println("Nhập số lượng invoice: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i< n; i++) {
			System.out.println("\nInvoice thứ: "+i+1);
			String maHang;
			
			while(true) {
				System.out.println("Nhập mã hàng: ");
				maHang = sc.nextLine();
				if(checkInvoice(maHang)) {
					System.out.println("Mã đã tồn tại. Nhập lại!");
				}
				else {
					break;
				}
					
			}
			System.out.println("Nhập mô tả: ");
			String moTa = sc.nextLine();
			System.out.println("Nhập số lượng: ");
			int soLuong = sc.nextInt();
			System.out.println("Nhập giá: ");
			double price = sc.nextDouble();
			
			Invoice iv = new Invoice(maHang, moTa, soLuong, price);
			
			list.add(iv);
		}
	}
	public static boolean checkInvoice(String maHang) {
		for(Invoice x: list) {
			if(x.getPastNumber().equals(maHang)) {
				return true;
			}
		}
		return false;
	}
	public static void outputInvoice() {
		if(list.isEmpty()) {
			System.out.println("Danh sách rỗng!");
			return;
		}
		
		for(Invoice x : list) {
			x.layThongTin();
		}
	}
	public static void searchInvoice() {
		System.out.println("Nhập mã cần tìm: ");
		String maHang = sc.nextLine();
		boolean found = false;
		
		for(Invoice x : list) {
			if(x.getPastNumber().equals(maHang)) {
				x.layThongTin();
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("Không tìm thấy!");
		}
	}
	public static void Xoa() {
		System.out.println("Nhập mã cần xoá: ");
		String maHang = sc.nextLine();
		boolean found = false;
		
		for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPastNumber().equals(maHang)) {
                list.remove(i);
                found = true;
                System.out.println("Xóa thành công!");
                break;
            }
        }
		
		 if (!found) {
	            System.out.println("Không tìm thấy mã để xoá!");
	        }
	}
	
	public static void sortByMaHang() {
		for (int i = 1; i < list.size(); i++) {
			Invoice temp = list.get(i);
            String maHang = temp.getPastNumber();
            int j = i - 1;

            while (j >= 0 && list.get(j).getPastNumber().compareToIgnoreCase(maHang) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j+1, temp);
        }

        System.out.println("Đã sắp xếp tăng dần (Insertion Sort)!");
	}
	public static void sortByQuantity() {
		for(int i = 0 ; i < list.size()-1; i++) {
			for(int j = 0; j< list.size() - i - 1; j++) {
				if(list.get(j).getQuantity() > list.get(j+1).getQuantity()) {
					Invoice temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		System.out.println("Sắp xếpt tăng dần( Bubble sort)");
	}
	
	public static void menu() {

        while (true) {

            System.out.println("\n========= MENU =========");
            System.out.println("1. Nhập danh sách Invoice");
            System.out.println("2. Xuất danh sách Invoice");
            System.out.println("3. Tìm Invoice theo mã");
            System.out.println("4. Xóa Invoice theo mã");
            System.out.println("5. Sắp xếp theo mã");
            System.out.println("6. Sắp xếp theo số lượng");
            System.out.println("0. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {

                case 1:
                    inputInvoice();
                    break;

                case 2:
                    outputInvoice();
                    break;

                case 3:
                    searchInvoice();
                    break;

                case 4:
                    Xoa();
                    break;

                case 5:
                    sortByMaHang();
                    break;

                case 6:
                    sortByQuantity();
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
