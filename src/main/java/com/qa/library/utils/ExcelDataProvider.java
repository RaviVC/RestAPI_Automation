package com.qa.library.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public static String projectpath;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public ExcelDataProvider(String excelPath, String sheetName) 
	{
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getRowCount() 
	{
		try {
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("rowcount is : " + rowcount);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static void getCellDataString(int rowNum, int colNum) {
		try {
			
			String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(celldata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(celldata);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
