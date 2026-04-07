package testDevTools;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.emulation.Emulation;

public class TestMocGeoLocation {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		driver.manage().window().maximize();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(51.509865), Optional.of(-0.118092), Optional.of(100)));
		driver.get("https://mylocation.org/");
	}

}
