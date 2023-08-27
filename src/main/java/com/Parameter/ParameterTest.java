package com.Parameter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	WebDriver driver;
	Actions act;
	@Test
	@Parameters({"url","data","Browser"})
	public void setupBrowser(String url,String data,String Browser)
	{
		if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\browserdrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(data);
		//act.sendKeys(Keys.ENTER).build().perform();
	 	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Boolean b=driver.findElement(By.linkText("Account")).isDisplayed();
		Assert.assertTrue(b);
	}
	@AfterMethod
	public void DriverQuit() {
		driver.quit();
	}
	

}
