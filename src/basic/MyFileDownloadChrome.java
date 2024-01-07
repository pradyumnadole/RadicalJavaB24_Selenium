package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MyFileDownloadChrome {
	
	@Test
	public void myDownload() throws InterruptedException, FileNotFoundException {
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "D:\\RadicalSelenium");

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");
		options.addArguments("--disable-extensions"); // to disable browser extension popup
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);

		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");

		driver.findElement(By.xpath("//a[contains(text(),'Download Text File')]")).click();// Download Text File
		Thread.sleep(5000);

		File file = new File ("D:\\RadicalSelenium\\Testing Text.txt");
		
		Scanner sc = new Scanner(file);
		
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println("Content of file is: " +line);
			
		}
		sc.close();
		
		driver.findElement(By.xpath("//a[contains(text(),'Download PDF File')]")).click();// Download PDF File
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Download CSV File')]")).click();// Download CSV File
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Download Excel File')]")).click();// Download Excel File
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Download Doc File')]")).click();// Download Doc File
		Thread.sleep(5000);
		
		driver.quit();

		//form//tr//td[contains(text(),'Tata Asset Management Ltd.')]
		//td[contains(text(),'7.07')]
		//*[@id="leftcontainer"]/form/table/tbody/tr[5]/td[1]
	}
	
	

}
