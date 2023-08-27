package excelRead;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVWriter;

public class demoSite {
	String filepath="C:\\Users\\biswa\\Desktop\\example.csv";	
	File fo=new File(filepath);
	CSVWriter csvWriter;
	
	@Test(dataProvider="login",dataProviderClass=excelR.class)
	public void demo(String username,String password) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mail.apmosys.com/webmail/#sign-in");
		String exceptedTitle="IceWarp WebClient";
		driver.findElement(By.name("email-address")).sendKeys(username);
		driver.findElement(By.name("next")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("next")).click();
		String actualTitle=driver.getTitle();
		driver.close();
		Assert.assertEquals(exceptedTitle, actualTitle);
		//Thread.sleep(2000);
				
	}
//	@Test(dataProvider="login",dataProviderClass=excelR.class)
//	public void makeCsv(String username,String password) throws IOException
//	{
//	csvWriter = new CSVWriter(new FileWriter(fo,true)); 
//		  csvWriter.writeNext(new String[]{username,password});		    
//		  csvWriter.close();
//	}
	@BeforeTest
	public void csvCreat() throws IOException
	{
		  csvWriter = new CSVWriter(new FileWriter(fo,true));
		  System.out.println("ashkljhkjgahslkjhlkjgahlhlajskhkljahskljhgsajsa");
		 csvWriter.writeNext(new String[]{"USERNAME","PASSWORD"}); 
		 csvWriter.writeNext(new String[]{"2", "con", "Male", "24"});
	}

}
