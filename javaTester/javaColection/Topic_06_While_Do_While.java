package javaColection;

import java.util.Scanner;

import org.testng.annotations.Test;




public class Topic_06_While_Do_While {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			System.out.println("for :" + i);
		}

		int b = 0;
		while (b < 5) {
			System.out.println("While :" + b);
			b++;

		}
		int a = 0;
		do {
			System.out.println("do_while :" + a);
			a++;
		} while (a < 6);
	}

	//@Test
	public void practice_01_While() {
		int numBer = scanner.nextInt();

		while (numBer <= 100) {
			if (numBer % 2 == 0) {
				System.out.println("While : " + numBer);

			}
			numBer++;
		}
	}

	//@Test
	public void practice_02_Do_While() {
		int numBer = scanner.nextInt();
		
		do { if (numBer % 2 == 0) {
			System.out.println("Do_While :" + numBer);
			}
		numBer++;
		}while (numBer < 100);
			
		}
	//@Test
	public void practice_03_Do_While() {
		int numBer = scanner.nextInt();
		
		do { if (numBer % 3 == 0 && numBer % 5 == 0) {
			System.out.println("Do_While :" + numBer);
			}
		numBer++;
		}while (numBer < 100);
			
		}
	
	//@Test
	public void practice_04_While() {
		int numBer = scanner.nextInt();
		
		while (numBer < 100) {
			if (numBer % 3 == 0 && numBer % 5 == 0) {
				System.out.println("While :" + numBer);
				}
			numBer++;
		}
			
		}
	
	@Test
	public void practice_05_While() {
		int numBer = scanner.nextInt();
		int i = 0;
		while (numBer > 0 ) {
			if (numBer % 2 != 0) {
				i += numBer;
				
				}
			numBer--;
		}
		System.out.println("While :" + i);
		}
	
	
	
	
	}

