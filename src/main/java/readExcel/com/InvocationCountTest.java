package readExcel.com;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=10)
	public void summation() {
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println("Sum="+c);
	}

}
