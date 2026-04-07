package testDevTools;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.network.Network;
import org.openqa.selenium.devtools.v145.network.model.ConnectionType;

public class TestNetworkSpeed {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.CELLULAR4G), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		driver.get("http://way2automation.com/");
	}

}
