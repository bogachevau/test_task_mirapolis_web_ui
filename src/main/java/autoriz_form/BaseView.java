package autoriz_form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseView {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
}
