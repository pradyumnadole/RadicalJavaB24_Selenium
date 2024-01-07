package basic;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B24MyMultipleWindow {

	@Test
	public void testCase1() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		Thread.sleep(5);
		String MainwindowTitle = driver.getTitle();
		System.out.println("main window Title is "+MainwindowTitle);
		String onewinhandle = driver.getWindowHandle();
		System.out.println("1st window handle is "+onewinhandle);
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		
		Thread.sleep(5);
		
		String seconwinhandle = null;
		
		Set<String> multiwindowset =driver.getWindowHandles();
		
		for (String window : multiwindowset) {
			if(!onewinhandle.equals(window)) {
				System.out.println("This is second window");
				driver.switchTo().window(window);
				seconwinhandle = window;
			}
			
		}
		
		String secwindowTitle = driver.getTitle();
		System.out.println("second window Title is "+secwindowTitle);
		driver.close();
		//moving to first window
		Thread.sleep(5);
		driver.switchTo().window(onewinhandle);
		driver.findElement(By.xpath("//a//strong[contains(text(),'TRAINS')]")).click();
		
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
