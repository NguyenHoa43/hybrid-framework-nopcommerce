package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public String getErrorMessageEmailUnregister() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_UNREGISTER);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE_UNREGISTER);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitAllElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE_EMPTY_TEXTBOX);
		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE_EMPTY_TEXTBOX);
	}
	
	public String getErrorMessageAtWrongPasswordTextbox() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE_WRONGPASSWORD);
		return getElementText(driver, LoginPageUI.PASSWORD_ERROR_MESSAGE_WRONGPASSWORD);
	}
	
	public UserHomePageObject loginAsUser(String emailAddress, String passWord) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(passWord);
		return clickToLoginButton();
	}
	
}
