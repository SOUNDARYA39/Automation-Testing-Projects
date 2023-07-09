package insertdataintoproperty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsertDataIntoProperty {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		Properties pro = new Properties();
		pro.setProperty("browser", "chrome");
		pro.setProperty("url", "http://localhost:8888/index.php?action=index&module=Home");
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		
		FileOutputStream fout = new FileOutputStream("src\\test\\resources\\insertdata.properties");
		pro.store(fout, "common data");
		fout.close();
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\insertdata.properties");
		pro.load(fis);
	
		String url = pro.getProperty("url");
		driver.get(url);
		

	}

}
