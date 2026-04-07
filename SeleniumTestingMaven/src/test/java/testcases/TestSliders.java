package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSliders {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement mainsl = driver.findElement(By.id("slider"));
		int wight = mainsl.getSize().width/2;
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		new Actions (driver).dragAndDropBy(slider, wight, 0).perform();

	}

}
