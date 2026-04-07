package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class MultipleElementsRelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> labels = driver.findElements(with(By.tagName("label")).below(By.xpath("//*[@id=\"load_form\"]/h3")));
		
		for(WebElement lab: labels) {
			
			System.out.println(lab.getText());
		}
		
		driver.manage().window().minimize();
	}

}
