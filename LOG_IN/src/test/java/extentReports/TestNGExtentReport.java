package extentReports;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestNGExtentReport {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentDB;
	static WebDriver driver =null;
	static String actual_title = "Bangladesh Army";
	static By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");
	//Before and After suite used for multiple test (if we have multiple test then those will run only once
	@BeforeSuite 
	public void setup() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extent1.html");
		// create ExtentReports and attach reporter(s)
		extentDB = new ExtentReports();
		extentDB.attachReporter(htmlReporter);
	}
	@BeforeTest
	public static void SetUPTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void finalTest() throws IOException {
		ExtentTest testDB = extentDB.createTest("Login Test", "Login Test with TestNG");
		// log(Status, details)
		testDB.log(Status.INFO, "Starting TestCase");

		driver.get("http://192.168.0.18:4999/");
		testDB.pass("Sucessfully negivated into BD Army UI");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		testDB.pass("Enter username pass");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@user");
		testDB.pass("Enter password pass");

		driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
		testDB.pass("Click sign In");

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bangladesh Army')]")));
		String expected_title = driver.findElement(Bangladesh_army).getText();
		System.out.println(expected_title);
		if(expected_title.equals(actual_title)){
			System.out.println("Sign in pass");
		}else {
			System.out.println("Sign in fail");
		}
		// info(details)
		testDB.info("This step shows usage of info(details)");
		driver.close();
	}

	@Test
	public void finalTestfail() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		ExtentTest testDB1 = extentDB.createTest("Login Test 2", "Login Test with TestNG");
		// log(Status, details)
		testDB1.log(Status.INFO, "Starting TestCase");
		driver.get("http://192.168.0.18:4999/");
		testDB1.pass("Sucessfully negivated into BD Army UI");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		testDB1.pass("Enter username pass");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Admin@u");
		testDB1.fail("Enter password pass");
		driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();
		testDB1.pass("Click sign In");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Bangladesh Army')]")));
		String expected_title = driver.findElement(Bangladesh_army).getText();
		System.out.println(expected_title);
		if(expected_title.equals(actual_title)){
			System.out.println("Sign in pass");
		}else {
			System.out.println("Sign in fail");
		}
		//info(details)
		testDB1.info("This step shows usage of info(details)");
	}
	@AfterSuite
	public void teardown() {
		// calling flush writes everything to the log file
		extentDB.flush();

	}
}
