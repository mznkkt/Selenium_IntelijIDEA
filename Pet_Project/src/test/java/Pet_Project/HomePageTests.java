package Pet_Project;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;

public class HomePageTests {

    private static final Logger log = LoggerFactory.getLogger(HomePageTests.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @Attachment(value = "{description}", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver, String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeMethod
    public void setUp() {
        log.info("Инициализация драйвера");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            log.info("Закрытие драйвера");
            driver.quit();
        }
    }

    @Test
    public void testPageTitle() {
        log.info("Запуск теста: проверка заголовка главной страницы");
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        log.debug("Ожидаемый заголовок: {}, Фактический: {}", expectedTitle, actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок страницы не соответствует ожидаемому");
        log.info("Тест 1 успешно завершен");
    }

    @Test
    public void testURL() {
        log.info("Запуск теста: проверка URL страницы");
        String currentUrl = driver.getCurrentUrl();
        log.debug("Текущий URL: {}", currentUrl);
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.startsWith("https://automationexercise.com/"),
                "URL не начинается с ожидаемого префикса");
        log.info("Тест 2 успешно завершен");
    }

    @Test
    public void testLogo(){
        log.info("Запуск теста: проверка логотипа страницы");
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
        Assert.assertTrue(logo.isDisplayed(), "Логотип не отображается");
        log.info("Тест 3 успешно завершен");
    }

    @Test
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));
        takeScreenshot(driver, "Главная страница загружена (полный скриншот)");
        log.info("Тест 4 успешно завершен. Страница полностью загружена");
    }

}