package webdriverBasics;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingDataFromPropertiesFile {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream
				("D:\\workspace\\SajidSelenium\\src\\webdriverBasics\\Test_data1.properties");
		
		// loading file through properties
		p.load(fi);
		
		//Reading data from file "Test_data1.properties"
		// we should pass exact same key as in file
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("DOB"));
		System.out.println(p.getProperty("username"));
		System.out.println(p.getProperty("password"));
		System.out.println(p.getProperty("mobile"));
		

	}

}
