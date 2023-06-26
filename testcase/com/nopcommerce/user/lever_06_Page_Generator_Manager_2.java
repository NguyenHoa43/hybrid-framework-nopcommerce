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

public class lever_06_Page_Generator_Manager_2 extends BaseTest {
	private WebDriver driverTestClass;
	private String  firstName, lastName, passWord, emailAddress, wrongPassword, wrongEmail;;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage; 
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  userHomePage = new UserHomePageObject(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  wrongPassword = "123";
		  wrongEmail = "123@456#%*"; 
		  
		  
		  
		  
		  
		  userRegisterPage = userHomePage.clickToRegisterLink(driverTestClass);
		  
		  userRegisterPage.inputToFirstnameTextbox(firstName);
		  userRegisterPage.inputToLastNameTextbox(lastName);
		  userRegisterPage.inputToEmailTextbox(emailAddress);
		  userRegisterPage.inputToPasswordTextbox(passWord);
		  userRegisterPage.inputToConfirmPasswordTextbox(passWord);
		  userRegisterPage.clickToRegisterButton();
		  Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");
	}
	@Test
	public void Login_01_Empty_Data() {
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");		
	}	
	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox("hoa12");
		userLoginPage.inputToPasswordTextbox(passWord);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}	
	@Test
	public void Login_03_Unregister_Email() {
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox("hoa12@gmail.com");
		userLoginPage.inputToPasswordTextbox(passWord);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageEmailUnregister(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Empty_Password() {
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtPasswordTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}	
	@Test
	public void Login_05_Wrong_Password() {
		userLoginPage =  userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox("123467");
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getErrorMessageAtWrongPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Successfull() {
		userLoginPage =  userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(passWord);
		userHomePage = userLoginPage.clickToLoginButton();
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
	}	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
