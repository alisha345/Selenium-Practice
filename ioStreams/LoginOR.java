package ioStreams;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class LoginOR {
	public WebDriver driver;
	public FileInputStream fi;
	public Workbook w;
	public Sheet s,s1;

	@Test (priority = 0)
	public void hmsLogin() throws Exception {
		 fi = new FileInputStream("D:\\workspace\\SeleniumAutomation\\OR\\loginOR.xls");
		w = Workbook.getWorkbook(fi);
		s = w.getSheet("Sheet1");
		driver.findElement(By.name(s.getCell(0, 1).getContents())).sendKeys("admin");
		driver.findElement(By.name(s.getCell(1, 1).getContents())).sendKeys("admin");
		driver.findElement(By.name(s.getCell(2, 1).getContents())).click();
		Thread.sleep(3000);
	}

	@Test (priority = 1)
	public void hmsLogout() {
		s1=w.getSheet(1);
		driver.findElement(By.linkText(s1.getCell(0, 1).getContents())).click();
		driver.quit();
		
	}
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
  }

}
