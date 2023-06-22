package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RewardPoinPageUI;

public class UserRewardPoinPageObject extends BasePage{
	private WebDriver driver;

	public UserRewardPoinPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isDisplayRewardPoinPage() {
		waitForElementVisible(driver, RewardPoinPageUI.MESSAGE_REWARD_POIN_PAGE);
		return isElementDisplay(driver, RewardPoinPageUI.MESSAGE_REWARD_POIN_PAGE);
	}
	
}
