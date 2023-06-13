//package com.nopcommerce.user;
//
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//import org.testng.annotations.BeforeClass;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//
//public class lever_02_Apply_BasePage_2 {
//	WebDriver driver;
//	String projectPath = System.getProperty("user.dir");
//	String emailAddress;
//	BasePage basePage;
//  @BeforeClass
//  public void beforeClass() {
//	  System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//	  driver = new FirefoxDriver();
//	  basePage = BasePage.getBasePageObject();
//	  emailAddress = "afc" + fadeNumber() + "@gmail.com";
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  driver.get("https://demo.nopcommerce.com/");
//	  }
//
//  @Test
//  public void Register_01_Empty_Data() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//  }
//  
//  
//  @Test
//  public void Register_02_Invalid_Email() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//input[@id='gender-male']");
//	  	basePage.sendkeysToElement(driver, "//input[@id='FirstName']", "Automation");
//	  	basePage.sendkeysToElement(driver, "//input[@id='LastName']", "FC");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Email']", "123@456#%*");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Password']", "123456");
//	  	basePage.sendkeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//  }
//
//  @Test
//  public void Register_03_Success() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//input[@id='gender-male']");
//	  	basePage.sendkeysToElement(driver, "//input[@id='FirstName']", "Automation");
//	  	basePage.sendkeysToElement(driver, "//input[@id='LastName']", "FC");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Email']", emailAddress);
//	  	basePage.sendkeysToElement(driver, "//input[@id='Password']", "123456");
//	  	basePage.sendkeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//		basePage.clickToElement(driver, "//a[@class='ico-login']");
//		basePage.sendkeysToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.sendkeysToElement(driver, "//input[@id='Password']", "123456");
//		basePage.clickToElement(driver, "//button[@class='button-1 login-button']");
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");	
//  }
//  
//  @Test
//  public void Register_04_Existing_Email() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//input[@id='gender-male']");
//	  	basePage.sendkeysToElement(driver, "//input[@id='FirstName']", "Automation");
//	  	basePage.sendkeysToElement(driver, "//input[@id='LastName']", "FC");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Email']", emailAddress);
//	  	basePage.sendkeysToElement(driver, "//input[@id='Password']", "123456");
//	  	basePage.sendkeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"), "The specified email already exists");
//  }
//  
//  @Test
//  public void Register_05_Password_Less_than_6_chars() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//input[@id='gender-male']");
//	  	basePage.sendkeysToElement(driver, "//input[@id='FirstName']", "Automation");
//	  	basePage.sendkeysToElement(driver, "//input[@id='LastName']", "FC");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Email']", emailAddress);
//	  	basePage.sendkeysToElement(driver, "//input[@id='Password']", "123");
//	  	basePage.sendkeysToElement(driver, "//input[@id='ConfirmPassword']", "123");
//	  	basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//	  	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//  }
//  
//  @Test
//  public void Register_06_Invalid_Password() {
//	  	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//a[@class='ico-register']");
//	  	basePage.clickToElement(driver, "//input[@id='gender-male']");
//	  	basePage.sendkeysToElement(driver, "//input[@id='FirstName']", "Automation");
//	  	basePage.sendkeysToElement(driver, "//input[@id='LastName']", "FC");
//	  	basePage.sendkeysToElement(driver, "//input[@id='Email']", emailAddress);
//	  	basePage.sendkeysToElement(driver, "//input[@id='Password']", "123456");
//	  	basePage.sendkeysToElement(driver, "//input[@id='ConfirmPassword']", "654321");
//	  	basePage.clickToElement(driver, "//button[@id='register-button']");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//  }
//  
//  public int fadeNumber() {
//	Random  rand = new Random();
//	return rand.nextInt(9999);
//  }
//  @AfterClass
//  public void afterClass() {
//	  driver.quit();
//  }
//
//}
