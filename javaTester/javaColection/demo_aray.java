package javaColection;

import org.testng.annotations.Test;

public class demo_aray {
	int number[] = { -1, -3, -45, 0, 5, 6, 9, 3, 10, 80, 50, 90, 100 };

	// @Test
	public void TC_01_find_max_number() {
		int x = 0;
		for (int i = 0; i < number.length; i++) {
			if (x < number[i]) {
				x = number[i];
			}
		}
		System.out.println("max number = " + x);
	}

	// @Test
	public void TC_02_Sum_firstNumber_LastNumber() {

		System.out.println(number[0] + number[number.length - 1]);
	}

	//@Test
	public void TC_03_Even_Number() {

		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 == 0) {
				System.out.println("Even number = " + number[i]);
			}
		}

	}

	//@Test
	public void TC_04_large_small() {

		for (int i = 0; i < number.length; i++) {
			if (number[i] >= 0 && number[i] <= 10) {
				System.out.println("number = " + number[i]);
			}
		}

	}
	
	@Test
	public void TC_05_Sum_Average() {
		int sum = 0;
		for (int i = 0; i < number.length; i++) {
			 sum += number[i];
			}
		System.out.println("sum = " + sum);
		System.out.println("Average = " + sum/ number.length);
		}

	
}
