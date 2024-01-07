package TestNGB24;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

public class PriorityTest {
	
	String userName;
	
	@Test (priority =1)
	public void login(){
		System.out.println("I am in test login");
	}
	
	@Test (priority =2)
	public void createU(){
		System.out.println("I am in test createU");
		Assert.assertTrue(false);
	}
	
	@Test (priority =3)
	public void deleteU(){
		System.out.println("I am in test deleteU");
	}
	
	@Test (priority =3)
	public void createG(){
		System.out.println("I am in test createG");
	}
	
	@Test (priority = 5)
	public void deletegroup(){
		System.out.println("I am in test delete grp");
	}
	
	

}
