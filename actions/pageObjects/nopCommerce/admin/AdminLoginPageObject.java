package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToUserNameTextbox(String valueEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, valueEmail);
		}
	
	public void inputToPasswordTextbox(String valuePass) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, valuePass);
	}
	
	public AdminDashboardPageObject clickToButtonLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String PassWord, String Email) {
		inputToUserNameTextbox(Email);
		inputToPasswordTextbox(PassWord);
		return clickToButtonLogin();
	}
}
