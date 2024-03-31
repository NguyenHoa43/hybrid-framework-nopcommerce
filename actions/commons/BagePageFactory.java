package commons;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BagePageFactory {
	protected static BagePageFactory getBagePageFactory1Object() {
		return new BagePageFactory();
	}

	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementInVisible(WebDriver driver, WebElement elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		explicitWait.until(ExpectedConditions.invisibilityOf(elements));
	}

	protected void waitAllElementInVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected boolean isElementDisplay(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void sendkeysToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	private long longTimeout = 30;
}
