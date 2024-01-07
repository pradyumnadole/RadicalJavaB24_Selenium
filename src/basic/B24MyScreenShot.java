package basic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B24MyScreenShot {
	
	
	@Test
	public void testCase1() throws IOException{
		ChromeDriver driver = new ChromeDriver();
		//can be used for waiting for element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Selenium");
		
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
//		File Fi = screenshot.getScreenshotAs(OutputType.FILE);
//		File FiNew = new File ("D:\\RadicalSelenium\\Screenshot\\Google1.png");
//		FileUtils.copyFile(Fi, FiNew);
		//Code with utility method
		B24MyUtility obj = new B24MyUtility();
		obj.takescreenshot(driver);
	
	}

}
