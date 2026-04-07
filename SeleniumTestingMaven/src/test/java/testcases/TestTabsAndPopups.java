package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTabsAndPopups {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Set<String>winids = driver.getWindowHandles();
		Iterator <String> iterate = winids.iterator();
		String first_window = iterate.next();
		System.out.println(first_window);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div/div/div/a[2]"))).click();
		
		//2 window
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		System.out.println(iterate.next());//first window
		String second_window = iterate.next();
		System.out.println(second_window);
		driver.switchTo().window(second_window);
		//driver.switchTo().frame("gsi_69615_404227");
		System.out.println(driver.getTitle());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title, 'Sign in with Google Button')]")));
		//*[@id="gsi_69615_404227"]
		driver.findElement(By.xpath("//*[@id=\"container\"]/div")).click();
	
		
		
		//3 window
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		System.out.println(iterate.next());//first window
		System.out.println(iterate.next());//second window
		String third_window = iterate.next();
		
		/*while (iterate.hasNext()) {
			
			iterate.next();
		}*/
		driver.switchTo().window(third_window);
		System.out.println(third_window);
		driver.quit();
		
	
	}

}
