package DataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class getDataFromExcel {
	@DataProvider(name="excel")
	public String[][] excelDataget() throws IOException {
		File f=new File("C:\\Users\\biswa\\Desktop\\kanha.xlsx");
		FileInputStream fio=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fio);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowCou=sheet.getPhysicalNumberOfRows();
		int colCou=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowCou);
		System.out.println(colCou);
		System.out.println("Display all the data what the data present in the ExcelSheet");
		String data[][]=new String[rowCou-1][colCou];
		for(int i=0;i<rowCou-1;i++)
		{
			for(int j=0;j<colCou;j++)
			{
				data[i][j]=	sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
			//System.out.println();
		}
		return data;
		
		
		
		
	}

}
