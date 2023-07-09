package adsel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ToWriteDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet3");
		System.out.println(sh.getLastRowNum());
		for(int i=0;i<sh.getLastRowNum();i++) {
			Row row = sh.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				Cell cel = row.getCell(j);
				DataFormatter formater=new DataFormatter();
				String data = formater.formatCellValue(cel);
				System.out.println(data);
				
			}
		}
		

	}

}
