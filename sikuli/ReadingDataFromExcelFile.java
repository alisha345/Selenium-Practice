package sikuli;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class ReadingDataFromExcelFile {
	public FileInputStream fi;
	public Workbook wb;
	public Sheet s;
	
  @Test
  public void f() throws Exception {
	  fi = new FileInputStream
			  ("D:\\workspace\\SeleniumAutomation\\test_data\\login1.xls");
	  wb = Workbook.getWorkbook(fi);
	  s = wb.getSheet("Sheet1");
	  System.out.println(s.getCell(0, 1).getContents());
	
  }
}
