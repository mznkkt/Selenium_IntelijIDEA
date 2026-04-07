package testDevTools;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v145.network.Network;
import org.openqa.selenium.devtools.v145.network.model.BlockPattern;

public class TestBlockingNetworkRequest { // Исправил опечатку в названии класса

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		// Включаем сеть (можно без параметров)
		devTools.send(Network.enable());

		// Создаём список шаблонов для блокировки
		List<BlockPattern> blockedPatterns = Arrays.asList(
				new BlockPattern("*.jpg", Optional.empty()),
				new BlockPattern("*.png", Optional.empty()),
				new BlockPattern("*.jpeg", Optional.empty())
		);

		// Отправляем команду один раз с правильным синтаксисом
		devTools.send(Network.setBlockedURLs(Optional.of(blockedPatterns)));

		// Переходим на сайт (теперь запросы к jpg/png/jpeg будут блокироваться)
		driver.get("https://ru.freepik.com/popular-photos");

		// Не забудьте закрыть браузер (хорошая практика)
		// driver.quit();
	}
}