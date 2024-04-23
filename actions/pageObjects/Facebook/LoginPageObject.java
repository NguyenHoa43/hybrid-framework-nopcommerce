package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);	
	}

	public boolean isEmailAddressTextBoxDisplay() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public void enterToEmailAdressTextBox(String emailAdress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAdress);
		
	}

	public boolean isConfirmEmailAdressTesxtboxDisplay() {
		return isElementDisplay(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtregisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
		
	}

	public boolean isConfirmEmailAddressTextBoxUndisplayed() {
		waitForElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
}
