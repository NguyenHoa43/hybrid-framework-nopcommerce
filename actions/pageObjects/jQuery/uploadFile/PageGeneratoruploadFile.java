package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

import pageObjects.jQuery.dataTable.HomePageObjectdataTable;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPoinPageObject;

public class PageGeneratoruploadFile {
	public static HomePageObjectuploadFile getHomePage(WebDriver driver) {
		return new HomePageObjectuploadFile(driver);
	}

}


