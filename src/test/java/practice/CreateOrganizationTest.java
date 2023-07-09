package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utility.BaseClass;
import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateOrganization;
import organizationpage.HomePage;
import organizationpage.LoginPage;
import organizationpage.OrgValidationPage;
//using at listeners in test script to get runtime screenshots
//@Listeners(generic_utility.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass{
	//to rerun the script we use retryAnalyser	
	
	//@Test(retryAnalyzer = generic_utility.RetryAnalyser.class)
	@Test
public void createOrganizationTest() throws Throwable {
			//WebDriverManager.chromedriver().setup();
			//WebDriver driver=new ChromeDriver();
			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	File_utility flib = new File_utility();
	
	Webdriver_utility wlib = new Webdriver_utility();
		/*String Browser = flib.getStringKeyAndValue("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		}

		Webdriver_utility wlib = new Webdriver_utility();
		wlib.waitForPageToLoad(driver);*/
			/*String URL = flib.getStringKeyAndValue("url");
			String Username = flib.getStringKeyAndValue("username");
			String Password = flib.getStringKeyAndValue("password");
			Webdriver_utility wlib = new Webdriver_utility();
			
			driver.get(URL);
			wlib.maximizeWindow(driver);
			
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(Username, Password);*/
			
			//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
			//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
			//driver.findElement(By.id("submitButton")).click();
			// driver.switchTo().alert().dismiss();
	        LoginPage lp=new LoginPage(driver);
			HomePage hp= new HomePage(driver);
			hp.orgLink();
			
			//driver.findElement(By.linkText("Organizations")).click();
			
			CreateOrganization co= new CreateOrganization(driver);
			co.coplus();
			
			//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			Java_utility jlib = new Java_utility();
			int data = jlib.getRanNum();
			Excel_utility elib = new Excel_utility();
			 String accName = elib.getExcelData("organization", 0, 0)+data;
			// co.organizationName(accName);
			 
			//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(accName);
			
			 String phone = elib.getDataFormatter("organization", 1, 0);
			//co.phoneNumber(phone);
			//driver.findElement(By.id("phone")).sendKeys(phone);
			
	       String email = elib.getDataFormatter("organization", 2, 0);	
	       
	     //  co.emailAdd(email);
	       // driver.findElement(By.id("email1")).sendKeys(email);
	       co.orgData(accName, phone, email);
	       
	     /*  SoftAssert sa=new SoftAssert();
	       sa.assertEquals(true, false);
	       sa.assertAll();*/
	       
	       Assert.assertEquals(false, true);
	       
	     co.saveButtonco();
	    
		// String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	    OrgValidationPage ovp=new OrgValidationPage(driver);
	   // String actData = ovp.getOrgNameVal().getText();
	   String actData = ovp.orgNamev();
	     Assert.assertEquals(actData, accName);
	    // Thread.sleep(4000);
        //wlib.signOut(null, driver);
		
	  String actph = ovp.orgPhonev();
	Assert.assertEquals(actph, phone);
	

	  String actemail = ovp.orgEmailv();
	Assert.assertEquals(actemail, email);
	
	
	}

	

	}


