package basic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import org.testng.Assert;

public class MySeleniumAssignment_Test {

	 @Test
	public void testCase1() throws Exception {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean testresult = true;
		String errormessage = null;

		String[] mystrarray = new String[4];
		mystrarray[0] = "C++";
		mystrarray[1] = "Android";
		//mystrarray[2] = "Pradyumna"; //tested for negative case as well
		mystrarray[2] = "Java";
		mystrarray[3] = "SQL";

	
		
			try {	
				WebElement element = driver.findElement(By.xpath("//select[@id='Skills']"));
				Select sel = new Select(element);
				for (int i = 0; i < mystrarray.length; i++) {
					sel.selectByVisibleText(mystrarray[i]);
					System.out.println("TestCase1 - Skill is present on Test Form " + mystrarray[i]);				
			}
			}
			 catch (Exception e) {
				testresult = false;
				errormessage =  "TestCase1 - skill is not present ";		
			}
			driver.quit();
			Assert.assertTrue(testresult, errormessage);
		}

	 @Test
	public void testCase2() throws Exception {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String[] mystrarray1 = new String[2];
		mystrarray1[0] = "SeleniumAutomation";
		// mystrarray1[0] = "Java";//tested for negative case as well
		mystrarray1[1] = "CucucmberAutomation";

		boolean testresult = true;
		String errormessage = null;

		for (int i = 0; i < mystrarray1.length; i++) {
			try {
				WebElement element = driver
						.findElement(By.xpath("//select[@id='Skills']//option[@value ='" + mystrarray1[i] + "']"));
				if (element.isDisplayed()== false) {
					System.out.println("TestCase2 - skill is not present  " + mystrarray1[i]);
				}
			} catch (Exception e) {
				testresult = false;
				System.out.println(errormessage = "TestCase2 - skill is not present " + mystrarray1[i]);
			}
		}
		driver.quit();
		Assert.assertFalse(testresult, errormessage);
	}

	@Test
	public void testCase3() throws Exception {
		MyEncapsulationOperation formdata = new MyEncapsulationOperation();
		MyTestFormEncapsulation obj = new MyTestFormEncapsulation();
		boolean testresult = true;
		String errormessage = null;
		

		try {
			obj.setFname("Ramesh");
			Thread.sleep(2000);
			obj.setLname("Pande");
			Thread.sleep(2000);
			obj.setAddress("Sydney");
			Thread.sleep(2000);
			obj.setEmail("abcd@gmail.com");
			Thread.sleep(2000);
			obj.setMobno("9956897009");
			Thread.sleep(2000);
			obj.setGender("Male");
			Thread.sleep(2000);
			obj.setHobby22("Movies"); // multiple hobbies selected by creating setter n getter
			Thread.sleep(2000);
			obj.setHobby11("Cricket");
			Thread.sleep(2000);
			obj.setHobby33("Hockey");
			Thread.sleep(2000);
			obj.setSkills("C");
			Thread.sleep(2000);
			obj.setCountry("Australia");
			Thread.sleep(2000);
			formdata.filldata(obj);
			Thread.sleep(2000);
		} catch (Exception e) {
			testresult = false;
			errormessage = "Values are not filled correctly";
		}
		Assert.assertTrue(testresult, errormessage);

	}

	 @Test
	public void testCase4() throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		boolean testresult = true;
		String errormessage = null;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			driver.findElement(By.xpath("//div[@id='msdd']")).click();
			String [] mystr = new String [3];
			mystr [0] = "Arabic";
			mystr [1] = "English";
			mystr [2] = "Dutch";
			Thread.sleep(2000);
			for (int i =0 ;i < mystr.length;i++) {
				driver.findElement(By.xpath("//a[text()='"+mystr [i]+"']")).click();	
			}
			Thread.sleep(2000);
			WebElement ele1 = driver.findElement(By.xpath("//div[@id='msdd']"));
			System.out.println(ele1.getText());
			if (ele1.getText().contains("Arabic") && ele1.getText().contains("English")
					&& ele1.getText().contains("Dutch")) {
				System.out.println("Testcase4 - Multiple languages are selected");
			}
		} catch (Exception e) {
			testresult = false;
			System.out.println("Testcase4 - Multiple languages are not selected");
		}

		driver.quit();
		Assert.assertTrue(testresult, errormessage);

	}

	@Test
	public void testCase5 () {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		boolean testresult = true;
		String errormessage = null;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			String expstr = null;
			String currentstr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1245648971000qqwrrdxx44466@@!!!7789jjfffd";
			
			driver.findElement(By.xpath("//textarea[@ng-model ='Adress']")).sendKeys(currentstr);	
			
			expstr = driver.findElement(By.xpath("//textarea[@ng-model ='Adress']")).getAttribute("value");
			System.out.println(expstr);
			if(currentstr.equals(expstr)) {
			System.out.println("Testcase5 -Given address is same as displayed address ");	
			}	
			else {
				testresult =false;
				errormessage ="Testcase5 -Given address is different than displayed address ";
				System.out.println(errormessage);	
			}
		} catch (Exception e) {
			//
		}

		driver.quit();
		Assert.assertTrue(testresult, errormessage);
		
	}
	
	
}
