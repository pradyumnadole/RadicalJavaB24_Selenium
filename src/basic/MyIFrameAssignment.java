package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyIFrameAssignment {
	
	@Test
	public void testcase1() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//move to single frame
		driver.switchTo().frame("singleframe");
		//update value in textbox
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test");
		driver.switchTo().parentFrame();
		
		//move to other tab 
		driver.findElement(By.xpath("//li//a[@href='#Multiple']")).click();

		//move to parent frame
		WebElement ele = driver.findElement(By.xpath("//div//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(ele);
		//move to child frame
		WebElement ele1 = driver.findElement(By.xpath("//div//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(ele1);
		
		//update value in textbox
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("New");
		driver.quit();	
	}

}
