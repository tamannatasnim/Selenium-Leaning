package manual_Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Manual_Login {

	public static void main(String[] args) {
		login();
		logininvalidusername();
		logininvalidpassword();
		loginwithoutpasswordfield();
		loginwithoutusernamefield();
		loginFieldsBlank();

	}
	public static void login() {
		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver = new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");

		String username = "Admin";
		String password = "Admin@user";
		String actual_title = "Bangladesh Army";
		By Bangladesh_army = By.xpath("//span[contains(text(),'Bangladesh Army')]");
		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);

			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();

			//WebDriverWait wait = new WebDriverWait(driver,30);
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By) driver.findElement(Bangladesh_army)));

			String expected_title = driver.findElement(Bangladesh_army).getText();
			System.out.println(expected_title);
			if(expected_title.equals(actual_title)){
				System.out.println("Test pass");
			}else {
				System.out.println("Test fail");
			}	
		}catch(NoSuchElementException e) {
			//System.out.println("Can't click");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();

		}
		driver.close();
	}
	public static void logininvalidusername() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");

		String username1 = "Admin1";
		String password1 = "Admin@user";
		String messagedefine = "Valid Username and password are required.";
		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username1);

			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password1);

			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click(); 

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
			String toast_messaage = driver.findElement(By.className("message")).getText();
			System.out.println(toast_messaage);
			System.out.println("The message is: "+toast_messaage);
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
		driver.close();
	}

	public static void logininvalidpassword() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
		String username2 = "Admin";
		String password2 = "Admin@use";
		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username2);
			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password2);
			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
			String toast_messaage = driver.findElement(By.className("message")).getText();
			System.out.println(toast_messaage);
			System.out.println("The message is: "+toast_messaage);
			Assert.assertEquals(toast_messaage, "Valid Username and password are required." );
			System.out.println("Login fail");

		}catch(NoSuchElementException e) {
			//System.out.println("Can't click");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();

		}
		driver.close();

	}
	public static void loginwithoutpasswordfield() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");

		String username = "Admin";
		String messagedefine = "User name or password can't be blank.";
		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();

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
			System.out.println("Login fail");

		}catch(NoSuchElementException e) {
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}
		driver.close();
	}
	public static void loginwithoutusernamefield() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");

		String password2 = "Admin@user";
		String messagedefine = "User name or password can't be blank.";
		try {

			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password2);
			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();

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
			System.out.println("Login fail");

		}catch(NoSuchElementException e) {
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();
		}
		driver.close();
	}

	public static void loginFieldsBlank() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");

		String username3 = "";
		String password3 = "";

		try {

			driver.findElement(By.xpath("//input[@type='text']")).click();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username3);
			driver.findElement(By.xpath("//input[@type='password']")).click();
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password3);
			driver.findElement(By.xpath("//span[@class='MuiButton-label']//span[contains(text(),'Sign In')]")).click();

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));

			String toast_title = driver.findElement(By.className("title")).getText();
			System.out.println(toast_title);
			String toast_messaage = driver.findElement(By.className("message")).getText();
			System.out.println(toast_messaage);

			System.out.println("The title of the toast message: "+toast_title);
			System.out.println("The title of the toast message: "+toast_messaage);

			Assert.assertEquals(toast_title, "error");
			Assert.assertEquals(toast_messaage, "User name or password can't be blank." );
			System.out.println("Login fail");

			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NoSuchElementException e) {
			//System.out.println("Can't click");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+e.getCause());
			e.printStackTrace();

		}
		driver.close();
	}


}

