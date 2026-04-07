package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParametersFromXML {

	@Parameters({"browser","env"})
	@Test()
	public void getBroser(String browser, String env) {
		
		System.out.println(browser+" "+env);
		
	}
	
}
