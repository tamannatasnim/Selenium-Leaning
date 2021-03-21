package testcases;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Username;

public class TestCases {
	static WebDriver driver = null;
	@BeforeTest
	public void setup1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test (priority = 1)
	public static void login_pass() throws InterruptedException{

		Username object_login = new Username(driver);

		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("Admin");
			object_login.password("Admin@user");
			object_login.signin_click();
			object_login.verify_login();
		}catch(NoSuchElementException exp) {
			exp.getMessage(); 
		}
		driver.close();
	}
	@Test (priority = 2)
	public static void invalid_usernamecase() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Username object_login = new Username(driver);
		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("Admin1");
			object_login.password("Admin@user");
			object_login.signin_click();
			object_login.toast_messaageclass();
		}catch(NoSuchElementException exp) {
			exp.getMessage();
		}
		driver.close();
	}
	@Test (priority = 3)
	public static void invalid_passwordcase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Username object_login = new Username(driver);
		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("Admin");
			object_login.password("Admin@372");
			object_login.signin_click();
			object_login.toast_messaageclass();
		}catch(NoSuchElementException exp) {
			exp.getMessage();
		}
		driver.close();
	}
	@Test (priority = 4)
	public static void invalid_withoutusernamecase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Username object_login = new Username(driver);
		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("");
			object_login.password("Admin@user");
			object_login.signin_click();
			object_login.tstwithoutup();
		}catch(NoSuchElementException exp) {
			exp.getMessage();
		}
		driver.close();
	}
	@Test (priority = 5)
	public static void invalid_withoutpasswordcase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Username object_login = new Username(driver);
		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("Admin");
			object_login.password("");
			object_login.signin_click();
			object_login.tstwithoutup();
		}catch(NoSuchElementException exp) {
			exp.getMessage();
		}
		driver.close();
	}
	@Test (priority = 6)
	public static void bothfieldblankcase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Username object_login = new Username(driver);
		driver.get("http://192.168.0.18:4999/");
		try {
			object_login.username("");
			object_login.password("");
			object_login.signin_click();
			object_login.tstwithoutup();
		}catch(NoSuchElementException exp) {
			exp.getMessage();
		}
		driver.close();
	}
}

