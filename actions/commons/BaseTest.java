package commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseTest {

	private WebDriver driverBaseTest;
	protected final Log log;
	
	@BeforeSuite
	public void initBeforeSuite() {
		deleteAllureReport();
	}
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

//	protected WebDriver getBrowserDriver(String browserName) {
//		if (browserName.equals("firefox")) {
//			
//			driverBaseTest = new FirefoxDriver();
//		} else if (browserName.equals("headlessfirefox")) {
//			
//		FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1920x1080");
//			driverBaseTest = new FirefoxDriver(options);
//		} else if (browserName.equals("coccoc")) {
//			
//			ChromeOptions options = new ChromeOptions();
//			if (GlobalConstants.OS_NAME.startsWith("Windows")) {
//				options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");
//			} else {
//				options.setBinary(".....");
//		}
//		driverBaseTest = new ChromeDriver(options);
//	} else if (browserName.equals("chrome")) {
//			
//			driverBaseTest = new ChromeDriver();
//		} else if (browserName.equals("headlesschrome")) {
//			
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1920x1080");
//			driverBaseTest = new ChromeDriver(options);
//		
//		} else if (browserName.equals("edge")) {
//			
//			driverBaseTest = new EdgeDriver();
//		} else {
//			throw new RuntimeException("Browser name invalid !");
//		}
//		driverBaseTest.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIME_OUT));
//		driverBaseTest.get(GlobalConstants.USER_PAGE_URL);
//		return driverBaseTest;
//	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			
			File chromeFile = new File(GlobalConstants.BROWSER_EXTENSION + "GPPONGMHJKPFNBHAGPMJFKANNFBLLAMG_6_10_74_0 (1).crx");
			ChromeOptions chromeOption = new ChromeOptions();
			chromeOption.addExtensions(chromeFile);
			driverBaseTest = new ChromeDriver(chromeOption);
			break;
		case FIREFOX:
			driverBaseTest = new FirefoxDriver();
			Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSION + "wappalyzer.xpi");
			FirefoxDriver ffDriver = (FirefoxDriver) driverBaseTest;
			ffDriver.installExtension(xpiPath);
			driverBaseTest = ffDriver;
			
			break;
		case EDGE:
			
			File edgeFile = new File(GlobalConstants.BROWSER_EXTENSION + "GPPONGMHJKPFNBHAGPMJFKANNFBLLAMG_6_10_74_0 (1).crx");
			EdgeOptions egdeOption = new EdgeOptions();
			egdeOption.addExtensions(edgeFile);
			driverBaseTest = new EdgeDriver(egdeOption);
			break;
		case CHROME_HEADLESS:
			ChromeOptions chOption = new ChromeOptions();
			chOption.addArguments("--headless");
			chOption.addArguments("window-size=1920x1080");
			driverBaseTest = new ChromeDriver(chOption);
			break;
		case EDGE_HEADLESS:
			EdgeOptions egOption = new EdgeOptions();
			egOption.addArguments("--headless");
			egOption.addArguments("window-size=1920x1080");
			driverBaseTest = new EdgeDriver(egOption);
			break;
		case FIREFOX_HEADLESS:
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.addArguments("--headless");
			ffOptions.addArguments("window-size=1920x1080");
			driverBaseTest = new FirefoxDriver(ffOptions);
			break;
		default:
			throw new RuntimeException("Browser name is not valid");
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
	
	public WebDriver getDriverInstance() {
		return this.driverBaseTest;
	}
	
	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("---------------------- Passed -----------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("---------------------- Failed -----------------------");
		}
		return status;
	}
	public void deleteAllureReport() {
		try {
			String pathFolderDownload = GlobalConstants.PROJECT_PATH +  "/allure-json";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			if (listOfFiles.length != 0) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
						new File(listOfFiles[i].toString()).delete();
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
    }
	
	protected void closeBrowserDriver() {
		String cmd = null;
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driverBaseTest.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			String browserDriverName = null;

			if (driverInstanceName.contains("chrome")) {
				browserDriverName = "chromedriver";
			} else if (driverInstanceName.contains("internetexplorer")) {
				browserDriverName = "IEDriverServer";
			} else if (driverInstanceName.contains("firefox")) {
				browserDriverName = "geckodriver";
			} else if (driverInstanceName.contains("edge")) {
				browserDriverName = "msedgedriver";
			} else if (driverInstanceName.contains("opera")) {
				browserDriverName = "operadriver";
			} else {
				browserDriverName = "safaridriver";
			}

			if (osName.contains("window")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
			} else {
				cmd = "pkill " + browserDriverName;
			}

			if (driverBaseTest != null) {
				driverBaseTest.manage().deleteAllCookies();
				driverBaseTest.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
