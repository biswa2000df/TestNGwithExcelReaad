package ExtentReport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class newExtentReportGenerateUsingSelenium {
	ExtentHtmlReporter htmlreporter;
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	
	
	
	@BeforeTest
	public void startReporter() {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//ExtentReportGenerated.html");
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		report.setSystemInfo("Machine", "Dell");
		report.setSystemInfo("Host Name","Automation Testing");
		report.setSystemInfo("User Name", "Biswajit Sahoo");
		
	}
	
	
	
	///////Take ScreenshotAs//////////////
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String s=System.getProperty("user.dir") + "/Screenshots/" + screenshotName +  ".png";
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File f=new File(s);
		FileUtils.copyFile(source, f);
		return s;
		
	}
	
	
	
	
	@BeforeMethod
	public void BrowserSetup() {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
	}
	
	@Test
	public void verifyTitle() {
		test=report.createTest("verifyTitleTest");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void verifyedLogo() {
		test=report.createTest("verify logo tests");
		boolean img = driver.findElement(By.xpath("//img&#91;@id='hplogo']")).isDisplayed();
		test.createNode("Image is present");
		Assert.assertTrue(img);
		test.createNode("Image is not present");
		Assert.assertTrue(img);
		
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			System.out.println("Name="+result.getName());
			System.out.println("Status="+result.getStatus());
		
			//call to screenshot class
			String screenshotpath=getScreenshot(driver,result.getName());
			test.fail("Test case is failed and screenshot is below"+test.addScreenCaptureFromPath(screenshotpath));
			
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName() + " - Test Case pass", ExtentColor.GREEN));
			System.out.println("Name="+result.getName());
			System.out.println("Status="+result.getStatus());
		}
		else if(result.getStatus()==ITestResult.SKIP){
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + " - Test Case skip", ExtentColor.ORANGE));
		}
		
		driver.close();
		
	}
	
	@AfterTest
	public void endReport() {
		report.flush();
		
	}
	
	

}
