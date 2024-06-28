package reportConfig;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;

public class ExtentReportListenerV2 extends BaseTest implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.endTest();
		ExtentManager.getReporter().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentManager.getTest().log(LogStatus.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver webDriver = ((BaseTest) testClass).getDriverInstance();
		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
		ExtentManager.getTest().log(LogStatus.FAIL, "Test Failed", ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentManager.getTest().log(LogStatus.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

}
