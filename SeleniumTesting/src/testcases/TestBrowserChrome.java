package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowserChrome {

    public static void main(String[] args) {
    	WebDriver driver = new ChromeDriver();
        driver.get("http://way2automation.com");
    }
}