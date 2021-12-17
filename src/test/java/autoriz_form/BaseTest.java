package autoriz_form;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;
    private static final String BASE_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";

    public void assertInvalidLogin() {
        String errorMessage = driver.switchTo().alert().getText();
        Assertions.assertTrue(errorMessage.contains("Неверные данные для авторизации"));
    }

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        webDriverWait = new WebDriverWait(driver, 15);
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
