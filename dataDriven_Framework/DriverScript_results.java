package dataDriven_Framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DriverScript_results {


	public WebDriver driver;
	public FileInputStream fi;
	public Workbook w;
	public Sheet s;
	public FileOutputStream fo;
	public WritableWorkbook wb;
	public WritableSheet ws;
	public String str;

	@Test
	public void driverscriptResults() throws Exception {
		fi = new FileInputStream("D:\\workspace\\SeleniumAutomation\\test_data\\driverscript.xls");
		w = Workbook.getWorkbook(fi);
		s = w.getSheet("Sheet3");

		fo = new FileOutputStream("D:\\workspace\\SeleniumAutomation\\test_data\\driverscriptresults.xls");
		wb = Workbook.createWorkbook(fo);
		ws = wb.createSheet("results", 0);

		for (int i = 1; i < s.getRows(); i++) {
			try {
				if (s.getCell(2, i).getContents().equalsIgnoreCase("textbox")) {
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("dropdown")) {
					new Select(driver.findElement(By.xpath(s.getCell(0, i).getContents())))
							.selectByVisibleText(s.getCell(3, i).getContents());
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("button")) {
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("link")) {
					driver.findElement(By.xpath((s.getCell(0, i).getContents()))).click();
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")) {
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("checkbox")) {
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
				} else if (s.getCell(2, i).getContents().equalsIgnoreCase("upload")) {
					driver.findElement(By.xpath(s.getCell(0, i).getContents())).sendKeys(s.getCell(3, i).getContents());
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
				str = "PASS";
			} catch (Exception e) {
				str = "FAIL";
				e.printStackTrace();
			}
			Label results = new Label(4, i, str);
			ws.addCell(results);
			for (int j = 0; j < s.getColumns(); j++) {
				System.out.println(s.getCell(j, i).getContents());
				Label a = new Label(j, i, s.getCell(j, i).getContents());
				ws.addCell(a);
			}

		}
		Label or=new Label(0, 0, "Object Repository");
		Label dn=new Label(1, 0, "Display Name");
		Label ot=new Label(2, 0, "Object Type");
		Label td=new Label(3, 0, "Test Data");
		Label rs=new Label(4, 0, "Results");
		ws.addCell(or);
		ws.addCell(dn);
		ws.addCell(ot);
		ws.addCell(td);
		ws.addCell(rs);
		
		wb.write();
		wb.close();

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
	}


  @AfterTest
  public void afterTest() {
	  driver.quit();
	 
  }

}
