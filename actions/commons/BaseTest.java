package commons;

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
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private WebDriver driverBaseTest;
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName ) {
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		}else if(browserName.equals("headlessfirefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		}else if(browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("122.0.6261.69").setup();
			ChromeOptions options = new ChromeOptions();
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				options.setBinary(".....");
			}
			driverBaseTest = new ChromeDriver(options);
		}else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		}else if(browserName.equals("headlesschrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = WebDriverManager.operadriver().create();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid !");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
		return driverBaseTest;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appURL) {
		if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driverBaseTest = new FirefoxDriver();
		}else if(browserName.equals("headlessfirefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(options);
		}else if(browserName.equals("coccoc")) {
			WebDriverManager.chromedriver().driverVersion("112.0.5615.28").setup();
			ChromeOptions options = new ChromeOptions();
			if(GlobalConstants.OS_NAME.startsWith("Windows")) {
				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
			}else {
				options.setBinary(".....");
			}
			driverBaseTest = new ChromeDriver(options);
		}else if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverBaseTest = new ChromeDriver();
		}else if(browserName.equals("headlesschrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(options);
		}else if(browserName.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driverBaseTest = WebDriverManager.operadriver().create();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driverBaseTest = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid !");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIME_OUT, TimeUnit.SECONDS);
		driverBaseTest.get(appURL);
		return driverBaseTest;
	}
	
	
	protected int fadeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}
