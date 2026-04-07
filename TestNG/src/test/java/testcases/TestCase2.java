package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 extends BaseTest {

	@Test(groups="smoke")
	public void ValidateTitles() {
	
		System.out.println("Beginning test");
		String expected_title="Yahoo.com"; //excel
		String actual_title ="Gmail.com";  //selenium
		
		/*if(expected_title==actual_title) {
			System.out.println("Test case pass!!!");
		}
		else {
			System.out.println("Test case fail...");
		}*/
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Validating title");
		softAssert.assertEquals(actual_title, expected_title);
		//isElementPresent("xpath") - True, False
		//Assert.assertTrue(false, "Element not found");
		//Assert.fail("Failing the test case as the condition is not met");
		System.out.println("Validating image");
		softAssert.assertEquals(true, false, "image not present");
		
		System.out.println("validate text box presence");
		softAssert.assertEquals(true, false, "text box not present");
		
		System.out.println("Ending test");
		
		softAssert.assertAll();
	}
	
}
