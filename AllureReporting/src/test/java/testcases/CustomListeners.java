package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class CustomListeners implements ITestListener {
	
	  public InputStream is;
	
	public void onTestStart(ITestResult result) {
	    // not implemented
	  }

	  public void onTestSuccess(ITestResult result) {
	    // not implemented
	  }

	  public void onTestFailure(ITestResult result) {
		
		try {
			is = new FileInputStream("C:\\Users\\mischenko\\Downloads\\1N5A6826.JPG");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Allure.addAttachment("Screenshot", is);
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
