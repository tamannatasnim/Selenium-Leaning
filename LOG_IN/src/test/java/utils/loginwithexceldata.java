package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginwithexceldata {

	public static void main(String[] args){
		
		String projectpath = System.getProperty("user.dir");
		System.out.println(projectpath);
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		try {
			driver.get("http://192.168.1.28/DBLLIVE/LogIn");

			WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
			username.sendKeys("Mis");
			System.out.println("The username is: " +username.getAttribute("value"));
			Thread.sleep(1000);	
		} catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

		try {
			WebElement password = driver.findElement(By.xpath("//input[@type='pasword']"));
			password.sendKeys("   ");
			System.out.println("The password is:" +password.getAttribute("value"));

			System.out.println("The system successfully entered the username & password");
			
		} catch(NoSuchElementException ex) {
			System.out.println("Message is: "+ex.getMessage());
			//System.out.println(ex.getCause());
			//ex.printStackTrace();
		}
		
		try {
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		System.out.println("Login done successfully");
		
	} catch(NoSuchElementException e) {
		//System.out.println("Can't click");
		System.out.println("Message is: "+e.getMessage());
		//System.out.println("Cause is: "+e.getCause());
		//e.printStackTrace();
	}

	}
}
