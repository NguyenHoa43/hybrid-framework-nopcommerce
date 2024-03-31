package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageUIs.nopCommerce.user.HomePageUI;

public class lever_07_CustomerInfor extends BaseTest {
	private WebDriver driverTestClass;
	private String firstName, lastName, passWord, emailAddress, cityAddress;
	private String dateOfBirth, monthOfBirth, yearOfBirth, companyName;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	private UserCustomerInforPageObject userCustomerInfor;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		emailAddress = "afc" + fadeNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		dateOfBirth = "1";
		monthOfBirth = "January";
		yearOfBirth = "1999";
		companyName = "Automation FC";
		cityAddress = "Ho Chi Minh";

		userRegisterPage = userHomePage.clickToRegisterLink(driverTestClass);

		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(passWord);
		userRegisterPage.inputToConfirmPasswordTextbox(passWord);
		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(passWord);
//		  loginPage.clickToLoginButton();
		userHomePage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());

	}

	@Test
	public void Account_01_Update_Infor() {
		log.info("Update Infor - Step 01: Navigate to 'Customer Information' page");
		userCustomerInfor = userHomePage.clickToAccountLink(driverTestClass);

		log.info("Update Infor - Step 02: Select Sex");
		userCustomerInfor.clickToGender();

		log.info("Update Infor - Step 03: Import First Name with value is '" + firstName + "'");
		userCustomerInfor.inputFirstName(firstName);

		log.info("Update Infor - Step 04: Import Last Name with value is '" + lastName + "'");
		userCustomerInfor.inputLastName(lastName);

		log.info("Update Infor - Step 05: Import Date of Birth with value is '" + dateOfBirth + "'");
		userCustomerInfor.inputDateOfBirth(dateOfBirth);

		log.info("Update Infor - Step 06: Import Month of Birth with value is '" + monthOfBirth + "'");
		userCustomerInfor.inputMonthOfBirth(monthOfBirth);

		log.info("Update Infor - Step 07: Import Years of Birth with value is '" + yearOfBirth + "'");
		userCustomerInfor.inputYeaOfBirth(yearOfBirth);

		log.info("Update Infor - Step 08: Import Email with value is '" + emailAddress + "'");
		userCustomerInfor.inputEmail(emailAddress);

		log.info("Update Infor - Step 09: Import Company Name with value is '" + companyName + "'");
		userCustomerInfor.inputCompanyName(companyName);

		log.info("Update Infor - Step 10: Save Information");
		userCustomerInfor.clickToButtonSave();

		log.info("Update Infor - Step 11: Verify Save information successfully");
		Assert.assertEquals(userCustomerInfor.getMessageUpdateSuccess(),
				"The customer info has been updated successfully.");

	}

	@Test
	public void Account_03_Update_Address() {
		log.info("Update Address - Step 01: Opent Address Page");
		userCustomerInfor.clickToButtonAddressLink();

		log.info("Update Address - Step 02: Opent Addnew Address Page");
		userCustomerInfor.clickToButtonAddnewLink();

		log.info("Update Address - Step 03: Import First Name with value is '" + firstName + "'");
		userCustomerInfor.inputFirstNameAddress(firstName);

		log.info("Update Address - Step 04: Import Last Name with value is '" + lastName + "'");
		userCustomerInfor.inputLastNameAddress(lastName);

		log.info("Update Address - Step 05: Import Email Address with value is '" + emailAddress + "'");
		userCustomerInfor.inputEmailAddress(emailAddress);

		log.info("Update Address - Step 06: Import Company Name with value is '" + companyName + "'");
		userCustomerInfor.inputCompanyNameAddress(companyName);

		log.info("Update Address - Step 07: Select ID Address Country");
		userCustomerInfor.selectCountryIDAddress("Viet Nam");

		log.info("Update Address - Step 08: Select ID Address Stateptovince");
		userCustomerInfor.selectStateptovinceIDAdress("Other");

		log.info("Update Address - Step 09: Import Address City");
		userCustomerInfor.inputCityAddress(cityAddress);

		log.info("Update Address - Step 10: Import Address One");
		userCustomerInfor.inputAddressOne("32/23 Strump");

		log.info("Update Address - Step 11: Import Address Two");
		userCustomerInfor.inputAddressTwo("45/54 Obama");

		log.info("Update Address - Step 12: Import Zipcode Address");
		userCustomerInfor.inputZipcodeAddress("65000");

		log.info("Update Address - Step 13: Import Phone Number");
		userCustomerInfor.inputPhoneNumberAddress("09876543210");

		log.info("Update Address - Step 14: Import Fax Number");
		userCustomerInfor.inputFaxNumberAddress("0123456789");

		log.info("Update Address - Step 15: Save Information Address");
		userCustomerInfor.clickToElementSaveAddress();

		log.info("Update Address - Step 16: Verify Addnew Address Successfully");
		Assert.assertEquals(userCustomerInfor.getMessageSuccessAddress(),
				"The new address has been added successfully.");

		log.info("Update Address - Step 17: Click Button Message Successfully");
		userCustomerInfor.clickToMessageSuccessButton();
	}

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
