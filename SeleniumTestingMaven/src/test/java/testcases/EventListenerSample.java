package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventListenerSample {

	public static void main(String[] args) {
		
		WebDriver webdriver = new ChromeDriver();
		
		WebDriverListener listener = new MyListener();
		WebDriver driver = new EventFiringDecorator<WebDriver>(listener).decorate(webdriver);
		
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.id("identifierId")).sendKeys("java@way2automation.com");//mznkkt - не пройдет, гугл блокирует реальные email
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Далее')]")));
		element.click();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("password");
		driver.quit();
	}

}
