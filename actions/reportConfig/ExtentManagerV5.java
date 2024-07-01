package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commons.GlobalConstants;

public class ExtentManagerV5 {
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.PROJECT_PATH + "/extentV5/ExtentReport.html");
		reporter.config().setReportName("Jquery HTML Report");
		reporter.config().setDocumentTitle("Jquery HTML Report");
		reporter.config().setTimelineEnabled(true);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.DARK);

		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Company", "Automation FC");
		extentReports.setSystemInfo("Project", "Jquery");
		extentReports.setSystemInfo("Team", "Basus VN");
		extentReports.setSystemInfo("OS version", GlobalConstants.OS_NAME);
		extentReports.setSystemInfo("JAVA version", GlobalConstants.JAVA_VERSION);
		return extentReports;
	}
}