package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenerator;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;
import pageUIs.nopCommerce.user.RewardPoinPageUI;

public class lever_10_DataTable_DataGrid extends BaseTest {
	
	WebDriver driver;
	HomePageObject homePage;
	PageGenerator page;
	@Parameters({"browser", "url"})
	@BeforeClass
	  public void beforeClass(String browserName, String appURL) {
		  driver = getBrowserDriver(browserName, appURL);	  
		  homePage = PageGenerator.getHomePage(driver);
		  
	}
	
	@Test
	public void Table_01_Enter_To_Textbox_At_Any_Row() {
		homePage.getValueEachRowAtAllPage();
	}
	
	@Test
	public void Table_02_Paging() { 
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
		homePage.openPagingByPageNumber("23");
		Assert.assertTrue(homePage.isPageNumberActived("23"));
		homePage.openPagingByPageNumber("15");
		Assert.assertTrue(homePage.isPageNumberActived("15"));
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		
	}
	@Test
	public void Table_03_Enter_To_Header() {
		homePage.enterToHeaderTextboxByLabel("Country", "Afghanistan");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("Afghanistan"));
		homePage.enterToHeaderTextboxByLabel("Females", "384187");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("384187"));
		homePage.enterToHeaderTextboxByLabel("Males", "407124");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("407124"));
		homePage.enterToHeaderTextboxByLabel("Total", "791312");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("791312"));
		
		
		homePage.enterToHeaderTextboxByLabel("Country", "Angola");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("Angola"));
		homePage.enterToHeaderTextboxByLabel("Females", "276880");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("276880"));
		homePage.enterToHeaderTextboxByLabel("Males", "276472");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("276472"));
		homePage.enterToHeaderTextboxByLabel("Total", "553353");
		homePage.sleep(3);
		Assert.assertTrue(homePage.isPagetextActive("553353"));
	}	
		
	@Test
	public void Table_04() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
