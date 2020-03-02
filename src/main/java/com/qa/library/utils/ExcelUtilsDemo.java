package com.qa.library.utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectpath = System.getProperty("user.dir");
		ExcelDataProvider excel = new ExcelDataProvider(projectpath+"/Excel/ExcelData.xlsx", "sheet1");
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}

}
