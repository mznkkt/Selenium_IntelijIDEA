package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyboardEvents {

	public static void main(String[] args) {
		

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://gmail.com");
		//driver.findElement(By.id("identifierId")).sendKeys("mznkkt14195@gmail.com");
		//driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mail@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div")).click();
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").perform();
		driver.findElement(By.xpath("//input[@id='email']")).click();
		actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
	}

}
