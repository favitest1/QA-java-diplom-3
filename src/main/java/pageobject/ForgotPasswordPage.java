package pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;

public class ForgotPasswordPage {

    // Ссылка Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginUrl;

    /*
     * Методы
     */

    // Ссылка Войти
    @Step("Клик на ссылку Войти")
    public void clickLoginUrl() {
        loginUrl.shouldBe(enabled).click();
    }
}
