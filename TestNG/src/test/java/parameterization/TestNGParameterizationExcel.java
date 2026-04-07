package parameterization;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParameterizationExcel {

	public static ExcelReader excel;
	
	@Test(dataProvider="getData")
	public void testData(Hashtable <String,String> data) {
		
		//System.out.println(username +"  " + password+"  "+ is_correct);
		System.out.println(data.get("username")+"---"+data.get("password")+"---"+data.get("age")+"---"+data.get("is_correct")+"---"+data.get("gender"));
		
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		if(excel==null) {
			
			excel=new ExcelReader("C:\\Users\\mischenko\\Documents\\selenium\\testngdata.xlsx");
		}
		
		String sheetName="loginTest";
		int rows = excel.getRowCount(sheetName)-1;
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows][1];
		Hashtable <String,String> table = null;
		System.out.println(rows+" "+cols);
		for(int rowNum = 0; rowNum<rows; rowNum++) {
			table = new Hashtable <String, String>();
			for(int colNum = 0; colNum<cols; colNum++) {
				//data[rowNum][colNum]=excel.getCellData(sheetName, colNum, rowNum+2);
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum+2));
				data[rowNum][0]=table;
			}
			
		}
		return data;
	}
	
}
