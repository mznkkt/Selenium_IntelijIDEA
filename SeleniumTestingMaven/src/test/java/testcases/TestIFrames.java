package testcases;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class TestIFrames {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("iframeResult");
		
		//((JavascriptExecutor) driver).executeScript("myFunction()");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='10px solid blue'", driver.findElement(By.id("mySubmit")));
		
		WebElement text = driver.findElement(By.xpath("//*[@id=\"demo\"]"));
		if (text.isDisplayed()) {
			
			js.executeScript("arguments[0].style.border='10px solid yellow'", driver.findElement(By.xpath("/html/body/p[2]")));
		}
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getDomAttribute("id"));
		}
		/* - Задание - переключиться на frame без id 
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of frames:" + frames.size());
		for(int i=0; i<frames.size(); i++) {
		WebElement currentFrame = frames.get(i);
		System.out.println("Frame no:"+ i +currentFrame.getAttribute("id"));
		if(currentFrame.getAttribute("id").isEmpty()) {
		System.out.println("Switching to unnamed frame");
		driver.switchTo().frame(i);
		driver.switchTo().defaultContent();*/
		
		
	}

}
