package testDevTools;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class TestDeviceMetrics {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		/*devTools.send(Emulation.setDeviceMetricsOverride(375, 812, 50, true, 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty(), 
				Optional.empty()));*/
		
		Map<String, Object> devicemetrics = new HashMap <String, Object>(){
			{
			put("width", 375);
			put("height", 812);
			put("mobile", true);
			put("deviceScaleFactor", 50);
			}
			
		};
		((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride", devicemetrics);
		
		driver.get("http://selenium.dev/");

	}

}
