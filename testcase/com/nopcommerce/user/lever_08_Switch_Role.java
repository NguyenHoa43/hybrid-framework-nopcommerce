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
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class lever_08_Switch_Role extends BaseTest {
	private WebDriver driverTestClass;
	private String firstName, lastName, userPassWord, userEmailAddress, adminEmailAddress, adminPassWord;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserHomePageObject userHomePage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driverTestClass = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		userEmailAddress = "afc" + fadeNumber() + "@gmail.com";
		firstName = "Automation";
		lastName = "FC";
		userPassWord = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassWord = "admin";

		userRegisterPage = userHomePage.clickToRegisterLink(driverTestClass);

		userRegisterPage.inputToFirstnameTextbox(firstName);
		userRegisterPage.inputToLastNameTextbox(lastName);
		userRegisterPage.inputToEmailTextbox(userEmailAddress);
		userRegisterPage.inputToPasswordTextbox(userPassWord);
		userRegisterPage.inputToConfirmPasswordTextbox(userPassWord);
		userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userRegisterPage.clickToLoginLink(driverTestClass);
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassWord);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
		userCustomerInforPage = userHomePage.clickToAccountLink();
		userHomePage = userCustomerInforPage.clickToLogoutLinkUserPage(driverTestClass);

		userHomePage.openPageUrl(driverTestClass, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driverTestClass);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminPassWord, adminEmailAddress);
		Assert.assertTrue(adminDashboardPage.isDisplayDashboardHeader());
		Assert.assertEquals(adminDashboardPage.getTextDashBoardHeader(), "Dashboard");

		adminLoginPage = adminDashboardPage.clickToLogoutLinkAdminPage(driverTestClass);
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUrl(driverTestClass, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driverTestClass);
		userHomePage.clickToLoginLink();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassWord);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
	}

	@AfterClass
	public void afterClass() {
		driverTestClass.quit();
	}
}
