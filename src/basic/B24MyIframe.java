package basic;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class B24MyIframe {

	@Test
	public void testcase1() {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		//move to parent frame
		driver.switchTo().frame("frame1");
		
		String str1 = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		System.out.println("Parent Frame " + str1);
		
		//move to child frame
		//driver.switchTo().frame(0); simpler using index of iframe.
		WebElement ele = driver.findElement(By.xpath("//iframe[@srcdoc = '<p>Child Iframe</p>']"));
		
		driver.switchTo().frame(ele);
		String str2 = driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]")).getText();
		System.out.println("Second Frame " + str2);
	
		//move to again parent frame
		driver.switchTo().parentFrame();
		
		String str3 = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		System.out.println("Back to Parent Frame " + str3);
		
		//move to main window
		driver.switchTo().defaultContent();
		System.out.println("Back to Main window " + driver.getTitle());
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
