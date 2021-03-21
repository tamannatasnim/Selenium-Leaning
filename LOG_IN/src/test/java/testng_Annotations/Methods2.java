package testng_Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Methods2 {
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
	public void testcase3() {
		System.out.println("Third test case");
	}
	@Test
	public void testcase4() {
		System.out.println("Fourth test case");
	}
	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before suite annotation is executed before the execution of all the test cases defined in the folder.");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("After suite annotation is executed after the execution of an XML file.");
		System.out.println("The @BeforeSuite annotation is used to set up or start the selenium drivers while the @AfterSuite annotation is used to stop the selenium web drivers.");
	}
	
	

}
