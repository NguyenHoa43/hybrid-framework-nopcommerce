package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK = "xpath=//li[@class='customer-addresses inactive']/a[text()='Addresses']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//a[text()='My product reviews']";
	public static final String CUSTOMER_INFOR_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String REWARD_POIN_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "Xpath=//button[text()='%s']";
	public static final String DYNAMIC_SELECT_DROPDOWN_BY_NAME = "Xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "Xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "Xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String ACCOUNT_LINK = "xpath=//a[@class='ico-account']";

	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String LOGOUT_USER_LINK = "xpath=//a[@class='ico-logout']";
	public static final String LOGOUT_ADMIN_LINK = "xpath=//a[text()='Logout']";
	public static final String ICON_OVER_ELEMENT = "xpath=//div[@id='ajaxBusy']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "Xpath=//input[@id='%s']";
}
