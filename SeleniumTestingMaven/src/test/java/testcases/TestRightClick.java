package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestRightClick {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement img = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		WebElement word1 = driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']"));
		action.moveToElement(word1).perform();
		
		WebElement word2 = driver.findElement(By.xpath("//td[@id='dm2m2i1tdT']"));
		action.moveToElement(word2).perform();
		
		WebElement word3 = driver.findElement(By.xpath("//td[@id='dm2m3i1tdT']"));
		action.click(word3).perform();
		
		
		
		
		

	}

}
