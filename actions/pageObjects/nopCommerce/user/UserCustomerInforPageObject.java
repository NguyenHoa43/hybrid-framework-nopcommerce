package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	private WebDriver driver;
	
	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserCustomerInforPageObject clickToMyAccoutLink() {
		waitForElementClickable(driver, CustomerInforPageUI.ACCOUNT_LINK);
		clickToElement(driver,CustomerInforPageUI.ACCOUNT_LINK);
		return PageGeneratorManager.getUserAccountPage(driver);
	}
	
	
	public void clickToGender() {
		waitForElementClickable(driver, CustomerInforPageUI.GENDER_RADIO);
		clickToElement(driver, CustomerInforPageUI.GENDER_RADIO);
	}
	
	public void inputFirstName(String firstName) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.EMAIL_TEXTBOX, firstName);
	}
	
	public void inputLastName(String lastName) {
		waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void inputEmail(String emailAddressValue) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.EMAIL_TEXTBOX, emailAddressValue);
	}
	
	public void inputCompanyName(String nameCompany) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.COMPANY_NAME_TEXTBOX, nameCompany);
	}
	
	public void inputDateOfBirth(String dateBirth) {
		waitForElementClickable(driver, CustomerInforPageUI.DATE_OF_BIRTH);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.DATE_OF_BIRTH, dateBirth);
	}
	
	public void inputMonthOfBirth(String monthBirth) {
		waitForElementClickable(driver, CustomerInforPageUI.MONTH_OF_BIRTH);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.MONTH_OF_BIRTH, monthBirth);
	}
	
	public void inputYeaOfBirth(String yearBirth) {
		waitForElementClickable(driver, CustomerInforPageUI.YEAR_OF_BIRTH);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.YEAR_OF_BIRTH, yearBirth);
	}
	
	public String getMessageUpdateSuccess() {
		waitForElementVisible(driver, CustomerInforPageUI.MESSAGE_UPDATE_INFO_SUCCESS);
		return getElementText(driver, CustomerInforPageUI.MESSAGE_UPDATE_INFO_SUCCESS);
	}
	
	public void clickToButtonSave() {
		waitForElementVisible(driver, CustomerInforPageUI.BUTTON_SAVE);
		clickToElement(driver, CustomerInforPageUI.BUTTON_SAVE);
	}
	
	public UserAddressPageObject clickToButtonAddressLink() {
		waitForElementClickable(driver, CustomerInforPageUI.ADDRESS_LINK);
		clickToElement(driver, CustomerInforPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public void clickToButtonAddnewLink() {
		waitForElementClickable(driver, CustomerInforPageUI.ADD_NEW_LINK);
		clickToElement(driver, CustomerInforPageUI.ADD_NEW_LINK);
	}
	
	public void inputFirstNameAddress(String textvalue) {
		waitForElementVisible(driver, CustomerInforPageUI.FIRSTNAME_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.FIRSTNAME_ADDRESS_TEXTBOX, textvalue);
	}
	
	public void inputLastNameAddress(String textLastNamvalue) {
		waitForElementVisible(driver, CustomerInforPageUI.LASTNAME_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.LASTNAME_ADDRESS_TEXTBOX, textLastNamvalue);
	}
	
	public void inputEmailAddress(String emailText) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.EMAIL_ADDRESS_TEXTBOX, emailText);
	}
	
	public void inputCompanyNameAddress(String companyText) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_NAME_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.COMPANY_NAME_ADDRESS_TEXTBOX, companyText);
	}
	
	public void selectCountryIDAddress(String countryName) {
		waitForElementClickable(driver, CustomerInforPageUI.COUNTRY_ID_ADDRESS_SELECT);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.COUNTRY_ID_ADDRESS_SELECT, countryName);
	}
	
	public void selectStateptovinceIDAdress(String statevalue) {
		waitForElementClickable(driver, CustomerInforPageUI.STATEPROVINCE_ID_ADDRESS_SELECT);
		selectItemInDefaultDropdown(driver, CustomerInforPageUI.STATEPROVINCE_ID_ADDRESS_SELECT, statevalue);
	}
	
	public void inputCityAddress(String cityValue) {
		waitForElementVisible(driver, CustomerInforPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.CITY_ADDRESS_TEXTBOX, cityValue);
	}
	
	public void inputAddressOne(String addressOneValue) {
		waitForElementVisible(driver, CustomerInforPageUI.ADDRESS_1_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.ADDRESS_1_TEXTBOX, addressOneValue);
	}
	
	public void inputAddressTwo(String addressTwoValue) {
		waitForElementVisible(driver, CustomerInforPageUI.ADDRESS_2_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.ADDRESS_2_TEXTBOX, addressTwoValue);
	}
	
	public void inputZipcodeAddress(String zipValue) {
		waitForElementVisible(driver, CustomerInforPageUI.ZIPCODE_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.ZIPCODE_ADDRESS_TEXTBOX, zipValue);
	}
	
	public void inputPhoneNumberAddress(String phoneValue) {
		waitForElementVisible(driver, CustomerInforPageUI.PHONENUMBER_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.PHONENUMBER_ADDRESS_TEXTBOX, phoneValue);
	}
	
	public void inputFaxNumberAddress(String faxValue) {
		waitForElementVisible(driver, CustomerInforPageUI.FAXNUMBER_ADDRESS_TEXTBOX);
		sendkeysToElement(driver, CustomerInforPageUI.FAXNUMBER_ADDRESS_TEXTBOX, faxValue);
	}
	
	public void clickToElementSaveAddress(){
		waitForElementClickable(driver, CustomerInforPageUI.SAVE_ADDRESS_LINK);
		clickToElement(driver, CustomerInforPageUI.SAVE_ADDRESS_LINK);
	}
	
	public String getMessageSuccessAddress() {
		waitForElementVisible(driver, CustomerInforPageUI.MESSAGE_SUCCESS_ADDRESS);
		return getElementText(driver,CustomerInforPageUI.MESSAGE_SUCCESS_ADDRESS);
	}
	
	public String getMessageErrorEmail() {
		waitForElementVisible(driver, CustomerInforPageUI.MESAGE_ERROR_EMAIL);
		return getElementText(driver, CustomerInforPageUI.MESAGE_ERROR_EMAIL);
	}
	
	public void clickToMessageSuccessButton() {
		waitForElementVisible(driver, CustomerInforPageUI.MESSAGE_SUCCESS_ADDRESS_BUTTOM);
		clickToElement(driver, CustomerInforPageUI.MESSAGE_SUCCESS_ADDRESS_BUTTOM);
		
	}
	
	public boolean isMycustomerInforDisplay() {
		waitForElementVisible(driver, CustomerInforPageUI.TEXT_ACCOUNT_PAGE);
		return isElementDisplay(driver, CustomerInforPageUI.TEXT_ACCOUNT_PAGE);
	}
}
