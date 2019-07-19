package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicWebtableHandling {
	static WebDriver driver;

	
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("https://classic.crmpro.com/login.cfm");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("seleniumtest346");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
		WebElement frame = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().deleteAllCookies();
		driver.get("https://classic.crmpro.com/login.cfm");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("seleniumtest346");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
		WebElement frame = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}

	public static void main(String[] args) {
		
		chrome();
		String table,name;
		name = "Dharma Teja";
		//driver.quit();
		//form[@id='vContactsForm']/table[@class='datacard']
		
		table = driver.findElement(By
				.xpath("//form[@id='vContactsForm']/table[@class='datacard']")).getText();
		
		
		if(table.contains(name)) {
			driver.findElement(By
					.xpath("//a[contains(text(), '"+ name+"')]/parent::td/preceding-sibling::td//input[@type='checkbox']"))
					.click();
			
			System.out.println("The "+name+" check box is clicked.");
		}
		else {
			System.out.println(name+ " not Found in WebTable");
		}
		
		
		driver.quit();

	}

}
