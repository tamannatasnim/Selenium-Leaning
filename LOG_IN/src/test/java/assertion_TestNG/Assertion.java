package assertion_TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Assertion {

	WebDriver driver = null;
	@BeforeClass
	void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	@Test (priority = 1)
	void logo() {
		WebElement logog = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/img[1]"));
		//Expection google logo will show
		Assert.assertTrue(logog.isDisplayed(), "Logo is not displaying"); //If the assertion fail this message will show Logo is not displaying.

		//Expection google logo will not show
		//Assert.assertFalse(logog.isDisplayed(),  "Logo is displaying");
	}
	@Test  (priority = 2)
	void title_verify() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google");
	}
	@AfterClass
	void teardown() {
		driver.close();
	}
}
