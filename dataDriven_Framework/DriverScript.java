package dataDriven_Framework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DriverScript {
	public WebDriver driver;
	public FileInputStream fi;
	public Workbook w;
	public Sheet s;

	@Test
	public void f() throws Exception {
		fi = new FileInputStream("D:\\workspace\\SeleniumAutomation\\test_data\\driverscript.xls");
		w = Workbook.getWorkbook(fi);
		s = w.getSheet("Sheet1");

		for(int j=3;j<s.getColumns();j++)
		for (int i = 1; i < s.getRows(); i++) {
			if (s.getCell(2, i).getContents().equalsIgnoreCase("textbox")) {
				driver.findElement(By.xpath(s.getCell(0, i).getContents()))
											.sendKeys(s.getCell(j, i).getContents());
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("dropdown")) {
				new Select(driver.findElement(By.xpath(s.getCell(0, i).getContents())))
						.selectByVisibleText(s.getCell(j, i).getContents());
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("button")) {
				driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("link")) {
				driver.findElement(By.xpath((s.getCell(0, i).getContents()))).click();
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")) {
				driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("checkbox")) {
				driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("upload")) {
				driver.findElement(By.xpath(s.getCell(0, i).getContents()))
											.sendKeys(s.getCell(3, i).getContents());
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("url")) {
				driver.get(s.getCell(0, i).getContents());
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("alert")) {
				if (s.getCell(3, i).getContents().equalsIgnoreCase("OK")) {
					String str = driver.switchTo().alert().getText();
					System.out.println(str);
					driver.switchTo().alert().accept();
				} else {
					driver.switchTo().alert().dismiss();
				}
			} else if (s.getCell(2, i).getContents().equalsIgnoreCase("wait")) {
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

		}
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
