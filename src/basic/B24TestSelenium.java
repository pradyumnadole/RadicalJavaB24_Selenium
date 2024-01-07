package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class B24TestSelenium {

	@Test
	public void testCase1() {
		System.out.println("Hello java");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
	}
	
//	@Test
//	public void testCase2() {
//		FirefoxDriver driver1 = new FirefoxDriver();
//		driver1.get("https://www.selenium.dev/");
//	}
//	
	@Test
	public void testCase3() {
		EdgeDriver driver2 = new EdgeDriver();
		driver2.get("https://www.selenium.dev/");
	}
}
