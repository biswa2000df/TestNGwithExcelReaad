package PassFailDataDrivenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelReadWriteTest {
	
	
	File f;
	FileInputStream fio;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	@DataProvider(name="read")
	public String[][] readWrite() throws IOException {
		f=new File("C:\\Users\\biswa\\Desktop\\kanha111.xlsx");
	fio=new FileInputStream(f);
	 workbook=new XSSFWorkbook(fio);
	sheet=workbook.getSheet("Sheet1");
	int rowCou=sheet.getPhysicalNumberOfRows();
	int colCou=sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println(rowCou);
	System.out.println(colCou);
	String username=null;
	String password=null;
	String data[][]=new String[rowCou-1][colCou];
	for(int i=0;i<rowCou-1;i++)
	{
		row=sheet.getRow(i+1);
		for(int j=0;j<colCou;j++)
		{
			DataFormatter df=new DataFormatter();
		data[i][j]=	df.formatCellValue(sheet.getRow(i+1).getCell(j));

		
		}
		System.out.println();
		
		cell=row.createCell(2);
	//	cell.setCellValue(result);
	}
	FileOutputStream foi=new FileOutputStream(f);
	workbook.write(foi);
	foi.close();
	
	return data;
	
	
	}

}
