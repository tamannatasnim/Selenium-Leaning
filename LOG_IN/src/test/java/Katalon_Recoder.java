
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Katalon_Recoder {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("http://192.168.0.18:4999/signin");
    driver.findElement(By.xpath("//input[@value='']")).click();
    driver.findElement(By.xpath("//input[@value='']")).clear();
    driver.findElement(By.xpath("//input[@value='']")).sendKeys("Admin");
    driver.findElement(By.xpath("(//input[@value=''])[2]")).clear();
    driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("Admin@user");
    driver.findElement(By.xpath("//div[@id='app-site']/div/div/div/div[2]/div[2]/form/fieldset/div[3]/button/span/span")).click();
    driver.findElement(By.xpath("//div[@id='app-site']/div/div/div[2]/div/header/div/button/span/span")).click();
    driver.findElement(By.xpath("//body[@id='body']/div[3]/div[3]/ul/nav/div[7]/div[2]/span")).click();
    driver.findElement(By.xpath("//body[@id='body']/div[3]/div[3]/ul/nav/div[8]/div/div/div/a/div/span")).click();
    driver.findElement(By.xpath("(//input[@value=''])[2]")).click();
    driver.findElement(By.xpath("(//input[@value=''])[2]")).clear();
    driver.findElement(By.xpath("(//input[@value=''])[2]")).sendKeys("BA-693");
    driver.findElement(By.xpath("//div[@id='app-site']/div/div/div[2]/main/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/table/tbody/tr/td[9]/button/span")).click();
    driver.findElement(By.xpath("//div[@id='panel3a-header']/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//div[@id='panel4a-header']/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//div[@id='panel9a-header']/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//div[@id='panel19a-header']/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//body[@id='body']/div[3]/div[3]/div/div[3]/button/span")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
