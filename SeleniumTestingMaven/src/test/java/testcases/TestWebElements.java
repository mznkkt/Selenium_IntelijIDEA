package testcases;

import java.time.Duration;
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWebElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://stackoverflow.com/questions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).withMessage("Time out as the condition is not met").ignoring(NoSuchElementException.class);
		WebElement username = driver.findElement(By.xpath("/html/body/header/div/nav/ol/li[3]/a"));
		username.click();
		//driver.manage().window().fullscreen();
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"openid-buttons\"]/button[1]"));
		
		btn.click();
		
		//WebElement row = driver.findElement(By.xpath("//*[@id=\\\"email\\\"]"));
		//row.sendKeys("mznkkt14195@gmail.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"email\"]"))).sendKeys("mznkkt14195@gmail.com");
		WebElement btn2 = driver.findElement(By.xpath("//*[@id=\"submit-button\"]"));
		btn2.click();
				
		
		
	}

}
