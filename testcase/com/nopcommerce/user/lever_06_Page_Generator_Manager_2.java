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
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserHomePageObject homePage; 
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  homePage = new UserHomePageObject(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  wrongPassword = "123";
		  wrongEmail = "123@456#%*"; 
		  
		  
		  
		  
		  
		  registerPage = homePage.clickToRegisterLink(driverTestClass);
		  
		  registerPage.inputToFirstnameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(emailAddress);
		  registerPage.inputToPasswordTextbox(passWord);
		  registerPage.inputToConfirmPasswordTextbox(passWord);
		  registerPage.clickToRegisterButton();
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	}
	@Test
	public void Login_01_Empty_Data() {
		loginPage = registerPage.clickToLoginLink(driverTestClass);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");		
	}	
	@Test
	public void Login_02_Invalid_Email() {
		loginPage = registerPage.clickToLoginLink(driverTestClass);
		loginPage.inputToEmailTextbox("hoa12");
		loginPage.inputToPasswordTextbox(passWord);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}	
	@Test
	public void Login_03_Unregister_Email() {
		loginPage = registerPage.clickToLoginLink(driverTestClass);
		loginPage.inputToEmailTextbox("hoa12@gmail.com");
		loginPage.inputToPasswordTextbox(passWord);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageEmailUnregister(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}
	@Test
	public void Login_04_Empty_Password() {
		loginPage = registerPage.clickToLoginLink(driverTestClass);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextbox(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}	
	@Test
	public void Login_05_Wrong_Password() {
		loginPage =  registerPage.clickToLoginLink(driverTestClass);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox("123467");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtWrongPasswordTextbox(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	@Test
	public void Login_06_Successfull() {
		loginPage =  registerPage.clickToLoginLink(driverTestClass);
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(passWord);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplay());
	}	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
