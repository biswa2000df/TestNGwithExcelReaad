package ExtentReport;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static void main(String args[]) {
		//File file=new File("Report8.html");
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//Extentreport.html");
		
		ExtentReports extent=new ExtentReports();
		
		extent.attachReporter(htmlReport);
		
		
		
		extent.setSystemInfo("Machine", "Dell");
		extent.setSystemInfo("Env","Automation tester");
		extent.setSystemInfo("Browser","Chrome");
		
		ExtentTest test = extent.createTest("verifyTittleTest");
		
		
		test.log(Status.INFO,"Login To Amazon page");
		test.log(Status.PASS,"Successfully login");
		
		
		
		
		
		
		
		extent.flush();
		
		
		
		
	}

}
