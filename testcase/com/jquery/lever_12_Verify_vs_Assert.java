package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

public class lever_12_Verify_vs_Assert extends BaseTest {
	private WebDriver driver;
	private HomePageObjectuploadFile homepage;
	String oneFile = "1.jpg";
	String twoFile = "2.jpg";
	String threeFile = "3.jpg";
	String fourFile = "4.jpg";
	String fiveFile = "5.jpg";
	String sixFile = "6.jpg";
	String[] allFile = {oneFile, twoFile, threeFile, fourFile, fiveFile, sixFile};
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
	driver = getBrowserDriver(browserName, appURL);
	homepage = PageGeneratoruploadFile.getHomePage(driver);

	}

	
	@Test
	public void Upload_01_One_file_per_Time() {
		// step 1 - Load single file
		homepage.uploadMultipleFile(driver, oneFile);
		homepage.sleep(3);
		// step 2 - Verify
		verifyTrue(homepage.isFileLoadedByName(oneFile));
		// step 3 - Click To star button
		homepage.clickToStartButton();
		// step 4 - Verify upload
		verifyTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		// step 5 - Verify image display
		verifyTrue(homepage.isFileImageUpLoadedByName(oneFile));
		
	}
	@Test
	public void Upload_02_Multiple_File_per_Time() {
		homepage.refreshToPage(driver);
		// step 1 - Load single file
		homepage.uploadMultipleFile(driver, allFile);
		homepage.sleep(3);
		// step 2 - Verify
		verifyTrue(homepage.isFileLoadedByName(oneFile));
		verifyTrue(homepage.isFileLoadedByName(twoFile));
		verifyTrue(homepage.isFileLoadedByName(threeFile));
		verifyTrue(homepage.isFileLoadedByName(fourFile));
		verifyTrue(homepage.isFileLoadedByName(fiveFile));
		verifyTrue(homepage.isFileLoadedByName(sixFile));
		// step 3 - Click To star button
		homepage.clickToStartButton();
		// step 4 - Verify upload
		verifyTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		verifyTrue(homepage.isFileLinkUpLoadedByName(twoFile));
		verifyTrue(homepage.isFileLinkUpLoadedByName(threeFile));
		verifyTrue(homepage.isFileLinkUpLoadedByName(fourFile));
		verifyTrue(homepage.isFileLinkUpLoadedByName(fiveFile));
		verifyTrue(homepage.isFileLinkUpLoadedByName(sixFile));
		
		// step 5 - Verify image display
		verifyTrue(homepage.isFileImageUpLoadedByName(oneFile));
		verifyTrue(homepage.isFileImageUpLoadedByName(twoFile));
		verifyTrue(homepage.isFileImageUpLoadedByName(threeFile));
		verifyTrue(homepage.isFileImageUpLoadedByName(fourFile));
		verifyTrue(homepage.isFileImageUpLoadedByName(fiveFile));
		verifyTrue(homepage.isFileImageUpLoadedByName(sixFile));
				
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
