package basic;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B24MyTableGrid {
	
	@Test
	public void tableread() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/mutual-funds/liquid");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		String col1 = "Company";
		String col2 = "Returns(%)";
		String col1_item = "Mahindra Manulife Investment Management Pvt. Ltd.";
		
		
		B24MyTableUtility table = new B24MyTableUtility();
		String value1 = table.getTableCellText(driver, col1, col2, col1_item);
		Assert.assertEquals("11.52", value1);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
