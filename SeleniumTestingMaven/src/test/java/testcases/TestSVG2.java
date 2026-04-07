package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSVG2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://google.com/");
		driver.findElement(By.xpath("//*[name()='svg' and @class='goxjub']/*[local-name()='path' and contains(@d,'m12 15')]")).click();//path использовать не обязательно после /*

	}

}
