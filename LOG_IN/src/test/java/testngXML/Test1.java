package testngXML;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Test1 {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;

	WebDriver driver = null;
	static String actual_title = "Bangladesh Army";
	static By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");

	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extenttestng.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();		
	}
	@Test
	public void loginpass() {
		ExtentTest test1 = extent.createTest("Login Test1", "Login Test with TestNG");
		driver.get("http://192.168.0.18:4999/");
		test1.info("Get URL Successfully");
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		test1.pass("Username Pass");
		driver.findElement(By.xpath("//input[@type='password']")).click();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@user");
		test1.pass("Password Pass Successfully");
		driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();	
		test1.pass("Sign In Pass");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bangladesh Army')]")));
		String expected_title = driver.findElement(Bangladesh_army).getText();
		System.out.println(expected_title);
		if(expected_title.equals(actual_title)){
			System.out.println("Sign in pass");
		}else {
			System.out.println("Sign in fail");
		}
		test1.info("Completed Successfully");
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
