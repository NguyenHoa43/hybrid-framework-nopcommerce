package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BagePageFactory;

public class HomePageObject extends BagePageFactory {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;

	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplay(driver, myAccountLink);

	}

}
