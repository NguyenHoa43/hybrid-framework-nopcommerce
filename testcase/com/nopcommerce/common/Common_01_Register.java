package com.nopcommerce.common;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;

public class Common_01_Register extends BaseTest {
	
    @Parameters("browser")
	@BeforeTest(description = "Create new common User for all Classes Test")
	public void Register_Success(String browserName) {
		driver = getBrowserDriver(browserName);
		UserHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = "afc" + fadeNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		passWord = "123456";
		
		userRegisterPage = UserHomePage.clickToRegisterLink(driver);

		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(emailAddress);
		userRegisterPage.inputToPasswordTextbox(passWord);
		userRegisterPage.inputToConfirmPasswordTextbox(passWord);
		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
		userLoginPage = userRegisterPage.clickToLogoutLink(driver);
		driver.quit();
	}
  
	private WebDriver driver;
	// để chế độ public cho passWord emailAddress để sử dụng cho class test case khác
	public static String passWord, emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject UserHomePage;
	
	
}

