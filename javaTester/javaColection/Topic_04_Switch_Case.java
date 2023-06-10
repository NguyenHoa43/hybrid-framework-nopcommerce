package javaColection;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_04_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Scanner scanner = new Scanner(System.in);
	
	@Parameters("browser")
	//@Test
	public void TC_01_Switch_Case(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default :
			new RuntimeException("Please input correct the browser name !");
			break;
			
		}
	}
	
	@Parameters("browser2")
	//@Test
	public void TC_02(String browserName) {
		driver = getBrowserDriver(browserName);
		System.out.println(browserName);
		driver.quit();
	}
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",projectPath + "\\browserDrivers\\chromedriver.exe");
			return new ChromeDriver();
			 
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			return new EdgeDriver();
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		default :
			return driver;
		
			
		}
	}
	
	@Parameters("month")
	@Test
	public void TC_03() {
		int Month = scanner.nextInt();
		switch (Month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày !!");
			break;
		case 2:
			System.out.println("tháng này có 28 ngày");
		
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày !");
			break;
		default:
			System.out.println("Nhập lại đúng định dạng !");
			break;
		}
	}
}
