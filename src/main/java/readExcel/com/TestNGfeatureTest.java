package readExcel.com;

import org.testng.annotations.Test;

public class TestNGfeatureTest {
	
	@Test
	public void loginTest()
	{
		System.out.println("LoginTest");
//		int i=10/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePage() {
		System.out.println("HomepageTest");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchBarTest() {
		System.out.println("SearchBarTest");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void registrationPage() {
		System.out.println("RegistrationPageTest");
	}
	
	

}
