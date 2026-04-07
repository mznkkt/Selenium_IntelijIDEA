package def;

import org.testng.annotations.Test;

public class LoginTest {

	@Test(dataProviderClass=DataProviders.class, dataProvider="dp1")
	public void testLogin(String username, String password) {
		
		System.out.println(username+"  "+password);
		
	}
	
	@Test(dataProviderClass=DataProviders.class, dataProvider="dp1")
	public void testUserReg(String fname, String lname, String email) {
		
		System.out.println(fname+"  "+lname+"  "+email);
		
	}
	
}
