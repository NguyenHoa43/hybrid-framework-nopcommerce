package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDisplayDashboardHeader() {
		waitForElementVisible(driver, AdminDashboardPageUI.TEXT_CONFIRM_DASHBOAR_PAGE);
		return isElementDisplay(driver, AdminDashboardPageUI.TEXT_CONFIRM_DASHBOAR_PAGE);
	}

	public String getTextDashBoardHeader() {
		waitForElementVisible(driver, AdminDashboardPageUI.TEXT_CONFIRM);
		return getElementText(driver, AdminDashboardPageUI.TEXT_CONFIRM);
	}
}
