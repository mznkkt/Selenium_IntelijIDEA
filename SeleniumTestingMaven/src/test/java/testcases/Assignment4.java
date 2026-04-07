package testcases;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		Window window = driver.manage().window();
		int x = 515;
		int y = 400;
		while (x < 900) {
		window.setSize(new Dimension(x, y));
		Thread.sleep(50);
		x += 10;
		y += 10;
		}
	}
}

		

