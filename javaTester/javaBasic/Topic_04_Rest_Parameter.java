package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
	String addressLink = "//div[@class='side-2']//a[text()='My account - Reward points']";
	String orderLink = "//div[@class='side-2']//a[text()='My account - My product reviews']";
	
	String sidebarLink = "//div[@class='side-2']//a[text()='%s']";
	@Test
	public void TC_01_Rest_Parameter(){
		clickToElement(addressLink);
		clickToElement(orderLink);
		
		clickToElement(sidebarLink, "Reward points");
		clickToElement(sidebarLink, "My account - My product reviews");
	}
	
	public void clickToElement(String localValue) {
		System.out.println("Click to:" + localValue);	
	}
	
	public void clickToElement(String locatorValue, String pageName) {
		System.out.println("locator trước khi pass value vào:" + locatorValue);
		locatorValue = String.format(locatorValue, pageName);
		System.out.println("locator sau khi pass value vào :" + locatorValue);
	}
}
