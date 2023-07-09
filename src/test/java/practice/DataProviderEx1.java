package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@Test(dataProvider = "dataProviderExe")
	
	public void bookTicket(String src, String dest)
	{
		System.out.println("book ticket from "+src+" to "+dest);
	}
	
	
	@DataProvider
	public 	Object[][] dataProviderExe()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0]="bangalore";
		obj[0][1]="mysore";
		obj[1][0]="coimbatore";
		obj[1][1]="bangalore";
		return obj;
	}

}
