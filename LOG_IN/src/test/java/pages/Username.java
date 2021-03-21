package pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class Username {
	static WebDriver driver = null;
	static By username = By.xpath("//input[@type='text']");
	static By password = By.xpath("//input[@type='password']");
	static By signin = By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]");
	static String actual_title = "Bangladesh Army";
	static By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");
	static String message_define = "Valid Username and password are required.";
	static String toast_title = "error";
	static String messagedefineforinvapass = "User name or password can't be blank.";

	public Username(WebDriver driver) {
		this.driver = driver;	
	}
	public static void username(String usernametext) throws InterruptedException {
		driver.findElement(username).sendKeys(usernametext);
		Thread.sleep(500);
	}
	public static void password(String passwordtext) throws InterruptedException {
		driver.findElement(password).sendKeys(passwordtext);
		Thread.sleep(500);
	}
	public static void signin_click() throws InterruptedException {
		driver.findElement(signin).click();	
		Thread.sleep(500);
	}
	public static void verify_login() {
		String expected_title = driver.findElement(Bangladesh_army).getText();
		System.out.println(expected_title);
		if(expected_title.equals(actual_title)){
			System.out.println("Test pass");
		}else {
			System.out.println("Test fail");
		}	
	}
	public static void toast_messaageclass(){
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated((By) (driver.findElement(By.className("message")))));
		String toast_messaagenew = driver.findElement(By.className("message")).getText();
		System.out.println(toast_messaagenew);
		System.out.println("The message is: "+toast_messaagenew);
		Assert.assertEquals(toast_messaagenew, message_define );
		if (toast_messaagenew.equals(message_define))
		{
			System.out.println( "Login fail 2 / 3 : Test Passed") ;
		}
		else {
			System.out.println( "Login success  2 / 3 : Test Failed" );
		}
	}
	public static void tstwithoutup(){
		String toast_title = driver.findElement(By.className("title")).getText();
		System.out.println(toast_title);
		String toast_messaage = driver.findElement(By.className("message")).getText();
		System.out.println(toast_messaage);
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
	}
}