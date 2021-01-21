package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	static ExcelUtils excel;
	static String projectPath = System.getProperty("user.dir");
	static String excelPath = projectPath+"\\excel\\Data.xlsx";


	@DataProvider(name = "test1data")//To provide data to the test case
	public static Object[] getData() {
		Object stringData[] = test1Data(excelPath,"sheet1");
		test1Data(excelPath,"sheet1"); 
		return stringData;
	}
	@DataProvider(name = "test2data")//To provide data to the second test case
	public static Object[][] getloginData() {
		Object loginData[][] = LogintestData(excelPath,"sheet1");
		test1Data(excelPath,"sheet1"); 
		return loginData;
	}
	
	public static Object[] test1Data(String excelPath ,String sheetName){//for extracting the username from excel file

		excel = new ExcelUtils(excelPath,sheetName);

		int rowCount  = excel.getRowCount();//for getting row count from the excel file
		int colCount  = excel.getColCount();//for getting column count from the excel file
		Object[] stringData = new Object[rowCount-1];
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				stringData[i-1] = excel.getCellDataString(i, 0);//for getting the data from the Username tag in excel file 
			}
		}
		return stringData;

	}
	public static Object[][] LogintestData(String excelPath ,String sheetName){//for extracting username and password from excel file
		excel = new ExcelUtils(excelPath,sheetName);
		int rowCount  = excel.getRowCount();
		int colCount  = excel.getColCount();
		Object[][] loginData = new Object[rowCount-1][colCount];//for storing excel data from of usrname and password 
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				String cellData = excel.getCellDataString(i, j);
				loginData[i-1][j] = cellData;
			}
			
		}
		return loginData;
		
	}
	

}
