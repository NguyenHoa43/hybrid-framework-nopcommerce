package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BagePageFactory;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BagePageFactory {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement buttonLogin;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement emailErrorMessageUnregister;
	
	@FindBy(id = "Email-error")
	private WebElement wrongEmailMessage;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement passwordErrorMessage;
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, buttonLogin);
		clickToElement(driver, buttonLogin);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeysToElement(driver, emailTextbox, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeysToElement(driver, passwordTextbox, password);
	}
	
	public String getErrorMessageEmailUnregister() {
		waitForElementVisible(driver, emailErrorMessageUnregister);
		return getElementText(driver, emailErrorMessageUnregister);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}
	
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}
	
	public String getErrorMessageAtWrongPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}
	
}
