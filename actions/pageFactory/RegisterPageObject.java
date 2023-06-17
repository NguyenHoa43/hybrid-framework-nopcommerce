package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BagePageFactory;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BagePageFactory{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	private WebElement emailTextbox;
	
	@FindBy(id = "Password")
	private WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "FirstName-error")
	private WebElement firstNameErrorMessage;
	
	@FindBy(id = "LastName-error")
	private WebElement lastNameErrorMessage;
	
	@FindBy(id = "Email-error")
	private WebElement emailErrorMessage;
	
	@FindBy(id = "Password-error")
	private WebElement passwordErrorMessage;
	
	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(id = "result")
	private WebElement registerMessageSuccess;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	
	@FindBy(id = "ico-logout")
	private WebElement logoutLink;
	
	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement existingEmailErrorMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);	
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);
		sendkeysToElement(driver, firstNameTextBox, firstName);
		
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeysToElement(driver, lastNameTextbox, lastName);
		
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeysToElement(driver, emailTextbox, emailAddress);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeysToElement(driver, passwordTextbox, password);
		
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeysToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerMessageSuccess);
		return getElementText(driver, registerMessageSuccess);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

}
