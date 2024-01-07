package TestNGB24;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class ParallelMethod {
	
	@Test
	public void myTest1() throws InterruptedException{
		System.out.println("Class : I am in test 1");
		Thread.sleep(10000);
	}
	
	@Test
	public void myTest2() throws InterruptedException{
		System.out.println("Class :  I am in test 2");
		Thread.sleep(10000);
	}
	
	@Test
	public void myTest3() throws InterruptedException{
		System.out.println("Class :  I am in test 3");
		Thread.sleep(10000);
	}
	
	@Test
	public void myTest4() throws InterruptedException{
		System.out.println("Class :  I am in test 4");
		Thread.sleep(10000);
	}
	@Test
	public void myTest5() throws InterruptedException{
		System.out.println("Class :  I am in test 5");
		Thread.sleep(10000);
	}

}
