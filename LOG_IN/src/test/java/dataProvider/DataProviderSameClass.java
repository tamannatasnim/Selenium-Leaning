package dataProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DataProviderSameClass {
	
	WebDriver driver = null;
	static By username = By.xpath("//input[@type='text']");
	static By password = By.xpath("//input[@type='password']");
	static By signin = By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]");
	static String actual_title = "Bangladesh Army";
	static By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");
	static String message_define = "Valid Username and password are required.";
	static String toast_title = "error";
	static String messagedefineforinvapass = "User name or password can't be blank.";
	@Test(dataProvider ="LoginDataProvide1", dataProviderClass = DataProvidedFrom.class)
	public void loginTest1(String username1, String password1) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
		driver.findElement(username).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(signin).click();
		Thread.sleep(500);
		String expected_title = driver.findElement(Bangladesh_army).getText();
		System.out.println(expected_title);
		if(expected_title.equals(actual_title)){
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}
		driver.close();
	}
	@Test (dataProvider ="LoginDataProvide2", dataProviderClass = DataProvidedFrom.class)
	public void invalidloginTest23(String username2, String password2) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
		driver.findElement(username).sendKeys(username2);
		driver.findElement(password).sendKeys(password2);
		driver.findElement(signin).click();
		Thread.sleep(500);
		String toast_messaagenew = driver.findElement(By.className("message")).getText();
		System.out.println("The message is: "+toast_messaagenew);
		Assert.assertEquals(toast_messaagenew, message_define );
		if (toast_messaagenew.equals(message_define))
		{
			System.out.println( "Login fail 2 / 3 : Test Passed") ;
		}
		else {
			System.out.println( "Login success  2 / 3 : Test Failed" );
		}
		driver.close();
	}
	@Test (dataProvider ="LoginDataProvide3", dataProviderClass = DataProvidedFrom.class)
	public void invalidloginTest456(String username3, String password3) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
		driver.findElement(username).sendKeys(username3);
		driver.findElement(password).sendKeys(password3);
		driver.findElement(signin).click();
		Thread.sleep(500);
		String toast_title = driver.findElement(By.className("title")).getText();
		String toast_messaage = driver.findElement(By.className("message")).getText();
		System.out.println("The title of the toast message: "+toast_title);
		System.out.println("The message is: "+toast_messaage);
		Assert.assertEquals(toast_title, toast_title);
		Assert.assertEquals(toast_messaage, messagedefineforinvapass );
		if (toast_messaage.equals(messagedefineforinvapass))
		{
			System.out.println( "Login fail 4 / 5 / 6 : Test Passed") ;
		}
		else {
			System.out.println( "Login success  4 / 5 / 6 : Test Failed" );
		}
		driver.close();
	}
}
