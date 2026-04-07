package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAlert {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		/*Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();*/		
		driver.findElement(By.name("proceed")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
	
		

	}

}
