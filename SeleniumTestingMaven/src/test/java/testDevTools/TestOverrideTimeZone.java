package testDevTools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.emulation.Emulation;

public class TestOverrideTimeZone {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://whatismytimezone.com/");
		
		Thread.sleep(5000);
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Emulation.setTimezoneOverride("EST"));
		driver.get("http://whatismytimezone.com/");
	}

}
