package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyEncapsulationOperation {
	
	public void filldata (MyTestFormEncapsulation obj) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		if (obj.getFname()!=null) {
			driver.findElement(By.xpath("//div/input[@placeholder = 'First Name']")).sendKeys(obj.getFname());
		}
		
		if (obj.getLname()!=null) {
			driver.findElement(By.xpath("//div/input[@placeholder = 'Last Name']")).sendKeys(obj.getLname());
		}
		
		if (obj.getAddress()!=null) {
			driver.findElement(By.xpath("//textarea[@ng-model ='Adress']")).sendKeys(obj.getAddress());	
		}
		
		if (obj.getEmail()!=null) {
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(obj.getEmail());	
		}
		
		if (obj.getMobno()!=null) {
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(obj.getMobno());
		}
		
		if (obj.getGender()!=null) {
			if(obj.getGender()=="Male") {
				driver.findElement(By.xpath("//input[@value='Male']")).click();
			}else {
				driver.findElement(By.xpath("//input[@value='FeMale']")).click();
			}	
		}
		
		if (obj.getCountry()!=null) {
			driver.findElement(By.xpath("//select[@id='country']//option[@value ='"+obj.getCountry()+"']")).click();	
		}
		
		if (obj.getSkills()!=null) {
			
			WebElement element =	driver.findElement(By.xpath("//select[@id='Skills']"));
			Select select = new Select(element);
			select.selectByVisibleText(obj.getSkills());
			//driver.findElement(By.xpath("//option[@value ='"+obj.getSkills()+"']")).click();
	
		}
		
		if (obj.getHobby11()!=null) {
			driver.findElement(By.xpath("//input[@value='"+obj.getHobby11()+"']")).click();
		}
		
		if (obj.getHobby22()!=null) {
			driver.findElement(By.xpath("//input[@value='"+obj.getHobby22()+"']")).click();
		}
		
		if (obj.getHobby33()!=null) {
			driver.findElement(By.xpath("//input[@value='"+obj.getHobby33()+"']")).click();
		}
		driver.quit();
		
	}

}
