package DataDrivenFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SiteAutomateandgetdatafromeExcel {
	
	WebDriver driver;
	@Test(dataProvider="excel",dataProviderClass=getDataFromExcel.class)
	public void setup(String name,String email,String username,String password,String conformpassword,String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
		System.setProperty("webdriver.edge.driver","C:\\browserdrivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://forms.app/auth/signup");
		
		//main part start
		driver.findElement(By.id("i-text-1")).sendKeys(name);
		driver.findElement(By.id("i-text-2")).clear();
		driver.findElement(By.id("i-text-2")).sendKeys(email);	
		driver.findElement(By.id("i-text-3")).clear();
		driver.findElement(By.id("i-text-3")).sendKeys(username);
		driver.findElement(By.id("i-text-4")).clear();
		driver.findElement(By.id("i-text-4")).sendKeys(password);
		driver.findElement(By.id("i-text-5")).clear();
		driver.findElement(By.id("i-text-5")).sendKeys(conformpassword);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
