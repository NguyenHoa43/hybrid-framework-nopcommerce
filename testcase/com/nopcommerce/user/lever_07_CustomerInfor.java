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
	private String  firstName, lastName, passWord, emailAddress, cityAddress;
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
		  
		  
		  
		  
		  
		  userRegisterPage =  userHomePage.clickToRegisterLink(driverTestClass);

		  userRegisterPage.inputToFirstnameTextbox(firstName);
		  userRegisterPage.inputToLastNameTextbox(lastName);
		  userRegisterPage.inputToEmailTextbox(emailAddress);
		  userRegisterPage.inputToPasswordTextbox(passWord);
		  userRegisterPage.inputToConfirmPasswordTextbox(passWord);
		  userRegisterPage.clickToRegisterButton();
		  Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
		  userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		  userLoginPage.inputToEmailTextbox(emailAddress);
		  userLoginPage.inputToPasswordTextbox(passWord);
//		  loginPage.clickToLoginButton();
		  userHomePage = userLoginPage.clickToLoginButton();
		  Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		 
	}
	@Test
	public void Account_01_Update_Infor() {
		userCustomerInfor = userLoginPage.clickToAccountLink(driverTestClass);
		userCustomerInfor.clickToGender();
		userCustomerInfor.inputFirstName(firstName);
		userCustomerInfor.inputLastName(lastName);
		userCustomerInfor.inputDateOfBirth(dateOfBirth);
		userCustomerInfor.inputMonthOfBirth(monthOfBirth);
		userCustomerInfor.inputYeaOfBirth(yearOfBirth);
		userCustomerInfor.inputEmail(emailAddress);
		userCustomerInfor.inputCompanyName(companyName);
		userCustomerInfor.clickToButtonSave();
		Assert.assertEquals(userCustomerInfor.getMessageUpdateSuccess(),"The customer info has been updated successfully.");
		
	}		
	@Test
	public void Account_03_Update_Address() {
		userCustomerInfor.clickToButtonAddressLink();
		userCustomerInfor.clickToButtonAddnewLink();
		userCustomerInfor.inputFirstNameAddress(firstName);
		userCustomerInfor.inputLastNameAddress(lastName);
		userCustomerInfor.inputEmailAddress(emailAddress);
		userCustomerInfor.inputCompanyNameAddress(companyName);
		userCustomerInfor.selectCountryIDAddress("Viet Nam");
		userCustomerInfor.selectStateptovinceIDAdress("Other");
		userCustomerInfor.inputCityAddress(cityAddress);
		userCustomerInfor.inputAddressOne("32/23 Strump");
		userCustomerInfor.inputAddressTwo("45/54 Obama");
		userCustomerInfor.inputZipcodeAddress("65000");
		userCustomerInfor.inputPhoneNumberAddress("09876543210");
		userCustomerInfor.inputFaxNumberAddress("0123456789");
		userCustomerInfor.clickToElementSaveAddress();
		Assert.assertEquals(userCustomerInfor.getMessageSuccessAddress(),"The new address has been added successfully.");
		userCustomerInfor.clickToMessageSuccessButton();
	}	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
