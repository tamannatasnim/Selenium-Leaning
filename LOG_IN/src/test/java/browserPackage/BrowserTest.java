package browserPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		
		//For any chrome version we can use it
		//WebDriverManager.chromedriver().browserVersion("2.36").setup();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("http://192.168.0.18:4999/");
		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Used for count how many input element in this page
		//		List<WebElement> ListOfElements =  driver.findElements(By.xpath("//input"));
		//		int count = ListOfElements.size();
		//		System.out.println("Total: " +count);
		

	}

}
