package autoriz_form;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DisplayName("Тестирование страницы авторизации")
public class TestLoginPage extends BaseTest {

    @DisplayName("Тест валидных логина и пароля")
    @Test
    void testValidLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin(LOGIN_VALID)
                .fillInputPassword(PASSWORD_VALID)
                .clickLoginButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//span[text()='Главная страница']")));
        String textHomePage = driver.findElement(
                By.xpath("//span[text()='Главная страница']")).getText();
        Assertions.assertEquals("Главная страница", textHomePage);
    }

    @DisplayName("Тест невалидных логина и пароля")
    @Test
    void testInValidLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin("test")
                .fillInputPassword("test")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест валидного логина и невалидного пароля")
    @Test
    void testValidLoginInvalidPassword() {
        new LoginPage(driver)
                .fillInputLogin(LOGIN_VALID)
                .fillInputPassword("test")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест невалидного логина и валидного пароля")
    @Test
    void testInvalidLoginAndValidPassword() {
        new LoginPage(driver)
                .fillInputLogin("test")
                .fillInputPassword(PASSWORD_VALID)
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест пустых логина и пароля")
    @Test
    void testEmptyLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin("")
                .fillInputPassword("")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест длинных логина и пароля")
    @Test
    void testLongLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin("qwertyuiopasdfghjklzxcvbnmpoiuytrewqasdfg")
                .fillInputPassword("poiuytrewqasdfghjklmnbvcxzqwertyuioplkjhgyhbvcdrtyui")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест логина/пароля содержащих кириллицу")
    @Test
    void testCyrillicLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin("йцукенгшщзхъ")
                .fillInputPassword("ъхзщшгнекуцй")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }

    @DisplayName("Тест логина/пароля содержащих спец. символы")
    @Test
    void testSpecialSymbolLoginAndPassword() {
        new LoginPage(driver)
                .fillInputLogin("&%$#@!*?")
                .fillInputPassword("?/*&^%$#@!")
                .clickInvalidLoginButton();

        assertInvalidLogin();
    }
    
    @DisplayName("Тест восстановления пароля на невалидный email")
    @Test
    void testRemindPasswordInvalid() {
        new LoginPage(driver)
                .clickForgotPassword();

        new RemindPasswordPage(driver)
                .fillInputLoginOrEmail("test@test.ru")
                .clickSendButton();

        String userNotFound = driver.findElement(By.xpath("//div[@class='alert']")).getText();
        Assertions.assertEquals("Пользователь с таким именем не найден.", userNotFound);
    }

    @DisplayName("Тест ссылки Назад к входу в систему")
    @Test
    void testLinkBackToLoginPage() {
        new LoginPage(driver)
                .clickForgotPassword();

        new RemindPasswordPage(driver)
                .clickLinkBackToLoginPage();

        Assertions.assertEquals("Авторизация",driver.getTitle());
    }

    @DisplayName("Тест нажатия на логотип и возврат на страницу авторизации")
    @Test
    void testLinkLogoCustomLoginPage() {
        new LoginPage(driver)
                .clickForgotPassword();

        new RemindPasswordPage(driver)
                .clickLinkLogoCustomLoginPage();

        Assertions.assertEquals("Авторизация",driver.getTitle());
    }
}
