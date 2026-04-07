package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestCheckBoxes {

	public static WebDriver driver;
	public static boolean IsElementPresent(By by) {
		try {
			
		driver.findElement(by);
		return true;
	 }catch(Throwable t) {
		 return false;
	 }
		

	}
	public static void main(String[] args) {

		driver = new ChromeDriver();
		
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*driver.findElement(By.xpath("//div[4]/input[1]")).click();
		
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		
		driver.findElement(By.xpath("//div[4]/input[4]")).click();*/

		

	/*	for(int i=1; i<=4; i++) {
			
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			
		}*/
		
			
		/*int i =1;
		int counter =0;
		
		while (IsElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			
			i++;
			counter++;
		}
		
		System.out.println("Total count of checkboxes:" +counter);
	
	*/
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		System.out.println("Total count of checkboxes:" +checkboxes.size());
		
		for(WebElement checkbox: checkboxes) {
			
			checkbox.click();
			}
		}
		
	}



