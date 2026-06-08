package Pet_Project;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class HomePageTests {

    private static final Logger log = LoggerFactory.getLogger(HomePageTests.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private void waitForGridReady() throws Exception {
        URL statusUrl = new URL("http://127.0.0.1:8989/status");
        for (int i = 0; i < 10; i++) {
            try {
                HttpURLConnection conn = (HttpURLConnection) statusUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                if (conn.getResponseCode() == 200) {
                    log.info("Grid ready");
                    return;
                }
            } catch (Exception ignored) {}
            Thread.sleep(1000);
        }
        throw new RuntimeException("Grid not ready after 30 seconds");
    }

    @Attachment(value = "{description}", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver, String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        log.info("Инициализация драйвера через контейнер http://127.0.0.1:8989");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        waitForGridReady();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:8989/wd/hub"), options);

        // driver.manage().window().maximize(); // не нужно, размер уже задан через options
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

    @Test(priority = 1)
    public void testPageTitle() {
        log.info("Запуск теста: проверка заголовка главной страницы");
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        log.debug("Ожидаемый заголовок: {}, Фактический: {}", expectedTitle, actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Заголовок страницы не соответствует ожидаемому");
        log.info("Тест 1 успешно завершен");
    }

    @Test(priority = 2)
    public void testURL() {
        log.info("Запуск теста: проверка URL страницы");
        String currentUrl = driver.getCurrentUrl();
        log.debug("Текущий URL: {}", currentUrl);
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.startsWith("https://automationexercise.com/"),
                "URL не начинается с ожидаемого префикса");
        log.info("Тест 2 успешно завершен");
    }

    @Test(priority = 3)
    public void testLogo(){
        log.info("Запуск теста: проверка логотипа страницы");
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo")));
        Assert.assertTrue(logo.isDisplayed(), "Логотип не отображается");
        log.info("Тест 3 успешно завершен");
    }

    @Test(priority = 4)
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState"), "complete"));
        takeScreenshot(driver, "Главная страница загружена (полный скриншот)");
        log.info("Тест 4 успешно завершен. Страница полностью загружена");
    }

}