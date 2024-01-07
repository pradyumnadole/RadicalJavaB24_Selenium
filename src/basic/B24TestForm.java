package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class B24TestForm {

	/***
	 * 
	 * Description of Test case
	 */
	@Test
	public void testCase1() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		
		boolean testresult = true;
		String errormessage = null;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			driver.findElement(By.xpath("//div/input[@placeholder = 'First Name']")).sendKeys("Pradyumna");
		} catch (Exception e) {
			testresult = false;
			errormessage = errormessage +" First Name is not present";
		}
		
		try {
			
			driver.findElement(By.xpath("//div/input[@placeholder = 'Middle Name']")).sendKeys("Bhalchandra");
		} catch (Exception e) {
			testresult = false;
			errormessage = errormessage +" Middle Name is not present";
		}
		
		try {
			
			driver.findElement(By.xpath("//div/input[@placeholder = 'Last Name']")).sendKeys("Dole");
		} catch (Exception e) {
			testresult = false;
			errormessage = errormessage +" Last Name is not present";
		}
		
		
		try {
			
			driver.findElement(By.xpath("//textarea[@ng-model ='Adress']")).sendKeys("Sinhagad Road");
		} catch (Exception e) {
			testresult = false;
			errormessage = errormessage +" Address is not present";
		}
		
		//1st way of xpath for skills
//		try {
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//select[@id='Skills']")).click();
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//select[@id='Skills']/option[text()='Android']")).click();
//		} catch (Exception e) {
//			testresult = false;
//			errormessage = errormessage +" Skills is not present";
//		}
		
		//2nd way of xpath for skills
		try {
		
		WebElement element =	driver.findElement(By.xpath("//select[@id='Skills']"));
		
		Select select = new Select(element);
		select.selectByVisibleText("Android");
		} catch (Exception e) {
			testresult = false;
			errormessage = errormessage +" Skills is not present";
		}
		
		Assert.assertTrue(testresult, errormessage); //TestNG assertion way
		
		
		
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys("pd@gmail.com");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys("9923004051");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div//input[@value='Male']")).click();
//		Thread.sleep(1000);	
//		boolean result = driver.findElement(By.xpath("//div//input[@value='Cricket']")).isSelected();
//		if(result) {
//			driver.findElement(By.xpath("//div//input[@value='Cricket']")).click();
//		}else {
//			System.out.println("check box is already unchecked");
//		}		
//		driver.findElement(By.xpath("//select//option[@value ='AutoCAD']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@id='country']//option[@value ='India']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@type='text']//option[@value ='1987']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@type='text']//option[@value ='September']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//select[@type='text']//option[@value ='22']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div//input[@onblur='validatepattern(this)']")).sendKeys("Pradyumna");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div//input[@onblur='validatepasswords(this)']")).sendKeys("Pradyumna");
		
		//driver.close(); //always closes current window/browser
//		driver.quit(); // close all launched during this current window/browser
		
//      driver.findElements(By.xpath("//li//a[@class='ui-corner-all']")).
//		driver.findElement(By.xpath("//div[(@id='msdd')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
//		driver.findElement(By.xpath("//div[(@id='msdd')]")).click();
//		List<WebElement> allProduct = driver.findElements(By.xpath("//li//a[@class='ui-corner-all']"));
//		for( WebElement product : allProduct){	
//			System.out.println(product.getText());	
//			System.out.println("***************");
//			System.out.println(product.getSize());
//
//		}			
//		 WebElement d= driver.findElement(By.xpath("//div//li[@class ='ng-scope']"));
//		  //object of Select class
//	      Select s=new Select(d);
//	      //get options of dropdown in list
//	     // List t =s.getOptions();
//	      System.out.println("Options are: ");
//	      for (WebElement i: s.getOptions()){
//	         System.out.println(i.getText());
//	      }
//	      //return true if multi-select dropdown
//	      Boolean b=s.isMultiple();
	}
	
}
