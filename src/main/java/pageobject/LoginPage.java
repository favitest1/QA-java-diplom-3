package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class LoginPage {

    // Поле Email
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    private SelenideElement emailField;

    // Поле Пароль
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    private SelenideElement passwordField;

    // Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    // Ссылка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerUrl;

    // Ссылка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement refreshUrl;

    // Текст Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterH;

    /*
    * Методы
     */

    @Step("Ввод данных в поле Емейл")
    public void setEmail (String email) {
        emailField.shouldBe(enabled).setValue(email);
    }

    @Step("Ввод данных в поле Пароль")
    public void setPassword(String password) {
        passwordField.shouldBe(enabled).setValue(password);
    }

    @Step("Нажать кнопки Войти")
    public void clickLoginButton() {
        loginButton.shouldBe(enabled).click();
    }

    @Step("Нажать на ссылку Регистраци")
    public void clickRegisterUrl() {
        registerUrl.shouldBe(enabled).click();
    }

    @Step("Нажать ссылку Восстановить пароль")
    public void clickRefreshUrl() {
        refreshUrl.shouldBe(enabled).click();
    }

    @Step("Наличие ссылки Восстановить пароль")
    public boolean isEnterHExist() {
        return refreshUrl.shouldBe(enabled).exists();
    }

    @Step("Наличие кнопки Вход")
    public boolean isEnterH() {
        return enterH.shouldBe(enabled).exists();
    }

}
