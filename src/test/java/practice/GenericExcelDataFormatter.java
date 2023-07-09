package practice;

import java.io.FileInputStream;
import java.util.Iterator;
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
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericExcelDataFormatter {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		File_utility flib = new File_utility();
		String URL = flib.getStringKeyAndValue("url");
		String Username = flib.getStringKeyAndValue("username");
		String Password = flib.getStringKeyAndValue("password");
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Java_utility jlib = new Java_utility();
		int data = jlib.getRanNum();
		
		//Random ran =new Random();
		//int data = ran.nextInt();
		Excel_utility elib = new Excel_utility();
		String prddata = elib.getExcelData("product", 0, 0)+data;
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prddata);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		WebElement input = driver.findElement(By.xpath("//a[text()='More']"));

		Actions act=new Actions(driver);
		act.moveToElement(input).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("hp laptop"+data);
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allwid = driver.getWindowHandles();
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
			
			
		}

		driver.findElement(By.name("search_text")).sendKeys(prddata);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+prddata+"']")).click();
		Thread.sleep(2000);
		Set<String> allwind = driver.getWindowHandles();
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
		}
		Thread.sleep(2000);
		String ti = driver.getTitle();
		System.out.println(ti);
	    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();


	}




	}


