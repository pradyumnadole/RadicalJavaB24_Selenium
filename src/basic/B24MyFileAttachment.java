package basic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B24MyFileAttachment {
	
	@Test
	public void testCase1() throws IOException{
		ChromeDriver driver = new ChromeDriver();
		//can be used for waiting for element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.freefileconvert.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='first_file']"))
		.sendKeys("D:\\RadicalSelenium\\Simple.txt");
		
	
	
	
		
	
	
	
	
	
	
	
	}
	

}
