package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	public static final String OS_NAME = System.getProperty("os.name");
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final String UPLOAD_FLIE = PROJECT_PATH + File.separator + "uploadFile" + File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFile";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;
	public static final String REPORTNG_SCREENSHOT_EXTENTV2 = PROJECT_PATH + File.separator + "extentV2" + File.separator;
	public static final String BROWSER_EXTENSION = PROJECT_PATH + File.separator + "browserExtensions" + File.separator;
	public static final String REPORTNG_SCREENSHOT_EXTENTV5 = PROJECT_PATH + File.separator + "extentV5" + File.separator;

	public static final String DB_DEV_URL = "192.168.1.15:9860";
	public static final String DB_DEV_USER = "automationFC";
	public static final String DB_DEV_PASS = "123456";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIME_OUT = 50;
	public static final long RETRY_TEST_FAIL = 3;

}
