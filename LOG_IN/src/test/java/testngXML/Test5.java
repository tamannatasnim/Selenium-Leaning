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

public class Test5 {
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
	public void clickwithoutPassword() {
		ExtentTest test5 = extent.createTest("Login Test5", "Login Test with TestNG");
		driver.get("http://192.168.0.18:4999/");
		String username = "Admin";
		String messagedefine = "User name or password can't be blank.";
		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
			test5.pass("Username Pass");

			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
			test5.fail("Sign In Pass");
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));

			String toast_title = driver.findElement(By.className("title")).getText();
			System.out.println(toast_title);
			String toast_messaage = driver.findElement(By.className("message")).getText();
			System.out.println(toast_messaage);

			System.out.println("The title of the toast message: "+toast_title);
			System.out.println("The message is: "+toast_messaage);
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
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}
		test5.info("Completed Successfully");

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
