package basic;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyActionsRightClickAssignment {
	
	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		Actions myaction = new Actions(driver);
		
		WebElement target = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		//code to perform right click using contextClick method
		myaction.contextClick(target).build().perform();
		
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']")).click();
		Alert alert = driver.switchTo().alert();
		String currentmsg = alert.getText();
		String expectedmsg = "clicked: edit";
		Assert.assertEquals(currentmsg, expectedmsg);
		alert.accept();
		driver.quit();
	}
	
}
