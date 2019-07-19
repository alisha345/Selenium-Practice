import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Linkscapture {
	public WebDriver driver;
  @Test
  public void VisibleLinks() {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total number of Available links: "+links.size());

		int count = 0;
		for (int i = 0; i<links.size(); i++)

		{
			if(!links.get(i).getText().isEmpty()) {
				
			

			System.out.println(links.get(i).getText());

			count++;
			}
			
		
		}
		System.out.println("Visible links are : "+count);

  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://spiecejet.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  
  }

}




		
		