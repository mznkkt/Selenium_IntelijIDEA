package Pet_Project;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ProductPageTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LoggerFactory.getLogger(ProductPageTests.class);


    @BeforeMethod
    public void setUp() {
        log.info("Инициализация драйвера");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/products");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            log.info("Закрытие драйвера");
            driver.quit();
        }
    }

    @Attachment(value = "{description}", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver, String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void allProductImagesLoadedViaSingleJS() {

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product-image-wrapper']//img"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<Boolean> loadStatus = (List<Boolean>) js.executeScript(
                "var results = [];" +
                        "var imgs = arguments[0];" +
                        "for (var i=0; i<imgs.length; i++) {" +
                        "   var img = imgs[i];" +
                        "   results.push(img.complete && img.naturalWidth > 0);" +
                        "}" +
                        "return results;", images);

        for (int i = 0; i < images.size(); i++) {
            Assert.assertTrue(loadStatus.get(i),
                    "Не загружено изображение " + (i+1) + ": " + images.get(i).getAttribute("src"));
        }
        takeScreenshot(driver, "Изображения товаров загружены успешно");
    }
}
