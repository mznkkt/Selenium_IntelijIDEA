package testDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.network.Network;
import org.openqa.selenium.devtools.v145.network.model.BlockPattern;
import com.google.common.collect.ImmutableList;

public class TestBlockingNetworkRequest {

	public static void main(String[] args) {

		// 1. Создаем драйвер и сессию DevTools
		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty(), Optional.empty()));
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.png", "*.jpeg")));

		// 5. Открываем страницу
		driver.get("https://ru.freepik.com/popular-photos");

		// 6. Хорошая практика - закрыть драйвер
		// driver.quit();
	}
}