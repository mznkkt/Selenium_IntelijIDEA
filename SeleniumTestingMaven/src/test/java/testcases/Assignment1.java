package testcases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment1 {
	
	private static final Cookie COOKIE;
	static {
        LocalDate localDate = LocalDate.parse("2023-03-12");
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        COOKIE = new Cookie("APISID", "-UQP9iZbBREfDmfG/A4xg0D3WwmW8dgKQL", ".google.com", "/", date);
    }
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().addCookie(COOKIE);
		driver.get("https://www.google.by/?hl=ru");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("way2automation");
		driver.findElement(By.xpath("//ul[@role='listbox']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3")).click();
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are:"+links.size());

		

		for(WebElement link: links) {
			
		System.out.println(link.getText().trim()+ " URL : " + link.getDomAttribute("href"));
		}
	}

}
