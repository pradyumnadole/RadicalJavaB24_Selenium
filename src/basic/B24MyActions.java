package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class B24MyActions {

	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	
		
		Actions myaction = new Actions(driver);
	
		//simple way
		WebElement target = driver.findElement(By.xpath("//input[@id='email']"));
//		target.click();
//		myaction.keyDown(Keys.SHIFT);
//		myaction.sendKeys("pradyumna");		
//		myaction.keyUp(Keys.SHIFT);
//		myaction.perform();
	
		myaction.moveToElement(target)
				.keyDown(Keys.SHIFT)
				.sendKeys("pradyumna")
				.keyUp(Keys.SHIFT)
				.build()
				.perform();
		
		//Right click using context click
		myaction.moveToElement(target).contextClick().build().perform();
	
		
	}
	
	
	
}
