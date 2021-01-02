package com.RestApi.TestCases;

import org.testng.annotations.Test;

import com.RestApi.Utilities.XLutilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class MonitringProcess {
  @Test(dataProvider = "samplelogic")
  public void f(Integer n, String s) {
  }

  @DataProvider(name = "samplelogic")
  
  String [][] dataFromXl() throws IOException{
	  
	  String path = System.getProperty("user.dir")+"";
	  int rownum = XLutilities.getRowCount(path, "sheet1");
	  int colcount = XLutilities.getCellCount(path, path, 1);
	  String empData[][] = new String[rownum][colcount];
	  
	  for(int i = 1; i<=rownum; i++) {
		  
		  for(int j =1; j<=colcount;j++) {
			  empData[i-1][j] = XLutilities.getCellData(path, "sheet1", i, j);
		  }
	  }
	return null;
  } 
}
