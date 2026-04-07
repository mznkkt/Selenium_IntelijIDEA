package testcases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Allure examples")
@Feature("Login feature")
public class TestCase1 {

	@Test
	@Description("Login test case")
	@Severity(SeverityLevel.CRITICAL)
	@Story("In order to perform login")
	@Story("User entered username and password")
	public void doLogin() throws FileNotFoundException {
		System.out.println("Test case pass");
		
	}
	
	@Test
	@Description("Registration test case")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Performing user registration")
	public void doUserReg() {
		Assert.fail("Test case is failed");
	}
	
	@Test
	@Description("Skip test case")
	@Severity(SeverityLevel.MINOR)
	public void isSkip() {
		throw new SkipException("Skipping the test case");
	}
	
	@Test
	@Description("Registration test case2")
	@Severity(SeverityLevel.BLOCKER)
	public void doUserReg2() {
		Assert.fail("Test case is failed");
	}
	
}
