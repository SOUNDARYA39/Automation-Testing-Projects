package practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import organizationpage.CreateProductPage;
import organizationpage.DeleteProduct;
import organizationpage.HomePage;
import organizationpage.LoginPage;

public class GenericCreateProductAndDelete {

	public static void main(String[] args) throws Throwable {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();*/
		
		Java_utility jlib = new Java_utility();
		int data = jlib.getRanNum();
		
		File_utility flib = new File_utility();
		WebDriver driver = null;
		
		String Browser = flib.getStringKeyAndValue("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("msedge"))
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
		
		 String URL = flib.getStringKeyAndValue("url");
		 String Username = flib.getStringKeyAndValue("username");
		 String Password = flib.getStringKeyAndValue("password");
		 
		driver.get(URL);
		
		LoginPage login=new LoginPage(driver);
		login.loginToApp(Username, Password);
		
		//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Password);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		 HomePage hp=new HomePage(driver);
		 hp.productLink();
		 
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		CreateProductPage cp = new CreateProductPage(driver);
		
		cp.proplus();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Excel_utility elib = new Excel_utility();
		//String prd = elib.getDataFormatter("product",0 , 0)+data;
		String prddata = elib.getExcelData("product", 0, 0)+data;
		
		cp.productName(prddata);
		//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(prddata);
		cp.save();
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		//table[@class='lvt small']//td//a[text()='samsungm21186']/../preceding::sibling::td
		//table[@class='lvt small']//td//a[text()='samsungm21186']/../preceding-sibling::td/input[@type='checkbox']
         hp.productLink();
		//driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
//dynamic xpath is recommended to keep in main class if you want you can write in pom class
        
	
		driver.findElement(By.xpath("//table[@class='lvt small']//td//a[text()='"+prddata+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
		DeleteProduct dp = new DeleteProduct(driver);
		dp.delete();
		//driver.findElement(By.xpath("(//input[@value='Delete'])[2]")).click();
	   Alert alt = driver.switchTo().alert();
	  alt.accept();
	 
			Thread.sleep(1000);
		//wlib.switchToAlertAndAccept(driver);
		List<WebElement> productlist = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
		
		boolean flag = false;
		for(WebElement prdName:productlist)
		{
			 String actName = prdName.getText();
			 if(actName.contains(prddata))
			 {
				 flag=true;
				 break;
			 }
		}
			 if(flag)
			 {
				 System.out.println("product is deleted");
		
			 }
			 
			 else
			 {
				 System.out.println("product not deleted");
			 }
		wlib.signOut(null, driver);
		
	}
	
	

}
