package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends BasePage{
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDisplayProductReviewPage() {
		waitForElementVisible(driver, MyProductReviewPageUI.MESSAGE_PRODUCT_REVIEW_PAGE_TEXT);
		return isElementDisplay(driver, MyProductReviewPageUI.MESSAGE_PRODUCT_REVIEW_PAGE_TEXT);
	}
}
