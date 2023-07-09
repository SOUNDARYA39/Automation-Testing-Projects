package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateContactPage;
import organizationpage.CreateOrganization;
import organizationpage.HomePage;
import organizationpage.LoginPage;

public class GenericContact {

	public static void main(String[] args) throws Throwable {
	Java_utility jlib= new Java_utility();
	int data = jlib.getRanNum();
	Excel_utility elib=new Excel_utility();
	File_utility flib=new File_utility();
	
	String brow = flib.getStringKeyAndValue("browser");
	WebDriver driver=null;
	
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
		driver= new EdgeDriver();
	}
	
	String URL = flib.getStringKeyAndValue("url");
	String Username = flib.getStringKeyAndValue("username");
	String Password = flib.getStringKeyAndValue("password");
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(Username, Password);
	
	
	
	HomePage hp=new HomePage(driver);
	hp.orgLink();
	
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.coplus();

	/*String accName = elib.getExcelData4("contact", 1, 2)+data;
	String phone = elib.getExcelData4("contact",1,3);
	String email = elib.getExcelData4("contact", 1, 4);*/
	
	String accName = elib.getDataFormatterprd1("contact", 1, 2)+data;
	String phone = elib.getDataFormatterprd1("contact", 1, 3);
	String email = elib.getDataFormatterprd1("contact", 1, 4);
	
    ccp.orgData(accName, phone, email);
    ccp.saveButtonco();
    Thread.sleep(2000);
	ccp.contactLink();
	
	ccp.createContact();
	String firstdd = elib.getExcelData4("contact", 1, 0);
	
	ccp.firstNameDD(firstdd);
	
	String firstName = elib.getExcelData4("contact", 1, 1)+data;
	
	ccp.firstNameTT(firstName);
	
	ccp.organizationSel();
	
	Webdriver_utility wlib=new Webdriver_utility();
	wlib.switchToWindow(driver, "Accounts&action");
	
	
	
	 ccp.orgSearch(accName);
	 
	 ccp.searchNowButton();

	 //ccp.dynamicData(driver, accName);
	  Thread.sleep(4000);
	 driver.findElement(By.xpath("//a[text()='"+accName+"' or @href='javascript:window.close();']")).click();
	 Thread.sleep(2000);
	 wlib.switchToWindow(driver, "Contacts&action");
	 String lastname = elib.getDataFormatterprd1("contact", 1, 5)+data;
	 
	 ccp.lastName(lastname);
	 ccp.contactSave();
	 
	 wlib.signOut(null, driver);
	

	}

}
