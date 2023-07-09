package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateCampaignPage;
import organizationpage.CreateProductPage;
import organizationpage.HomePage;
import organizationpage.LoginPage;

public class GenericProductModule {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		Webdriver_utility wlib = new Webdriver_utility();
		//wlib.waitForPageToLoad(driver);
		wlib.waitForPageToLoad(driver);
	
		File_utility flib = new File_utility();
		String URL = flib.getStringKeyAndValue("url");
		String Username = flib.getStringKeyAndValue("username");
		String Password = flib.getStringKeyAndValue("password");
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(Username, Password);
		
		
		/*driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		HomePage hp = new HomePage(driver);
		hp.productLink();
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		CreateProductPage propage = new CreateProductPage(driver);
		propage.proplus();
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Java_utility jlib = new Java_utility();
		int data = jlib.getRanNum();
		
		//Random ran =new Random();
		//int data = ran.nextInt();
		/*FileInputStream fis=new FileInputStream("./src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("product");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String prddata = cel.getStringCellValue()+data;*/
		Excel_utility elib = new Excel_utility();
		String prddata = elib.getExcelData("product", 0, 0)+data;
		propage.productName(prddata);
		
		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prddata);
		
		propage.save();
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		hp.moreLink();
		
		//WebElement input = driver.findElement(By.xpath("//a[text()='More']"));

	/*	Actions act=new Actions(driver);
		act.moveToElement(input).perform();*/
		
		//wlib.mouseHoverOnElement(driver, input);
		
		hp.campaign();
		//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		CreateCampaignPage cc = new CreateCampaignPage(driver);
		
		cc.pluscamp();
		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		 String camp = elib.getExcelData2("campaign", 0, 0)+data;
		 cc.campName(camp);
		//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("hp laptop"+data);
		
		 //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		 
		 cc.selectSwitching();
		//driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		wlib.switchToWindow(driver, "Products&action");
		
		/*Set<String> allwid = driver.getWindowHandles();
		Iterator<String> id = allwid.iterator();
		
		while(id.hasNext())
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.contains("Products&action"))
			{
				break;
			}
			
			
		}*/
        cc.searchPro(prddata);
		//driver.findElement(By.name("search_text")).sendKeys(prddata);
        cc.searchButton();
		//driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		Thread.sleep(2000);
		
		
		
		/*Set<String> allwind = driver.getWindowHandles();
		Iterator<String> id1 = allwind.iterator();
		while(id1.hasNext())
		{
			String win1 = id1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if(title1.contains("Campaigns&action"))
			{
				break;
			}
		}*/
		
		wlib.switchToWindow(driver, "Campaigns&action");
		
		Thread.sleep(2000);
		//String ti = driver.getTitle();
		//System.out.println(ti);
		
		Thread.sleep(2000);
		cc.saveButton();
	  //  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);
	   wlib.switchToWindow(driver, "DetailView&module");
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 
	    //WebElement signou = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		// wlib.explicitWait(signou, driver);
	   
	  
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		wlib.signOut(null, driver);
		//driver.findElement(By.linkText("Sign Out")).click();


	}

}
