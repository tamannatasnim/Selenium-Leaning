package testngXML;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Test6 {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;
	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extenttestng.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}
	@Test
	public void incorrectpassword() {
		ExtentTest test6 = extent.createTest("Login Test6", "Login Test with TestNG");
		driver.get("http://192.168.0.18:4999/");
		String username3 = "";
		String password3 = "";
		String messagedefine = "User name or password can't be blank.";
		try {
			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username3);
			test6.pass("Username Pass");

			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password3);
			test6.pass("Password Pass Successfully");

			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
			test6.pass("Sign In Pass");
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
			String toast_title = driver.findElement(By.className("title")).getText();
			String toast_messaage = driver.findElement(By.className("message")).getText();
			System.out.println("The title of the toast message: "+toast_title);
			System.out.println("The title of the toast message: "+toast_messaage);
			Assert.assertEquals(toast_title, "error");
			Assert.assertEquals(toast_messaage, messagedefine );
			if (toast_messaage.equals(messagedefine))
			{
				System.out.println( "Login fail: Test Passed") ;
			}
			else {
				System.out.println( "Login success: Test Failed" );
			}
		}catch(NoSuchElementException e) {
			//System.out.println("Can't click");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}
		test6.info("Completed Successfully");

	}
	@Test
	public void validlogin() {
		ExtentTest test7 = extent.createTest("Login Test7", "Login Test with TestNG");
		driver.get("http://192.168.0.18:4999/");
		String username3 = "Admin";
		String password3 = "Admin@user";
		String actual_title = "Bangladesh Army";
		By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");
		try {
			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username3);
			test7.pass("Username Pass");

			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password3);
			test7.pass("Password Pass Successfully");

			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bangladesh Army')]")));
			String expected_title = driver.findElement(Bangladesh_army).getText();
			System.out.println(expected_title);
			if(expected_title.equals(actual_title)){
				System.out.println("Sign in pass");
			}else {
				System.out.println("Sign in fail");
			}
		}catch(NoSuchElementException e) {
			//System.out.println("Can't click");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}
		test7.info("Completed Successfully");

	}
	@AfterTest
	public void teardown1() {
		driver.close();

	}
	@AfterSuite
	public void teardown() {

		// calling flush writes everything to the log file
		extent.flush();

	}
}
