package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;




public class BaseTest {

	private WebDriver driverBaseTest;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equals("firefox")) {
			
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("headlessfirefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("coccoc")) {
			
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary(".....");
			}
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("chrome")) {
			
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("headlesschrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		
		} else if (browserName.equals("edge")) {
			
			driverBaseTest = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid !");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT));
		driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
		return driverBaseTest;
	}

	protected WebDriver getBrowserDriver(String browserName, String appURL) {
		if (browserName.equals("firefox")) {
			
			driverBaseTest = new FirefoxDriver();
		} else if (browserName.equals("headlessfirefox")) {
			
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		} else if (browserName.equals("coccoc")) {
			
			ChromeOptions options = new ChromeOptions();
			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			} else {
				options.setBinary(".....");
			}
			driverBaseTest = new ChromeDriver(options);
		} else if (browserName.equals("chrome")) {
			
			driverBaseTest = new ChromeDriver();
		} else if (browserName.equals("headlesschrome")) {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		
		} else if (browserName.equals("edge")) {
			
			driverBaseTest = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid !");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT));
		driverBaseTest.get(appURL);
		return driverBaseTest;
	}

	protected int fadeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
