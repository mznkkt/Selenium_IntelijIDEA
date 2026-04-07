package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFullPageScreenshot {
	public static WebDriver driver;
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String FileName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File pageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);             
        FileUtils.copyFile(pageScreenshot, new File ("./screenshot/"+FileName));
	}
	public static void main(String[] args) throws IOException {
		
		driver = new FirefoxDriver();
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		captureScreenshot();
		//File pageScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);             
        //FileUtils.copyFile(pageScreenshot, new File ("./screenshot/page.jpg"));
        
        File fullPageScreenshot =((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fullPageScreenshot, new File ("./screenshot/fullpage.jpg"));
	}

}
