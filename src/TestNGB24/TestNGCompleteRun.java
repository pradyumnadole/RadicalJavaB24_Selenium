package TestNGB24;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGCompleteRun {
	
	
	
	@BeforeClass
	public void myBeforeClass(){
		System.out.println("I am in before class");
	}
	
	@BeforeMethod
	public void startBrowser(){
		System.out.println("I am in before method");
	}
	
	@BeforeSuite
	public void myBeforeSuite(){
		System.out.println("I am in before suite");
	}
	
	@BeforeTest
	public void myBeforeTest(){
		System.out.println("I am in before Test");
	}
	
	@Test	
	public void test1(){
		System.out.println("I am in Test 1");
	}
	
	@Test	
	public void test2(){
		System.out.println("I am in Test 2");
	}
	@AfterSuite
	public void myAfterSuite(){
		System.out.println("I am in after suite");
	}
	
	@AfterTest
	public void myAfterTest(){
		System.out.println("I am in after Test");
	}
	
	@AfterClass
	public void myAfterClass(){
		System.out.println("I am in after class");
	}
	
	@AfterMethod
	public void closeBrowser(){
		System.out.println("I am in after method");
	}

}
