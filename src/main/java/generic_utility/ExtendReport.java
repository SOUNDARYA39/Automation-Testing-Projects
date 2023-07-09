package generic_utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport implements ITestListener {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		//step 3: create test methods during the test execution 
		report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		//step 4: log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) 
	{
		//test.log(Status.FAIL, result.getMethod().getMethodName());
		String testData = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.Sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(src, new File("./Screenshot/"+testData+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		//step 1:extend report configuration
		Date date = new Date();
		System.out.println(date);
		date.toString().replace(":", "-").replace("/", "*");
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(new File("ExtentReports.html"));
		htmlReport.config().setDocumentTitle("Vtiger ExtentReport");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Automation Testing");
		
		//Step2: attach physical report and do the system congiguration
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("os", "windows 10");
		report.setSystemInfo("Enviornment", "Automation Testing");
		report.setSystemInfo("url", "http://localhost:8888/index.php?action=index&module=Home");
		report.setSystemInfo("Reporter Name", "Soundarya");
		
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
	}

	
	
	
}
