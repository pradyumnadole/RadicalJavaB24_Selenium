package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class B24MyDragandDrop {
	
	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	
		
		
		Actions myaction = new Actions(driver);
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']")); 
		WebElement target =driver.findElement(By.xpath("//div[@id='droppable']"));
		myaction.dragAndDrop(source, target).build().perform();
	
		
		if (driver.findElement(By.xpath("//div//p[contains(text(),'Dropped')]")).isDisplayed()) {
			System.out.println("Drag & drop passed");
		}
	
		driver.quit();
	
	
	
	
	}
	

}
