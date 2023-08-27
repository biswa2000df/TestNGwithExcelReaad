package PassFailDataDrivenProject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MailExcelGet   {
	public static WebDriver driver;
	static String result=null;
	static String P="PASS";
	static String F="FAIL";
	
	
	@Test(dataProvider="read",dataProviderClass = ExcelReadWriteTest.class)
	public static void getData(String username,String password) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.get("https://mail.apmosys.com/webmail/");
		Thread.sleep(3000);
		driver.findElement(By.name("email-address")).sendKeys(username);
		driver.findElement(By.name("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("remember-me")).click();
		driver.findElement(By.name("next")).click();
		Thread.sleep(10000);
		Boolean b=driver.findElement(By.xpath("//*[@id=\"gui.frm_main.hmenu1/0\"]")).isDisplayed();
		System.out.println("khsaklhsgkjhjahkhakhskjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj   "+b);
		result=P;
		
		
	
		
		
				
		
	}
	

}
