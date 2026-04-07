package def;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="dp1")
	public static Object [][] getData(Method m){
		
		Object[][] data = null;
		
		if(m.getName().equals("testLogin")) {
		
		data = new Object[2][2];
		data[0][0]="raman";
		data[0][1]="123456";
		
		data[1][0]="ilya";
		data[1][1]="1717171";
		
		}else if(m.getName().equals("testUserReg")){
			
			data = new Object[2][3];
			data[0][0]="raman";
			data[0][1]="ramanov";
			data[0][2]="raman@gmail.com";
			
			
			data[1][0]="ilya";
			data[1][1]="sidorov";
			data[1][2]="ilya@gmail.com";
			
		}
		return data;
		
		
	}
	
	/*@DataProvider(name="dp2")
	public static Object [][] getData2(){
		
		Object[][] data = new Object[2][3];
		data[0][0]="raman";
		data[0][1]="ramanov";
		data[0][2]="raman@gmail.com";
		
		
		data[1][0]="ilya";
		data[1][1]="sidorov";
		data[1][2]="ilya@gmail.com";
		
		
		return data;*/
		
	}

