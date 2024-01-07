package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class B24MyImplicitExplicit {
	
	@Test
	public void testCase1() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//can be used for waiting for element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Explicit waits till that element loads
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@title='Searchzz']")));
		driver.findElement(By.xpath("//textarea[@title='Searchzz']"));
	
		driver.quit();
		
		
		
	}
	
}
