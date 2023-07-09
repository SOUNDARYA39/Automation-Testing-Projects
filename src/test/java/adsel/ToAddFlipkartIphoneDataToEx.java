/*package adsel;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToAddFlipkartIphoneDataToEx {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/excel.xlsx");
		Workbook book1 = WorkbookFactory.create(fis);
		Sheet sh = book1.getSheet("Sheet3");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
		//List<WebElement> iphone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		Thread.sleep(2500);
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		//Thread.sleep(2500);
		//WebElement electronics = driver.findElement(By.xpath("//span[@class='_2I9KP_ _2WDRax']"));
		Actions act=new Actions(driver);
		act.moveToElement(electronics).perform();
		WebDriverWait wait=new WebDriverWait(driver, 2000);
		WebElement ans = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='iPhone SE']")));
		//driver.findElement(By.xpath("//a[text()='iPhone SE']")).click();
		ans.click();
		
		//List<WebElement> ip = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> ip = driver.findElements(By.xpath("//div[@class='_4rR01T' or text()='APPLE iPhone SE']"));
		Thread.sleep(2000);
		WebDriverWait wait1=new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='_4rR01T' or text()='APPLE iPhone SE']")));
		
		//String str = ip.toString();
		int inp = ip.size();
		System.out.println(inp);
		for(WebElement we:ip)
		{
			
			
			String res = we.getText();
			System.out.println(res);
			
		}
		//Thread.sleep(4000);
		//driver.quit();

	}

}*/
