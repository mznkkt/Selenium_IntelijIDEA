package customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// not implemented
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Passed test - "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href =\"D:\\error.jpg\" target = \"_blank\"> Screenshot link </a>");
		Reporter.log("</br>");
		Reporter.log("<a href =\"D:\\error.jpg\" target = \"_blank\"><img src = \"D:\\error.jpg\" height = 200 weidth =200></a>");
		System.out.println("Capturing screenshot for the Failed test - " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
	}
}
