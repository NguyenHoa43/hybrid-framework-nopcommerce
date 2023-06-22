package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class lever_03_Page_Object_01_Register {
	  private WebDriver driver;
	  private String projectPath = System.getProperty("user.dir");
	  private String firstName, lastName, passWord, emailAddress, wrongPassword, wrongEmail;
	  private UserHomePageObject homePage;
	  private UserRegisterPageObject registerPage;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  
	  emailAddress = "afc" + fadeNumber() + "@gmail.com";
	  firstName = "Automation";
	  lastName = "FC";
	  passWord = "123456";
	  wrongPassword = "123";
	  wrongEmail = "123@456#%*"; 
	  
	  homePage = new UserHomePageObject(driver);
	  registerPage = new UserRegisterPageObject(driver);
	  }

  @Test
  public void Register_01_Empty_Data() {
	  	
	  	homePage.clickToRegisterLink(driver);
	  
	  	registerPage.clickToRegisterButton();
	  	
	  	Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
	  	Assert.assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");
	  	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
	  	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
	  	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	  	
	  	
	  	
  }
  
  
  @Test
  public void Register_02_Invalid_Email() {
	  	
	  	homePage.clickToRegisterLink(driver);
	  	
	  	
	  	
	  	registerPage.inputToFirstnameTextbox(firstName);
	  	registerPage.inputToLastNameTextbox(lastName);
	  	registerPage.inputToEmailTextbox(wrongEmail);
	  	registerPage.inputToPasswordTextbox(passWord);
	  	registerPage.inputToConfirmPasswordTextbox(passWord);
	  	
	 
	  	registerPage.clickToRegisterButton();
	  	Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Wrong email");
	 
  }

  @Test
  public void Register_03_Success() {
	  	
	  	homePage.clickToRegisterLink(driver);
		
	  	registerPage.inputToFirstnameTextbox(firstName);
	  	registerPage.inputToLastNameTextbox(lastName);
	  	registerPage.inputToEmailTextbox(emailAddress);
	  	registerPage.inputToPasswordTextbox(passWord);
	  	registerPage.inputToConfirmPasswordTextbox(passWord);
	  	registerPage.clickToRegisterButton();
	  	Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
	  	registerPage.clickToLoginLink(driver);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.clickToLoginButton();
		registerPage.clickToLogoutLink();
  }
  
  @Test
  public void Register_04_Existing_Email() {
		homePage.clickToRegisterLink(driver);
	
	  	registerPage.inputToFirstnameTextbox(firstName);
	  	registerPage.inputToLastNameTextbox(lastName);
	  	registerPage.inputToEmailTextbox(emailAddress);
	  	registerPage.inputToPasswordTextbox(passWord);
	  	registerPage.inputToConfirmPasswordTextbox(passWord);
	  	registerPage.clickToRegisterButton();
	  	
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
  }
  
  @Test
  public void Register_05_Password_Less_than_6_chars() {
	  	homePage.clickToRegisterLink(driver);
		
	  	registerPage.inputToFirstnameTextbox(firstName);
	  	registerPage.inputToLastNameTextbox(lastName);
	  	registerPage.inputToEmailTextbox(emailAddress);
	  	registerPage.inputToPasswordTextbox(wrongPassword);
	  	registerPage.inputToConfirmPasswordTextbox(wrongPassword);
	  	registerPage.clickToRegisterButton();
	  	
	  	Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	  	
  }
  
  @Test
  public void Register_06_Invalid_Password() {
	  
		homePage.clickToRegisterLink(driver);
		
	  	registerPage.inputToFirstnameTextbox(firstName);
	  	registerPage.inputToLastNameTextbox(lastName);
	  	registerPage.inputToEmailTextbox(emailAddress);
	  	registerPage.inputToPasswordTextbox(passWord);
	  	registerPage.inputToConfirmPasswordTextbox("654321");
	  	registerPage.clickToRegisterButton();
	  	Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
		
  }
  
  public int fadeNumber() {
	Random  rand = new Random();
	return rand.nextInt(9999);
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
