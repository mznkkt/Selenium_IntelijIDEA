package Pet_Project;

import io.qameta.allure.Attachment;
import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTests {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public final void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "{description}", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver, String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void SignUpPage(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Faker faker = new Faker();
        try {
            driver.get("https://automationexercise.com/login");
            WebElement inputName = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
            WebElement inputEmail = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
            WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
            String name = faker.name().fullName();
            String email = faker.internet().emailAddress();
            inputName.sendKeys(name);
            inputEmail.sendKeys(email);
            String message = (String) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].reportValidity() ? '' : arguments[0].validationMessage;",
                    inputEmail);
            takeScreenshot(driver, "Главная страница загружена (полный скриншот)");
            System.out.println("Текст ошибки:" + message);
        }
        finally {
            driver.quit();
        }
    }
}
