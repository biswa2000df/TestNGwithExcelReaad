package readExcel.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	WebDriver driver;
	Actions act;
	@BeforeMethod
	public void browserSetup()
	{
		System.out.println("How to start the Browser this process");
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http:///www.google.com");
	}

	@Test
	public void titleTest()
	{
		String s=driver.getTitle();
		System.out.println(s);
		Assert.assertEquals(s, "Google","Sorry! The title is not matched");
	}
	
	@AfterMethod
	public void browserClose()
	{
		driver.close();
	}

}
