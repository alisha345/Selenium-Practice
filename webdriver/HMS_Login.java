package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HMS_Login {
	public static WebDriver driver;
	
	public static void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
		
	}
	public static void VerifyLogin() {
		driver.findElement(By.linkText("HMS")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		
	}
	public static void VerifyRegistration() throws Exception {
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Perminent Registration")).click();
		Thread.sleep(3000);


	}
	public static void verifyPR() throws Exception {
		new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Self");
		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Brother");
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		(driver.findElement(By.name("PNT_NAME"))).sendKeys("ALISHA");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("AAdhar Card");
		(driver.findElement(By.name("PAT_IDENTITY_PROOF"))).sendKeys("12345678900");
		(driver.findElement(By.name("LAST_NAME"))).sendKeys("AHAMAD");
		(driver.findElement(By.name("DOB"))).sendKeys("01-01-2019");	
		new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		(driver.findElement(By.name("AGE"))).sendKeys("26");	
		new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("No");
		new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");
		new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("B.Tech");
		new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
		new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Self Employeed");
		new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Muslim");
		new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("O+");
		new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("Telugu");
		new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("No");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		(driver.findElement(By.name("ADDRESS1"))).sendKeys("OU COLONY, SHEIKPET");
		(driver.findElement(By.name("MOBILE_NO"))).sendKeys("1234567890");
		(driver.findElement(By.name("ZIP"))).sendKeys("500089");
		(driver.findElement(By.name("image"))).sendKeys("D:\\Resume\\my pic.jpg");
		(driver.findElement(By.name("submit"))).click();

		
		Thread.sleep(3000);

	}
	
	public static void main(String[] args) throws Exception {
OpenUrl();
VerifyLogin();
VerifyRegistration();
verifyPR();
driver.close();

	}

}
