package basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B24MyAlert {

	@Test
	public void testCase1() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick ='alertbox()']")).click();
		
		//Alert
		Alert alert = driver.switchTo().alert();
		String currentmsg = alert.getText();
		String expectedmsg = "I am an alert box!";
		Assert.assertEquals(currentmsg, expectedmsg);
		alert.accept();
		
		//Confirmation
		driver.findElement(By.xpath("//div//a[text()= 'Alert with OK & Cancel ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick ='confirmbox()']")).click();
		Alert alert1 = driver.switchTo().alert();
		String currentmsg1 = alert1.getText();
		String expectedmsg1 = "Press a Button !";
		Assert.assertEquals(currentmsg1, expectedmsg1);
		//alert1.accept();
		alert1.dismiss();
		
		//Textbox
		driver.findElement(By.xpath("//div//a[text()= 'Alert with Textbox ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick ='promptbox()']")).click();
		Alert alert2 = driver.switchTo().alert();
		String currentmsg2 = alert1.getText();
		String expectedmsg2 = "Please enter your name";
		Assert.assertEquals(currentmsg2, expectedmsg2);
		Thread.sleep(2000);
		alert1.sendKeys("Pradyumna");
		Thread.sleep(2000);
		alert1.accept();
		
		String textu= driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		System.out.println(textu);
		
		String expectedtext = "Hello Pradyumna How are you today";
		Assert.assertEquals(textu, expectedtext);
		driver.quit();
		
		
		
		
		
		
		
		
		
	}
	
}
