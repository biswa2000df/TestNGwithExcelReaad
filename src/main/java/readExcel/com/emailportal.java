package readExcel.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class emailportal {
//	@Test
//public void hello() throws InterruptedException {
////	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		String exceptedTitle="IceWarp WebClient";
//		driver.get("https://mail.apmosys.com/webmail/#sign-in");
//		
//		driver.findElement(By.name("email-address")).sendKeys("biswajit.sahoo@apmosys.com");
//		driver.findElement(By.name("next")).click();
//	
//		driver.findElement(By.name("password")).sendKeys("Welcome@2022");
//	driver.findElement(By.name("next")).click();
//Thread.sleep(5000);
//driver.close();
//Assert.assertTrue(driver.findElement(By.id("gui.frm_main.bar.tree.add_container.btn_add#main")).isDisplayed());
//		//Thread.sleep(2000);
//		//driver.close();	
//		
//}
	//------------------------------------------sequence wise execute---------------------------------------
	
	/* @BeforeMethod
	 * @Test
	 * @AfterMethod
	 * @BeforeMethod
	 * @Test
	 * @AfterMethod
	 * */
@BeforeSuite
public void setUp()
{
	System.out.println("@BeforeSuit setup the path");
}
@BeforeTest
public void lunchBrowser()
{
	System.out.println("@BeforeTest start the browser");
}

@BeforeClass
public void urlHit()
{
	System.out.println("@BeforeClass Hit the URL");
}
@BeforeMethod
public void executeBrowser()
{
	System.out.println("@BeforeMethod browser execute");
}
@Test
public void logoCheck()
{
	System.out.println("@Test case are executed");
}
@Test
public void browserCheck()
{
	System.out.println("@Test1 case are executed");
}
@AfterMethod
public void afterMethod()
{
	System.out.println("@AfterMethod case are executed");	
}
@AfterClass
public void afterClass()
{
	System.out.println("@AfterClass case are executed");
}
@AfterTest
public void afterTest()
{
	System.out.println("@AfterTest case are executed");
}
@AfterSuite
public void afterSuite()
{
	System.out.println("@AfterSuite case are executed");
}

}
