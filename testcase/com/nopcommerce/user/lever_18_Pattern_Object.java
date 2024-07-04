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
import pageUIs.nopCommerce.user.RewardPoinPageUI;

public class lever_18_Pattern_Object extends BaseTest {
	private WebDriver driverTestClass;
	private String firstName, lastName, passWord, emailAddress, wrongPassword, wrongEmail;
	private String dateOfBirth, monthOfBirth, yearOfBirth, companyName, cityAddress;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject UserHomePage;
	private UserCustomerInforPageObject UserCustomerInforPage;
	private UserAddressPageObject UserAddressPage;
	private UserRewardPoinPageObject UserRewardPoinPage;
	private UserMyProductReviewPageObject UserMyProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);
		UserHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
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
	public void User_01_Register_Login() {

		userRegisterPage = UserHomePage.clickToRegisterLink(driverTestClass);
		
		userRegisterPage.clickToRadioButtonByLabel(driverTestClass,"Male");
		userRegisterPage.inputToTextboxByID(driverTestClass, "FirstName", firstName);
		userRegisterPage.inputToTextboxByID(driverTestClass, "LastName", lastName);
		userRegisterPage.selectToDropdownByName(driverTestClass, "DateOfBirthDay", dateOfBirth);
		userRegisterPage.selectToDropdownByName(driverTestClass, "DateOfBirthMonth", monthOfBirth);
		userRegisterPage.selectToDropdownByName(driverTestClass, "DateOfBirthYear", yearOfBirth);
		userRegisterPage.inputToTextboxByID(driverTestClass, "Email", emailAddress);
		userRegisterPage.clickTocheckboxByLabel(driverTestClass, "Newsletter:");
		userRegisterPage.inputToTextboxByID(driverTestClass, "Password", passWord);
		userRegisterPage.inputToTextboxByID(driverTestClass, "ConfirmPassword", passWord);
		

		userRegisterPage.clickToButtonByText(driverTestClass, "Register");
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

		userLoginPage = userRegisterPage.clickToLogoutLink(driverTestClass);
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userLoginPage.inputToEmailTextbox(emailAddress);
		userLoginPage.inputToPasswordTextbox(passWord);
		userLoginPage.clickToLoginButton();
		Assert.assertTrue(UserHomePage.isMyAccountLinkDisplay());

		UserCustomerInforPage = userLoginPage.clickToAccountLink(driverTestClass);
		verifyEquals(UserCustomerInforPage.getTextboxValueByID(driverTestClass, "FirstName"), firstName);
		verifyEquals(UserCustomerInforPage.getTextboxValueByID(driverTestClass, "LastName"), lastName);
		verifyEquals(UserCustomerInforPage.getTextboxValueByID(driverTestClass, "Email"), emailAddress);
		Assert.assertTrue(UserCustomerInforPage.isMycustomerInforDisplay());
	}

	@Test
	public void User_02_Dynamic_Page() {

		UserAddressPage = UserCustomerInforPage.openAddressLink(driverTestClass);
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

	@Test
	public void User_03_Dynamic_Page_01() {

		UserRewardPoinPage = (UserRewardPoinPageObject) UserMyProductReviewPage
				.openPagesAtMyAccountByName(driverTestClass, "Reward points");
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());

		UserAddressPage = (UserAddressPageObject) UserRewardPoinPage.openPagesAtMyAccountByName(driverTestClass,
				"Addresses");
		Assert.assertTrue(UserAddressPage.isDisplayAddressPage());

		UserRewardPoinPage = (UserRewardPoinPageObject) UserMyProductReviewPage
				.openPagesAtMyAccountByName(driverTestClass, "Reward points");
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());

		UserMyProductReviewPage = (UserMyProductReviewPageObject) UserRewardPoinPage
				.openPagesAtMyAccountByName(driverTestClass, "My product reviews");
		Assert.assertTrue(UserMyProductReviewPage.isDisplayProductReviewPage());

		UserCustomerInforPage = (UserCustomerInforPageObject) UserMyProductReviewPage
				.openPagesAtMyAccountByName(driverTestClass, "Customer info");
	}

	@Test
	public void User_04_Dynamic_Page_01() {

		UserCustomerInforPage.openPagesAtMyAccountByName(driverTestClass, "My product reviews");
		UserMyProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driverTestClass);
		UserMyProductReviewPage.openPagesAtMyAccountByName(driverTestClass, "Reward points");
		UserRewardPoinPage = PageGeneratorManager.getUserRewardPoinPage(driverTestClass);
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());
		UserRewardPoinPage.openPagesAtMyAccountByName(driverTestClass, "Addresses");
		UserAddressPage = PageGeneratorManager.getUserAddressPage(driverTestClass);
		Assert.assertTrue(UserAddressPage.isDisplayAddressPage());
		UserAddressPage.openPagesAtMyAccountByName(driverTestClass, "Reward points");
		UserRewardPoinPage = PageGeneratorManager.getUserRewardPoinPage(driverTestClass);
		Assert.assertTrue(UserRewardPoinPage.isDisplayRewardPoinPage());
		UserRewardPoinPage.openPagesAtMyAccountByName(driverTestClass, "My product reviews");
		UserMyProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driverTestClass);
		Assert.assertTrue(UserMyProductReviewPage.isDisplayProductReviewPage());
		UserMyProductReviewPage.openPagesAtMyAccountByName(driverTestClass, "Customer info");
		UserCustomerInforPage = PageGeneratorManager.getUserAccountPage(driverTestClass);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
		
	}
}
