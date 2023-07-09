package adsel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {


	public static void main(String[] args) throws Throwable {
	WebDriver driver;
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
	
FileInputStream fis=new FileInputStream("src/test/resources/property.properties.txt");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String usn = pro.getProperty("username");
String pwd = pro.getProperty("password");
driver.get(URL);
driver.findElement(By.id("username")).sendKeys(usn);
driver.findElement(By.name("pwd")).sendKeys(pwd);
driver.findElement(By.id("loginButton")).click();

	}

}
