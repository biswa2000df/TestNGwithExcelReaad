package readExcel.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class googleTest {
	
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

	@Test(priority=1,groups="youtu")
	public void Youtube()
	{
		driver.findElement(By.name("q")).sendKeys("youtube");
		 act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();	
		System.out.println("Hello YouTube");
	}
	
	
	@Test(priority=2,groups="link")
	public void linkTest()
	{
	boolean b=	driver.findElement(By.linkText("Gmail")).isDisplayed();
	System.out.println("Link is="+b);
	Assert.assertTrue(b);	
	}
	
	
	@Test(priority=3,groups="flipkart")
	public void Flipkart()
	{
		driver.findElement(By.name("q")).sendKeys("flipkart");
		 act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();		
		System.out.println("Hello flipkart");
	}
	
	@Test(priority=4,groups="test")
	public void test1()
	{
		System.out.println("Test1");
	}
	
	@Test(priority=5,groups="test")
	public void test2()
	{
		System.out.println("Test2");
	}
	
	@Test(priority=6,groups="test")
	public void test3()
	{
		System.out.println("Test3");
	}
	
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		driver.quit();
	}
}
