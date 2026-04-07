package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestScreenshotUsingAshot {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/lifetime-membership-club/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"Mzk2OjY4NA==-1\"]"));
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(driver, ele);
		ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\ashptelement.jpg"));

	}

}
