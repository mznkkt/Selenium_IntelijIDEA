package testcases;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestIsElementPresent {
	
	public static WebDriver driver;
	
	public static boolean IsElementPresent(By by) {
		try {
			
		driver.findElement(by);
		return true;
	 }catch(Throwable t) {
		 return false;
	 }
		

	}
	

	public static void main(String[] args) {
	

		driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.out.println(IsElementPresent(By.id("searchLanguage222")));
		
		
	}

}
