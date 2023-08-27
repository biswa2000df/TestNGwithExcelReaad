package readExcel.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getExcelDataTest {
	
	
	@DataProvider(name="logintest")
	public String[][] getData() throws IOException {
		File f=new File("C:\\Users\\biswa\\Desktop\\kanha.xlsx");
		FileInputStream fio=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fio);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowCount=sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(rowCount);
		System.out.println(colCount);
		String data[][]=new String[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				DataFormatter df=new DataFormatter();
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				
				
			}
		}
		return data;
		
	}

}
