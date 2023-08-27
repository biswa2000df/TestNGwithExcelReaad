package excelRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelR {
	@DataProvider(name="login")
	public String[][] read() throws IOException
	{
	File f=new File("C:\\Users\\biswa\\Desktop\\kanha.xlsx");
	FileInputStream fio=new FileInputStream(f);
	XSSFWorkbook workbook=new XSSFWorkbook(fio);
	XSSFSheet sheet=workbook.getSheet("sheet1");
	int row=sheet.getPhysicalNumberOfRows();		//5
	int col=sheet.getRow(0).getPhysicalNumberOfCells();//2
	
	System.out.println("Row="+row);
	System.out.println("Col="+col);
	String data[][]=new String[row-1][col];//row- re kete thera chrome open kariba au kete  thare data read kariba
	for(int i=0;i<row-1;i++)
	{
		for(int j=0;j<col;j++)
		{
			DataFormatter df=new DataFormatter();			
			data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			System.out.println(data[i][j]);
			
		}
		System.out.println();
		
	}

	
	return data;
	
	}
	

	

}
