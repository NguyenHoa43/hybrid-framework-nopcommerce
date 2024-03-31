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

public class lever_11_Upload_Files extends BaseTest {
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
		Assert.assertTrue(homepage.isFileLoadedByName(oneFile));
		// step 3 - Click To star button
		homepage.clickToStartButton();
		// step 4 - Verify upload
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		// step 5 - Verify image display
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(oneFile));
		
	}
	@Test
	public void Upload_02_Multiple_File_per_Time() {
		homepage.refreshToPage(driver);
		// step 1 - Load single file
		homepage.uploadMultipleFile(driver, allFile);
		homepage.sleep(3);
		// step 2 - Verify
		Assert.assertTrue(homepage.isFileLoadedByName(oneFile));
		Assert.assertTrue(homepage.isFileLoadedByName(twoFile));
		Assert.assertTrue(homepage.isFileLoadedByName(threeFile));
		Assert.assertTrue(homepage.isFileLoadedByName(fourFile));
		Assert.assertTrue(homepage.isFileLoadedByName(fiveFile));
		Assert.assertTrue(homepage.isFileLoadedByName(sixFile));
		// step 3 - Click To star button
		homepage.clickToStartButton();
		// step 4 - Verify upload
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(oneFile));
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(twoFile));
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(threeFile));
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(fourFile));
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(fiveFile));
		Assert.assertTrue(homepage.isFileLinkUpLoadedByName(sixFile));
		
		// step 5 - Verify image display
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(oneFile));
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(twoFile));
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(threeFile));
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(fourFile));
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(fiveFile));
		Assert.assertTrue(homepage.isFileImageUpLoadedByName(sixFile));
				
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
