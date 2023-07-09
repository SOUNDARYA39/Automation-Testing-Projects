package adsel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet2");
		 
		 
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
     
        
        driver.get("https://www.amazon.in/ref=nav_logo");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
       //driver.navigate().refresh();
       
     // driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
      
      int count = alllinks.size();
      System.out.println(count);
       for(int i=0;i<alllinks.size();i++)
       {
    	   Row row = sh.createRow(i);
    	 Cell cel = row.createCell(0);
    	 cel.setCellValue(alllinks.get(i).getAttribute("href"));
       }
FileOutputStream fos=new FileOutputStream("./src/test/resources/excel.xlsx");
book.write(fos);
book.close();
	}

}
