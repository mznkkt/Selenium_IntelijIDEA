package Pet_Project;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class ProductPageTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LoggerFactory.getLogger(ProductPageTests.class);
    private final String query = "Top";
    private WebElement searchBox;
    private WebElement submitSearch;


    @BeforeMethod
    public void setUp() throws InterruptedException, MalformedURLException {
        log.info("Инициализация драйвера");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        //options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        //options.addArguments("--disable-javascript");// - для того чтобы открыть DevTools и увидеть баннер в HTML,
        // т.к при обнаружении DevTools срабатывает защита: баннер удаляется или скрывается
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:8989/wd/hub"), options);
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/products");
        searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));
        submitSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit_search")));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            log.info("Закрытие драйвера))");
            driver.quit();
        }
    }

    @Attachment(value = "{description}", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver, String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Полноэкранный скриншот: {description}", type = "image/png")
    public byte[] attachFullPageScreenshot(BufferedImage image, String description) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    @SuppressWarnings("unchecked")
    @Test(priority = 1)
    public void allProductImagesLoadedViaSingleJS() throws IOException {

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
            Assert.assertNotNull(loadStatus);
            Assert.assertTrue(loadStatus.get(i),
                    "Не загружено изображение " + (i+1) + ": " + images.get(i).getAttribute("src"));
        }
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        attachFullPageScreenshot(screenshot.getImage(), "Весь каталог товаров");
        takeScreenshot(driver, "Изображения товаров загружены успешно");
        log.info("Тест \"Загрузка всех изображений на странице\" успешно завершен");
    }

    @Test(priority = 2)
    public void searchBoxIsDisplayed() {

        WebElement clickableButton = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        Assert.assertNotNull(clickableButton, "Кнопка не кликабельна");
        log.info("Тест \"Отображение поисковой строки\" успешно завершен");
    }

    @Test(priority = 3)
    public void searchCatalog(){

        searchBox.sendKeys(query);
        submitSearch.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        Assert.assertFalse(products.isEmpty(), "По запросу '" + query + "' не найдено товаров");
        log.info("Тест \"Поиск по каталогу\" успешно завершен");

    }

    @Test(priority = 4)
    public void numberOfProductsBySearch() {
        int expectedCountOfTops = 14;
        searchBox.sendKeys(query);
        submitSearch.click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='productinfo text-center']"));
        int actualCountOfTops = products.size();

        Assert.assertEquals(actualCountOfTops, expectedCountOfTops,
                "Количество найденных товаров не совпадает. Ожидалось: " + expectedCountOfTops + ", фактически: " + actualCountOfTops);
        log.info("Тест \"Количество товаров по поиску\" успешно завершен");
    }

    @Test(priority = 5)
    public void usingFiltration() throws InterruptedException, IOException {
        int expectedCountOfDresses = 3;
        WebElement womenCategories = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='badge pull-right']")));
        womenCategories.click();
        WebElement dressCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/category_products/1']")));
        dressCategory.click();
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='productinfo text-center']")));
        int actualCountOfDresses = products.size();
        takeScreenshot(driver, "Фильтрация");
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                .takeScreenshot(driver);
        attachFullPageScreenshot(screenshot.getImage(), "Фильтрация");
        File dir = new File("./screenshot");
        if (!dir.exists()) dir.mkdirs();  // создаём папку, если её нет
        ImageIO.write(screenshot.getImage(), "PNG", new File(dir, "fullpage.png"));
        Assert.assertEquals(actualCountOfDresses, expectedCountOfDresses,
                "Количество найденных товаров не совпадает. Ожидалось: " + expectedCountOfDresses + ", фактически: " + actualCountOfDresses);
        log.info("Тест \"Фильтрация товаров\" успешно завершен!");
    }



}
