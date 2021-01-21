package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath , String sheetName) {//H
		try {
			workbook = new XSSFWorkbook(excelPath);//To link excel file with the project 
			sheet = workbook.getSheet(sheetName);//for working on a particular sheet in excel file
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static int getRowCount() {//to get row count from excel sheet
		int rowCount=0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		}catch(Exception exp) {
			System.out.print(exp.getMessage());
			System.out.print(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	public static int getColCount() {//to get the column count from the excel sheet 
		int colCount=0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}catch(Exception exp) {
			System.out.print(exp.getMessage());
			System.out.print(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
	public static String getCellDataString(int rowNum , int colNum) {//to get the string data from excel file (username)
		String cellData=null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch(Exception exp) {
			System.out.print(exp.getMessage());
			System.out.print(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	public static double getCellDataNumber(int rowNum , int colNum) {//to get the numerical value from the excel file(password)
		double cellData=0; 
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		}catch(Exception exp) {
			System.out.print(exp.getMessage());
			System.out.print(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

}
