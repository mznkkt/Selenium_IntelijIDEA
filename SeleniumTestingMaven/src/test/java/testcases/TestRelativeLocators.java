package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public final class TestRelativeLocators {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement above = driver.findElement(with(By.tagName("input")).above(By.tagName("select")));
		above.sendKeys("mznkkt14195@gmail.com");
		File aboveScrn = above.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(aboveScrn, new File ("./screenshot/above.jpg"));
		
		WebElement below = driver.findElement(with(By.tagName("input")).below(By.tagName("select")));
		below.sendKeys("New York");
		File belowScrn = below.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(belowScrn, new File ("./screenshot/below.jpg"));
		
		//WebElement near = driver.findElement(RelativeLocator.with(By.partialLinkText("THE")).near(By.linkText("Signin")));
		//near.click();
		
		WebElement rightOf = driver.findElement(with(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).toRightOf(By.tagName("label")));
		rightOf.sendKeys("12345");
		File rightScrn = rightOf.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(rightScrn, new File ("./screenshot/right.jpg"));
		
		WebElement leftOf = driver.findElement(with(By.linkText("Signin")).toLeftOf(By.xpath("/html/body/div[2]/div/div/div/div/div/form/div[1]/div[2]/input")));
		File leftScrn = leftOf.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(leftScrn, new File ("./screenshot/left.jpg"));
		leftOf.click();
		
		/*
		driver.findElement(with(By.tagName("input"))
				.above(By.linkText("Signin"))
				.below(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input")))
				.sendKeys("abcd");
				*/
	}

}
