package pageUIs;

public class CustomerInforPageUI {
	public static final String ACCOUNT_LINK = "//a[@class='ico-account']";
	public static final String GENDER_RADIO = "//input[@id='gender-male']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DATE_OF_BIRTH = "//label[text()='Date of birth:']/parent::div//following-sibling::div/child::select[@name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTH = "//label[text()='Date of birth:']/parent::div//following-sibling::div/child::select[@name='DateOfBirthMonth']";
	public static final String YEAR_OF_BIRTH = "//label[text()='Date of birth:']/parent::div//following-sibling::div/child::select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String MESAGE_ERROR_EMAIL = "//span[@id='Email-error']";
	public static final String COMPANY_NAME_TEXTBOX = "//input[@id='Company']";
	public static final String MESSAGE_UPDATE_INFO_SUCCESS = "//p[@class='content']";
	public static final String BUTTON_SAVE = "//button[@id='save-info-button']";
	public static final String ADDRESS_LINK = "//li[@class='customer-addresses inactive']/a[text()='Addresses']";
	public static final String ADD_NEW_LINK = "//button[@class='button-1 add-address-button']";
	public static final String FIRSTNAME_ADDRESS_TEXTBOX = "//input[@id='Address_FirstName']";
	public static final String LASTNAME_ADDRESS_TEXTBOX = "//input[@id='Address_LastName']";
	public static final String EMAIL_ADDRESS_TEXTBOX = "//input[@id='Address_Email']";
	public static final String COMPANY_NAME_ADDRESS_TEXTBOX = "//input[@id='Address_Company']";
	public static final String COUNTRY_ID_ADDRESS_SELECT = "//select[@id='Address_CountryId']";
	public static final String STATEPROVINCE_ID_ADDRESS_SELECT = "//select[@id='Address_StateProvinceId']";
	public static final String CITY_ADDRESS_TEXTBOX = "//input[@id='Address_City']";
	public static final String ADDRESS_1_TEXTBOX = "//input[@id='Address_Address1']";
	public static final String ADDRESS_2_TEXTBOX = "//input[@id='Address_Address2']";
	public static final String ZIPCODE_ADDRESS_TEXTBOX = "//input[@id='Address_ZipPostalCode']";
	public static final String PHONENUMBER_ADDRESS_TEXTBOX = "//input[@id='Address_PhoneNumber']";
	public static final String FAXNUMBER_ADDRESS_TEXTBOX = "//input[@id='Address_FaxNumber']";
	public static final String MESSAGE_SUCCESS_ADDRESS = "//p[@class='content']";
	public static final String MESSAGE_SUCCESS_ADDRESS_BUTTOM = "//span[@class='close']";
	public static final String SAVE_ADDRESS_LINK = "//button[@class='button-1 save-address-button']";
	public static final String TEXT_ACCOUNT_PAGE = "//h1[text()='My account - Customer info']";


}
