package autoriz_form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemindPasswordPage extends BaseView {

    public RemindPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "loginOrEmail")
    private WebElement inputLoginOrEmail;

    @FindBy(xpath = "//button")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@class='mira-page-forgot-password-link']")
    private WebElement linkBackToLoginPage;

    @FindBy(xpath = "//div[@class='head']/a")
    private WebElement linkLogoCustomLoginPage;

    public RemindPasswordPage fillInputLoginOrEmail(String loginOrEmail) {
        inputLoginOrEmail.sendKeys(loginOrEmail);
        return this;
    }

    public RemindPasswordPage clickSendButton() {
        sendButton.click();
        return this;
    }

    public LoginPage clickLinkBackToLoginPage() {
        linkBackToLoginPage.click();
        return new LoginPage(driver);
    }

    public LoginPage clickLinkLogoCustomLoginPage() {
        linkLogoCustomLoginPage.click();
        return new LoginPage(driver);
    }

}
