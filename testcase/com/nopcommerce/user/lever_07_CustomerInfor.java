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
import pageUIs.HomePageUI;

public class lever_07_CustomerInfor extends BaseTest {
	private WebDriver driverTestClass;
	private String  firstName, lastName, passWord, emailAddress, cityAddress;
	private String dateOfBirth, monthOfBirth, yearOfBirth, companyName;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserHomePageObject homePage; 
	private UserCustomerInforPageObject customerInfor;
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  homePage = PageGeneratorManager.getHomePage(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  dateOfBirth = "1";
		  monthOfBirth = "January";
		  yearOfBirth = "1999";
		  companyName = "Automation FC";
		  cityAddress = "Ho Chi Minh";
		  
		  
		  
		  
		  
		  registerPage =  homePage.clickToRegisterLink(driverTestClass);

		  registerPage.inputToFirstnameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(emailAddress);
		  registerPage.inputToPasswordTextbox(passWord);
		  registerPage.inputToConfirmPasswordTextbox(passWord);
		  registerPage.clickToRegisterButton();
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		  loginPage = registerPage.clickToLoginLink(driverTestClass);
		  loginPage.inputToEmailTextbox(emailAddress);
		  loginPage.inputToPasswordTextbox(passWord);
//		  loginPage.clickToLoginButton();
		  homePage = loginPage.clickToLoginButton();
		  Assert.assertTrue(homePage.isMyAccountLinkDisplay());
		 
	}
	@Test
	public void Account_01_Update_Infor() {
		customerInfor = loginPage.clickToAccountLink(driverTestClass);
		customerInfor.clickToGender();
		customerInfor.inputFirstName(firstName);
		customerInfor.inputLastName(lastName);
		customerInfor.inputDateOfBirth(dateOfBirth);
		customerInfor.inputMonthOfBirth(monthOfBirth);
		customerInfor.inputYeaOfBirth(yearOfBirth);
		customerInfor.inputEmail(emailAddress);
		customerInfor.inputCompanyName(companyName);
		customerInfor.clickToButtonSave();
		Assert.assertEquals(customerInfor.getMessageUpdateSuccess(),"The customer info has been updated successfully.");
		
	}		
	@Test
	public void Account_03_Update_Address() {
		customerInfor.clickToButtonAddressLink();
		customerInfor.clickToButtonAddnewLink();
		customerInfor.inputFirstNameAddress(firstName);
		customerInfor.inputLastNameAddress(lastName);
		customerInfor.inputEmailAddress(emailAddress);
		customerInfor.inputCompanyNameAddress(companyName);
		customerInfor.selectCountryIDAddress("Viet Nam");
		customerInfor.selectStateptovinceIDAdress("Other");
		customerInfor.inputCityAddress(cityAddress);
		customerInfor.inputAddressOne("32/23 Strump");
		customerInfor.inputAddressTwo("45/54 Obama");
		customerInfor.inputZipcodeAddress("65000");
		customerInfor.inputPhoneNumberAddress("09876543210");
		customerInfor.inputFaxNumberAddress("0123456789");
		customerInfor.clickToElementSaveAddress();
		Assert.assertEquals(customerInfor.getMessageSuccessAddress(),"The new address has been added successfully.");
		customerInfor.clickToMessageSuccessButton();
	}	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
