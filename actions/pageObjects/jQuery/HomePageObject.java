package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextboxByLabel(String headerLabel, String value) {
		waitAllElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABELNAME, headerLabel);
		sendkeysToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABELNAME, value, headerLabel);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABELNAME, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplay(driver, HomePageUIs.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public boolean isPagetextActive(String textBox) {
		waitForElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_ACTIVE_BY_LABELNAME, textBox);
		
		return isElementDisplay(driver, HomePageUIs.HEADER_TEXTBOX_ACTIVE_BY_LABELNAME, textBox);
		
	}

	public List<String> getValueEachRowAtAllPage(){
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGINATION);
		
		List<String> allRowValueAllPage = new ArrayList<String>();
		
		// duyet qua tat ca cac page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_INDEX, String.valueOf(index));
			sleep(1);
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUIs.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
			
		}
		for (String value : allRowValueAllPage) {
		System.out.println("------------------------");
		System.out.println(value);
		}
		return allRowValueAllPage;
		
	}
	public void enterToTextboxByColumNameAtRowNumber(String string, String string2, String string3) {
		
		
	}
	
	
}
