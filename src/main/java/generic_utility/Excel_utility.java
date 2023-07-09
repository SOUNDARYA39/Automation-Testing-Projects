package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("product");
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
		
	}
	
	public String getExcelData1(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("organization");
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
		
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */

public String getDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
{
	
	FileInputStream fis1 = new FileInputStream("src/test/resources/excel.xlsx");
	Workbook book = WorkbookFactory.create(fis1);
	DataFormatter format = new DataFormatter();
	String value1 = format.formatCellValue(book.getSheet("organization").getRow(rowNum).getCell(cellNum));
	
	return value1;
	
	
}

	public String getDataFormatterprd(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable 
	{
		FileInputStream fis2 = new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		DataFormatter format1 = new DataFormatter();
		String value2 = format1.formatCellValue(book.getSheet("product").getRow(rowNum).getCell(cellNum));
		return value2;
	}
	
	public String getExcelData2(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable
	{
		FileInputStream fis2 = new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sh3 = book.getSheet("campaign");
		Row row = sh3.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
	}
	public String getExcelData3(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("orgindutype");
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
		
	}
	public String getExcelData4(String sheetName, int rowNum, int cellNum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("contact");
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		String value = cel.getStringCellValue();
		return value;
		
	}
	public String getDataFormatterprd1(String sheetName, int rowNum, int cellNum) throws Throwable, Throwable 
	{
		FileInputStream fis2 = new FileInputStream("src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		DataFormatter format1 = new DataFormatter();
		String value2 = format1.formatCellValue(book.getSheet("contact").getRow(rowNum).getCell(cellNum));
		return value2;
	}
	
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		Random ran=new Random();
		int data = ran.nextInt(1000);
		FileInputStream fis5=new FileInputStream("src/test/resources/dataprov.xlsx");
		 Workbook book = WorkbookFactory.create(fis5);
		Sheet sh = book.getSheet(sheetName);
		int lastrow = sh.getLastRowNum()+1;
		 int lastcol = sh.getRow(0).getLastCellNum();
		 DataFormatter format=new DataFormatter();
		
		 Object[][] obj=new Object[lastrow][lastcol];
		 for(int i=0;i<lastrow;i++)
		 {
			 for(int j=0;j<lastcol;j++)
			 {
				 
				 obj[i][j]=format.formatCellValue(book.getSheet(sheetName).getRow(i).getCell(j))+data;
			 }
		 }
		return obj;
		 
		 
		 
	}
	
	}

