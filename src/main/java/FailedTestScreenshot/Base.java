package FailedTestScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public  void initilization() {
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	public void failed() throws IOException {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("failedtestimage.png"));
	}

}
