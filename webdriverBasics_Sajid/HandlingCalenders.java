package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingCalenders {
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
		//driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
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
		//driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}

	public static void main(String[] args) {
		
		Firefox();
		
		 String date		 = "12-May-2019";
		 String[] dataarr	 = date.split("-");
		 String day			 = dataarr[0];
		 String mnth		 = dataarr[1];
		 String year 		 = dataarr[2];
		 
		//select[@name='slctMonth']		 
		 Select s = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
		 s.selectByVisibleText(mnth);
		 
		 Select y = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		 y.selectByVisibleText(year);
		 
		//table[@class='crmcalendar']//tbody//tr//td//table
		 String table = driver.findElement(By
				 .xpath("//table[@class='crmcalendar']//tbody//tr//td//table")).getText();
		 
		 
		 String[] table1 = table.split("\\s+");
		 for(int i=0;i<table1.length;i++) {
			 System.out.println(table1[i]);
			 if(table1[i].equals(day)) {
				 driver.findElement(By.xpath("//td[contains(text(),'"+day+"')]")).click();
			 }
		 }
		 System.out.println(table1);
		//td[contains(text(),'17')]
		// if(table.(day))
		 
		 driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		 driver.quit();
		
		
	}

}
