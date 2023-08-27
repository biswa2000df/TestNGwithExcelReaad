package JustPractice;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListner extends Base implements ITestListener {
			public void onTestFailure(ITestResult result) {
			System.out.println("Failed Test Case");
			try {
				FailedTestCase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
}

}
