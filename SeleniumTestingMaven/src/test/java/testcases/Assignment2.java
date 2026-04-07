package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Assignment2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		List<WebElement> inputs= driver.findElements(By.name("name"));
		WebElement input= inputs.get(0);	
		for(WebElement in: inputs) {
			
			System.out.println(in+" ");
		}
		input.sendKeys("Kate");
		List<WebElement> submits =driver.findElements(By.className("button"));
		WebElement submit = submits.get(1);
		for(WebElement sub: submits) {
			
			System.out.println(sub.getDomAttribute("value")+" ");
		}
		
		submit.click();
	}

}
