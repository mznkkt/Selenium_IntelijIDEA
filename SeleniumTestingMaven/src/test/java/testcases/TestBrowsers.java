package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBrowsers {
	
	public static String browser = "firefox";
	public static WebDriver driver;
	

	public static void main(String[] args) {
	
		
		if (browser.equals("chrome"))
		{
		driver = new ChromeDriver();
		}else if (browser.equals("ie")) 
		{
			driver = new ChromeDriver();
			}
		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.way2automation.com");
		
		String title = driver.getTitle();
		System.out.println(title.length());
		System.out.println(title);
		
		driver.quit();
	}

}
