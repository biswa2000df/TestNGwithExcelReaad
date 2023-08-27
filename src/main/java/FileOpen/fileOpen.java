package FileOpen;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fileOpen {
	static String s ;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
//		try {
//			File f=new File("C:\\Users\\biswa\\Desktop\\New folder (4)\\kanha.txt");
//			
//			Desktop desktop=Desktop.getDesktop();
//			if(!Desktop.isDesktopSupported())
//			{
//				System.out.println("System is not supported");
//				return;
//			}
//			System.out.println(desktop);
//			if(f.exists())
//				desktop.open(f);
//			
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
		
		System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.guru99.com/java-interview-questions-answers.html");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"post-1488\"]/div/div/p[5]/a")).click();
		
		Thread.sleep(3000);
		
		
		File dir=new File("C:\\Users\\biswa\\Downloads");
      //  File dir = new File(path);
        File[] files = dir.listFiles();

        Arrays.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
            }
        });

        for (int i = 0; i < files.length; i++) {
            
            // s=files[0].getName();
              s = files[0].getPath();
              Desktop desktop=Desktop.getDesktop();
  		
              File dir1=new File(s);
  			System.out.println(desktop);
//  			if(dir1.exists())
//  				desktop.open(dir1);
            System.out.println(s);
            
            break;

        }
      driver.navigate().to(s);
      Thread.sleep(5000);
        File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f1,new File("D:\\image\\kanah.png"));
        
        
		

	}

}
