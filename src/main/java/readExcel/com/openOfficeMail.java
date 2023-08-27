package readExcel.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class openOfficeMail {
	
	
	@Test(dataProvider="logintest",dataProviderClass=getExcelDataTest.class)
	public void OpenMail(String username,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mail.apmosys.com/webmail/#sign-in");
		
		driver.findElement(By.name("email-address")).sendKeys(username);
		driver.findElement(By.name("next")).click();
	
		driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("next")).click();
	Thread.sleep(2000);
	driver.quit();
		
	}

}
