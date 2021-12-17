package autoriz_form;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "user")
    private WebElement inputLogin;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(id = "button_submit_login_form")
    private WebElement loginButton;

    @FindBy(className = "mira-default-login-page-link")
    private WebElement forgotPassword;

    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public LoginPage clickInvalidLoginButton() {
        loginButton.click();
        return this;
    }

    public RemindPasswordPage clickForgotPassword() {
        forgotPassword.click();
        return new RemindPasswordPage(driver);
    }
}
