package generic_utility;

import java.io.File;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MultipleListenerImplementation implements ITestListener{

	

	public void onTestFailure(ITestResult result) {
		
		String testData = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.Sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		LocalTime localtime = LocalTime.now();
		localtime.toString().replace("", "-").replace(":", "/");
		try {
			
			FileUtils.copyFile(src, new File("./Screenshot/"+testData+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String testName = result.getMethod().getMethodName();
		
		TakesScreenshot screen = (TakesScreenshot)BaseClass.Sdriver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		LocalTime localtime = LocalTime.now();
		localtime.toString().replace("", "-").replace(":", "/");
		File dest = new File("./Screenshot"+testName+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("taking screenshot of failed"+e.getMessage());
		}*/
		
	}

}
