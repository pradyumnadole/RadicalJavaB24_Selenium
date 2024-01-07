package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTablePrac1 {
	
	@Test
	public void tableread() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		
		String Col1 = "Country";		
		String Col3 = "Capital(s)";	
		String Col_item = "Tirane";	
		
		List<WebElement> ele1 = driver.findElements(By.xpath("//table/tbody/tr/td"));
		 int totalcols = ele1.size();
		 System.out.println(totalcols);
		 int colPosition =0;
	
		 for(int i =1;i<=totalcols;i++) {
			String ColName = driver.findElement(By.xpath("//table/tbody/tr/td["+i+"]")).getText();
			if(Col1.equals(ColName)) {		
				colPosition =i;
				break;
			}
		 }
		 System.out.println("Column 1 position is "+colPosition);
	
		
		int colPosition2 =0;
		 for(int i =1;i<=totalcols;i++) {
				String ColName2 = driver.findElement(By.xpath("//table/tbody/tr/td["+i+"]")).getText();
				if(Col3.equals(ColName2)) {		
					colPosition2 =i;
					break;
				}
			}
		System.out.println("Column 3 position is "+colPosition2);
		
		 List<WebElement> allItemsfromCol1 = driver.findElements(By.xpath("//table/tbody/tr"));
		 int totalRows = allItemsfromCol1.size(); 
		 System.out.println(totalRows);
		 int rowPosition =0;
		 
		 for(int i =1;i<=totalRows;i++) {
				String rowName = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+colPosition2+"]")).getText();
				if(Col_item.equals(rowName)) {		
					rowPosition =i;
					System.out.println(rowPosition);
					break;
				}
			}
		 
		 String new1 = driver.findElement(By.xpath("//table/tbody/tr["+rowPosition+"]/td["+colPosition+"]")).getText();
		 System.out.println(new1);
		 Assert.assertEquals("Albania", new1);
	
	}

}
