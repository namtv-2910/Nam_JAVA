package bt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bt_arraylist2 {

	public static void main(String[] args) {
    try {
    	 Scanner sc = new Scanner(System.in);
         ArrayList<String> list = new ArrayList<>();
         int choice;

         do {
             System.out.println("\n===== MENU =====");
             System.out.println("1. Thêm sinh viên");
             System.out.println("2. Xuất danh sách");
             System.out.println("3. Sửa sinh viên");
             System.out.println("4. Xóa sinh viên theo tên");
             System.out.println("5. Tìm sinh viên có chữ 'An'");
             System.out.println("6. Sắp xếp danh sách");
             System.out.println("7. Số lượng sinh viên");
             System.out.println("0. Thoát");
             System.out.print("Chọn: ");
             choice = sc.nextInt();
             sc.nextLine();

             switch (choice) {
                 case 1:
                     System.out.print("Nhập tên sinh viên: ");
                     String name = sc.nextLine();
                     list.add(name);
                     break;

                 case 2:
                     System.out.println("Danh sách sinh viên:");
                     for (String sv : list) {
                         System.out.println(sv);
                     }
                     break;

                 case 3:
                     System.out.print("Nhập vị trí cần sửa: ");
                     int index = sc.nextInt();
                     sc.nextLine();
                     if (index >= 0 && index < list.size()) {
                         System.out.print("Nhập tên mới: ");
                         String newName = sc.nextLine();
                         list.set(index, newName);
                     } else {
                         System.out.println("Vị trí không hợp lệ!");
                     }
                     break;

                 case 4:
                     System.out.print("Nhập tên cần xóa: ");
                     String delName = sc.nextLine();
                     if (list.removeIf(sv -> sv.equalsIgnoreCase(delName))) {
                         System.out.println("Đã xóa!");
                     } else {
                         System.out.println("Không tìm thấy!");
                     }
                     break;

                 case 5:
                     System.out.println("Sinh viên có chứa 'An':");
                     boolean found = false;
                     for (String sv : list) {
                         if (sv.toLowerCase().contains("an")) {
                             System.out.println(sv);
                             found = true;
                         }
                     }
                     if (!found) {
                         System.out.println("Không có!");
                     }
                     break;

                 case 6:
                 	for (int i = 1; i < list.size(); i++) {
                         String key = list.get(i);
                         int j = i - 1;

                         while (j >= 0 && list.get(j).compareToIgnoreCase(key) > 0) {
                             list.set(j + 1, list.get(j));
                             j--;
                         }
                         list.set(j+1, key);
                     }

                     System.out.println("Đã sắp xếp tăng dần (Insertion Sort)!");
                     break;

                 case 7:
                     System.out.println("Số lượng sinh viên: " + list.size());
                     break;

                 case 0:
                     System.out.println("Thoát!");
                     break;

                 default:
                     System.out.println("Chọn sai!");
             }

         } while (choice != 0);

         sc.close();
     
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		System.out.println("hello");
	}
	}

}
