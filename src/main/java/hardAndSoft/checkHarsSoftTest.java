package hardAndSoft;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class checkHarsSoftTest {
//hardassert:-if the testcase is failed then immediately testcase marked as failed and the testcase will be terminated .
//SoftAssert:-If the testcase is failed then test case marked as pass and the as well as the next line will be executed.
//soft assert re aeta lekha huee ki-:(assertAll()):-realy the test case is fail and use softassert to pass the test case then use to assertAll() method to mark the testcase are failed and as well as next line will not be executed .
	WebDriver driver;
	@Test
	public void Hard()
	{
		System.out.println("browser check");
		Assert.assertEquals(false, true);
		System.out.println("Chrome driver open");
		Assert.assertEquals(true, false);
		System.out.println("login check");
		
	}
	
	
	@Test
	public void soft() throws IOException
	{
		SoftAssert softAssert=new SoftAssert();
		System.out.println("signin");
		System.out.println("signup");
		softAssert.assertEquals(true, false);
//		softAssert.assertAll();
		System.out.println("check login properly or not");
		System.out.println("take a screenshot");
		System.out.println("window handle");
		softAssert.assertEquals(false, true);
//		softAssert.assertAll();
		System.out.println("drop down");
		System.out.println("mouse hover");
		//File f=new File("kanhanew.png");
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("youtube");
		File f= new File("kanhakanh1.png");
		File ff=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ff,f);
		driver.close();
		
			
	}
	
	
	
	

}
