package Pet_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Testing_Online_Store {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        System.out.println(((ChromeDriver) driver).getCapabilities().getBrowserVersion());

        driver.get("https://automationexercise.com/view_cart");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.id("susbscribe_email"));
        WebElement submitButton = driver.findElement(By.id("subscribe"));

        // Медленный ввод текста
        slowType(textBox, "mznkkt14195@gmail.com", 200);

        submitButton.click();

        // Здесь можно добавить проверку сообщения об успешной подписке
        // WebElement message = driver.findElement(By.id("alert-success alert"));
        // System.out.println(message.getText());

        driver.quit();
    }

    public static void slowType(WebElement element, String text, long delayMillis) {
        for (char ch : text.toCharArray()) {
            element.sendKeys(String.valueOf(ch));
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}