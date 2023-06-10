package javaColection;

import static org.testng.Assert.expectThrows;

import java.util.Scanner;

import org.openqa.grid.internal.exception.NewSessionException;
import org.testng.annotations.Test;

public class Topic_03_If_Else {
	Scanner scanner = new Scanner(System.in);
	
	
	//@Test
	public void TC_01_If_Else() {
		// page object
		// dynamic page
		// hàm Scanner scanner = new Scanner(System.in) dùng để nhập liệu vào console
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		if (number % 2 == 0) {
			System.out.println("Số : " + number + " " + "là số chẵn");
			
		}else {
			System.out.println("Số : " + number + " " + "là số lẻ ");
		}
	}
	
	//@Test
	public void TC_02_If_Else() {
		
		int NumberA = scanner.nextInt();
		int NumberB = scanner.nextInt();
		
		if(NumberA >= NumberB) {
			System.out.println(NumberA + " " + "lớn hơn hoặc bằng" + " " + NumberB);
		}else {
			System.out.println(NumberA + " " + "nhỏ hơn" + " " + NumberB);
		}
	}
	
	//@Test
	public void TC_03_If_Else() {
		
		String firstStudent;
		String secondStudent;
		firstStudent = scanner.nextLine();
		secondStudent = scanner.nextLine();
		
		if(firstStudent.equals(secondStudent)) {
			System.out.println("Tên hai sinh viên giống nhau");
		}else {
			System.out.println("Tên hai sinh viên khác nhau");
		}
	}
	//@Test
	public void TC_04_If_Else() {
		
		int NumberA = scanner.nextInt();
		int NumberB = scanner.nextInt();
		int NumberC = scanner.nextInt();
		
		if(NumberA > NumberB && NumberA > NumberC) {
			System.out.println(NumberA + " " + "NumberA lớn nhất");
		}else if (NumberB > NumberC){
			System.out.println(NumberB + " " + "NumberB lớn nhất");
		}else {
			System.out.println(NumberC + " " + "NumberC lớn nhất");
		}
	}
	@Test
	public void TC_05_If_Else() {
		
		float pointA = scanner.nextFloat();
		
		
		
		if(pointA<= 10 && pointA >= 8.5) {
			System.out.println("Hệ số A");
		}else if (pointA < 8.5 && pointA >= 7.5){
			System.out.println("Hệ số B");
		}else if(pointA < 7.5 && pointA >= 5){
			System.out.println("Hệ số C");
		}else if(pointA < 5 && pointA > 0) {
			System.out.println("Hệ số D");
		}else if (pointA > 10) {
			System.out.println("nhập lại điểm");
		}else {
			System.out.println("nhập lại điểm");
		}
	}
	
}
