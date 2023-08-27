package readExcel.com;

import java.util.concurrent.TimeoutException;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

public class TimeOutandExceptedException {
	
//	@Test(timeOut=2000,expectedExceptions=ThreadTimeoutException.class)
//	public void infinityLoop(){
//		int i=1;												//timeout means inbetween this time to stop the execution
//		while(i==1)
//		{
//			System.out.println(i);
//		}
//	}
	
//	@Test(expectedExceptions=NumberFormatException.class)
//	public void ExceptedException() {
//		String s="100A";										//expected exception program
//		Integer.parseInt(s);
//	}
	@Test(invocationTimeOut = 2000,expectedExceptions=ThreadTimeoutException.class)
	public void InvocationTimeout() {
		int i=1;
		while(i==1)							//another annotation are used to handle the expectedExceptions
			System.out.println(i);
	}

}
