package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateOrgTyIn;
import organizationpage.HomePage;
import organizationpage.LoginPage;

public class GenericOrganizationwithTypeAndIndustry {

	public static void main(String[] args) throws Throwable {
	//WebDriverManager.chromedriver().setup();
	//WebDriver driver=new ChromeDriver();
		Java_utility jlib=new Java_utility();
		int data=jlib.getRanNum();
	
	File_utility flib = new File_utility();
	WebDriver driver=null;
	String brow = flib.getStringKeyAndValue("browser");
	
	
   if(brow.equalsIgnoreCase("chrome"))
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
   }
   else if(brow.equalsIgnoreCase("firefox"))
   {
	   WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
   }
   else
   {
	   WebDriverManager.edgedriver().setup();
	   driver=new EdgeDriver();
   }
   Webdriver_utility wlib=new Webdriver_utility();
   wlib.waitForPageToLoad(driver);
   
   String URL = flib.getStringKeyAndValue("url");
   String Username = flib.getStringKeyAndValue("username");
   String Password = flib.getStringKeyAndValue("password");
   
  
   driver.get(URL);
   LoginPage lp=new LoginPage(driver);
   lp.loginToApp(Username, Password);
   
   HomePage hp=new HomePage(driver);
   hp.orgLink();
   
   CreateOrgTyIn oti=new CreateOrgTyIn(driver);
   oti.orgClick();
   
   Excel_utility elib=new Excel_utility();
   String orgname = elib.getExcelData3("orgindutype", 1, 0)+data;
   
   oti.orgaName(orgname);
   
  String industry = elib.getExcelData3("orgindutype", 1, 1);
  
  // WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
   

   
  // wlib.handleDropDown1(ele, industry);
   oti.orgindustry(industry);
  String type = elib.getExcelData3("orgindutype", 1, 2);
  oti.orgType(type);
  oti.saveButton();
  
  
  Thread.sleep(2000);
  wlib.signOut(null, driver);
   
	}

}
