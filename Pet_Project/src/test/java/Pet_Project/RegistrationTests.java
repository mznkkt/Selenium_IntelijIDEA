package Pet_Project;

import io.qameta.allure.Attachment;
import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LoggerFactory.getLogger(RegistrationTests.class);
    Faker faker = new Faker();
    WebElement inputName;
    WebElement inputEmail;
    WebElement submitButton;
    String name;
    String email;


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        name = faker.name().fullName(); //"Ekaterina";
        email = faker.internet().emailAddress(); //"mznkkt14195@gmail.com";
        driver.get("https://automationexercise.com/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Name']")));

        inputName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        inputEmail  = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        submitButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));


    }

    @AfterMethod
    public final void teardown() {
        if (driver != null) {
            driver.quit();
        }
   }

    @Attachment(value = "{description}", type = "image/png")
    @SuppressWarnings("unused")
    public byte[] captureScreenshot (String description) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void ValidateFieldName(){
        inputName.sendKeys(name);
        validateField(inputName, "Name");
    }

    @Test
    public void ValidateFieldEmail(){
        inputEmail.sendKeys(email);
        validateField(inputEmail, "Email");
    }

    @Test
    public void SignUpPage() {
        System.out.println(email);
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        submitButton.click();
        captureScreenshot ("Форма регистрации загружена");
        try {
            WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p")));
            String errorText = errorMsgElement.getText();
            if (!errorText.isEmpty()) {
                log.error("Ошибка регистрации: " + errorText);
                throw new AssertionError("Регистрация не удалась: " + errorText);
            }
        }
        catch(TimeoutException e){
            log.info("Тест \"Форма регистрации\" успешно завершен.");
        }
    }

    private void validateField(WebElement field, String fieldName) {
        String javaScript = "return arguments[0].reportValidity() ? '' : arguments[0].validationMessage;";
        String validationMessage = (String) ((JavascriptExecutor) driver).executeScript(javaScript, field);
        if (validationMessage != null && !validationMessage.isEmpty()) {
            String error = "Поле " + fieldName + " не прошло валидацию: " + validationMessage;
            log.error(error);
            captureScreenshot ("Ошибка валидации поля " + fieldName);
            Assert.fail(error);
        } else {
            log.debug("Поле {} заполнено корректно", fieldName);
        }
    }

    @Test
    public void RegisterUser(){
        inputName.sendKeys(name);
        inputEmail.sendKeys(email);
        ((JavascriptExecutor) driver).executeScript(
                "var iframes = document.querySelectorAll('iframe[id^=\"aswift_\"]'); " +
                        "iframes.forEach(function(iframe) { iframe.remove(); });"
        );
        submitButton.click();
        WebElement inputPassword = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        WebElement inputFirstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        WebElement inputLastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        WebElement inputAdress = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        WebElement inputState = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        WebElement inputCity = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        WebElement inputZipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        WebElement inputMobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));

        String password = faker.passport().toString();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String address = faker.address().toString();
        String state = faker.address().state();
        String city = faker.address().city();
        String zipcode = faker.code().toString();
        String mobilePhone = faker.phoneNumber().cellPhone();

        radioButton.click();
        inputPassword.sendKeys(password);
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAdress.sendKeys(address);
        inputState.sendKeys(state);
        inputCity.sendKeys(city);
        inputZipcode.sendKeys(zipcode);
        inputMobileNumber.sendKeys(mobilePhone);

        submitButton.click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title.text-center")));
        String actualMessage = message.getText();
        String expectedMessage = "ACCOUNT CREATED!";
        Assert.assertEquals(actualMessage, expectedMessage,
                "Текст подтверждения не совпадает: ожидалось '" + expectedMessage + "', получено '" + actualMessage + "'");
        log.info("Тест \"Регистрация пользователя\" успешно завершен."+" "+"Пользователь: "+firstName+" "+lastName+" ");




    }

}

