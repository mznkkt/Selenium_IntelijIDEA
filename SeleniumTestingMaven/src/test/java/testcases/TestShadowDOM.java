package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestShadowDOM {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("chrome://downloads/");
		WebElement root = driver.findElement(By.cssSelector("downloads-manager"));
        SearchContext shadowRoot = root.getShadowRoot();
 
        WebElement root2 = shadowRoot.findElement(By.cssSelector("downloads-toolbar"));
        SearchContext shadowRoot2 = root2.getShadowRoot();
 
        WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
        SearchContext shadowRoot3 = root3.getShadowRoot();
 
        WebElement root4 = shadowRoot3.findElement(By.cssSelector("cr-toolbar-search-field"));
        SearchContext shadowRoot4 = root4.getShadowRoot();
 
 
        shadowRoot4.findElement(By.cssSelector("#searchInput")).sendKeys("Sometext");
		
	}

}
