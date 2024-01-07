package datadriven;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MyDataDrivenScript1 {
	
	WebDriver driver ;
	
	@DataProvider(name="AnilsDataProvider")
	public Object[][] getData(){
		Object[][] data = new Object[4][2];
		
			data[0][0]= "admin";
			data[0][1]= "pwd";

			data[1][0]= "admin1";
			data[1][1]= "pwd";

			data[2][0]= "admin2";
			data[2][1]= "pwd";
	
			data[3][0]= "user";
			data[3][1]= "pwd22";
			
		return data;
	}
	
	@Test(dataProvider="AnilsDataProvider")
	public void loginToFacebook(String username, String password){
		
		System.out.println("Name "+username);
		System.out.println("pwd "+password);

	}
	

}
