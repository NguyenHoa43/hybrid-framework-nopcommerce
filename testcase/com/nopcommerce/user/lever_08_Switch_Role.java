package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;
import pageUIs.RewardPoinPageUI;

public class lever_08_Switch_Role extends BaseTest {
	private WebDriver driverTestClass;
	private String  firstName, lastName, passWord, emailAddress;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	private UserCustomerInforPageObject UserCustomerInfor;
	private UserAddressPageObject UserAddressPage;
	private UserRewardPoinPageObject UserRewardPoinPage;
	private UserMyProductReviewPageObject UserMyProductReviewPage;
	
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  userHomePage = PageGeneratorManager.getHomePage(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  
		  userRegisterPage =  userHomePage.clickToRegisterLink(driverTestClass);

		  userRegisterPage.inputToFirstnameTextbox(firstName);
		  userRegisterPage.inputToLastNameTextbox(lastName);
		  userRegisterPage.inputToEmailTextbox(emailAddress);
		  userRegisterPage.inputToPasswordTextbox(passWord);
		  userRegisterPage.inputToConfirmPasswordTextbox(passWord);
		  userRegisterPage.clickToRegisterButton();
		  Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(),"Your registration completed");	
		  
		  
	}
	@Test
	public void Role_01_User() {
		  userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		  userHomePage= userLoginPage.loginAsUser(emailAddress, passWord);
		  Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		 	
	}	
	@Test
	public void Role_02_Admin() {
		 userHomePage.openPageUrl(driverTestClass, GlobalConstants.ADMIN_PAGE_URL);
		 
	}	
	
	//@Test
	public void User_05_Switch_Role() {
		
	}
	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
