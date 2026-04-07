package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebTables {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> rowNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		
		System.out.println("Total rows are:"+rowNum.size());
		

		List<WebElement> colNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
		
		System.out.println("Total columns are:"+colNum.size());
		
		for(int rows=1; rows<=rowNum.size(); rows++) {
			for(int cols=1; cols<=colNum.size(); cols++) {
				
				System.out.print(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"  ");
			}
			
			System.out.println();
		}
	}

}
