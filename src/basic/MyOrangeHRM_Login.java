package basic;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyOrangeHRM_Login {
	
	
	MyOrangeHRM obj = new MyOrangeHRM();
	MyOrangeHRMOperations update = new MyOrangeHRMOperations();

//	@Test (priority = 0)
	public void login() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		boolean testresult = true;
		String errormessage = null;	
		try {		
			obj.setAdminname("Admin");
			obj.setAdminpwd("admin123");
			update.fillDetails_admin(driver, obj);
			Thread.sleep(100);
			Reporter.log("Login successful");
			
		}
		catch (Exception e) {
			testresult = false;
			errormessage = "Login failed";		
		}
		
		Assert.assertTrue(testresult, errormessage);
		driver.quit();
	}

	//@Test (priority = 1)
	public void login_invaliduser() throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		boolean testresult = true;
		String errormessage = null;	
		try {		
			obj.setAdminname("Admin1");
			obj.setAdminpwd("admin123");
			update.fillDetails_admin(driver, obj);
			Thread.sleep(100);
			driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed();
			errormessage = "Login with invalid user is restricted";	
			Reporter.log("Login with invalid user is restricted");
		}
		catch (Exception e) {
			testresult = false;
			errormessage = "Login failed";		
		}
		
		Assert.assertTrue(testresult, errormessage);
		driver.quit();
	}
	
	@Test(priority = 2)
	public void searchCandidate() throws InterruptedException {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		boolean testresult = true;
		String errormessage = null;
		
		try {
			obj.setAdminname("Admin");
			obj.setAdminpwd("admin123");
			update.fillDetails_admin(driver, obj);
			driver.findElement(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
//			driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
//			driver.findElement(By.xpath("//span[text()='Senior QA Lead']")).click();
			

		
		List<WebElement> ele1  = driver.findElements(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//label[@class = 'oxd-label']"));
		for(int i =0;i<ele1.size();i++) {
			int count = 1;
			System.out.println("val "+ ele1.get(i).getText());
			if(ele1.get(i).getText().equals("Vacancy")) {
				count ++;
				driver.findElement(By.xpath("(//div[@class = 'oxd-select-text-input'])["+count+"]")).click();
				driver.findElement(By.xpath("//span[text()='Senior QA Lead']")).click();
			}
		}
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
		}
		catch (Exception e) {
			testresult = false;
			errormessage = "New data update failed";		
		}
		Assert.assertTrue(testresult, errormessage);
	}	
	
	//@Test(priority = 3)
	public void addCandidate() throws InterruptedException {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		boolean testresult = true;
		String errormessage = null;
		
		try {
			obj.setAdminname("Admin");
			obj.setAdminpwd("admin123");
			update.fillDetails_admin(driver, obj);
			obj.setEmpfname("Pradyumna");
			obj.setEmpmname("Bhalchandra");
			obj.setEmplname("Dole");
			update.fillDetails(driver,obj);
			driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
			driver.findElement(By.xpath("//span[text()='Senior QA Lead']")).click();
		
			driver.findElement(By.xpath("//label[text()='Email']")).click();
			
		}
		catch (Exception e) {
			testresult = false;
			errormessage = "New data update failed";		
		}
		Assert.assertTrue(testresult, errormessage);
	}	

}
