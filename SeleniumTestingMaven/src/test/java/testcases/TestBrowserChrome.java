package testcases;

import org.openqa.selenium.chrome.ChromeDriver;



public class TestBrowserChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://way2automation.com");
		
		String title = driver.getTitle();
		System.out.println(title.length());
		System.out.println(title);
		
		driver.close();
	}

}
