package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyMultipleWindowPrac2 {

	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String Title1 = driver.getTitle();
		System.out.println(Title1);
		String win1 = driver.getWindowHandle();
		System.out.println(win1);
		
		driver.findElement(By.xpath("//a[contains(text(),'Watch the Videos')]")).click();
		
		Set <String> windows = driver.getWindowHandles();
		
		for (String win : windows) {
			if(!win1.equals(win)) {
				System.out.println("This is second window");
				driver.switchTo().window(win);
			}
			
		}
		String Title2 = driver.getTitle();
		System.out.println(Title2);
		String win2 = driver.getWindowHandle();
		System.out.println(win2);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		
		
		
		
		
		
		
		
	}
	
}
