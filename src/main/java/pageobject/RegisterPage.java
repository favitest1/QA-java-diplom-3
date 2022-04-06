package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class RegisterPage {

    // Ссылка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginUrl;

    // Поле Имя
    @FindBy(how = How.XPATH, using = ".//fieldset[1]/div/div/input")
    private SelenideElement nameField;

    // Поле Емейл
    @FindBy(how = How.XPATH, using = ".//fieldset[2]/div/div/input")
    private SelenideElement emailField;

    // Поле Пароль
    @FindBy(how = How.XPATH, using = ".//fieldset[3]/div/div/input")
    private SelenideElement passwordField;

    // Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @FindBy(how = How.CLASS_NAME, using = "input_status_error")
    private SelenideElement errorMessaged;

    /*
    * Методы
     */

    @Step("Клик по ссылке Войти")
    public void clickLoginUrl() {
        loginUrl.shouldBe(enabled).click();
    }

    @Step("Заполнеие поля Имя")
    public void setNameField (String name) {
        nameField.shouldBe(enabled).setValue(name);
    }

    @Step("Заполнение поля емейл")
    public void setEmailField (String email) {
        emailField.shouldBe(enabled).setValue(email);
    }

    @Step("Заполнение поля Пароль")
    public void setPasswordField(String password) {
        passwordField.shouldBe(enabled).setValue(password);
    }

    @Step("Клие по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        registerButton.shouldBe(enabled).click();
    }

    @Step("Наличие сообщения об ошибке пароля")
    public boolean isErrorMessage() {
        return errorMessaged.shouldBe(enabled).exists();
    }

}
