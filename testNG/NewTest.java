package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath("//div[@id='SIvCob']/a[1]")).click();//Hindi
		driver.findElement(By.linkText("English")).click();
	  System.out.println("this is  test method");

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	  System.out.println("this is before test method");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("this is after test method");

  }

}
