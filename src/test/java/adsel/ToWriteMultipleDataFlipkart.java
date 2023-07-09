package adsel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToWriteMultipleDataFlipkart {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/excel.xlsx");
		Workbook book1 = WorkbookFactory.create(fis);
		Sheet sh = book1.getSheet("Sheet3");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		List<WebElement> alllink = driver.findElements(By.xpath("//a"));
		
		int count = alllink.size();
		System.out.println(count);
		for(int i=0;i<alllink.size();i++)
		{
			Row row = sh.createRow(i);
			Cell cel = row.createCell(0);
			cel.setCellValue(alllink.get(i).getAttribute("href"));
			
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/excel.xlsx");
		book1.write(fos);
		book1.close();

	}

}
