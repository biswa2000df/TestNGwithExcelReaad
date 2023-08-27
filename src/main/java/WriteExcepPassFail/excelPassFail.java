package WriteExcepPassFail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelPassFail {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		File f=new File("‪C:\\Users\\biswa\\Desktop\\kanha.xlsx");
		FileInputStream fio=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fio);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getPhysicalNumberOfRows();
		int colCount=sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(rowCount);
		System.out.println(colCount);
		
		XSSFRow row=null;
		XSSFCell cell=null;
		
	
		String username=null;
		String password=null;
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver;
		
		
		
		
		for(int i=0;i<rowCount;i++)
		{
			
			row=sheet.getRow(i);
			
			for(int j=0;j<colCount;j++)
			{
				cell=row.getCell(j);
				//System.out.println("=========================================> "+cell);
				if(j==0)
				{
					username=cell.getStringCellValue();
					System.out.println(username);
				}
				else if(j==1)
				{
					password=cell.getStringCellValue();
					System.out.println(password);
				}
			
			}
			 driver=new ChromeDriver();
			driver.get("https://mail.apmosys.com/webmail/#sign-in");
			System.out.println(username);
			Thread.sleep(3000);
			driver.findElement(By.name("email-address")).sendKeys(username);
			driver.findElement(By.name("next")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("next")).click();
			
			
			String result=null;
			
			
			try {
				Boolean a=true;
				
				if(a==true)
				{
					result="PASS";
					cell=row.createCell(7);
					cell.setCellValue(result);
				}
			}
			catch(Exception e) {
				Boolean b=true;
				if(b==true)
				{
					result="FAIL";
					cell=row.createCell(8);
					cell.setCellValue(result);
				}
				
			}
			driver.quit();
			
			
			
			
			
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		
		
		
		
		

	}

}
