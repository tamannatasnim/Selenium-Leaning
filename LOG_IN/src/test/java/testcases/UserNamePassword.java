package testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Username;

public class UserNamePassword {
	WebDriver driver = null;
	
	@BeforeMethod
	public void beforetestmethods() {
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
	}
	@AfterMethod
	public void aftertestmethods() {
		driver.close();
	}	
	@Test (priority = 1)
	public void logininvalidusername() throws InterruptedException {
		Username object = new Username(driver);
		object.username("Admin1");
		object.password("Admin@user");
		object.signin_click();
		object.toast_messaageclass();
	}
	@Test (priority = 2)
	public void logininvalidpassword() throws InterruptedException {
		Username object = new Username(driver);
		object.username("Admin");
		object.password("Admin@usr");
		object.signin_click();
		object.toast_messaageclass();
	}

}
