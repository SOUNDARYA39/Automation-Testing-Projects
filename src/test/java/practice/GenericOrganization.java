package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateOrganization;
import organizationpage.HomePage;
import organizationpage.LoginPage;
import organizationpage.OrgValidationPage;

public class GenericOrganization {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File_utility flib = new File_utility();
		
		String URL = flib.getStringKeyAndValue("url");
		String Username = flib.getStringKeyAndValue("username");
		String Password = flib.getStringKeyAndValue("password");
		
		
		driver.get(URL);
		wlib.maximizeWindow(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(Username, Password);
		
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(Password);
		//driver.findElement(By.id("submitButton")).click();
		// driver.switchTo().alert().dismiss();
		
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
     co.saveButtonco();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//Actions act=new Actions(driver);
		//act.moveToElement(sign).perform();
		//driver.findElement(By.xpath("//a[@class='drop_down_usersettings'][2]")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		// OrgValidationPage ovp=new OrgValidationPage();
		 //   String actData = ovp.getOrgNameVal().getText();
		     
		     Assert.assertEquals(actData, accName);
        wlib.signOut(null, driver);
	}

}
