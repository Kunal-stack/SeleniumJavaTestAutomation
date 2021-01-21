package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	static ExcelUtils excel;
	static String projectPath = System.getProperty("user.dir");
	static String excelPath = projectPath+"\\excel\\Data.xlsx";


	@DataProvider(name = "test1data")
	public static Object[] getData() {
		Object stringData[] = test1Data(excelPath,"sheet1");
		test1Data(excelPath,"sheet1"); 
		return stringData;
	}
	@DataProvider(name = "test2data")
	public static Object[][] getloginData() {
		Object loginData[][] = LogintestData(excelPath,"sheet1");
		test1Data(excelPath,"sheet1"); 
		return loginData;
	}

	//public Object[][] testData(String excelPath ,String sheetName){
	public static Object[] test1Data(String excelPath ,String sheetName){

		excel = new ExcelUtils(excelPath,sheetName);

		int rowCount  = excel.getRowCount();
		int colCount  = excel.getColCount();
		//Object data[][] = new Object[rowCount-1][colCount];
		Object[] stringData = new Object[rowCount-1];
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				//String cellData = excel.getCellDataString(i, j);
				stringData[i-1] = excel.getCellDataString(i, 0);
				//double numericData = excel.getCellDataNumber(i, 1);
				//System.out.print(stringData+" | ");
				//System.out.print(numericData+" | ");	
				//data[i-1][j] = cellData;
			}
		}
		return stringData;

	}
	public static Object[][] LogintestData(String excelPath ,String sheetName){
		excel = new ExcelUtils(excelPath,sheetName);
		int rowCount  = excel.getRowCount();
		int colCount  = excel.getColCount();
		Object[][] loginData = new Object[rowCount-1][colCount];
		for(int i=1; i<rowCount;i++) {
			for(int j=0; j<colCount;j++) {
				String cellData = excel.getCellDataString(i, j);
				loginData[i-1][j] = cellData;
			}
			
		}
		return loginData;
		
	}
	

}
