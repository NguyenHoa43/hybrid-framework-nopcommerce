package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressPageUI;

public class UserAddressPageObject extends BasePage{
	private WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}	
	public boolean isDisplayAddressPage() {
		waitForElementVisible(driver, AddressPageUI.MESSAGE_ADDRESS_TEXT);
		return isElementDisplay(driver, AddressPageUI.MESSAGE_ADDRESS_TEXT);
	}
}
