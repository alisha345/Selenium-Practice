package com.evexso_webapp.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()  {
		
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream("D:\\workspace\\org.evexso-webapp.com\\src\\main\\"
					+ "java\\com\\evexso_webapp\\qa\\config\\config.properties");
			prop.load(fi);
		}
		catch(FileNotFoundException e) {
			System.out.println("Config.properties file is not find in specified path.");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("IO Exception has occured.");
			e.printStackTrace();

		}
	}
	
	public static void Initilaization() {
		
		String browsername = prop.getProperty("Browser");
		String eveXso_site_URL = prop.getProperty("URL");
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
			driver = new FirefoxDriver();
	}
		else {
			System.out.println("Please define Browser as either "+"\n"+"Chrome or Firefox in config.properties file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(eveXso_site_URL);
		
		
		}

}
