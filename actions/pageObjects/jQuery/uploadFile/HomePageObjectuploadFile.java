package pageObjects.jQuery.uploadFile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.jQuery.dataTable.HomePageUIs;

public class HomePageObjectuploadFile extends BasePage {
	WebDriver driver;

	public HomePageObjectuploadFile(WebDriver driver) {
		this.driver = driver;
	}
	@Step("verify display File")
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_LOADING, fileName);
		return isElementDisplay(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_LOADING, fileName);
	}
	@Step("verify Verify upload")
	public boolean isFileLinkUpLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplay(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_UPLOADED_LINK, fileName);
	}
	@Step("verify file display")
	public boolean isFileImageUpLoadedByName(String fileName) {
		waitForElementVisible(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, pageUIs.jQuery.uploadFile.HomePageUIs.FILE_NAME_UPLOADED_IMAGE, fileName);
	}
	
	@Step("click to button upload file")
	public void clickToStartButton() {
		List<WebElement> startButtons = getListWebElement(driver, pageUIs.jQuery.uploadFile.HomePageUIs.STAR_BUTTON);
		
		for(WebElement startButton : startButtons ) {
			waitForElementClickable(driver, startButton);
			clickToElement(driver, startButton);
		}
	}


	
	
}
