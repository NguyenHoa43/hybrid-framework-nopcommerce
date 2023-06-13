package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driverBaseTest;;
	protected WebDriver getBrowserDriver(String browserName ) {
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driverBaseTest = new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driverBaseTest = new ChromeDriver();
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driverBaseTest = new EdgeDriver();
		}else {
			throw new RuntimeException("Browser name invalid !");
		}
		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driverBaseTest.get("https://demo.nopcommerce.com/");
		return driverBaseTest;
	}
	
}
