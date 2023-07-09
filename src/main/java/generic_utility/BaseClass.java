package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.HomePage;
import organizationpage.LoginPage;

public class BaseClass {
	//globally called
	public WebDriver driver;
	//used to take only screenshots when listener class is triggered
	public static WebDriver Sdriver;
	
	//@BeforeSuite(groups= {"smoke testing","Regression testing"})
	@BeforeSuite()
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	
	//@BeforeTest(groups= {"smoke testing","Regression testing"})
	@BeforeTest()
	public void beforeTest()
	{
		System.out.println("Parallel execution");
	}
	
	//@Parameters( "browser")
	//@BeforeClass(groups= {"smoke testing","Regression testing"})
	@BeforeClass()
	//public void beforeClass(String browser ) throws Throwable
	public void beforeClass() throws Throwable
	{
		File_utility flib = new File_utility();
		
	
		
		String browser = flib.getStringKeyAndValue("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		}

		Webdriver_utility wlib = new Webdriver_utility();
		wlib.waitForPageToLoad(driver);
		System.out.println("Launch the browser");
		
		Sdriver=driver;
	}

	//@Parameters({ "url","username","password"})
   //	@BeforeMethod(groups= {"smoke testing","Regression testing"})
	
	//to fetch url, username, password without property file
	@BeforeMethod()
	public void beforeMethod() throws Throwable
	//public void beforeMethod(String url, String username, String password) throws Throwable
	{
		File_utility flib = new File_utility();
		String URL = flib.getStringKeyAndValue("url");
		String Username = flib.getStringKeyAndValue("username");
		String Password = flib.getStringKeyAndValue("password");
		Webdriver_utility wlib = new Webdriver_utility();
		driver.get(URL);
	//	driver.get(url);
		wlib.maximizeWindow(driver);
		
		LoginPage lp=new LoginPage(driver);
		  lp.loginToApp(Username, Password);
	    //lp.loginToApp(username, password);
		System.out.println("login to application");
	}
	
	//@AfterMethod(groups= {"smoke testing","Regression testing"})
	@AfterMethod()
	public void afterMethod() throws Throwable
	{
		/*Webdriver_utility wlib = new Webdriver_utility();  
		Thread.sleep(4000);
	         wlib.signOut(null, driver);*/
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
		System.out.println("logout of application");
	}
	
	//@AfterClass(groups= {"smoke testing","Regression testing"})
	@AfterClass()
	public void afterClass()
	{
		driver.close();
		System.out.println("closing browser");
	}
	
	//@AfterTest(groups= {"smoke testing","Regression testing"})
	@AfterTest()
	public void afterTest()
	{
		System.out.println("parallel execution done");
	}
	
	//@AfterSuite(groups= {"smoke testing","Regression testing"})
	@AfterSuite()
	public void afterSuite()
	{
		System.out.println("Database close");
	}
}
