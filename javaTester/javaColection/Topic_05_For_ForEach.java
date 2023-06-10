package javaColection;

import org.testng.annotations.Test;

public class Topic_05_For_ForEach {

	
	//@Test
	public void TC_01_For() {
		
		String[] cityName = {"Hồ Chí Minh", "Cần Thơ", "Vũng Tàu", "Đà Nẵng"};
		
		for(int i = 0; i < cityName.length; i++) {
			System.out.println(cityName[i]);
		}
	}
	
	//@Test
	public void TC_02_For() {
		
		String[] cityName = {"Hồ Chí Minh", "Cần Thơ", "Vũng Tàu", "Đà Nẵng"};
		
		for(int i = 0; i < cityName.length; i++) {
			if(cityName[i].equals("Hồ Chí Minh")) {
				System.out.println(cityName[i]);
				break;
			}
			
		}
	}
	
	@Test
	public void TC_03_ForEach() {
		
		String[] cityName = {"Hồ Chí Minh", "Cần Thơ", "Vũng Tàu", "Đà Nẵng"};
		
		for (String city : cityName) {
			if(city.equals("Cần Thơ")) {
				
			System.out.println(city);
		}
			
		}
	}

}
