package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropDowns {

	public static void main(String[] args) {


		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.name("country")).sendKeys("Germany");
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
	
		select.selectByVisibleText("Eesti");
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println("Total values are : "+values.size());
		System.out.println(values.get(7).getText());
		
		for(int i=0; i<values.size();i++) {
		
			System.out.println(values.get(i).getText());
		}
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/footer/nav"));
		
		List <WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println("PRINTING LINKS");
		System.out.println("Count of links:"+links.size());
		
		for(WebElement link: links) {
			
			System.out.println(link.getText()+"...URL IS..."+link.getDomAttribute("href"));
		
		}
		
	}

}
