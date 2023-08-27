package JustPractice;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListner.class)
public class javaTest extends Base {
	
	
	@BeforeMethod
	public void setup() {
		Initially();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void screenShot() {
		Assert.assertEquals(true, false);
	}

}
