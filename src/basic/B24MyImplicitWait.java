package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B24MyImplicitWait {

	@Test
	public void testCase1(){
		ChromeDriver driver = new ChromeDriver();
		//can be used for waiting for element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("Selenium");
	
		driver.navigate().back();
		//to check for wait for page - implicit way
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.navigate().forward();
		
		driver.quit();
		
	}
	
}
