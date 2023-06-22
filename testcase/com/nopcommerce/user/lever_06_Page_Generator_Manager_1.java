package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class lever_06_Page_Generator_Manager_1 extends BaseTest {
	private WebDriver driverTestClass;
	private String  firstName, lastName, passWord, emailAddress, wrongPassword, wrongEmail;;
	private UserLoginPageObject UserLoginPage;
	private UserRegisterPageObject UserRegisterPage;
	private UserHomePageObject UserHomePage; 
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  UserHomePage = new UserHomePageObject(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  wrongPassword = "123";
		  wrongEmail = "123@456#%*"; 
		  
		  
		  
		  
		  
		  UserHomePage.clickToRegisterLink(driverTestClass);
		  UserRegisterPage = new UserRegisterPageObject(driverTestClass);
		  UserRegisterPage.inputToFirstnameTextbox(firstName);
		  UserRegisterPage.inputToLastNameTextbox(lastName);
		  UserRegisterPage.inputToEmailTextbox(emailAddress);
		  UserRegisterPage.inputToPasswordTextbox(passWord);
		  UserRegisterPage.inputToConfirmPasswordTextbox(passWord);
		  UserRegisterPage.clickToRegisterButton();
		  Assert.assertEquals(UserRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
	}
	@Test
	public void Login_01_Empty_Data() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.clickToLoginButton();
		Assert.assertEquals(UserLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");		
	}	
	@Test
	public void Login_02_Invalid_Email() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.inputToEmailTextbox("hoa12");
		UserLoginPage.inputToPasswordTextbox(passWord);
		UserLoginPage.clickToLoginButton();
		Assert.assertEquals(UserLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}	
	@Test
	public void Login_03_Unregister_Email() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.inputToEmailTextbox("hoa12@gmail.com");
		UserLoginPage.inputToPasswordTextbox(passWord);
		UserLoginPage.clickToLoginButton();
		Assert.assertEquals(UserLoginPage.getErrorMessageEmailUnregister(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Empty_Password() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.inputToEmailTextbox(emailAddress);
		UserLoginPage.clickToLoginButton();
		Assert.assertEquals(UserLoginPage.getErrorMessageAtPasswordTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}	
	@Test
	public void Login_05_Wrong_Password() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.inputToEmailTextbox(emailAddress);
		UserLoginPage.inputToPasswordTextbox("123467");
		UserLoginPage.clickToLoginButton();
		Assert.assertEquals(UserLoginPage.getErrorMessageAtWrongPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Successfull() {
		UserRegisterPage.clickToLoginLink(driverTestClass);
		UserLoginPage = new UserLoginPageObject(driverTestClass);
		UserLoginPage.inputToEmailTextbox(emailAddress);
		UserLoginPage.inputToPasswordTextbox(passWord);
		UserLoginPage.clickToLoginButton();
		UserHomePage = new UserHomePageObject(driverTestClass);
		Assert.assertTrue(UserHomePage.isMyAccountLinkDisplay());
	}	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
