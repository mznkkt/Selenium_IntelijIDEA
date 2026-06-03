package Pet_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInTests{

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LoggerFactory.getLogger(LogInTests.class);
    String email = "mznkkt14195@gmail.com";
    String password = "5@pjT37uqnFPem2";
    WebElement inputEmail;
    WebElement inputPass;
    WebElement submitButton;



    @BeforeMethod
    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://automationexercise.com/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Password']")));

        inputPass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        submitButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

    }

    @AfterMethod
    public final void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void LogInUser() {
        try {
            inputEmail.sendKeys(email);
            inputPass.sendKeys(password);
            submitButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='/logout']")));

            log.info("Тест \"Вход в учетную запись\" успешно завершен.");

        } catch (TimeoutException e) {
            log.error("Элемент \"Logout\" не появился. Вход не выполнен.", e);
            throw new AssertionError("Таймаут ожидания элемента \"Logout\"", e);
        }
    }
}
