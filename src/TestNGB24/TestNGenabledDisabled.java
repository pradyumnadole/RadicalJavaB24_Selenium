package TestNGB24;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestNGenabledDisabled {
	
	
	@Test(enabled=false)
	public void myTest1(){
		System.out.println("I am in test 1");
	}
	
	@Test(enabled=true)
	public void myTest2(){
		System.out.println("I am in test 2");
	}
	
	@Test()
	public void myTest3(){
		System.out.println("I am in test 3");
	}
	

	
	
}
