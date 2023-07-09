package generic_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	int count=0;
	int retrylimits=2;
	public boolean retry(ITestResult result) {
		if(count<retrylimits)
		
		{
			count++;
			return true;
		}
		
		return false;
	}
	

}
