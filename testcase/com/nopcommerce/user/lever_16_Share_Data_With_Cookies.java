package com.nopcommerce.user;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;
import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class lever_16_Share_Data_With_Cookies extends BaseTest {
	private WebDriver driver;
	private String passWord, emailAddress;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject UserHomePage;
	private UserLoginPageObject userLoginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		UserHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		emailAddress = Common_01_Register.emailAddress;
		passWord = Common_01_Register.passWord;
		
		userLoginPage = UserHomePage.clickToLoginLink(driver);
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCookies);
		userLoginPage.refreshToPage(driver);
	}

	@Test
	public void Login_01_Successfull() {
		
		verifyTrue(UserHomePage.isMyAccountLinkDisplay());
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
