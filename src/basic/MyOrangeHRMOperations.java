package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyOrangeHRMOperations {
	
	
	public void fillDetails_admin(WebDriver driver, MyOrangeHRM obj) {
		
		if (obj.getAdminname()!=null) {
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(obj.getAdminname());
		}
		
		if (obj.getAdminpwd()!=null) {
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(obj.getAdminpwd());
		}
		driver.findElement(By.xpath("//div//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
		
	}		
		
	public void fillDetails(WebDriver driver,MyOrangeHRM obj) {	
		
		driver.findElement(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")).click();
		
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		
		if (obj.getEmpfname()!=null) {
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(obj.getEmpfname());
		}
		
		if (obj.getEmpmname()!=null) {
			driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys(obj.getEmpmname());
		}
		
		if (obj.getEmplname()!=null) {
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(obj.getEmplname());
		}
		
	}
	

}
