package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestElementScreenshot {
	public static WebDriver driver;
	
	public static void captureEleScreenshot(WebElement ele) throws IOException {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screen);
		
		Point point = ele.getLocation();
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		
		BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "jpg", screen);
		
		File screenshotLocation = new File(".\\screenshot\\googlelogo.jpg");
		FileUtils.copyFile(screen, screenshotLocation);
	}
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img"));
		captureEleScreenshot(ele);
		
		
	}

}
