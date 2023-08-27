package PassFailDataDrivenProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class justTest {
	@Test
	public void test() throws IOException
	{
		File f=new File("C:\\Users\\biswa\\Desktop\\excel1.xlsx");
		FileInputStream fio=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fio);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowCou=sheet.getPhysicalNumberOfRows();
		int colCou=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowCou);
		System.out.println(colCou);
		XSSFRow row=null;
		XSSFCell cell=null;
		
		String username=null;
		String password=null;
		for(int i=1;i<rowCou;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<colCou;j++)
			{
				cell=row.getCell(j);
//				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
				if(j==0)
				{
					username=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				if(j==1)
				{
					password=sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			System.out.println();
			cell=row.createCell(2);
			cell.setCellValue("PASS");
		}
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		
		//workbook.close();
		fos.close();
		
	}

}
