package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lauching_ie {
	WebDriver driver;
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.ie.driver", "D:\\Library\\IEDriverServer.exe");
	  driver = new InternetExplorerDriver();
	  driver.get("http://www.seleniumbymahesh.com/HMS");
	  driver.close();
	  
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
