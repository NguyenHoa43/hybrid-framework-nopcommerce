package com.jquery;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
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
import reportConfig.ExtentTestManagerV5;

//import reportConfig.ExtentTestManagerV5;

public class lever_16_ExtendV5_Screenshot5 extends BaseTest {
	private WebDriver driver;
	private HomePageObjectuploadFile homepage;
	String oneFile = "1.jpg";
	String twoFile = "2.jpg";
	String threeFile = "3.jpg";
	String fourFile = "4.jpg";
	String fiveFile = "5.jpg";
	String sixFile = "6.jpg";
	String seventfile = "7.jpg";
	String[] allFile = {oneFile, twoFile, threeFile, fourFile, fiveFile, sixFile};
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
	driver = getBrowserDriver(browserName, appURL);
	homepage = PageGeneratoruploadFile.getHomePage(driver);

	}

	
	@Test
	public void Upload_01_One_file_per_Time(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Upload_01_One_file_per_Time");
		// step 1 - Load single file
		homepage.uploadMultipleFile(driver, oneFile);
		
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 03: upLoad Two file");
		homepage.uploadMultipleFile(driver, twoFile);
		homepage.sleep(3);
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 02: Verify");
		// step 2 - Verify
		verifyTrue(homepage.isFileLoadedByName(oneFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 04: Verify two file display");
		// step 2 - Verify
		verifyTrue(homepage.isFileLoadedByName(twoFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 05: Click To star button");
		// step 3 - Click To star button
		homepage.clickToStartButton();
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 06: Verify upload");
		// step 4 - Verify upload
		verifyTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 07: Verify image displayd");
		// step 5 - Verify image display
		verifyTrue(homepage.isFileImageUpLoadedByName(twoFile));
		
	}
	@Test
	public void Upload_02_Multiple_File_per_Time(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "Upload_02_Multiple_File_per_Time");
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 01: Refresh page");
		homepage.refreshToPage(driver);
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 02: Load single file");
		// step 1 - Load single file
		homepage.uploadMultipleFile(driver, allFile);
		homepage.sleep(3);
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 03: Verify File One");
		// step 2 - Verify
		verifyTrue(homepage.isFileLoadedByName(twoFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 04: Verify File Two");
		verifyTrue(homepage.isFileLoadedByName(threeFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 05: Verify File Three");
		verifyTrue(homepage.isFileLoadedByName(threeFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 06: Verify File Four");
		verifyTrue(homepage.isFileLoadedByName(fourFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 07: Verify File Five");
		verifyTrue(homepage.isFileLoadedByName(fiveFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 08: Verify File Six");
		verifyTrue(homepage.isFileLoadedByName(fiveFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 09: Click To star button");
		// step 3 - Click To star button
		homepage.clickToStartButton();
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 10: Verify upload File One");
		// step 4 - Verify upload
		verifyTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 11: Verify upload File Two");
		verifyTrue(homepage.isFileLinkUpLoadedByName(twoFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 12: Verify upload File Three");
		verifyTrue(homepage.isFileLinkUpLoadedByName(threeFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 13: Verify upload File Four");
		verifyTrue(homepage.isFileLinkUpLoadedByName(fourFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 14: Verify upload File Five");
		verifyTrue(homepage.isFileLinkUpLoadedByName(seventfile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 15: Verify upload File Six");
		verifyTrue(homepage.isFileLinkUpLoadedByName(sixFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 16: Verify image display File One");
		// step 5 - Verify image display
		verifyTrue(homepage.isFileImageUpLoadedByName(oneFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 17: Verify image display File Two");
		verifyTrue(homepage.isFileImageUpLoadedByName(twoFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 18: Verify image display File Three");
		verifyTrue(homepage.isFileImageUpLoadedByName(twoFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 19: Verify image display File Four");
		verifyTrue(homepage.isFileImageUpLoadedByName(fourFile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 20: Verify image display File Five");
		verifyTrue(homepage.isFileImageUpLoadedByName(seventfile));
		ExtentTestManagerV5.getTest().log(Status.INFO,"Upload - Step 21: Verify image display File Six");
		verifyTrue(homepage.isFileImageUpLoadedByName(seventfile));
				
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}