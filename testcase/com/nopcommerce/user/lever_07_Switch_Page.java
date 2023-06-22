package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;
import pageUIs.RewardPoinPageUI;

public class lever_07_Switch_Page extends BaseTest {
	private WebDriver driverTestClass;
	private String  firstName, lastName, passWord, emailAddress, wrongPassword, wrongEmail;
	private String dateOfBirth, monthOfBirth, yearOfBirth, companyName, cityAddress;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserHomePageObject UserHomePage;
	private UserCustomerInforPageObject UserCustomerInfor;
	private UserAddressPageObject UserAddressPage;
	private UserRewardPoinPageObject UserRewardPoinPage;
	private UserMyProductReviewPageObject UserMyProductReviewPage;
	
	@Parameters("browser")
	@BeforeClass
	  public void beforeClass(String browserName) {
		  driverTestClass = getBrowserDriver(browserName);
		  UserHomePage = PageGeneratorManager.getHomePage(driverTestClass);
		  emailAddress = "afc" + fadeNumber() + "@gmail.com";
		  firstName = "Automation";
		  lastName = "FC";
		  passWord = "123456";
		  wrongPassword = "123";
		  wrongEmail = "123@456#%*"; 
		  dateOfBirth = "1";
		  monthOfBirth = "January";
		  yearOfBirth = "1999";
		  companyName = "Automation FC";
		  cityAddress = "Ho Chi Minh";
		  
		  
		  
		  
		  
	}
	@Test
	public void User_01_Register() {

		  registerPage =  UserHomePage.clickToRegisterLink(driverTestClass);

		  registerPage.inputToFirstnameTextbox(firstName);
		  registerPage.inputToLastNameTextbox(lastName);
		  registerPage.inputToEmailTextbox(emailAddress);
		  registerPage.inputToPasswordTextbox(passWord);
		  registerPage.inputToConfirmPasswordTextbox(passWord);
		  registerPage.clickToRegisterButton();
		  Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");		
	}	
	@Test
	public void User_02_Login() {
		  loginPage = registerPage.clickToLoginLink(driverTestClass);
		  loginPage.inputToEmailTextbox(emailAddress);
		  loginPage.inputToPasswordTextbox(passWord);
		  loginPage.clickToLoginButton();
		  Assert.assertTrue(UserHomePage.isMyAccountLinkDisplay());
	}	
	@Test
	public void User_3_My_Account() {
		UserCustomerInfor = loginPage.clickToAccountLink(driverTestClass);
		Assert.assertTrue(UserCustomerInfor.isMycustomerInforDisplay());
	}
	@Test
	public void User_04_Switch_Page() {
		
		UserCustomerInfor = loginPage.clickToAccountLink(driverTestClass);
		
		UserAddressPage = UserCustomerInfor.openAddressLink(driverTestClass);
		Assert.assertTrue(UserAddressPage.isDisplayAddressPage());
		
		UserMyProductReviewPage = UserAddressPage.openMyProductReviewPage(driverTestClass);
		Assert.assertTrue(UserMyProductReviewPage.isDisplayProductReviewPage());
		
		UserRewardPoinPage = UserMyProductReviewPage.openRewardPoin(driverTestClass);
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());
		
		UserAddressPage = UserRewardPoinPage.openAddressLink(driverTestClass);
		Assert.assertTrue(UserAddressPage.isDisplayAddressPage());
		
		UserRewardPoinPage = UserAddressPage.openRewardPoin(driverTestClass);
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());
		
		UserMyProductReviewPage = UserRewardPoinPage.openMyProductReviewPage(driverTestClass);
		Assert.assertTrue(UserMyProductReviewPage.isDisplayProductReviewPage());
	}	
	//@Test
	public void User_05_Switch_Role() {
		
	}
	

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
