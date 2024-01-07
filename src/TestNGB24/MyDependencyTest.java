package TestNGB24;

import org.testng.annotations.Test;
import org.testng.Assert;

public class MyDependencyTest {
	
	@Test
	public void mySetup() throws InterruptedException{
		System.out.println(" in setup ");
		Assert.assertTrue(true);
		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods={"mySetup"})
	public void test1() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("my test method");
	}
	
	@Test(dependsOnMethods={"mySetup"})
	public void test2() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("my test method");
	}
}
