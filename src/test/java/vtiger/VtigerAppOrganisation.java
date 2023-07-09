package vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerAppOrganisation {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// driver.switchTo().alert().dismiss();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("soun1");
		driver.findElement(By.id("phone")).sendKeys("556788");
		driver.findElement(By.id("email1")).sendKeys("sofk@gmail.com");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//Actions act=new Actions(driver);
		//act.moveToElement(sign).perform();
		//driver.findElement(By.xpath("//a[@class='drop_down_usersettings'][2]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
