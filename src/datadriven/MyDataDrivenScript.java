package datadriven;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import basic.B24MyReadExcel;
import basic.B24MyReadUtility;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDataDrivenScript {
	
	WebDriver driver ;
	String excelPath="src/datadriven/loginDemo.xlsx";
	
	@Test(dataProvider="MyDataProvider")
	public void loginToFacebook(String username, String password) throws InterruptedException{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.quit();
				
	}
	
	@DataProvider(name="MyDataProvider")
	public Object[][] getDataB7() throws InvalidFormatException, IOException{
//		ReadExcelSheet excelObj = new ReadExcelSheet(excelPath);
//		int rowCount = excelObj.getRowCount(0);
		
		B24MyReadUtility excelUtility = new B24MyReadUtility (excelPath,0);
		int rowCount =excelUtility.getLastRowNum();
		int colCount = excelUtility.getLastColNum();	
		System.out.println();						
//		ReadExcelSheet excelObj = new ReadExcelSheet(excelPath);
//		int rowCount = excelObj.getRowCount(0);
		
		Object[][] data = new Object[rowCount][colCount];
		for(int i=0;i<rowCount;i++ ){		
			for(int j=0;j<colCount;j++ ) {
				data[i][j]=excelUtility.getcellvalue(0,i, j);	
			}	
		}
		return data;
	}
	
	
}









