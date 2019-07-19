package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EdgeTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	WebElement var = driver.findElement(By.id("search"));
	var.click();
	  var.sendKeys("hello");
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
  }
  @BeforeTest
  public void beforeTest() {
	 /* System.setProperty("webdriver.chrome.driver", 
				"D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();*/
	  System.setProperty("webdriver.edge.driver", 
				"D:\\Library\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.get("http://youtube.com");
	
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
