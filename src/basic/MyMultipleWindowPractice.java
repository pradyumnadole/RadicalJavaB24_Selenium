package basic;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyMultipleWindowPractice {
	
	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String Title1 = driver.getTitle();
		System.out.println("Main window Title is " +Title1);
		String win1 = driver.getWindowHandle();
		System.out.println("Main window handle is " +win1);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'HOTELS')]")).click();
		

	
		Set <String> Mwins = driver.getWindowHandles();
		for (String win : Mwins) {
			if(!win1.equals(win)) {
				System.out.println("This is second window");
				driver.switchTo().window(win);
				
			}
			
		}
		
		String Title2 = driver.getTitle();
		System.out.println("Hotel window Title is " +Title2);
		String win2 = driver.getWindowHandle();
		System.out.println("Hotel window handle is " +win2);
		
		driver.findElement(By.xpath("//input[@id='filterText']")).sendKeys("Pune");
		
		
		
		
	}
	

}
