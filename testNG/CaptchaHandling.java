package testNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class CaptchaHandling {
	public WebDriver driver;
  @Test (priority = 1)
  public void AlertsHandling() {
	  driver.switchTo().alert().dismiss();
	//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable ui-resizable']//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://www.incometaxindiaefiling.gov.in");
	  driver.manage().window().maximize();
  }

}
