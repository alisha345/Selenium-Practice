package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class creatingExcel {

		public WebDriver driver;
		public FileInputStream fi;
		public Workbook w;
		public Sheet s;
		public FileOutputStream fo;
		public WritableWorkbook wb;
		public WritableSheet ws;
		public String str;
  @Test
  public void f() throws Exception { 
	  fo = new FileOutputStream("D:\\\\workspace\\\\SeleniumAutomation\\results\\results.xls");
		wb = Workbook.createWorkbook(fo);
		ws = wb.createSheet("results", 0);
		Label un = new Label(0, 0, "User Name");
		Label pw = new Label(1, 0, "Password");
		Label rs = new Label(2, 0, "Results");
		ws.addCell(un);
		ws.addCell(pw);
		ws.addCell(rs);
		wb.write();
		wb.close();
  }
}

