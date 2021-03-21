package testng_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Methods {
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class annotation is executed before the test Methods in a current class");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("After class annotation is executed after the test Methods in a current class");
	}
	@BeforeMethod
	public void beforetestmethod() {
		System.out.println("Before method annotation  will executes before every test cases");
	}
	@AfterMethod
	public void aftertestmethod() {
		System.out.println("After method annotation  will executes after every test cases");
	}
	@Test
	public void testcase1() {
		System.out.println("First test case");
	}
	@Test
	public void testcase2() {
		System.out.println("Second test case");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test annotation is executed before the class (Methods) first before any test belonging to that folder.");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test annotation is executed after the class (Methods) exists at the end");
	}
}
