package pageUIs.jQuery;

public class HomePageUIs {
	public static final String PAGINATION_PAGE_BY_NUMBER = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABELNAME = "Xpath=//div[text()='%s']/parent::div[@class='qgrd-header-text-wrap']/following-sibling::input[@class='qgrd-header-filter']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "Xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String HEADER_TEXTBOX_ACTIVE_BY_LABELNAME = "XPATH=//tr//td[text()='%s']";
	public static final String COLUM_INDEX_BY_NAME = "Xpath=//tr//th[text()='%s']/preceding-sibling::th";
	public static final String TOTAL_PAGINATION =  "css=ul.qgrd-pagination-ul>li.qgrd-pagination-page";
	public static final String PAGINATION_PAGE_INDEX = "Xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE = "Xpath=//tbody/tr";
}
