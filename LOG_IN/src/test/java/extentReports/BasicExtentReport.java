package extentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicExtentReport {
	static WebDriver driver = null;
	public static void main(String[]args) {
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("basicextent.html");
		// create ExtentReports and attach reporter(s)
		ExtentReports extentDB = new ExtentReports();
		extentDB.attachReporter(htmlReporter);
		//create a toggle for the the, add test case name and test case description
		ExtentTest testDB = extentDB.createTest("Login Pass","We are in the BD Army Website successfully");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		testDB.log(Status.INFO, "Starting TestCase");
		driver.get("http://192.168.0.18:4999/");
		testDB.pass("Sucessfully negivated into BD Army UI");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		testDB.pass("Enter username pass");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@user");
		testDB.pass("Enter password pass");
		driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
		testDB.pass("Sign in pass");
		driver.close();
		testDB.pass("Close brower pass");
		testDB.info("Test completed");
		//create a toggle for the the, add test case name and test case description
		ExtentTest testDB2 = extentDB.createTest("Login Fail","We are not in the BD Army Website");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		testDB2.log(Status.INFO, "Starting TestCase");
		driver.get("http://192.168.0.18:4999/");
		testDB2.pass("Sucessfully negivated into BD Army UI");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		testDB2.pass("Enter username pass");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@user");
		testDB2.pass("Enter password pass");
		driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
		testDB2.fail("Sign in pass");
		driver.close();
		testDB2.pass("Close brower pass");
		testDB2.info("Test fail");
		// calling flush writes everything to the log file
		extentDB.flush();

	}

}
