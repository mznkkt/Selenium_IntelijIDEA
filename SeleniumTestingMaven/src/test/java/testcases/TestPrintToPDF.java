package testcases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

public class TestPrintToPDF {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");
		
		ChromeDriver driver = new ChromeDriver(opt);
		driver.get("https://selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Pdf pdf = driver.print(new PrintOptions());
		Files.write(Paths.get("./selenium.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
	}

}
