package JustPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	public static void Initially() {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
	}
	
	public void FailedTestCase() throws IOException {
	
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("hellobaby.png"));
	}

}
