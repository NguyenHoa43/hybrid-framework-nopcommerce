package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MYACCOUNT_LINK);
	}
	
}
