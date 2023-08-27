package FailedTestScreenshot;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner extends Base implements ITestListener{

	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase Failed");
		try {
			failed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
		public void onTestSuccess(ITestResult result) {
			System.out.println("Testcase pass");
		}
	
}
