package FailedTestScreenshot;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListner.class)
public class ScreenshotTest extends Base {
	
	
	@BeforeMethod
	public void BrowserSetup()
	{
		initilization();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	@Test
	public void screenshotAs() {
		Assert.assertEquals(true, false);
		
	}

	
	

}
