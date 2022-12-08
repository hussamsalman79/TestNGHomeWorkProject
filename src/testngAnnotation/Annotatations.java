package testngAnnotation;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotatations {
	
	@BeforeTest
	public void setup() {
		System.out.println("Before test set up");
	
	}
	
	@AfterTest
	public void teardown() {
		System.out.println("After test tear down");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("Before Method");
		
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		
	}
	@Test(priority=4)
	public void test1() {
		System.out.println("Test Case 1");
		
	}
	@Test(priority=3)
	public void test2() {
		System.out.println("Test Case 2");
	}
	@Test(priority=2)
	public void test3() {
		System.out.println("Test Case 3");
	}
	@Test(priority=1, description = "This is for testing the priority order")
	public void test4() {
		System.out.println("Test Case 4");
	}
	

}
