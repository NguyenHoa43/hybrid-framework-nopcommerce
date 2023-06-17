package eclipseTip;

import java.util.Scanner;

public class Topic_01_Debug {

	
	public static void in(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Nhập vào họ và tên  : ");
		String fullname1 = input.nextLine();
		System.out.println("Họ tên bạn vừa nhập vào sử dụng method nextLine : "+fullname1);
		
		System.out.println("Nhập vào họ và tên  : ");
		String fullname2 = input.next();
		System.out.println();
		System.out.println("Họ tên bạn vừa nhập vào sử dụng method next : "+fullname2);
	}
	
}
