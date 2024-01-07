package TestNGB24;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClassA {
	
	@Test
	public void myTest1() throws InterruptedException{
		System.out.println("ClassA : I am in test 1");
		Thread.sleep(10000);
		AssertJUnit.assertTrue(false);
	}
	
	@Test
	public void myTest2() throws InterruptedException{
		System.out.println("ClassA :  I am in test 2");
		Thread.sleep(10000);
	}
	
	@Test
	public void myTest22() throws InterruptedException{
		System.out.println("ClassA :  I am in test 22");
		Thread.sleep(10000);
	}

}
