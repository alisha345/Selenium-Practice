package com.Ashon;

import java.io.IOException;

import com.RestApi.Utilities.XLutilities;

public class OnHands {
	//public static int rowcount, cellcount;
	public static String data;
	
	public static String xlFile = System.getProperty("user.dir")+"\\src\\test\\java\\com\\RestApi\\Resources\\test.xlsx";
	public static String xlSheet = "Sheet1";

	public static void main(String[] args) {

		try {
			XLutilities.getCellCount(xlFile, xlSheet, 1);
			int i = XLutilities.cellcount;
			System.out.println("cellcount " + i);

			XLutilities.getRowCount(xlFile, xlSheet);
			XLutilities.getCellData(xlFile, xlSheet, 1, 1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
