package grid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class LaunchingBrowsers {
	WebDriver driver;
  @Parameters("Sajid")
  @BeforeTest
  public void beforeTest(String str) {
	  if(str.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", 
					"D:\\Library\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://seleniumbymahesh.com");
			driver.close();
	  }
	  else if (str.equalsIgnoreCase("chrome")) 
	  {
		  System.setProperty("webdriver.chrome.driver", 
					"D:\\Library\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://seleniumbymahesh.com");
			driver.close();

		
	}
	  else if (str.equalsIgnoreCase("edge"))
	  {
		  System.setProperty("webdriver.edge.driver", 
					"D:\\Library\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://seleniumbymahesh.com");
			driver.close();

		
	}
	  else if (str.equalsIgnoreCase("ie"))
	  {
			System.setProperty("webdriver.ie.driver", 
					"D:\\Library\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("http://seleniumbymahesh.com");
			driver.close();

			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
  

	  
  }


}
