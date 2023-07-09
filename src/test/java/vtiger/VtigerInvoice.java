package vtiger;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerInvoice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement mo = driver.findElement(By.linkText("More"));
		Actions act=new Actions(driver);
		act.moveToElement(mo).perform();
		driver.findElement(By.xpath("//a[@name='Invoice']")).click();
		driver.findElement(By.xpath("//img[@title='Create Invoice...']")).click();
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("advance selemiun");
		driver.findElement(By.xpath("//input[@name='customerno']")).sendKeys("458789");
		 driver.findElement(By.xpath("(//img[@title='Select'])[3]")).click();
		
		String parent = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		allwindow.remove(parent);
		for(String windowid:allwindow) {
			driver.switchTo().window(windowid);
		}
		//System.out.println(parent);
		//driver.switchTo().window(parent);
		
		
		driver.findElement(By.id("search_txt")).sendKeys("soundaryag");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.linkText("soundaryag")).click();
		Alert conf = driver.switchTo().alert();
		conf.accept();
		driver.switchTo().window(parent);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(200);
		driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("mysore");
		driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("bangalore");
		js.executeScript("window.scrollBy(0,-300)");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Runtime.getRuntime().exec("./src/test/resources/invoice.exe");

	}

}
