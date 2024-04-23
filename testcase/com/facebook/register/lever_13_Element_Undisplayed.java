package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.Facebook.PageGeneratorLoginFacebook;
import pageObjects.jQuery.dataTable.HomePageObjectdataTable;
import pageObjects.jQuery.uploadFile.HomePageObjectuploadFile;
import pageObjects.jQuery.uploadFile.PageGeneratoruploadFile;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;
import pageUIs.nopCommerce.user.RewardPoinPageUI;

public class lever_13_Element_Undisplayed extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;

	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
	driver = getBrowserDriver(browserName, appURL);
	loginPage = PageGeneratorLoginFacebook.getLoginPage(driver);

	}

	
	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextBoxDisplay());
	}
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_Dom() {
		loginPage.enterToEmailAdressTextBox("Lam12@gmail.com");
		loginPage.sleep(3);
		verifyTrue(loginPage.isConfirmEmailAdressTesxtboxDisplay());
		verifyFalse(loginPage.isConfirmEmailAdressTesxtboxDisplay());
		
		
		loginPage.enterToEmailAdressTextBox("");
		loginPage.sleep(3);
		verifyTrue(loginPage.isConfirmEmailAdressTesxtboxDisplay());
		verifyFalse(loginPage.isConfirmEmailAdressTesxtboxDisplay());
				
	}
	
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom() {
		loginPage.clickCloseIconAtregisterForm();
		loginPage.sleep(2);
		
		verifyTrue(loginPage.isConfirmEmailAddressTextBoxUndisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
