package practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx2 {
	@Test(dataProvider = "dataProviderExe")
	public void createOrgDataPro(String orgName, String phone, String email) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phone);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//Actions act=new Actions(driver);
		//act.moveToElement(sign).perform();
		//driver.findElement(By.xpath("//a[@class='drop_down_usersettings'][2]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] dataProviderExe()
	{
		Object[][] obj = new Object[3][3];
		
		Random ran=new Random();
		int data = ran.nextInt(1000);
		obj[0][0]="dell"+data;
		obj[0][1]="87878";
		obj[0][2]="sjdhsj@gmail.com";
		
		obj[1][0]="samsung"+data;
		obj[1][1]="8568";
		obj[1][2]="sfdkfjsj@gmail.com";
		
		obj[2][0]="hp"+data;
		obj[2][1]="438577";
		obj[2][2]="cfxdhsj@gmail.com";
		return obj;
		
	}

}
