package basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class B24MyTableUtility {
	
	public String getTableCellText(WebDriver driver, String col1, String col2, String col_item) {
		
		 List<WebElement> allColNamesEle = driver.findElements(By.xpath("//table/thead/tr/th"));
		 int totalNumOfCol = allColNamesEle.size(); 
		 System.out.println("total columns is " + totalNumOfCol);
		 int colposition = 0;
		 for(int i=1;i<=totalNumOfCol;i++) {
			String col_Name = driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText();
			if(col1.equals(col_Name)) {
				colposition = i;
				break;
			}		
		}
		 System.out.println("Column 1 position is "+colposition);
		 
		 int col2position = 0;
		 for(int i=1;i<=totalNumOfCol;i++) {
			String col_Name = driver.findElement(By.xpath("//table/thead/tr/th["+i+"]")).getText();
			if(col2.equals(col_Name)) {
				col2position = i;
				break;
			}		
		}
		 System.out.println("Column 2 position is "+col2position); 
		 
		 
		 List<WebElement> allItemsfromCol1 = driver.findElements(By.xpath("//table/tbody/tr"));
		 int totalRows = allItemsfromCol1.size(); 
		 int rowPosition =0;
		 
		 for(int i =1;i<=totalRows;i++) { 
			String actValue =  driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+colposition+"]")).getText();
				if(col_item.equals(actValue)) {
					rowPosition = i;
					break;				
				}			
		 }
		 
		 String returnPerIs = driver.findElement(By.xpath("//table/tbody/tr["+rowPosition+"]/td["+col2position+"]")).getText();
		 System.out.println(col2 + " of "+col_item + "is "+returnPerIs );
		 
		 return returnPerIs;
	
		
	}
	
	

}
